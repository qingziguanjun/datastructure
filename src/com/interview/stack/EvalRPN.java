package com.interview.stack;

import java.util.List;
import java.util.Stack;

/**
 * @author songyi
 * @date 2020-02-12 10:37
 * @Description:https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 逆波兰表达式求值
 */
public class EvalRPN {
    public final  String OPEN_PAREN= "(";
    public final  String CLOSE_PAREN= ")";
    public final  String PLUS = "+";
    public final  String MINUS = "-";
    public final  String MULTI = "*";
    public final  String DIVIDED = "/";
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String e = tokens[i];
            switch (e) {
                case PLUS:
                case MINUS:
                case MULTI:
                case DIVIDED:
                    String num1 = stack.pop();
                    String num2 = stack.pop();
                    int tempResult = calculate(num2, num1, e);
                    stack.push(tempResult + "");
                    break;
                default:
                    stack.push(e);
                    break;
            }
        }
        String strResult = stack.pop();
        return Integer.parseInt(strResult);
    }

    public int calculate(String strNum1, String strNum2, String e){
        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);
        switch (e) {
            case PLUS:
                return num1 + num2;
            case MINUS:
                return num1 - num2;
            case MULTI:
                return num1 * num2;
            case DIVIDED:
                return num1 / num2;
        }
        throw new RuntimeException("表达式错误");
    }
}
