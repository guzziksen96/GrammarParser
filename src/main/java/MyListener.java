import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MyListener implements ExprListener {
    public void enterProg(ExprParser.ProgContext ctx) {
        System.out.println("Start!");
    }

    public void exitProg(ExprParser.ProgContext ctx) {
        System.out.println("End!");
    }

    public void enterStat(ExprParser.StatContext ctx) {

    }

    public void exitStat(ExprParser.StatContext ctx) {

    }

    public void enterExpr(ExprParser.ExprContext ctx) {

    }

    public void exitExpr(ExprParser.ExprContext ctx) {

    }

    public void visitTerminal(TerminalNode terminalNode) {
        System.out.println(terminalNode.getSymbol() + "==> thats my symbol!");
    }

    public void visitErrorNode(ErrorNode errorNode) {

    }

    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
