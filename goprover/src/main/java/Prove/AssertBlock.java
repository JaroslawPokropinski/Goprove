import Expressions.*;
import Prove.ProveContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssertBlock implements CodeBlock {
    private Expression expression;
    private int line;

    public AssertBlock(int line, Expression accept) {
        expression = accept;
        this.line = line;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("Assert: %s", expression.toString());
    }

    @Override
    public Expression calculateCondition(ProveContext proveContext, ProveContext.ProveBlock proveBlock, Expression post) {
        List<CodeBlock> codeBlocks = new ArrayList<>();
        for (int i = 0; i < proveBlock.codeBlocks.size() && proveBlock.codeBlocks.get(i) != this; i++) {
            codeBlocks.add(proveBlock.codeBlocks.get(i));
        }
        proveContext.add(proveContext.getPrecondition(), expression, codeBlocks);
        return post;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public List<Expression> getForwardAssertion(List<Expression> prev) {
        prev.add(expression);
        return prev;
    }

    @Override
    public List<OperandName> getVariables() {
        return Collections.emptyList();
    }
}
