package Expressions;


import Prove.ProveContext;

public final class OperandName implements Expression {
    private final String name;
    private final String type;

    public OperandName(String name) {
        this.name = name;
        this.type = "int";
    }

    public OperandName(String name, String type) {
        this.name = name;
        this.type = type;
    }

    private static int anonCount = 0;

    public static OperandName createAnonymous() {
        OperandName op = new OperandName(String.format("anon'%d", anonCount));
        anonCount++;
        return op;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        if (a instanceof OperandName) {
            OperandName operandName = (OperandName) a;
            if (getName().equals(operandName.getName())) {
                return b;
            } else {
                return this;
            }
        }
        return this;
    }

    @Override
    public boolean contains(Expression a) {
        if (a instanceof OperandName) {
            if (getName().equals(((OperandName) a).getName())) {
                if (getType().equals(((OperandName) a).getType())) {
                    return true;
                }
                throw new RuntimeException("Type doesn't match same name operands");
            }
        }
        return false;
    }

    @Override
    public Expression removeTernary() {
        return this;
    }

    @Override
    public void checkDeclaration(ProveContext proveContext) {
        proveContext.getVariable(name);
    }
}
