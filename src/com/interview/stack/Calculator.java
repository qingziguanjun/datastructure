package com.interview.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author songyi
 * @date 2020-02-12 07:24
 * @Description:
 */
public class Calculator {

    public final  String OPEN_PAREN= "(";
    public final  String CLOSE_PAREN= ")";
    public final  String PLUS = "+";
    public final  String MINUS = "-";
    public final  String MULTI = "*";
    public final  String DIVIDED = "/";
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
       // String exp = "1*2-3/4+5*6-7*8+9/10";
        String exp = "1+((2+3)*4)-5";
        int result = calculator.calculate(exp);
        System.out.println(result);
    }

    private List<String> convert(String exp) {
        List<String> postfixExp = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        List<String> elements = getElement(exp);
        for(int i= 0; i < elements.size(); i++){
            String e = elements.get(i);
            switch (e){
                case OPEN_PAREN:
                    stack.push(e);
                    break;
                case CLOSE_PAREN:
                    while (!stack.peek().equals(OPEN_PAREN)){
                        postfixExp.add(stack.pop());
                    }
                    stack.pop();
                    break;
                case PLUS:
                case MINUS:
                case MULTI:
                case DIVIDED:
                    //todo 可以优化下面几行简化
                    while (stack.size() != 0 && compare(stack.peek(), e) >= 0){
                        postfixExp.add(stack.pop());
                    }
                    stack.push(e);
//                    if(stack.isEmpty()){
//                        stack.push(e);
//                    }else {
//                        while (!stack.isEmpty()) {
//                            String peek = stack.peek();
//                            if(peek.equals(OPEN_PAREN) || peek.equals(CLOSE_PAREN)){
//                                //入栈继续
//                                stack.push(e);
//                                break;
//                            }
//                            if (compare(peek, e) < 0) {
//                                //如果新的优先级高，入栈
//                                stack.push(e);
//                                break;
//                            } else {
//                                String pop = stack.pop();
//                                //如果新的优先级低，出栈
//                                postfixExp.add(pop);
//                            }
//                            //这里太难了，如果新来的优先级不高，一直出栈，直到栈为空，加入
//                            if(stack.isEmpty()){
//                                stack.push(e);
//                                break;
//                            }
//                        }
//                    }
                    break;
                default:
                    postfixExp.add(e);
                    break;
            }
        }
        while (!stack.isEmpty()){
            postfixExp.add(stack.pop());
        }
        String res = String. join(" ", postfixExp);
        System.out.println(res);
        return postfixExp;
    }

    //todo 这个比较不好,要优化
    public int compare(String com1, String com2){
        if(com1.equals(MULTI) || com1.equals(DIVIDED)){
            if(com2.equals(PLUS) || com2.equals(MINUS)){
                return 1;
            }
        }else if(com2.equals(MULTI) || com2.equals(DIVIDED)){
            return -1;
        }
        return 0;
    }


    public int calculate(String s) {
        List<String> postfixExp = convert(s);
        return doCalculate(postfixExp);
    }


    /**
     * 将字符串转换成中缀表达式
     * @param exp   a+b*c +(d*e+f)*g
     * @return
     */
    public List<String> getElement(String exp){
        String expNoSpace = exp.replaceAll(" ", "");
        int index = 0;
        String element = "";
        List<String> expList = new ArrayList<>();
        while (index < expNoSpace.length()){
            char temp = expNoSpace.charAt(index);
            element = element + temp;
            if(isNum(temp)) {
                if (index + 1 < expNoSpace.length()) {
                    char next = expNoSpace.charAt(index +1 );
                    if(!isNum(next)){
                        expList.add(element);
                        //清空
                        element = "";
                    }
                }else {
                    expList.add(element);
                    //清空
                    element = "";
                }
                index++;
            }else {
                expList.add(element);
                //清空
                element = "";
                index++;
            }
        }
        return expList;
    }

    public boolean isNum(char c){
        return c >= 48 && c <=57;
    }

    public int doCalculate(List<String> eles){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < eles.size(); i++) {
            String e = eles.get(i);
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
