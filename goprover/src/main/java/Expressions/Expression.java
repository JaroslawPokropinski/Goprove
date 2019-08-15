package Expressions;

public interface Expression {
    Expression replace(Expression a, Expression b);
    boolean contains(Expression a);
    Expression removeTernary();
}
