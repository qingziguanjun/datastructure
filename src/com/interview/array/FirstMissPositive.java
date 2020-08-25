package com.interview.array;

import java.io.File;
import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-19 09:37
 * @Description: 第一个对丢失的正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class FirstMissPositive {


    public static void main(String[] args) {
        int[] nums = {1,2,-1};
        int[] nums2 = {3,4,-1,1};
        int[] nums3 = { 7,8,9,11,12};
        FirstMissPositive firstMissPositive = new FirstMissPositive();
        //firstMissPositive.firstMissingPositive(nums);
        firstMissPositive.firstMissingPositive(nums2);
        firstMissPositive.firstMissingPositive(nums3);
    }
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }



        for(int i = 0; i < nums.length ; i++){
            if( nums[i] <= nums.length && nums[i] > 0 && nums[i] != i+1){
                int t = nums[i];
                nums[i] = nums[t-1];
                nums[t-1] = t;
            }
        }
        System.out.println(Arrays.toString(nums));
        return 0;
    }
}
