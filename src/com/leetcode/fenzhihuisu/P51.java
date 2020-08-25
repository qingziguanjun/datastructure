package com.leetcode.fenzhihuisu;

import java.util.*;

public class P51 {

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    /**
     * ˼��·����
     * 1. ��λ����backtrack problem
     * 2. ˼���������Ĺ�������
     * 3. ˼�����ݵ�ģ��
     */
    // ��������ÿһ���ʾ�����ϵ�ÿһ�У�ÿ���ڵ����������ѡ���ǣ��ڸ��е�����һ�з���һ���ʺ�
    static class Solution1 {
        List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
            if (n <= 0) return null;
            res = new LinkedList<>();
            char[][] board = new char[n][n];
            for (char[] chars : board) Arrays.fill(chars, '.');
            backtrack(board, 0);
            return res;
        }

        /**
         * ·����board��С��row����Щ�ж��Ѿ��ɹ������˻ʺ�
         * ��ѡ���б�: ��row�е������ж��Ƿ���Q��ѡ��
         * ��������: row����board�����һ��
         *
         * @param board
         * @param row
         */
        private void backtrack(char[][] board, int row) {
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }
            int n = board[row].length;
            for (int col = 0; col < n; col++) {
                if (!isValid(board, row, col)) continue;
                board[row][col] = 'Q';
                backtrack(board, row + 1);
                board[row][col] = '.';
            }
        }

        private boolean isValid(char[][] board, int row, int col) {
            int rows = board.length;
            // check is valid in col
            for (char[] chars : board) if (chars[col] == 'Q') return false;
            // check is valide upright
            for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
                if (board[i][j] == 'Q') return false;
            }
            // check is valide upleft
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') return false;
            }
            return true;
        }

    }

    public static class Solution2 {

        /**
         * �Ż�isValid�Ĳ�ѯ��ͨ��3��set���ֱ��¼�С����Խ��ߡ����Խ�����Q����������ٵ����Ĳ�ѯ
         * Keyֵ��colIndex, [r-c], [r + c] ��Ϊset��key
         */
        private List<List<String>> res = new LinkedList<>();
        private Set<Integer> colSet = new HashSet<>();
        private Set<Integer> masterSet = new HashSet<>();
        private Set<Integer> slaveSet = new HashSet<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] chars : board) Arrays.fill(chars, '.');
            backtrack(board, 0);
            return res;
        }

        /**
         * path: board in [0, row -1]
         * choices for a row : every cols
         * time to end: row == board.length
         *
         * @param board
         * @param row
         */
        private void backtrack(char[][] board, int row) {
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }
            for (int col = 0; col < board[row].length; col++) {
                if (!isValide(board, row, col)) continue;
                updateRecords(board, row, col);
                backtrack(board, row + 1);
                updateRecords(board, row, col);
            }
        }

        private void updateRecords(char[][] board, int row, int col) {
            if (colSet.contains(col)) {
                board[row][col] = '.';
                colSet.remove(col);
                masterSet.remove(row - col);
                slaveSet.remove(row + col);
            } else {
                board[row][col] = 'Q';
                colSet.add(col);
                masterSet.add(row - col);
                slaveSet.add(row + col);
            }
        }

        private boolean isValide(char[][] board, int row, int col) {
            return !colSet.contains(col)
                    && !masterSet.contains(row - col)
                    && !slaveSet.contains(row + col);
        }

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<List<String>> lists = solution2.solveNQueens(4);
        System.out.println(lists);
    }

}