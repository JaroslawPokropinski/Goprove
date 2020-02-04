package Prove;

import Expressions.Expression;
import com.microsoft.z3.*;

public class Z3Prover implements Prover {
    private Context ctx = new Context();
    private ExpressionConverter<Expr> converter = new Z3Converter(ctx);
    private boolean verbose;

    public Z3Prover(boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public boolean implies(Expression left, Expression right) {
        Solver solver = ctx.mkSolver();

        BoolExpr implication = ctx.mkImplies((BoolExpr) converter.convertExpression(left.removeTernary()), (BoolExpr)converter.convertExpression(right.removeTernary()));
        solver.add(ctx.mkNot(implication));
        if (verbose) {
            System.out.println(String.format(
                    "%s => %s: %s",
                    left,
                    right,
                    (solver.check() == Status.UNSATISFIABLE)? "OK": "FAILED"
            ));
        }
        return solver.check() == Status.UNSATISFIABLE;
    }
}
