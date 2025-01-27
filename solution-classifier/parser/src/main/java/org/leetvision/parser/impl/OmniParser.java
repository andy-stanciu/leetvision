package org.leetvision.parser.impl;

import org.leetvision.parser.impl.lang.*;

import java.util.ArrayList;
import java.util.List;

public class OmniParser {
    public static final OmniParser STANDARD = new OmniParser(new ArrayList<>() {{
        add(new CSolutionParser());
        add(new PythonSolutionParser());
        add(new CppSolutionParser());
        add(new JavaSolutionParser());
        add(new JavaScriptSolutionParser());
        add(new TypeScriptSolutionParser());
        add(new CSharpSolutionParser());
        add(new GolangSolutionParser());
    }});

    private final List<IParsable> suite;

    private OmniParser(List<IParsable> suite) {
        this.suite = suite;
    }

    /**
     * Parses the specified file, determining its language.
     * @param fileName The file to parse.
     * @return The language the file is in, or unknown if it is not supported.
     */
    public Language parse(String fileName) {
        for (var parser : suite) {
            if (parser.parse(fileName)) {
                return parser.getLanguage();
            }
        }
        return Language.UNKNOWN;
    }
}
