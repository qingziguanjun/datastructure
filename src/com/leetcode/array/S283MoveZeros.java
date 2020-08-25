package com.leetcode.array;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-07-19 14:12
 * @Description:https://leetcode-cn.com/problems/move-zeroes/
 *
 * https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
 */
public class S283MoveZeros {

    public static void main(String[] args) {
        int[] array = {0,1,0,0,3,0,12,4};
        S283MoveZeros s = new S283MoveZeros();
        s.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
    public void moveZeroes(int[] nums){
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(nums[i] != nums[j]){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        int zeroIndex = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != 0){
                if(i != zeroIndex){
                    nums[zeroIndex] = nums[i];
                    nums[i] = 0;
                }
                zeroIndex++;
            }
        }
    }


}

