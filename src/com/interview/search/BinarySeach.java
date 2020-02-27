package com.interview.search;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-24 07:08
 * @Description:
 */
public class BinarySeach {

    public static void main(String[] args) {
        int[] nums = {-1,0,2,2,2,2,3,5,9,12};
        int target = 2;
        BinarySeach binarySeach = new BinarySeach();
        int result = binarySeach.search(nums, target);
        System.out.println(result);

    }
    public int search(int[] nums, int target){
        if(nums.length == 0){
            return -1;
        }
        return binarySearch(nums, 0, nums.length, target);
    }

    //todo  查找出第一个  最后一个 或者 所有的， 就是找到后不要返回，继续往左 找第一个，往右找最后一个，  左右一起找所有相等的
    public int binarySearch(int[] nums, int left, int right, int target){
        int mid = (left + right) >> 1 ;
        int result = -1;
        //没有找到，这里要加上判断， 为什么是大于号，因为下面是 left 到 mid-1,而不是mid，是mid就是坏了
        if(left > right) {
            return result;
        }
        if (nums[mid] == target) {
            result = mid;
            //下面是查找第一个相等的，如果相等的太多，执行次数有点多
//            while (target == nums[mid]){
//                mid--;
//            }
//            return mid+1;
        } else if (nums[mid] > target) {
            // 又便捷不能是mid，要是mid-1的
            result = binarySearch(nums, left, mid-1, target);
        } else {
            result = binarySearch(nums, mid + 1, right, target);
        }
        return result;
    }
}
