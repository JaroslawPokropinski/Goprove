package Expressions;


public final class OperandName implements SimpleExpression {
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

    @Override
    public String toString() {
        return String.format("%s %s", type, name);
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
                throw new RuntimeException("Type doesnt match same name operands");
            }
        }
        return false;
    }
}
