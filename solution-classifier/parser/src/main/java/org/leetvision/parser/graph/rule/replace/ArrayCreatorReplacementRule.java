package org.leetvision.parser.graph.rule.replace;

import org.antlr.v4.runtime.Parser;
import org.leetvision.parser.graph.ReducedParseTree;
import org.leetvision.parser.meta.MetaLanguage;
import org.leetvision.parser.meta.mapper.LanguageMapper;

import java.util.ArrayList;
import java.util.List;

import static org.leetvision.parser.meta.MetaLanguage.MetaNode;

public final class ArrayCreatorReplacementRule implements IReplacementRule {
    @Override
    public List<ReducedParseTree> replace(ReducedParseTree node,
                                          LanguageMapper languageMapper,
                                          Parser parser) {
        List<ReducedParseTree> result = new ArrayList<>();
        var mapping = languageMapper.getMapping(node, parser);
        if (mapping != MetaLanguage.MetaNode.ARRAY_CREATOR_REST) {
            result.add(node);
            return result;
        }

        result.addAll(node.getChildren());
        return result;
    }

    @Override
    public boolean shouldReplace(ReducedParseTree node,
                                 LanguageMapper languageMapper,
                                 Parser parser) {
        var mapping = languageMapper.getMapping(node, parser);
        return mapping == MetaNode.ARRAY_CREATOR_REST;
    }
}
