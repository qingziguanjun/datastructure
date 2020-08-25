package com.leetcode.array;

/**
 * @author songyi
 * @date 2020-07-28 17:37
 * @Description:https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
 */
public class S41FirstMissPositive {

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = nums.length + 1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            int n = Math.abs(nums[i]);
            if(n <= nums.length) {
                nums[n - 1 ] = Math.abs(nums[n - 1]) * -1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return nums.length + 1;
    }





    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }


    /**
     * for(int i = 0; i < nums.length; i++){
     *             if(nums[i] <= 0){
     *                 nums[i] = nums.length + 1;
     *             }
     *         }
     *
     *         for(int i = 0; i < nums.length; i++){
     *             int n = Math.abs(nums[i]);
     *             if(n <= nums.length) {
     *                 nums[n - 1 ] = Math.abs(nums[n - 1]) * -1;
     *             }
     *         }
     *         for(int i = 0; i < nums.length; i++){
     *             if(nums[i] > 0){
     *                 return i+1;
     *             }
     *         }
     *         return nums.length + 1;
     *     }
     * @param nums
     * @return
     */
    //自己尝试hash
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            //这里判断范围是 <= n
            if(num <= n ){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }

        for(int i = 0; i < n; i++){
            //是大于0
            if( nums[i] < 0 ){
                return  i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        //int[] nums = {1};
        S41FirstMissPositive s = new S41FirstMissPositive();
        System.out.println(s.firstMiss(nums));
    }


    //*****************2020-08-03自己写的hash ************************
    public int firstMiss(int[] nums){

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = nums.length + 1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            int n = Math.abs(nums[i]);
            if(n <= nums.length){
                nums[n-1] = -Math.abs(nums[n-1]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return nums.length+1;

    }
    //****************2020-08-03自己写的hash结束 **************************













}
