package com.example.caculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.opton_normal_1:
                Intent intent =new Intent(MainActivity.this,HelpActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.caculater);
        setTitle("简单计算器");
        setView();
    }

        public void setView(){
        final Button getResult = (Button) findViewById(R.id.getResult);
        Button zero = (Button) findViewById(R.id.zero);
        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById((R.id.eight));
        Button nine = (Button) findViewById(R.id.nine);
        final Button clear = (Button) findViewById(R.id.clear);
        Button backspace = (Button) findViewById(R.id.backspace);
        final Button point = (Button) findViewById(R.id.point);
        Button divide = (Button) findViewById(R.id.divide);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button button_jz = (Button) findViewById(R.id.button_jz);
        Button left = (Button) findViewById(R.id.left);
        Button right = (Button) findViewById(R.id.right);
        Button percentage = (Button) findViewById(R.id.percentage);
        Button button_dw = (Button) findViewById(R.id.button_dw);
        Button sin = (Button) findViewById(R.id.sin);
        Button cos = (Button) findViewById(R.id.cos);
        Button tan = (Button) findViewById(R.id.tan);
        final TextView textView1 = (TextView)findViewById(R.id.textView1);
        final TextView textView2 = (TextView)findViewById(R.id.textView2);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew=textView1.getText().toString().charAt(textView1.getText().toString().length()-1);
                if((!textView1.getText().toString().equals("0"))&&(findnew!=')')){
                    textView1.setText(textView1.getText().toString()+"0");
                }
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("1");
                    } else {
                        textView1.setText(textView1.getText().toString() + "1");
                    }
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("2");
                    } else {
                        textView1.setText(textView1.getText().toString() + "2");
                    }
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("3");
                    } else {
                        textView1.setText(textView1.getText().toString() + "3");
                    }
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("4");
                    } else {
                        textView1.setText(textView1.getText().toString() + "4");
                    }
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("5");
                    } else {
                        textView1.setText(textView1.getText().toString() + "5");
                    }
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("6");
                    } else {
                        textView1.setText(textView1.getText().toString() + "6");
                    }
                }
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("7");
                    } else {
                        textView1.setText(textView1.getText().toString() + "7");
                    }
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("8");
                    } else {
                        textView1.setText(textView1.getText().toString() + "8");
                    }
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (findnew != ')') {
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("9");
                    } else {
                        textView1.setText(textView1.getText().toString() + "9");
                    }
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if(findnew==')'||findnew=='0'||findnew=='1'||findnew=='2'||findnew=='3'||findnew=='4'
                        ||findnew=='5' ||findnew=='6'||findnew=='7'||findnew=='8'||findnew=='9')
                    textView1.setText(textView1.getText().toString()+"+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if(findnew==')'||findnew=='0'||findnew=='1'||findnew=='2'||findnew=='3'||findnew=='4'
                        ||findnew=='5' ||findnew=='6'||findnew=='7'||findnew=='8'||findnew=='9')
                    textView1.setText(textView1.getText().toString()+"-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if(findnew==')'||findnew=='0'||findnew=='1'||findnew=='2'||findnew=='3'||findnew=='4'
                        ||findnew=='5' ||findnew=='6'||findnew=='7'||findnew=='8'||findnew=='9')
                    textView1.setText(textView1.getText().toString()+"*");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if(findnew==')'||findnew=='0'||findnew=='1'||findnew=='2'||findnew=='3'||findnew=='4'
                        ||findnew=='5' ||findnew=='6'||findnew=='7'||findnew=='8'||findnew=='9')
                    textView1.setText(textView1.getText().toString()+"/");
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberl=appearNumber(textView1.getText().toString(),"(");
                int numberr=appearNumber(textView1.getText().toString(),")");
                char findnew=textView1.getText().toString().charAt(textView1.getText().toString().length()-1);
                if(numberr<numberl &&(findnew=='0'||findnew=='1'||findnew=='2'||findnew=='3'||findnew=='4'
                        ||findnew=='5' ||findnew=='6'||findnew=='7'||findnew=='8'||findnew=='9'))
                    textView1.setText(textView1.getText().toString()+")");
            }
            public int appearNumber(String srcText, String findText) {
                int count = 0;
                int index = 0;
                while ((index = srcText.indexOf(findText, index)) != -1) {
                    index = index + findText.length();
                    count++;
                }
                return count;
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView1.getText().toString().equals("0")){
                    textView1.setText("(");
                }else {
                    char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                    if (findnew != '0' && findnew != '1' && findnew != '2' && findnew != '3' && findnew != '4' && findnew != '5'
                            && findnew != '6' && findnew != '7' && findnew != '8' && findnew != '9' && findnew != '.') {
                        textView1.setText(textView1.getText().toString() + "(");
                    }
                }
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            private boolean pointFlag = true;
            @Override
            public void onClick(View view) {
                String str = textView1.getText().toString();
                boolean pointFlag = true;
                int lastIndex;
                for (lastIndex = str.length() - 1; lastIndex >= 0; --lastIndex) {
                    if (str.charAt(lastIndex) == '.') {
                        pointFlag = false;
                        break;
                    } else if (Character.isDigit(str.charAt(lastIndex))) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (pointFlag) {
                    // lastNum = str.subString(lastIndex + 1, str.length())
                    // if (lastNum.length() > 0) {
                    //     textView1.setText(str + ".");
                    // }

                    if (lastIndex + 1 == str.length()) {
                        // do nothing
                    } else {
                        textView1.setText(str + ".");
                    }
                } else {
                    // do nothing
                }

            }
        });
        button_dw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(MainActivity.this,UnitConverter.class);
                    startActivity(intent);
                }
            });
        button_jz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(MainActivity.this,BinaryConverter.class);
                    startActivity(intent);
                }
            });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew = textView1.getText().toString().charAt(textView1.getText().toString().length() - 1);
                if (textView1.getText().toString().equals("0")) {
                    textView1.setText("sin");
                } else {
                    if (findnew == '+' || findnew == '-' || findnew == '*' || findnew == '/' || findnew == '(') {
                        textView1.setText(textView1.getText().toString() + "sin");
                    }
                }
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew=textView1.getText().toString().charAt(textView1.getText().toString().length()-1);
                if(textView1.getText().toString().equals("0")){
                    textView1.setText("cos");
                }
                else {
                    if (findnew == '+' || findnew == '-' || findnew == '*' || findnew == '/' || findnew == '(') {
                        textView1.setText(textView1.getText().toString() + "cos");
                    }
                }
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char findnew=textView1.getText().toString().charAt(textView1.getText().toString().length()-1);
                if(textView1.getText().toString().equals("0")){
                    textView1.setText("tan");
                }
                else {
                    if (findnew == '+' || findnew == '-' || findnew == '*' || findnew == '/' || findnew == '(') {
                        textView1.setText(textView1.getText().toString() + "tan");
                    }
                }
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("0");
                textView2.setText("0");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int llo = textView1.getText().length();
                if(llo!=1) {
                    String ss = textView1.getText().toString().substring(0, llo - 1);
                    textView1.setText(ss);
                }
                else{
                    textView1.setText("0");
                }
            }
        });
        getResult.setOnClickListener(new View.OnClickListener() {
            public double giveResult (String exp){
                String[] arr = exp.split("\\s+");
                for (String ss : arr) {
                    Log.i("d", ss);
                }
                Stack<Double> stack = new Stack<Double>();
                for (String ss : arr) {

                    if (!(ss.equals("+") || ss.equals("-") || ss.equals("*") || ss.equals("/") || ss.equals("^") || ss.equals("c") || ss.equals("s") || ss.equals("t") || ss.equals("√"))) {
                        double kk = Double.valueOf(ss);
                        //Log.i("d",String.valueOf(kk) );
                        stack.push(kk);
                    }
                    if (ss.equals("+")) {
                        double a = stack.pop();
                        double b = stack.pop();
                        stack.push(a + b);
                    }
                    if (ss.equals("-")) {
                        double a = stack.pop();
                        double b = stack.pop();
                        stack.push(b - a);
                    }
                    if (ss.equals("*")) {
                        double a = stack.pop();
                        double b = stack.pop();
                        stack.push(a * b);
                    }
                    if (ss.equals("/")) {
                        double a = stack.pop();
                        double b = stack.pop();
                        stack.push(b / a);
                    }
                    if (ss.equals("c")) {
                        double a = stack.pop();
                        a = 2 * Math.PI * (a / 360);
                        stack.push(Math.cos(a));
                    }
                    if (ss.equals("s")) {
                        double a = stack.pop();
                        a = 2 * Math.PI * (a / 360);
                        stack.push(Math.sin(a));
                    }
                    if (ss.equals("t")) {
                        double a = stack.pop();
                        a = 2 * Math.PI * (a / 360);
                        stack.push(Math.tan(a));
                    }
                }
                return stack.pop();
            }
            public int priority ( char fu){
                if (fu == '+' || fu == '-') {
                    return 1;
                }
                if (fu == '*' || fu == '/') {
                    return 2;
                }
                if (fu == 'c' || fu == 's' || fu == 't' || fu == '√') {
                    return 3;
                }
                return 0;
            }

            public String suffixS (String inputs){
                Stack<Character> stack = new Stack<Character>();
                String suffix = "";
                int index = 0;
                int length = inputs.length();
                while (index < length) {
                    switch (inputs.charAt(index)) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case '.':
                            suffix += inputs.charAt(index);
                            break;
                        case 'c':
                        case 's':
                        case 't':
                            suffix += " ";
                            while (stack.size() != 0) {
                                char temp = stack.peek();
                                if (temp == '(') {
                                    break;
                                }
                                if (priority(temp) >= 4) {
                                    stack.pop();
                                    suffix += temp;
                                    suffix += " ";
                                } else {
                                    break;
                                }
                            }
                            stack.push(inputs.charAt(index));
                            index = index + 2;
                            break;
                        case '*':
                        case '/':
                            suffix += " ";
                            while (stack.size() != 0) {
                                char temp2 = stack.peek();
                                if (temp2 == '(') {
                                    break;
                                }
                                if (priority(temp2) >= 2) {
                                    stack.pop();
                                    suffix += temp2;
                                    suffix += " ";
                                } else {
                                    break;
                                }

                            }
                            stack.push(inputs.charAt(index));
                            break;
                        case '(':
                            suffix += " ";
                            stack.push(inputs.charAt(index));
                            break;
                        case '+'://当遇到加减符号时，将运算式中所有符号弹出，放到输出队列
                        case '-':
                            suffix += " ";
                            while (stack.size() != 0) {
                                char temp = stack.peek();
                                if (temp == '(') {
                                    //stack.push('(');
                                    break;
                                }
                                if (priority(temp) >= 1) {
                                    stack.pop();
                                    suffix += temp;
                                    suffix += " ";
                                }
                            }
                            stack.push(inputs.charAt(index));
                            break;
                        case ')':
                            suffix += " ";
                            while (!stack.isEmpty() && stack.peek() != '(') {

                                suffix += stack.pop();
                                suffix += " ";

                            }
                            stack.pop();
                            break;
                    }
                    index++;
                }
                while (!stack.isEmpty()) {
                    suffix += " ";
                    suffix += stack.pop();

                }
                Log.i("d", suffix);
                return suffix;
            }
            @Override
            public void onClick(View view) {
                int numberl=appearNumber(textView1.getText().toString(),"(");
                int numberr=appearNumber(textView1.getText().toString(),")");
                char findnew=textView1.getText().toString().charAt(textView1.getText().toString().length()-1);
                if((numberl==numberr)&&(findnew=='0'||findnew=='1'||findnew=='2'||findnew=='3'||findnew=='4'
                        ||findnew=='5' ||findnew=='6'||findnew=='7'||findnew=='8'||findnew=='9'||findnew==')')) {
                    String inputs = textView1.getText().toString();
                    String out = "0+" + inputs;
                    String siffixs = suffixS(out);
                    double result = giveResult(siffixs);
                    //textView1.setText(siffixs);
                    textView2.setText(inputs + "=" + result);
                   // textView1.setText(String.valueOf(result));
                    textView2.setText(String.format("%.2f", result));
                }
            }
            public int appearNumber(String srcText, String findText) {
                int count = 0;
                int index = 0;
                while ((index = srcText.indexOf(findText, index)) != -1) {
                    index = index + findText.length();
                    count++;
                }
                return count;
            }
        });

    }
}
