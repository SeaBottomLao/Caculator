package com.example.caculator.ExpressionCaculator;

public enum SelectOp
{
    left, right, number, dot, minus, op1, op2, op3, op4;

    public static SelectOp getType(char ch)
    {
        if(ch == '(')
            return SelectOp.left;
        else if(ch == ')')
            return SelectOp.right;
        else if(ch >= '0' && ch <= '9')
            return SelectOp.number;
        else if(ch == '.')
            return SelectOp.dot;
        else if(ch == '-')
            return SelectOp.minus;
        else if(ch == '+')
            return SelectOp.op1;
        else if(ch == '*' || ch == '×' || ch == '/' || ch == '÷')
            return SelectOp.op2;
        else if(ch == '^')
            return SelectOp.op3;
        else
            return null;
    }

    public static SelectOp getType(String str)
    {
        if(str.length() == 1)
            return getType(str.charAt(0));
        else if(str.equals("sin") || str.equals("cos") || str.equals("tan") )
            return SelectOp.op4;
        else
            return null;
    }
}
