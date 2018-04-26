
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
public class ExpresionExample {
    public static void exampleParse(String testFileName) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(testFileName));
        RubyLexer lexer = new RubyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RubyParser parser = new RubyParser(tokens);

        parser.addParseListener(new MyRubyListener());
        Trees.inspect(parser.prog(),parser);
    }

    public static void main(String[] args) throws IOException {
        ExpresionExample.exampleParse("test/ifTest");
        System.out.println();
        ExpresionExample.exampleParse("test/whileTest");
        System.out.println();
        ExpresionExample.exampleParse("test/defTest");
    }
}
