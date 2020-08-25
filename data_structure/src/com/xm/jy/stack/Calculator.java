package com.xm.jy.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: albert.fang
 * @date: 2020/8/25 13:21
 * @description: 用栈实现综合计算器（中缀表达式：我们平时书写的表达式就是中缀的，从左到右一目了然的东西，比如：4 - 5 + 3 / 3）
 */
public class Calculator {

    // 思路分析
    // 1、将一个中缀表达式的String转成一个List
    // 2、创建两个栈，一个用于表示符号栈、一个用于表示数栈
    // 3、从左到右扫描中缀表达式的List,碰见数字则压入数栈中；
    // 4、碰见符号则需要先进行判断符号栈中是否为空，为空则直接加入；
    // 如果不为空则需要判断要入栈的符号和当前符号栈栈顶符号的优先级大小：
    // 如果要入栈的符号优先级小于等于当前符号栈的栈顶符号，pop出符号栈当前的栈顶元素，并且从数栈pop出两个数字，进行计算，将得到的结果push到数栈中。
    // 5、当中缀表达式的List扫描完毕之后，则按顺序出栈并且将得到的结果入数栈操作
    // 6、数栈中最后一个数字就是表达式的结果

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = "";
        while (scanner.hasNextLine()){
            expression = scanner.nextLine();
            if ("exit".equals(expression)) {
                System.out.println("退出程序");
                break;
            }
            else {
                // 数栈和符号栈
                Stack<Integer> numStack = new Stack<>();
                Stack<String> operStack = new Stack<>();
                List<String> stringList = Arrays.asList(expression.split(" "));
                stringList.forEach( v -> {
                    // 如果是一位或多位数字时
                    if (v.matches("\\d+")){
                        numStack.push(Integer.valueOf(v));
                    }
                    // 是符号时
                    else{
                        while (true){
                            // 先判断符号栈是否为空，为空直接加入
                            if (operStack.size() == 0){
                                operStack.push(v);
                                break;
                            }
                            // 不为空
                            else {
                                // 如果要入栈的操作符优先级大于栈顶操作符优先级，那么直接入栈
                                if (getLevel(v) > getLevel(operStack.peek())){
                                    operStack.push(v);
                                    break;
                                }
                                // 要入栈操作符小于等于栈顶操作符优先级
                                else {
                                    int num1 = numStack.pop();
                                    int num2 = numStack.pop();
                                    String oper = operStack.pop();
                                    int num = 0;
                                    if (oper.equals("+")){
                                        num = num2 + num1;
                                    }else if (oper.equals("-")){
                                        num = num2 - num1;
                                    }else if (oper.equals("*")){
                                        num = num2 * num1;
                                    }else if (oper.equals("/")){
                                        num = num2 / num1;
                                    }
                                    // 将操作之后得到的数字，入栈
                                    numStack.push(num);
                                }
                            }
                        }
                        }
                });
                while (numStack.size() > 1){
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    String oper = operStack.pop();
                    int num = 0;
                    switch (oper) {
                        case "+":
                            num = num2 + num1;
                            break;
                        case "-":
                            num = num2 - num1;
                            break;
                        case "*":
                            num = num2 * num1;
                            break;
                        case "/":
                            num = num2 / num1;
                            break;
                    }
                    // 将操作之后得到的数字，入栈
                    numStack.push(num);
                }
                System.out.println(numStack.peek());
            }
        }
        scanner.close();
    }

    // 判断符号的优先级
    private static int getLevel(String operator){
        if (operator.equals("+") || operator.equals("-")){
            return 1;
        }
        if (operator.equals("*") || operator.equals("/")){
            return 2;
        }
        throw new RuntimeException("操作符异常");
    }

}
