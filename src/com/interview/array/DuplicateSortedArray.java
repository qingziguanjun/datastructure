package com.interview.array;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-19 08:05
 * @Description:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 循环一遍，记录不重复的个数，如果发现不重复就把这个数放到 索引上，索引+1，最后索引值就是个数
 *
 * 不重复的个数就是 相邻两个数不相等 的个数，找到不重复就往前放
 */
public class DuplicateSortedArray {

    //删除排序好的重复数据

    public static void main(String[] args) {
        int[] num ={1,1};
        DuplicateSortedArray duplicateSortedArray = new DuplicateSortedArray();
        duplicateSortedArray.removeDuplicates(num);
    }

    //更优雅的写法
    //链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
    public int removeDuplicatesRef(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int result = 1;
        //int duplicateNum = 0;
        int index = 1;
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++){
            //不重复
             if(nums[i] != temp){
                 temp = nums[i];
                 result++;
                 nums[index++] = nums[i];
             }
//             else {
//                 //重复数据
//                 duplicateNum++;
//             }

        }
        System.out.println(Arrays.toString(nums));

        return result;

    }
}
