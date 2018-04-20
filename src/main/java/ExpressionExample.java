import com.ibm.icu.text.SymbolTable;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.*;
import java.util.IdentityHashMap;
import java.util.Map;

public class ExpresionExample {
    public static void main(String[] args) throws IOException {

//        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("test/test1"));
//        ExprLexer lexer = new ExprLexer(input);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        ExprParser parser = new ExprParser(tokens);

        // CREATE LEXER/PARSER THAT CREATES AST FROM INPUT
        CLexer lexer = new CLexer(new ANTLRInputStream(input));
        TokenRewriteStream tokens = new TokenRewriteStream(lexer);
        CParser parser = new CParser(tokens);
        parser.setTreeAdaptor(cTreeAdaptor);
        CParser.translation_unit_return ret = parser.translation_unit();
        CommonTree t = (CommonTree)ret.getTree();
        System.out.println("; "+t.toStringTree());

        // MAKE SYM TAB
        SymbolTable symtab = new SymbolTable();

        // LOAD TEMPLATES (via classpath)
        ClassLoader cl = CC.class.getClassLoader();
        InputStream in = cl.getResourceAsStream(templatesFilename);
        Reader rd = new InputStreamReader(in);
        StringTemplateGroup templates = new StringTemplateGroup(rd);
        rd.close();

        CommonTreeNodeStream nodes = new CommonTreeNodeStream(cTreeAdaptor, t);
        nodes.setTokenStream(tokens);

        // DEFINE/RESOLVE SYMBOLS
        DefRef def = new DefRef(nodes, symtab); // use custom constructor
        def.downup(t); // trigger symtab actions upon certain subtrees
        //System.out.println("globals: "+symtab.globals);

        // GENERATE CODE
        nodes.reset();
        Gen walker = new Gen(nodes, symtab);
        walker.setTemplateLib(templates);
        Gen.translation_unit_return ret2 = walker.translation_unit();

        // EMIT IR
        // uncomment next line to learn which template emits what output
        //templates.emitDebugStartStopStrings(true);
        String output = ret2.getTemplate().toString();
        System.out.println(output);
    }


}
