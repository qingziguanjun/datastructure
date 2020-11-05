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

        List<String> strings2 = s.generateParenthesis2(3);
        System.out.println(strings2);
    }

    public List<String> generateParenthesis(int n) {
        gene_help(0,0,  n , "");
        return result;
    }

    private void gene_help(int left, int right,int max, String s) {
        if(left == max && right == max){
            result.add(s);
            return;
        }
        if(left < max){
            gene_help(left+1, right, max, s + "(");
        }

        if(right < left){
            gene_help(left, right + 1, max, s + ")");
        }

    }


    //#####括号生成#########
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    public void dfs(String curStr, int left, int right, List<String> res){
        //递归终止的时候加入结果集  46 39题
        if(left == 0 && right == 0 ){
            res.add(curStr);
            return;
        }
        //剪枝  左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝
        if(left > right){
            return;
        }

        if(left > 0){
            dfs(curStr + "(", left-1, right, res);
        }
        if(right > 0){
            dfs(curStr + ")", left, right-1, res);
        }
    }
}
