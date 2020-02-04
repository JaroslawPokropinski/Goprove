
import Expressions.*;

import com.microsoft.z3.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionTest {
    @Test
    void containmentTest() {
        Expression expression = new BinaryExpression(
                new OperandName("a"),
                new OperandName("b"),
                "=="
        );
        Assertions.assertTrue(expression.contains(new OperandName("a")));
        Assertions.assertTrue(expression.contains(new OperandName("b")));
        Assertions.assertFalse(expression.contains(new OperandName("c")));
    }

    @Test
    void replacementTest() {
        Expression expression = new BinaryExpression(
                new OperandName("a"),
                new OperandName("b"),
                "=="
        );
        Expression after = expression.replace(new OperandName("a"), new OperandName("c"));
        Assertions.assertFalse(after.contains(new OperandName("a")));
        Assertions.assertTrue(after.contains(new OperandName("b")));
        Assertions.assertTrue(after.contains(new OperandName("c")));
    }

    @Test
    void arrayReplacementTest() {
        Expression expression = new BinaryExpression(
                new ArrayExpression(new OperandName("a"), new Literal("0")),
                new OperandName("b"),
                "=="
        );
        Expression after = expression.replace(new ArrayExpression(new OperandName("a"), new Literal("0")), new OperandName("c"));
        // Assertions.assertFalse(after.contains(new OperandName("a")));
        Assertions.assertTrue(after.contains(new OperandName("b")));
        Assertions.assertTrue(after.contains(new OperandName("c")));
    }

    @Test
    void z3() {
        Context ctx = new Context();
        Solver solver = ctx.mkSolver();
        Quantifier q = ctx.mkForall(
                new Expr[]{ctx.mkIntConst("k")},
                ctx.mkImplies(
                        ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), ctx.mkIntConst("k")), ctx.mkLe(ctx.mkIntConst("k"), ctx.mkSub(ctx.mkIntConst("j"), ctx.mkInt(1)))),
                        ctx.mkLe(
                                (ArithExpr)
                                        ctx.mkSelect(
                                                ctx.mkArrayConst("x", ctx.getIntSort(), ctx.getIntSort()),
                                                ctx.mkSub(ctx.mkIntConst("k"), ctx.mkInt(1))
                                ),
                                (ArithExpr)
                                        ctx.mkSelect(
                                        ctx.mkArrayConst("x", ctx.getIntSort(), ctx.getIntSort()),
                                        ctx.mkIntConst("k")
                                )
                        )
                        ),
                1,
                null,
                null,
                null,
                null
        );
        BoolExpr implication = ctx.mkImplies(ctx.mkAnd(ctx.mkGe(ctx.mkIntConst("j"), ctx.mkInt(2)), q), ctx.mkLe((ArithExpr)
                        ctx.mkSelect(
                                ctx.mkArrayConst("x", ctx.getIntSort(), ctx.getIntSort()),
                                ctx.mkSub(ctx.mkIntConst("j"), ctx.mkInt(2))
                        ),
                (ArithExpr)
                        ctx.mkSelect(
                                ctx.mkArrayConst("x", ctx.getIntSort(), ctx.getIntSort()),
                                ctx.mkSub(ctx.mkIntConst("j"), ctx.mkInt(1))
                        )));
        solver.add(ctx.mkNot(implication));
        Assertions.assertEquals(solver.check(), Status.UNSATISFIABLE);
    }
}
