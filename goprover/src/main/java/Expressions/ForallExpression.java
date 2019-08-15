package Expressions;

public class ForallExpression implements Expression {

    private OperandName iterator;
    private Expression expression;

    public ForallExpression(OperandName iterator, Expression expression) {
        // TODO: Check for shadowing
        this.iterator = iterator;
        this.expression = expression;
    }

    public OperandName getIterator() {
        return iterator;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public Expression replace(Expression a, Expression b) {
        throw new RuntimeException("Replace on for all is not implemented");
    }

    @Override
    public boolean contains(Expression a) {
        throw new RuntimeException("Contains on for all is not implemented");
    }
}
