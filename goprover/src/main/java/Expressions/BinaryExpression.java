package Expressions;

import java.util.Arrays;

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

    public boolean isBoolean() {
        String[] boolOperators = {"<", "<=", ">", ">=", "==", "!=", "&&", "||"};
        return Arrays.asList(boolOperators).contains(binaryOperator);
    }

    @Override
    public String toString() {
        return String.format("(%s) %s (%s)", left, binaryOperator, right);
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        Expression newLeft = left.replace(a, b);
        Expression newRight = right.replace(a, b);
        return new BinaryExpression(newLeft, newRight, binaryOperator);
    }

    @Override
    public boolean contains(Expression a) {
        return left.contains(a) || right.contains(a);
    }
}