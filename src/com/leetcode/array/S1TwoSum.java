package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author songyi
 * @date 2020-07-23 19:57
 * @Description:https://leetcode-cn.com/problems/two-sum/
 */
public class S1TwoSum {

    // nums = [], target = 9
    // À˘“‘∑µªÿ [0, 1]
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] nums2 = {3,2,4};
        S1TwoSum s1 = new S1TwoSum();
        System.out.println(Arrays.toString(s1.twoSumPointer(nums2, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) ){
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumPointer(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        Arrays.sort(nums);

        int i = 0, j = nums.length-1;
        while (i < j ){
            int sum = nums[i] + nums[j];
            if(sum > target){
                j--;
            }else if(sum < target){
                i++;
            }else {
                return new int[] { map.get(nums[i]), map.get(nums[j]) };
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
