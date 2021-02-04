package com.leetcode.digui;

/**
 * @author songyi
 * @date 2020-11-27 12:42
 * @Description:
 */
public class S529SaoLei {

    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // ���� 1
            board[x][y] = 'X';
        } else{
            dfs(board, x, y);
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; ++i) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            // �����ж� M����Ϊ����� M �Ļ���Ϸ�Ѿ�������
            if (board[tx][ty] == 'M') {
                ++cnt;
            }
        }
        if (cnt > 0) {
            // ���� 3
            board[x][y] = (char) (cnt + '0');
        } else {
            // ���� 2
            board[x][y] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                // ���ﲻ��Ҫ�ڴ��� B ��ʱ�������չ����Ϊ B ֮ǰ�������ʱ���Ѿ�����չ����
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }

    /**
     * ������һ������ɨ����Ϸ��
     *
     * ����һ��������Ϸ��Ķ�ά�ַ�����?'M'?����һ��δ�ڳ��ĵ��ף�'E'?����һ��δ�ڳ��Ŀշ��飬'B'?����û�����ڣ��ϣ��£����ң�������4���Խ��ߣ����׵����ڳ��Ŀհ׷��飬���֣�'1' �� '8'����ʾ�ж��ٵ�����������ڳ��ķ������ڣ�'X'?���ʾһ�����ڳ��ĵ��ס�
     *
     * ���ڸ���������δ�ڳ��ķ����У�'M'����'E'������һ�����λ�ã��к������������������¹��򣬷�����Ӧλ�ñ�������Ӧ����壺
     *
     * ���һ�����ף�'M'�����ڳ�����Ϸ�ͽ�����- ������Ϊ?'X'��
     * ���һ��û�����ڵ��׵Ŀշ��飨'E'�����ڳ����޸���Ϊ��'B'�����������к������ڵ�δ�ڳ����鶼Ӧ�ñ��ݹ�ؽ�¶��
     * ���һ��������һ���������ڵĿշ��飨'E'�����ڳ����޸���Ϊ���֣�'1'��'8'������ʾ���ڵ��׵�������
     * ����ڴ˴ε���У����޸��෽��ɱ���¶���򷵻���塣
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/minesweeper
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     *
     * ����:
     *
     * [['E', 'E', 'E', 'E', 'E'],
     *  ['E', 'E', 'M', 'E', 'E'],
     *  ['E', 'E', 'E', 'E', 'E'],
     *  ['E', 'E', 'E', 'E', 'E']]
     *
     * Click : [3,0]
     *
     * ���:
     *
     * [['B', '1', 'E', '1', 'B'],
     *  ['B', '1', 'M', '1', 'B'],
     *  ['B', '1', '1', '1', 'B'],
     *  ['B', 'B', 'B', 'B', 'B']]
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/minesweeper
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     */

}
