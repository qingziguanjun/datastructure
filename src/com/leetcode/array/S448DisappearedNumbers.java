package com.leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author songyi
 * @date 2020-07-28 22:29
 * @Description:https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class S448DisappearedNumbers {

    /**
     * 给定一个范围在? 1 ≤ a[i] ≤ n (?n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [5,6]
     * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
     */

    public static void main(String[] args) {
        int[] array = {4,3,2,7,8,2,3,1};
        S448DisappearedNumbers s = new S448DisappearedNumbers();
        System.out.println(s.findDisappearedNumbers(array));
        System.out.printf(Arrays.toString(array));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) -1;
            nums[index] = -Math.abs(nums[index]);
        }
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            if(num < nums.length){
                nums[num-1] = -Math.abs(nums[num - 1]);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) != i+1){
                result.add(i+1);
            }
        }

        return result;
    }

}
