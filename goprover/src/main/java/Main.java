import Antlr.GoproveBaseVisitor;
import Antlr.GoproveLexer;
import Antlr.GoproveParser;
import Prove.ProveContext;
import Prove.SourceVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ProveContext proveContext = new ProveContext();
        if (args.length < 1) {
            System.out.println("Usage: goprove filename.go");
            System.exit(1);
        }
        try {
            // String inPath = "D:\\Programming ssd\\Praca dyplomowa\\examples\\ex1.5.go";
            String inPath = args[0];
            GoproveLexer grammarLexer = new GoproveLexer(CharStreams.fromFileName(inPath));
            CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
            GoproveParser parser = new GoproveParser(tokens);
            ParseTree tree = parser.sourceFile();

            GoproveBaseVisitor<Void> visitor = new SourceVisitor(proveContext);
            visitor.visit(tree);

        } catch (IOException _e) {
            System.out.println("Problem opening file");
            System.exit(1);
        } catch (Exception e) {
            System.out.print("Problem parsing file: ");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        // Prove program
        proveContext.prove();
    }
}
