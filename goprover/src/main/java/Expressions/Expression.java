package Expressions;


import Prove.ProveContext;

public interface Expression {
    Expression replace(Expression a, Expression b);
    boolean contains(Expression a);
    Expression removeTernary();
    void checkDeclaration(ProveContext proveContext);
}
