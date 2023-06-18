package com.cause.antlr4;

import com.cause.antlr4.source.ExprBaseListener;
import com.cause.antlr4.source.ExprParser;

import java.util.Stack;

public class ExprExecuteListener extends ExprBaseListener {

    Stack<Integer> stack = new Stack<>();

    @Override
    public void exitInt(ExprParser.IntContext ctx) {
        stack.add(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public void exitAdd(ExprParser.AddContext ctx) {
        int r = stack.pop();
        int l = stack.pop();
        stack.add(l + r);
    }

    @Override
    public void exitSub(ExprParser.SubContext ctx) {
        int r = stack.pop();
        int l = stack.pop();
        stack.add(l - r);
    }

    public int result() {
        return stack.pop();
    }

}
