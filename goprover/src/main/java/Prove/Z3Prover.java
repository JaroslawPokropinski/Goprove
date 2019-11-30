package Prove;

import Expressions.Expression;
import com.microsoft.z3.*;

public class Z3Prover implements Prover {
    private Context ctx = new Context();
    private ExpressionConverter<Expr> converter = new Z3Converter(ctx);

    @Override
    public boolean implies(Expression left, Expression right) {
        Solver solver = ctx.mkSolver();

        BoolExpr implication = ctx.mkImplies((BoolExpr) converter.convertExpression(left.removeTernary()), (BoolExpr)converter.convertExpression(right.removeTernary()));
        solver.add(ctx.mkNot(implication));
        return solver.check() == Status.UNSATISFIABLE;
    }
}
