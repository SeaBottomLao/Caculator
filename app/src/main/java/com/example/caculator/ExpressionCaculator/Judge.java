package com.example.caculator.ExpressionCaculator;

import java.util.HashMap;
import java.util.Map;

public class Judge//判断该表达式是否为实体类
{
    private String src;

    private boolean result;

    private Map<SelectOp, Integer> judgeMap;

    public Judge(String src)
    {
        this.src = src;
        judgeMap = new HashMap<SelectOp, Integer>();
        judge();
    }

    private void resetJudgeMap()
    {
        judgeMap.put(SelectOp.dot, 1);
        judgeMap.put(SelectOp.left, 0);
        judgeMap.put(SelectOp.minus, 0);
        judgeMap.put(SelectOp.number, 0);
        judgeMap.put(SelectOp.op1, 1);
        judgeMap.put(SelectOp.op2, 1);
        judgeMap.put(SelectOp.op3, 1);
        judgeMap.put(SelectOp.op4, 0);
        judgeMap.put(SelectOp.right, 1);
    }

    private void judge()
    {
        resetJudgeMap();
        char[] arr = src.toCharArray();
        int weight = 0;
        for(int a = 0; a < arr.length; a++)
        {
            SelectOp type;
            if(arr[a] >='a' && arr[a] <= 'z')
            {
                StringBuffer sb = new StringBuffer("");
                while(a < arr.length && arr[a] >= 'a' && arr[a] <= 'z')
                {
                    sb.append(arr[a]);
                    a++;
                }
                a--;
                type = SelectOp.getType(sb.toString());
            }
            else
                type = SelectOp.getType(arr[a]);
            if(judgeMap.get(type) != 0)
            {
                result = false;
                return;
            }
            else
            {
                if(type == SelectOp.dot)
                {
                    judgeMap.put(SelectOp.dot, 2);
                    judgeMap.put(SelectOp.left, 1);
                    judgeMap.put(SelectOp.minus, 1);
                    judgeMap.put(SelectOp.number, 0);
                    judgeMap.put(SelectOp.op1, 1);
                    judgeMap.put(SelectOp.op2, 1);
                    judgeMap.put(SelectOp.op3, 1);
                    judgeMap.put(SelectOp.op4, 1);
                    judgeMap.put(SelectOp.right, 1);
                }
                else if(type == SelectOp.left)
                {
                    weight++;
                    judgeMap.put(SelectOp.dot, 1);
                    judgeMap.put(SelectOp.left, 0);
                    judgeMap.put(SelectOp.minus, 0);
                    judgeMap.put(SelectOp.number, 0);
                    judgeMap.put(SelectOp.op1, 1);
                    judgeMap.put(SelectOp.op2, 1);
                    judgeMap.put(SelectOp.op3, 1);
                    judgeMap.put(SelectOp.op4, 0);
                    judgeMap.put(SelectOp.right, 0);
                }
                else if(type == SelectOp.right)
                {
                    weight--;
                    judgeMap.put(SelectOp.dot, 1);
                    judgeMap.put(SelectOp.left, 1);
                    judgeMap.put(SelectOp.minus, 0);
                    judgeMap.put(SelectOp.number, 1);
                    judgeMap.put(SelectOp.op1, 0);
                    judgeMap.put(SelectOp.op2, 0);
                    judgeMap.put(SelectOp.op3, 0);
                    judgeMap.put(SelectOp.op4, 1);
                    judgeMap.put(SelectOp.right, 1);
                    if(weight > 0)
                        judgeMap.put(SelectOp.right, 0);
                }
                else if(type == SelectOp.minus || type == SelectOp.op1 || type == SelectOp.op2 || type == SelectOp.op3)
                {
                    judgeMap.put(SelectOp.dot, 1);
                    judgeMap.put(SelectOp.left, 0);
                    judgeMap.put(SelectOp.minus, 1);
                    judgeMap.put(SelectOp.number, 0);
                    judgeMap.put(SelectOp.op1, 1);
                    judgeMap.put(SelectOp.op2, 1);
                    judgeMap.put(SelectOp.op3, 1);
                    judgeMap.put(SelectOp.op4, 0);
                    judgeMap.put(SelectOp.right, 1);
                }
                else if(type == SelectOp.number)
                {
                    if(judgeMap.get(SelectOp.dot) == 1)
                        judgeMap.put(SelectOp.dot, 0);
                    else if(judgeMap.get(SelectOp.dot) == 2)
                        judgeMap.put(SelectOp.dot, 2);
                    else
                        judgeMap.put(SelectOp.dot, 0);
                    judgeMap.put(SelectOp.left, 1);
                    judgeMap.put(SelectOp.minus, 0);
                    judgeMap.put(SelectOp.number, 0);
                    judgeMap.put(SelectOp.op1, 0);
                    judgeMap.put(SelectOp.op2, 0);
                    judgeMap.put(SelectOp.op3, 0);
                    judgeMap.put(SelectOp.op4, 1);
                    judgeMap.put(SelectOp.right, 1);
                    if(weight > 0)
                        judgeMap.put(SelectOp.right, 0);
                }
                else if(type == SelectOp.op4)
                {
                    judgeMap.put(SelectOp.dot, 1);
                    judgeMap.put(SelectOp.left, 0);
                    judgeMap.put(SelectOp.minus, 1);
                    judgeMap.put(SelectOp.number, 1);
                    judgeMap.put(SelectOp.op1, 1);
                    judgeMap.put(SelectOp.op2, 1);
                    judgeMap.put(SelectOp.op3, 1);
                    judgeMap.put(SelectOp.op4, 1);
                    judgeMap.put(SelectOp.right, 1);
                }
            }
        }
        if(weight == 0)
            result = true;
        else
            result = false;
    }

    public boolean getResult()
    {
        return result;
    }
}
