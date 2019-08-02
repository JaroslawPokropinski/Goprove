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
        return null;
    }

    @Override
    public boolean contains(Expression a) {
        return false;
    }
}
