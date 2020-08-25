package com.leetcode.digui;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-08-07 16:57
 * @Description: https://leetcode-cn.com/problems/generate-parentheses/
 */
public class S22GenerateParentheses {
    List<String> result = new ArrayList<>();

    /*所有的括号情况*/
    public List<String> generateParenthesisAll(int n) {
        gne_help(0, n * 2, "");
        return result;
    }

    private void gne_help(int n ,int max, String s) {
        if(n == max){
            result.add(s);
            return;
        }
        gne_help(n+1, max, s + "(" );
        gne_help(n+1, max, s +")");
    }

    public static void main(String[] args) {
        S22GenerateParentheses s = new S22GenerateParentheses();
        List<String> strings = s.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        gene_help(0,0,  n , "");
        return result;
    }

    private void gene_help(int left, int right,int max, String s) {
        if(left == max && right == max){
            System.out.println("3---" + s);
            result.add(s);
            return;
        }
        if(left < max){
            System.out.println("1----" + s);
            gene_help(left+1, right, max, s + "(");
        }

        if(right < left){
            System.out.println("2----" + s);
            gene_help(left, right + 1, max, s + ")");
        }

    }
}
