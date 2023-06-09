package com.cause.antlr4;

import com.cause.antlr4.source.ExprLexer;
import com.cause.antlr4.source.ExprParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ExecuteTest {

    public static int exec(String input) {
        CodePointCharStream cs  = CharStreams.fromString(input);
        ExprLexer lexer = new ExprLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.expr();
        ParseTreeWalker walker = new ParseTreeWalker();

        ExprExecuteListener listener = new ExprExecuteListener();
        walker.walk(listener, tree);

        // 打印生成的语法树
        String stringTree = tree.toStringTree(parser);
        System.out.println(stringTree);

        return listener.result();
    }

    public static void main(String[] args) {
        String input = "1+2+4";
        System.out.println(exec(input));
    }

}
