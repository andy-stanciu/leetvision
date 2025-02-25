package org.leetvision.parser;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.leetvision.parser.meta.*;
import org.leetvision.parser.meta.mapper.LanguageMapper;
import org.leetvision.parser.solution.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public final class OmniParser {
    public static final OmniParser STANDARD = new OmniParser();
    private static final int THREAD_POOL_SIZE = 10;

    private final Map<Language, ISolutionParser> parsers = new HashMap<>() {{
        put(Language.CPP, new CppSolutionParser());
        put(Language.JAVA, new JavaSolutionParser());
        put(Language.C, new CSolutionParser());
        put(Language.CSHARP, new CSharpSolutionParser());
        put(Language.GOLANG, new GolangSolutionParser());
        put(Language.PYTHON, new PythonSolutionParser());
        put(Language.JAVASCRIPT, new JavaScriptSolutionParser());
        put(Language.TYPESCRIPT, new TypeScriptSolutionParser());
    }};

    private File[] solutionDirectories;
    private OmniParser() {}

    public OmniParser withSolutionDirectories(File... solutionDirectories) {
        this.solutionDirectories = solutionDirectories;
        return this;
    }

    public void exportSolutions(String dotDirectory, String edgesDirectory, String cooccurencesFile) {
        exportSolutions(dotDirectory, edgesDirectory, cooccurencesFile, LanguageFilter.ALL, SolutionFilter.ALL);
    }

    public void exportSolutions(String dotDirectory,
                                String edgesDirectory,
                                String cooccurencesFile,
                                LanguageFilter languageFilter) {
        exportSolutions(dotDirectory, edgesDirectory, cooccurencesFile, languageFilter, SolutionFilter.ALL);
    }

    /**
     * Exports the solutions as DOT files (.dt) and adjacency list (.edges) representations. Additionally, exports
     * the cooccurence matrix.
     * @param dotDirectory Relative directory containing .dt exported solutions.
     * @param edgesDirectory Relative directory containing .edges exported solutions.
     * @param languageFilter Language filter.
     * @param solutionFilter Solution filter.
     */
    public void exportSolutions(String dotDirectory,
                                String edgesDirectory,
                                String cooccurencesFile,
                                LanguageFilter languageFilter,
                                SolutionFilter solutionFilter) {
        int batchSize = 100;
        int batches = solutionDirectories.length / batchSize + 1;
        for (int batch = 25; batch < batches; batch++) {
            System.out.printf("Exporting solutions, batch %d/%d...%n", batch + 1, batches);
            var cooccurenceEncoder = MetaLanguageCooccurenceEncoder.fromFile(cooccurencesFile);
            processSolutionsInParallel(solutionDirectories, file -> {
                var language = getLanguage(file);
                if (!language.withinFilter(languageFilter)) {
                    return;
                }

                var parser = parsers.get(language);
                var result = parser.parse(readSolution(file), true);
                if (!result.success()) {
                    System.err.println("Warning: found unparsable solution " + file.getName());
                    return;
                }

                String fileName = file.getName().split("\\.")[0];
                String solutionName = file.getParentFile().getName();

                // export dot
                var dot = new StringBuilder("digraph AST {\n");
                traverseDot(result.ast(),
                        parser.getLanguageMapper(),
                        parser.getLanguageParser(),
                        dot,
                        null,
                        new AtomicInteger());
                dot.append("}");

                writeToDisk(dot.toString(), Path.of(dotDirectory, solutionName), fileName, "dt");

                // export edges
                var edgeList = new StringBuilder();
                traverseEdges(result.ast(),
                        parser.getLanguageMapper(),
                        cooccurenceEncoder,
                        parser.getLanguageParser(),
                        edgeList,
                        null,
                        null,
                        new AtomicInteger());

                writeToDisk(edgeList.toString(), Path.of(edgesDirectory, solutionName), fileName, "edges");

                // export cooccurences
                var cooccurrences = cooccurenceEncoder.vectorize();
                var sb = new StringBuilder();
                for (var entry : cooccurrences.entrySet()) {
                    sb.append(entry.getKey()).append(':');
                    for (long l : entry.getValue()) {
                        sb.append(' ').append(l);
                    }
                    sb.append('\n');
                }

                try (var outputStream = new FileOutputStream(cooccurencesFile)) {
                    outputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, true, solutionFilter.solutions() == null ? null :
                    Arrays.stream(solutionFilter.solutions()).collect(Collectors.toSet()),
                    new SolutionRange(batch * batchSize, (batch + 1) * batchSize));
        }
    }

    public Map<MetaNode, long[]> encodeCooccurences() {
        return encodeCooccurences(LanguageFilter.ALL);
    }

    public Map<MetaNode, long[]> encodeCooccurences(LanguageFilter languageFilter) {
        var cooccurenceEncoder = MetaLanguageCooccurenceEncoder.create();
        processSolutionsInParallel(solutionDirectories, file -> {
            var language = getLanguage(file);
            if (!language.withinFilter(languageFilter)) {
                return;
            }

            var parser = parsers.get(language);
            var parseResult = parser.parse(readSolution(file), true);
            if (!parseResult.success()) {
                throw new IllegalStateException("Found unparsable solution: " + file.getName());
            }

            traverseAST(parseResult.ast(),
                    parser.getLanguageMapper(),
                    parser.getLanguageParser(),
                    self -> cooccurenceEncoder.updateCooccurence(self, self),
                    cooccurenceEncoder::updateCooccurence
            );
        }, true);

        return cooccurenceEncoder.vectorize();
    }

    /**
     * Traverses the specified AST in "topological" order via a recursive BFS. Applies the specified
     * <tt>selfAction</tt> to each node, and the <tt>edgeAction</tt> to each parent-child node "edge".
     * @param ast The AST to traverse.
     * @param languageMapper The language-specific {@link LanguageMapper} to convert to the {@link MetaLanguage}.
     * @param parser The language-specific {@link Parser} to extract AST terminals and non-terminals.
     * @param selfAction Logic to apply to each {@link MetaNode}, individually. Executed exactly once for each node,
     *                   in topological order.
     * @param edgeAction Logic to apply to each parent-child {@link MetaNode} relationship. Executed exactly once
     *                   for each "edge", in topological order.
     */
    private void traverseAST(ParseTree ast,
                             LanguageMapper languageMapper,
                             Parser parser,
                             Consumer<MetaNode> selfAction,
                             BiConsumer<MetaNode, MetaNode> edgeAction) {
        var selfNode = languageMapper.getMapping(ast, parser);
        selfAction.accept(selfNode);  // apply self-action

        for (int i = 0; i < ast.getChildCount(); i++) {
            var child = ast.getChild(i);
            var childNode = languageMapper.getMapping(child, parser);
            edgeAction.accept(selfNode, childNode);  // accept edge-action
        }

        for (int i = 0; i < ast.getChildCount(); i++) {
            traverseAST(ast.getChild(i), languageMapper, parser, selfAction, edgeAction);
        }
    }

    private void traverseDot(ParseTree ast,
                             LanguageMapper languageMapper,
                             Parser parser,
                             StringBuilder dot,
                             String parentNodeId,
                             AtomicInteger nodeId) {
        String currentNodeId = "node" + nodeId.getAndIncrement();
        dot.append(String.format("%s [label=\"%s\"];\n", currentNodeId, languageMapper.getMapping(ast, parser)));

        if (parentNodeId != null) {
            dot.append(String.format("%s -> %s;\n", parentNodeId, currentNodeId));
        }

        for (int i = 0; i < ast.getChildCount(); i++) {
            var child = ast.getChild(i);
            if (child == null) {
                throw new IllegalStateException("Found null child in AST");
            }
            traverseDot(child, languageMapper, parser, dot, currentNodeId, nodeId);
        }
    }

    private void traverseEdges(ParseTree ast,
                               LanguageMapper languageMapper,
                               ICooccurenceEncoder cooccurenceEncoder,
                               Parser parser,
                               StringBuilder edgeList,
                               String parentNodeId,
                               String parentNode,
                               AtomicInteger nodeId) {
        String currentNodeId = "node" + nodeId.getAndIncrement();
        var node = languageMapper.getMapping(ast, parser);
        String currentNode = node.toString();
        cooccurenceEncoder.updateCooccurence(node, node);  // self-occurrence

        if (parentNodeId != null) {
            edgeList.append(parentNodeId).append(" ")
                    .append(parentNode).append(" ")
                    .append(currentNodeId).append(" ")
                    .append(currentNode).append("\n");
        }

        for (int i = 0; i < ast.getChildCount(); i++) {
            var child = ast.getChild(i);
            traverseEdges(child, languageMapper, cooccurenceEncoder, parser,
                    edgeList, currentNodeId, currentNode, nodeId);
            cooccurenceEncoder.updateCooccurence(languageMapper.getMapping(child, parser), node);  // parent-child
        }
    }

    /**
     * @return The language frequencies of all solutions.
     */
    public Map<Language, Integer> getLanguages() {
        if (solutionDirectories == null) {
            return Collections.emptyMap();
        }

        Map<Language, Integer> languages = new ConcurrentHashMap<>();
        processSolutionsInParallel(solutionDirectories, file -> {
            var language = getLanguage(file);
            languages.compute(language, (k, v) -> v == null ? 1 : v + 1);
        }, false);
        return languages;
    }

    /**
     * Purges all solutions that have an unknown language.
     */
    public void purgeUnknown() {
        if (solutionDirectories == null) {
            return;
        }

        processSolutionsInParallel(solutionDirectories, file -> {
            var language = getLanguage(file);
            if (language == Language.UNKNOWN) {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, false);
    }

    public List<Map.Entry<String, Integer>> getSolutions() {
        if (solutionDirectories == null) {
            return new ArrayList<>();
        }

        Map<String, Integer> solutions = new ConcurrentHashMap<>();
        processSolutionsInParallel(solutionDirectories, file -> {
            String question = file.getParentFile().getName();
            solutions.compute(question, (k, v) -> v == null ? 1 : v + 1);
        }, false);

        var entries = new ArrayList<>(solutions.entrySet());
        entries.sort(Comparator.comparing(Map.Entry::getValue));
        return entries;
    }

    /**
     * Categorizes the specified solutions. Each solution file's first line will be updated with the language
     * it is written in, or UNKNOWN if the language could not be identified.
     */
    public void categorize() {
        if (solutionDirectories == null) {
            return;
        }

        // iterate in order of parser suites
        parsers.values().forEach(parser -> {
            var solutionCount = new AtomicInteger();
            processSolutionsInParallel(solutionDirectories, file -> {
                try {
                    var language = getLanguage(file);
                    if (language == Language.UNKNOWN) {
                        // if the file has not yet been categorized, then parse it with the current parser
                        String content = readSolution(file);
                        var result = parser.parse(content);
                        if (result.success()) {
                            content = parser.getLanguage().toString() + System.lineSeparator() + content;
                            Files.writeString(file.toPath(), content, StandardOpenOption.TRUNCATE_EXISTING);
                            solutionCount.incrementAndGet();
                        }
                    } else if (language == parser.getLanguage()) {
                        solutionCount.incrementAndGet();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, true);
        });
    }

    /**
     * Marks all solutions as unknown.
     */
    public void markUnknown() {
        if (solutionDirectories == null) {
            return;
        }

        processSolutionsInParallel(solutionDirectories, file -> {
            try {
                String content = Files.readString(file.toPath());
                content = Language.UNKNOWN.toString() + System.lineSeparator() + content;
                Files.writeString(file.toPath(), content, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, true);
    }

    /**
     * Gets the language the file is written in, or UNKNOWN if it is not known.
     * @param file The file to read.
     * @return The file's language.
     */
    private Language getLanguage(File file) {
        try (var reader = new BufferedReader(new FileReader(file))) {
            String firstLine = reader.readLine();
            return Language.valueOf(firstLine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads a solution from the specified file.
     * @param file The file to read.
     * @return The solution.
     */
    private String readSolution(File file) {
        var solution = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();  // skip first line

            String line;
            while ((line = reader.readLine()) != null) {
                solution.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return solution.toString();
    }

    private int processSolutionsInParallel(File[] solutionDirectories,
                                           Consumer<File> action,
                                           boolean verbose) {
        return processSolutionsInParallel(solutionDirectories, action, verbose, null);
    }

    private int processSolutionsInParallel(File[] solutionDirectories,
                                           Consumer<File> action,
                                           boolean verbose,
                                           Set<String> solutionFilter) {
        return processSolutionsInParallel(solutionDirectories, action, verbose, solutionFilter, SolutionRange.ALL);
    }

    private int processSolutionsInParallel(File[] solutionDirectories,
                                           Consumer<File> action,
                                           boolean verbose,
                                           Set<String> solutionFilter,
                                           SolutionRange solutionRange) {
        ExecutorService executorService = new ThreadPoolExecutor(
                THREAD_POOL_SIZE,
                THREAD_POOL_SIZE,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        List<Future<?>> futures = new LinkedList<>();
        var solutionCount = new AtomicInteger();
        var questionCount = new AtomicInteger();

        var directories = Arrays.stream(solutionDirectories)
                .filter(dir -> dir.isDirectory() && (solutionFilter == null || solutionFilter.contains(dir.getName())))
                .sorted()
                .toList();

        directories = directories.subList(solutionRange.start(),
                Math.min(solutionRange.end(), directories.size()));

        int totalQuestions = directories.size();

        for (var dir : directories) {
            var future = executorService.submit(() -> {
                var files = Objects.requireNonNull(dir.listFiles());
                int count = 0;
                for (var file : files) {
                    if (!file.isFile() || !file.getName().endsWith(".txt")) {
                        continue;
                    }
                    action.accept(file);
                    count++;
                }

                int solutionsProcessed = solutionCount.addAndGet(count);
                int questionsProcessed = questionCount.incrementAndGet();

                if (verbose) {
                    System.out.printf("Finished processing %s; questions processed: (%d/%d); solutions processed: %s%n",
                            dir.getName(), questionsProcessed, totalQuestions, solutionsProcessed);
                }
            });

            futures.add(future);
        }

        // Wait for all tasks to complete
        for (var future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executorService.shutdown();
        try {
            boolean success = executorService.awaitTermination(1, TimeUnit.HOURS);
            if (!success) {
                System.err.println("Task execution timed out");
            }
        } catch (InterruptedException e) {
            System.err.println("Executor termination interrupted: " + e.getMessage());
        }

        return solutionCount.get();
    }

    private void writeToDisk(String str, Path path, String filename, String extension) {
        if (!Files.exists(path)) {
            path.toFile().mkdirs();
        }

        String filePath = String.format("%s/%s.%s", path, filename, extension);
        try (var outputStream = new FileOutputStream(filePath)) {
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
