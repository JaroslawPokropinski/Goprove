package Expressions;

import Prove.ProveContext;

public class Literal implements Expression {
    private final String value;

    public static Literal zero = new Literal("0");

    public Literal(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        return this;
    }

    @Override
    public boolean contains(Expression a) {
        return false;
    }

    @Override
    public Expression removeTernary() {
        return this;
    }

    @Override
    public void checkDeclaration(ProveContext proveContext) {
    }
}
