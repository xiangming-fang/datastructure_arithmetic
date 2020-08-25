package com.xm.jy.stack;

import java.util.*;

/**
 * @author: albert.fang
 * @date: 2020/8/25 14:46
 * @description: 逆波兰表达式（计算器的计算表达式，也是后缀表达式，后缀表达式是给计算机看的，中缀表达式是给人看的）
 */
public class ReversePolandExpression {


    // 输入一个后缀表达式，运算得到表达式结果
    // 后缀表达式：1 2 3 + 4 * + 5 -
    // 思路分析：
    // 1、从左到右扫描后缀表达式，遇见数字入栈
    // 2、遇见操作符则从栈中弹出两个操作数进行运算
    // 3、将运算结果压入栈中，继续往后扫描（重复1，2，3步骤）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String expression = scanner.nextLine();
            if (expression.equals("exit")){
                break;
            }
            else {
                List<String> stringList = Arrays.asList(expression.split(" "));
                List<String> suffixExpression = infixToSuffixExpression(stringList);
                Stack<Integer> stack = new Stack<>();
                suffixExpression.forEach( v -> {
                    // 如果是数字的话
                    if (v.matches("\\d+")){
                        stack.push(Integer.valueOf(v));
                    }
                    else {
                        int num1 = stack.pop();
                        int num2 = stack.pop();
                        int num = 0;
                        switch (v) {
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
                        stack.push(num);
                    }
                });
                System.out.println(stack.peek());
            }
        }
        scanner.close();
    }

    // 将中缀表达式转换成后缀表达式
    // 思路分析：
    // 1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
    // 2) 从左至右扫描中缀表达式；
    // 3) 遇到操作数时，将其压s2；
    // 4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
    //    1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
    //    2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
    //    3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
    // 5) 遇到括号时：
    //   (1) 如果是左括号“(”，则直接压入s1
    //   (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
    // 6) 重复步骤2至5，直到表达式的最右边
    // 7) 将s1中剩余的运算符依次弹出并压入s2
    // 8)  依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
    public static List<String>  infixToSuffixExpression(List<String> stringList){
        // 用list来代替结果栈，只有放入的操作，省得后续翻转
        List<String> suffixExpression = new ArrayList<>();
        Stack<String> operStack = new Stack<>();
//        Stack<String> resultStack = new Stack<>();
        stringList.forEach( v -> {
            // 如果是操作数的话，将其压入resultStack栈中
            if (v.matches("\\d+")){
                suffixExpression.add(v);
            }
            // 如果是左括号
            else if (v.equals("(")){
                operStack.push(v);
            }
            // 如果是右括号,依次弹出符号栈的符号压入结果栈，并去掉小括号
            else if (v.equals(")")){
                String oper = "";
                while (!(oper = operStack.pop()).equals("(")){
                    suffixExpression.add(oper);
                }
            }
            // 如果是操作符的话
            else {
                while (true){
                    // 如果栈顶符号位"("或者符号栈为空，则直接入栈
                    if (operStack.size() == 0 || operStack.peek().equals("(")){
                        operStack.push(v);
                        break;
                    }
                    // 如果当前符号的优先级大于符号栈栈顶符号优先级，直接入栈
                    else if (getLevel(v) > getLevel(operStack.peek())){
                        operStack.push(v);
                        break;
                    }
                    else {
                        suffixExpression.add(operStack.pop());
                    }
                }
            }
        });
        while (operStack.size() > 0){
            suffixExpression.add(operStack.pop());
        }
        return suffixExpression;
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
