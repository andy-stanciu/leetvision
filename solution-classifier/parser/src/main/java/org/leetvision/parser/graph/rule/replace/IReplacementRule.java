package org.leetvision.parser.graph.rule.replace;

import org.antlr.v4.runtime.Parser;
import org.leetvision.parser.graph.ReducedParseTree;
import org.leetvision.parser.meta.mapper.LanguageMapper;

import java.util.List;

public interface IReplacementRule {
    List<ReducedParseTree> replace(ReducedParseTree node, LanguageMapper languageMapper, Parser parser);
    boolean shouldReplace(ReducedParseTree node, LanguageMapper languageMapper, Parser parser);
}
