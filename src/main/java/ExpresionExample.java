
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
public class ExpresionExample {
    public static void ifExample() throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("test/ifTest"));
        RubyLexer lexer = new RubyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RubyParser parser = new RubyParser(tokens);

        //Trees.inspect(parser.prog(),parser);

        parser.addParseListener(new MyRubyListener());
        parser.prog();
    }

    public static void main(String[] args) throws IOException {

        if (5==5) {

        } else {
            if (5==3) {

            }
        }

        ExpresionExample.ifExample();
    }
}
