package com.leetcode.fenzhihuisu;

import com.algs4.algs4.In;

import java.util.*;

/**
 * @author songyi
 * @date 2020-08-12 20:59
 * @Description:
 */
public class S51NQueen {

    private Set<Integer> col = new HashSet<Integer>();
    private Set<Integer> diag1 = new HashSet<Integer>();
    private Set<Integer> diag2 = new HashSet<Integer>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res,new ArrayList<String>(), 0, n);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, int row, int n){
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++){
            //ÁÐ      ¶Ô½ÇÏß
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;

            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);

            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            dfs(res, list, row + 1, n);

            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }


    public static void main(String[] args) {
        S51NQueen solution  = new S51NQueen();
        List<List<String>> lists = solution.solveNQueens(8);
        System.out.println(lists);
    }









}
