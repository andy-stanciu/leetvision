package org.leetvision.parser.solution;

import org.antlr.v4.runtime.Parser;
import org.leetvision.parser.IParsable;
import org.leetvision.parser.meta.mapper.LanguageMapper;

import static org.leetvision.parser.solution.SolutionParser.ParseResult;

public interface ISolutionParser extends IParsable {
    ParseResult parse(String text, boolean reduce);
    LanguageMapper getLanguageMapper();
    Parser getLanguageParser();
}
