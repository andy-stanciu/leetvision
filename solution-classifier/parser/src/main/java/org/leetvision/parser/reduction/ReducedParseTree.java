package org.leetvision.parser.reduction;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import java.util.List;

public final class ReducedParseTree implements ParseTree {
    @Getter
    private final ParseTree self;
    @Setter
    private List<ReducedParseTree> children;

    public ReducedParseTree(ParseTree self, List<ReducedParseTree> children) {
        this.self = self;
        this.children = children;
    }

    @Override
    public ReducedParseTree getChild(int i) {
        return children.get(i);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public String getText() {
        return self.getText();
    }

    @Override
    public String toStringTree(Parser parser) {
        return self.toStringTree(parser);
    }

    @Override
    public String toStringTree() {
        return self.toStringTree();
    }

    @Override
    public Object getPayload() {
        return self.getPayload();
    }

    @Override
    public ParseTree getParent() {
        return self.getParent();
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
        return self.accept(visitor);
    }

    @Override
    public void setParent(RuleContext ruleContext) {
        self.setParent(ruleContext);
    }

    @Override
    public Interval getSourceInterval() {
        return self.getSourceInterval();
    }
}
