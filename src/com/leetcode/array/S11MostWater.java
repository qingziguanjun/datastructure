package com.leetcode.array;

/**
 * @author songyi
 * @date 2020-07-23 19:32
 * @Description:https://leetcode-cn.com/problems/container-with-most-water/
 */
public class S11MostWater {
    /**
     *  ‰»Î£∫[1,8,6,2,5,4,8,3,7]
     *  ‰≥ˆ£∫49
     */


    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        S11MostWater s11 = new S11MostWater();
        System.out.println(s11.maxArea(nums));
    }

    public int sum(int[] nums){
        int max = 0;
        for(int i = 0, j = nums.length -1 ; i < j; ){
            int minHeight = nums[i] < nums[j] ? nums[i++] : nums[j--];
            max = Math.max((j -i + 1) * minHeight, max );
        }
        return max;
    }


    public int maxArea(int[] nums){
        int max = 0;
        for(int i = 0, j = nums.length-1; i < j; ){
            int t = Math.min(nums[i], nums[j])*(j-i);
            if(t > max){
                max=t;
            }
            if(nums[i] < nums[j]){
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}
