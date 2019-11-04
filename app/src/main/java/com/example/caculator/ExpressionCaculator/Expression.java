package com.example.caculator.ExpressionCaculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Expression
{
    private String src;	//中缀表达式

    private List<String> postfix;	//后缀表达式

    private Map<SelectOp, Integer> priorityMap;	//运算符优先级图

    private String result;	//表达式结果

    public Expression(String src)
    {
        this.src = src;

        run();
    }


    private void run()
    {
        if(src==null || src.length() == 0)
        {
            result = new String("");
            return;
        }
        if(!isSrcValid())
        {
            result = new String("error");
            return;
        }
        initializePriorityMap();
        toPostfix();
        try
        {
            calculate();
        }
        catch(ArithmeticException e)
        {
            result = e.getMessage();
        }
        catch(EmptyStackException e)
        {
            result = "error";
        }
        catch(NullPointerException e)
        {
            result = "error";
        }
    }

    private boolean isSrcValid()
    {
        return new Judge(src).getResult();
    }

    private void initializePriorityMap()
    {
        priorityMap = new HashMap<SelectOp, Integer>();
        priorityMap.put(SelectOp.left, 0);
        priorityMap.put(SelectOp.minus, 1);
        priorityMap.put(SelectOp.op1, 1);
        priorityMap.put(SelectOp.op2, 2);
        priorityMap.put(SelectOp.op3, 3);
        priorityMap.put(SelectOp.op4, 4);
    }

    private void toPostfix()
    {
        Stack<String> stack = new Stack<String>();
        postfix = new ArrayList<String>();
        char[] arr = src.toCharArray();
        boolean isMinus = true;
        for(int a = 0; a < arr.length; a++)
        {
            if(isMinus && arr[a] != '-')
                isMinus = false;
            if(arr[a] == '-')
            {
                if(isMinus)
                {
                    isMinus = false;
                    StringBuffer sb = new StringBuffer("");
                    sb.append(arr[a]);
                    a++;
                    while(a < arr.length && (SelectOp.getType(arr[a]) == SelectOp.number || SelectOp.getType(arr[a]) == SelectOp.dot))
                    {
                        sb.append(arr[a]);
                        a++;
                    }
                    a--;
                    postfix.add(sb.toString());
                }
                else
                {
                    while(!stack.isEmpty() && priorityMap.get(SelectOp.getType(stack.peek())) >= priorityMap.get(SelectOp.getType(arr[a])))
                    {
                        postfix.add(stack.pop());
                    }
                    stack.push(String.valueOf(arr[a]));
                }
            }
            else if(arr[a] >= '0' && arr[a] <= '9')
            {
                StringBuffer sb = new StringBuffer("");
                while(a < arr.length && (SelectOp.getType(arr[a]) == SelectOp.number || SelectOp.getType(arr[a]) == SelectOp.dot))
                {
                    sb.append(arr[a]);
                    a++;
                }
                a--;
                postfix.add(sb.toString());
            }
            else if(arr[a] >= 'a' && arr[a] <= 'z')
            {
                StringBuffer sb = new StringBuffer("");
                while(a < arr.length && arr[a] >= 'a' && arr[a] <= 'z')
                {
                    sb.append(arr[a]);
                    a++;
                }
                a--;
                while(!stack.isEmpty() && priorityMap.get(SelectOp.getType(stack.peek())) >= priorityMap.get(SelectOp.getType(sb.toString())))
                {
                    postfix.add(stack.pop());
                }
                stack.push(String.valueOf(sb.toString()));
            }
            else if(arr[a] == '(')
            {
                isMinus = true;
                stack.push(String.valueOf(arr[a]));
            }
            else if(arr[a] == ')')
            {
                while(!stack.isEmpty() && !stack.peek().equals("("))
                {
                    postfix.add(stack.pop());
                }
                stack.pop();
            }
            else
            {
                while(!stack.isEmpty() && priorityMap.get(SelectOp.getType(stack.peek())) >= priorityMap.get(SelectOp.getType(arr[a])))
                {
                    postfix.add(stack.pop());
                }
                stack.push(String.valueOf(arr[a]));
            }
        }
        while(!stack.isEmpty())
        {
            postfix.add(stack.pop());
        }
    }

    private void calculate()
    {
        for(int a = 0; a < postfix.size(); a++)
        {
            System.out.print(postfix.get(a)+" ");
        }
        System.out.println();
        Stack<Double> stack = new Stack<Double>();
        for(int a = 0; a < postfix.size(); a++)
        {
            if(SelectOp.getType(postfix.get(a)) == null || SelectOp.getType(postfix.get(a)) == SelectOp.number)
                stack.push(new Double(postfix.get(a)));
            else
            {
                if(postfix.get(a).equals("+"))
                {
                    Double y = stack.pop();
                    Double x = stack.pop();
                    stack.push(x + y);
                }
                else if(postfix.get(a).equals("-"))
                {
                    Double y = stack.pop();
                    Double x = stack.pop();
                    stack.push(x - y);
                }
                else if(postfix.get(a).equals("*") || postfix.get(a).equals("×"))
                {
                    Double y = stack.pop();
                    Double x = stack.pop();
                    stack.push(x * y);
                }
                else if(postfix.get(a).equals("/") || postfix.get(a).equals("÷"))
                {
                    Double y = stack.pop();
                    Double x = stack.pop();
                    if(y == 0)
                        throw new ArithmeticException("除数不能为0！");
                    stack.push(x / y);
                }
                else if(postfix.get(a).equals("^"))
                {
                    Double y = stack.pop();
                    Double x = stack.pop();
                    stack.push(Math.pow(x, y));
                }
                else if(postfix.get(a).equals("sin"))
                {
                    Double x = stack.pop();
                    x = 2 * Math.PI * (x / 360);
                    stack.push(Math.sin(x));
                }
                else if(postfix.get(a).equals("cos"))
                {
                    Double x = stack.pop();
                    x = 2 * Math.PI * (x / 360);
                    stack.push(Math.cos(x));
                }
                else if(postfix.get(a).equals("tan"))
                {
                    Double x = stack.pop();
                    if(x % 90 == 0 && (x / 90) % 2 != 0)
                        throw new ArithmeticException("error");
                    x = 2 * Math.PI * (x / 360);
                    stack.push(Math.tan(x));
                }
            }
        }
        if(stack.size() != 1)
        {
            throw new NullPointerException();
        }
        Double temp = stack.pop();
        if(temp == temp.intValue())
            result = Integer.toString(temp.intValue());
        else
            result = temp.toString();

    }

    public String getResult()
    {
        return result;
    }
}
