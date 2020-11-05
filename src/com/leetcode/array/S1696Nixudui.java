package com.leetcode.array;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-10-16 14:21
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
 */
public class S1696Nixudui {
    public int reversePairs(int[] nums){
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r){
        if( l>= r) {
            return 0;
        }
        System.out.println(Arrays.toString(nums));
        int mid = l +(r-l)/2;
        int count = mergeSort(nums, l, mid) + mergeSort(nums, mid+1, r);
        int[] cache = new int[r-l + 1];
        int i = l, t= l, c = 0;
        for(int j = mid + 1; j <= r; j++,c++){
            while(i <= mid && nums[i] <= nums[j]){
            //while(i <= mid && nums[i] <= 2*(long) nums[j]){
                i++;
            }
            while(t <= mid && nums[t] < nums[j]){
                cache[c++] = nums[t++];
            }
            cache[c] = nums[j];
            count += mid - i + 1;
        }
        while(t <= mid) {
            cache[c++] = nums[t++];
        }
        System.arraycopy(cache, 0, nums, l, r - l + 1);
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {7,5,6,4};
        int num = new S1696Nixudui().reversePairs(arr);
        System.out.println(num);
    }
}
