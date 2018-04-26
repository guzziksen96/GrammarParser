
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
public class ExpresionExample {
    public static void ifExample() throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("test/ifTest"));
        RubyLexer lexer = new RubyLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RubyParser parser = new RubyParser(tokens);

        parser.addParseListener(new MyRubyListener());
        parser.prog();
    }

    public static void main(String[] args) throws IOException {

        /*ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("test/test1"));
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        parser.addParseListener(new MyListener());
        parser.prog();*/

        ExpresionExample.ifExample();
    }
}
