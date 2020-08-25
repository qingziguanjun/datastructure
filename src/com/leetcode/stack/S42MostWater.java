package com.leetcode.stack;

/**
 * @author songyi
 * @date 2020-08-06 07:38
 * @Description:
 */
public class S42MostWater {

        // �����ⷨ���ҵ�������ߵ��Ǹ��߶ȣ���Ҫ��ȥ�Լ��ĸ߶�

        public int trap(int[] height) {
            int len = height.length;
            // ����
            if (len < 3) {
                return 0;
            }

            int res = 0;
            // ������ [1, len - 2] ��ÿ��λ�ã��ֱ������Դ�ˮ�ĵ�λ���
            for (int i = 1; i < len - 1; i++) {
                int leftHighest = max(height, 0, i - 1);
                int rightHighest = max(height, i + 1, len - 1);

                // ľͰԭ����ˮ�ĸ߶�ȡ���ڶ���֮�еĽϰ���
                int curHeight = Math.min(leftHighest, rightHighest);
                if (curHeight > height[i]) {
                    res += (curHeight - height[i]);
                }
            }
            return res;
        }

        private int max(int[] height, int left, int right) {
            int res = height[left];
            for (int i = left + 1; i <= right; i++) {
                res = Math.max(res, height[i]);
            }
            return res;
        }
    /*
   ���ߣ�liweiwei1419
    ���ӣ�https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/
    ��Դ�����ۣ�LeetCode��*/


    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        S42MostWater s = new S42MostWater();
        int trap = s.trap(nums);
        System.out.println(trap);
    }


    /**
     * �������������ƽ��Ż���ʹ�������¼��������ұ����
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int len = height.length;
        // ����
        if (len < 3) {
            return 0;
        }

        // leftHighest[i] ���壺���� [0, i - 1] �е����ֵ
        int[] leftHighest = new int[len];
        // �±�Ϊ 0 �� �±�Ϊ len - 1 ��λ�ò��ü��㣬����ͬ��
        for (int i = 1; i < len - 1; i++) {
            leftHighest[i] = Math.max(height[i - 1], leftHighest[i - 1]);
        }

        // rightHighest[i] ���壺���� [i + 1, len - 1] �е����ֵ
        int[] rightHighest = new int[len];
        for (int i = len - 2; i > 0; i--) {
            rightHighest[i] = Math.max(height[i + 1], rightHighest[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int minHeight = Math.min(leftHighest[i], rightHighest[i]);
            if (height[i] < minHeight) {
                res += minHeight - height[i];
            }
        }
        return res;
    }


    // ˫ָ�루ָ���ײ��

    public int trap3(int[] height) {
        int len = height.length;
        // ����
        if (len < 3) {
            return 0;
        }

        // ע���ֵ��ѡȡ��ǰ���������У��±� 0 �� len - 1 λ�ö�������ˮ�����������Ч
        // ������ [1, len - 2] ������ˮ��
        int left = 1;
        int right = len - 2;

        // ��¼���� [0, left - 1] �����߶�
        int curLeftHighest = height[0];
        // ��¼���� [right + 1, len - 1] �����߶�
        int curRightHighest = height[len - 1];

        int res = 0;
        // �����ǵ��ڣ���Ϊ�� left == right ��ʱ��left(right) ���λ�õĴ�ˮ������Ҫ����һ��
        while (left <= right) {
            // ���Դ���
            // System.out.println("left = " + left + " right = " + right + " curLeftHighest = " + curLeftHighest + " curRightHighest = " + curRightHighest+ " res = " + res );
            int minHeight = Math.min(curLeftHighest, curRightHighest);

            // ��ˮ��λ���ȡ���ڽ϶̵��Ǹ����εĸ߶�
            if (minHeight == curLeftHighest) {
                if (minHeight > height[left]) {
                    // ���ڵ�ǰ���ſ��Դ�ˮ
                    res += minHeight - height[left];
                }
                // ������ߵ����ε���߸߶�
                curLeftHighest = Math.max(curLeftHighest, height[left]);
                // ָ������
                left++;
            } else {
                if (minHeight > height[right]) {
                    res += minHeight - height[right];
                }
                curRightHighest = Math.max(curRightHighest, height[right]);
                right--;
            }
        }
        return res;
    }

}
