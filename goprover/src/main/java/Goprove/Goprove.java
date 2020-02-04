package Goprove;

import Antlr.GoproveBaseVisitor;
import Antlr.GoproveLexer;
import Antlr.GoproveParser;
import Prove.ProveContext;
import Prove.SourceVisitor;
import de.inetsoftware.jwebassembly.api.annotation.Export;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.List;

public class Goprove {
    public static void main(String[] args) {
        ProveContext proveContext = null;
        boolean verbose = false;
//        if (args.length < 1) {
//            System.out.println("Usage: goprove [--verbose] [-i filename.go]");
//            System.exit(1);
//        }
        try {
            CommandLine commandLine;
            Options options = new Options();
            options.addOption( "v", "verbose", false, "Print verbose output" );
            options.addOption( "i", "input", true, "Input file (defaults to stdin)" );
            CommandLineParser optParser = new DefaultParser();

            commandLine = optParser.parse(options, args);
            if (commandLine.hasOption("v")) {
                verbose = true;
            }
            proveContext = new ProveContext(verbose);
            GoproveLexer grammarLexer;
            if (commandLine.hasOption('i')) {
                String inPath = commandLine.getOptionValue('i');
                grammarLexer = new GoproveLexer(CharStreams.fromFileName(inPath));
            } else {
                grammarLexer = new GoproveLexer(CharStreams.fromStream(System.in));
            }


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
        try {
            List<Boolean> results = proveContext.prove();
            if (!results.contains(false)) {
                System.out.println("OK.");
            } else {
                for(String err : proveContext.proveModule.errors) {
                    System.out.println(err);
                }
            }
        } catch (Exception e) {
            System.out.print("Problem parsing file.");
            System.exit(1);
        }
    }



    @Export
    public static ProveResult prove(String code) {
        ProveContext proveContext = null;
        try {
            proveContext = new ProveContext(false);
            GoproveLexer grammarLexer = new GoproveLexer(CharStreams.fromString(code));
            CommonTokenStream tokens = new CommonTokenStream(grammarLexer);
            GoproveParser parser = new GoproveParser(tokens);
            ParseTree tree = parser.sourceFile();

            GoproveBaseVisitor<Void> visitor = new SourceVisitor(proveContext);
            visitor.visit(tree);

        } catch (Exception e) {
            String[] error =  new String[]{"Problem parsing file: " + e.getMessage()};
            return new ProveResult(false, error);
        }
        // Prove program
        try {
            List<Boolean> results = proveContext.prove();
            if (!results.contains(false)) {
                return new ProveResult(true, new String[]{});
            } else {
                List<String> errors = proveContext.proveModule.errors;
                return new ProveResult(false, errors.toArray(new String[0]));
            }
        } catch (Exception e) {
            String[] error =  new String[]{"Problem parsing file: " + e.getMessage()};
            return new ProveResult(false, error);
        }
    }
}
