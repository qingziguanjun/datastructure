package com.leetcode.stack;

/**
 * @author songyi
 * @date 2020-08-06 07:38
 * @Description:
 */
public class S42MostWater {

        // 暴力解法：找到两边最高的那个高度，还要减去自己的高度

        public int trap(int[] height) {
            int len = height.length;
            // 特判
            if (len < 3) {
                return 0;
            }

            int res = 0;
            // 对区间 [1, len - 2] 的每个位置，分别计算可以存水的单位体积
            for (int i = 1; i < len - 1; i++) {
                int leftHighest = max(height, 0, i - 1);
                int rightHighest = max(height, i + 1, len - 1);

                // 木桶原理，存水的高度取决于二者之中的较矮者
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
   作者：liweiwei1419
    链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/
    来源：力扣（LeetCode）*/


    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        S42MostWater s = new S42MostWater();
        int trap = s.trap(nums);
        System.out.println(trap);
    }


    /**
     * 方法二：暴力破解优化，使用数组记录左边最大和右边最大。
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        // leftHighest[i] 定义：区间 [0, i - 1] 中的最大值
        int[] leftHighest = new int[len];
        // 下标为 0 和 下标为 len - 1 的位置不用计算，下面同理
        for (int i = 1; i < len - 1; i++) {
            leftHighest[i] = Math.max(height[i - 1], leftHighest[i - 1]);
        }

        // rightHighest[i] 定义：区间 [i + 1, len - 1] 中的最大值
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


    // 双指针（指针对撞）

    public int trap3(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        // 注意初值的选取，前面做了特判，下标 0 和 len - 1 位置都不存雨水，因此这里有效
        // 在区间 [1, len - 2] 里计算存水量
        int left = 1;
        int right = len - 2;

        // 记录区间 [0, left - 1] 的最大高度
        int curLeftHighest = height[0];
        // 记录区间 [right + 1, len - 1] 的最大高度
        int curRightHighest = height[len - 1];

        int res = 0;
        // 这里是等于，因为当 left == right 的时候，left(right) 这个位置的存水量还需要计算一下
        while (left <= right) {
            // 调试代码
            // System.out.println("left = " + left + " right = " + right + " curLeftHighest = " + curLeftHighest + " curRightHighest = " + curRightHighest+ " res = " + res );
            int minHeight = Math.min(curLeftHighest, curRightHighest);

            // 存水单位体积取决于较短的那个柱形的高度
            if (minHeight == curLeftHighest) {
                if (minHeight > height[left]) {
                    // 大于当前，才可以存水
                    res += minHeight - height[left];
                }
                // 更新左边的柱形的最高高度
                curLeftHighest = Math.max(curLeftHighest, height[left]);
                // 指针右移
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
