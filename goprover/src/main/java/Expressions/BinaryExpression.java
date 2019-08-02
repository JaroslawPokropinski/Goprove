package Expressions;

public final class BinaryExpression implements Expression {
    private final Expression left, right;
    private final String binaryOperator;

    public BinaryExpression(Expression left, Expression right, String binaryOperator) {
        this.left = left;
        this.right = right;
        this.binaryOperator = binaryOperator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getBinaryOperator() {
        return binaryOperator;
    }

    @Override
    public String toString() {
        return String.format("(%s) %s (%s)", left, binaryOperator, right);
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        Expression newLeft;
        if (left instanceof OperandName) {
            OperandName operandName = (OperandName) left;
            if (operandName.getName().equals(((OperandName) a).getName())) {
                newLeft = b;
            } else {
                newLeft = left;
            }
        } else {
            newLeft = left.replace(a, b);
        }

        Expression newRight;
        if (right instanceof OperandName) {
            OperandName operandName = (OperandName) right;
            if (operandName.getName().equals(((OperandName) a).getName())) {
                newRight = b;
            } else {
                newRight = right;
            }
        } else {
            newRight = right.replace(a, b);
        }
        return new BinaryExpression(newLeft, newRight, binaryOperator);
    }

    @Override
    public boolean contains(Expression a) {
        if (left instanceof OperandName) {
            OperandName operandName = (OperandName) left;
            if (operandName.getName().equals(((OperandName) a).getName())) {
                return true;
            }
        } else if(left.contains(a)) {
            return true;
        }

        if (right instanceof OperandName) {
            OperandName operandName = (OperandName) right;
            if (operandName.getName().equals(((OperandName) a).getName())) {
                return true;
            }
        } else if(right.contains(a)) {
            return true;
        }
        return false;
    }
}
