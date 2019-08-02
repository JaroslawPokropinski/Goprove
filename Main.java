package goprover;

import com.microsoft.z3.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Context ctx = new Context();
        Solver solver = ctx.mkSolver();
        IntExpr x = ctx.mkIntConst("x");
        IntExpr y = ctx.mkIntConst("y");
        BoolExpr left = ctx.mkEq(ctx.mkAdd(x, ctx.mkInt(1)), ctx.mkAdd(y, ctx.mkInt(1)));
        BoolExpr right = ctx.mkEq(x, y);
        BoolExpr implication = ctx.mkImplies(left, right);
        solver.add(ctx.mkNot(implication));
        if (solver.check() == Status.UNSATISFIABLE) {
            System.out.println("Valid");
        } else {
            System.out.println("Not Valid");
        }

        String inPath = null;
        try {
            GoproveLexer grammarLexer = new GoproveLexer (CharStreams.fromFileName(inPath));
            CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
            GoproveParser parser = new GoproveParser(tokens);
            try {
                parser.sourceFile();
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("Problem opening file");
            System.exit(1);
        }
    }
}
