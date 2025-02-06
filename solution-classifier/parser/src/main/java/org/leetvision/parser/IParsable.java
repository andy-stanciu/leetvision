package org.leetvision.parser;

import static org.leetvision.parser.solution.SolutionParser.ParseResult;

public interface IParsable {
    ParseResult parse(String text);
    Language getLanguage();
}
