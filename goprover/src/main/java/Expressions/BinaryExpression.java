package Expressions;

import Prove.ProveContext;

import java.util.Arrays;

public final class BinaryExpression implements Expression {
    private final Expression left, right;
    private final String binaryOperator;

    public BinaryExpression(Expression left, Expression right, String binaryOperator) {
        if (left == null) {
            throw new NullPointerException();
        }
        if (right == null) {
            throw new NullPointerException();
        }
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
        boolean leftPar = true;
        boolean rightPar = true;
        if (left instanceof BinaryExpression && right instanceof BinaryExpression) {
            BinaryExpression leftBin = (BinaryExpression) left;
            BinaryExpression rightBin = (BinaryExpression) right;
            if (isBoolean()) {
                if (!leftBin.isBoolean()) {
                    leftPar = false;
                }
                if (!rightBin.isBoolean()) {
                    rightPar = false;
                }
            }
            if (binaryOperator.equals("&&") && !leftBin.getBinaryOperator().equals("||")) {
                leftPar = false;
            }
            if (binaryOperator.equals("&&") && !rightBin.getBinaryOperator().equals("||")) {
                rightPar = false;
            }

            if (binaryOperator.equals("||")) {
                leftPar = false;
                rightPar = false;
            }
        }
        if (left instanceof OperandName || left instanceof UnaryExpression || left instanceof  Literal) {
            leftPar = false;
        }

        if (right instanceof OperandName|| right instanceof UnaryExpression || right instanceof  Literal) {
            rightPar = false;
        }

        if (leftPar && rightPar) {
            return String.format("(%s) %s (%s)", left, binaryOperator, right);
        }
        if (!leftPar && rightPar) {
            return String.format("%s %s (%s)", left, binaryOperator, right);
        }
        if (leftPar) {
            return String.format("(%s) %s %s", left, binaryOperator, right);
        }
        return String.format("%s %s %s", left, binaryOperator, right);
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

    @Override
    public Expression removeTernary() {
        Expression et = elevateTernary();
        if (isBoolean()) {
            if (et instanceof TernaryExpression) {
                TernaryExpression te = (TernaryExpression) et;
                return new BinaryExpression(
                        new BinaryExpression(
                                new UnaryExpression("!", te.getCondition()),
                                te.getA(),
                                "||"
                        ).removeTernary(),
                        new BinaryExpression(
                                te.getCondition(),
                                te.getB(),
                                "||"
                        ).removeTernary(),
                        "&&"
                );
            }
            return et;
        }
        return et;
    }

    @Override
    public void checkDeclaration(ProveContext proveContext) {
        left.checkDeclaration(proveContext);
        right.checkDeclaration(proveContext);
    }


    private Expression elevateTernary() {
        Expression l = left.removeTernary();
        Expression r = right.removeTernary();
        if (l instanceof  TernaryExpression && r instanceof TernaryExpression) {
            TernaryExpression tl = (TernaryExpression)l;
            TernaryExpression tr = (TernaryExpression)r;
            return new TernaryExpression(
                    tl.getCondition(),
                    new TernaryExpression(
                            tr.getCondition(),
                            new BinaryExpression(tl.getA(), tr.getA(), binaryOperator).removeTernary(),
                            new BinaryExpression(tl.getA(), tr.getB(), binaryOperator).removeTernary()
                    ),
                    new TernaryExpression(
                            tr.getCondition(),
                            new BinaryExpression(tl.getB(), tr.getA(), binaryOperator).removeTernary(),
                            new BinaryExpression(tl.getB(), tr.getB(), binaryOperator).removeTernary()
                    )
            );
        }
        if (l instanceof TernaryExpression) {
            TernaryExpression tl = (TernaryExpression)l;
            return new TernaryExpression(
                    tl.getCondition(),
                    new BinaryExpression(tl.getA(), right, binaryOperator).removeTernary(),
                    new BinaryExpression(tl.getB(), right, binaryOperator).removeTernary()
            );
        }
        if (r instanceof TernaryExpression) {
            TernaryExpression tr = (TernaryExpression)r;
            return new TernaryExpression(
                    tr.getCondition(),
                    new BinaryExpression(left, tr.getA(), binaryOperator).removeTernary(),
                    new BinaryExpression(left, tr.getB(), binaryOperator).removeTernary()
            );
        }
        return new BinaryExpression(l, r, binaryOperator);
    }
}