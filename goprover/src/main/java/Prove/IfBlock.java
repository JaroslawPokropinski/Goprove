package Prove;

import Expressions.BinaryExpression;
import Expressions.Expression;
import Expressions.OperandName;
import Expressions.UnaryExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IfBlock implements StatementBlock {

    private int line;
    private Expression condition;
    private List<StatementBlock> body;
    private List<StatementBlock> elBody;
    private List<OperandName> var = null;

    public IfBlock(int line, Expression condition, List<StatementBlock> body) {
        this(line, condition, body, null);
    }

    public IfBlock(int line, Expression condition, List<StatementBlock> body, List<StatementBlock> elBody) {
        this.line = line;
        this.condition = condition;
        this.body = body;
        this.elBody = elBody;
    }

    @Override
    public Expression calculateCondition(ProveContext proveContext, ProveContext.ProveBlock proveBlock, Expression post) {
        Expression left, right;
        if (elBody == null) {
            left = new BinaryExpression(new UnaryExpression("!", condition), post, "&&");
        } else {
            Expression elBodyAssertion = post;
            for (int i = elBody.size() - 1; i >= 0; i--) {
                elBodyAssertion = elBody.get(i).calculateCondition(proveContext, proveBlock, elBodyAssertion);
            }
            left = new BinaryExpression(new UnaryExpression("!", condition), elBodyAssertion, "&&");
        }

        Expression bodyAssertion = post;
        for (int i = body.size() - 1; i >= 0; i--) {
            bodyAssertion = body.get(i).calculateCondition(proveContext, proveBlock, bodyAssertion);
        }
        right = new BinaryExpression(condition, bodyAssertion, "&&");
        return new BinaryExpression(left, right, "||");
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public List<Expression> getForwardAssertion(List<Expression> prev) {
        for (Iterator<Expression> iterator = prev.iterator(); iterator.hasNext(); ) {
            Expression next = iterator.next();
            // if next contains any of variables then remove it
            for (OperandName v : getVariables()) {
                if (next.contains(v)) {
                    iterator.remove();
                    break;
                }
            }
        }
        // TODO : In the loop assertions
        return prev;
    }

    @Override
    public List<OperandName> getVariables() {
        if (var == null) {
            var = new ArrayList<>();
            for (StatementBlock statementBlock : body) {
                statementBlock
                        .getVariables()
                        .forEach((v) -> {
                            if (!var.contains(v)) {
                                var.add(v);
                            }
                        });
            }
        }
        return var;
    }
}
