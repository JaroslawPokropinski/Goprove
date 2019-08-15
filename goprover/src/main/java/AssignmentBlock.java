import Expressions.ArrayExpression;
import Expressions.BinaryExpression;
import Expressions.Expression;
import Expressions.OperandName;

import java.util.ArrayList;
import java.util.List;

public class AssignmentBlock implements CodeBlock {
    private List<Expression> left, right;
    private String op;
    private int line;

    public AssignmentBlock(int line, List<Expression> left, List<Expression> right, String op) {
        this.left = left;
        this.right = right;
        this.op = op;
        this.line = line;
    }

    public List<Expression> getLeft() {
        return left;
    }

    public List<Expression> getRight() {
        return right;
    }

    public String getOp() {
        return op;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (left.size() > 0) {
            stringBuilder.append(left.get(0));
            for (int i = 1; i < left.size(); i++) {
                stringBuilder.append(" ,");
                stringBuilder.append(left.get(i));
            }
        }
        stringBuilder.append(" := ");
        if (right.size() > 0) {
            stringBuilder.append(right.get(0));
            for (int i = 1; i < right.size(); i++) {
                stringBuilder.append(" ,");
                stringBuilder.append(right.get(i));
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public Expression calculateCondition(ProveContext proveContext, ProveContext.ProveBlock proveBlock, Expression post) {
        Expression newExpression = post;
        for (int j = 0; j < getLeft().size(); j++) {
            newExpression = newExpression.replace(getLeft().get(j), getRight().get(j));
        }
        return newExpression;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public List<Expression> getForwardAssertion(List<Expression> prev) {
        // TODO: Test and improve
        for (int i = 0; i < getLeft().size(); i++) {
            // Process Expressions in prev with variable on the left
            for (int j = prev.size() - 1; j >= 0; j--) {
                if (prev.get(j).contains(getLeft().get(i))) {
                    prev.remove(j);
                }
            }
            if (!getRight().get(i).contains(getLeft().get(i))) {
                prev.add(new BinaryExpression(getLeft().get(i), getRight().get(i), "=="));
            }
        }
        return prev;
    }

    @Override
    public List<OperandName> getVariables() {
        ArrayList<OperandName> list = new ArrayList<>(1);
        getLeft().forEach((e) -> {
            if (e instanceof OperandName) {
                list.add((OperandName) e);
                return;
            }
            if (e instanceof ArrayExpression) {
                ArrayExpression ae = (ArrayExpression)e;
                list.add(ae.getOperandName());
                return;
            }
            throw new RuntimeException("Left side of expression must be either operand or array");
        });
        return list;
    }
}
