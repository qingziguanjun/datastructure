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
     * ����һ����Χ��? 1 �� a[i] �� n (?n = �����С ) �� �������飬�����е�Ԫ��һЩ���������Σ���һЩֻ����һ�Ρ�
     * �ҵ������� [1, n] ��Χ֮��û�г����������е����֡�
     * �����ڲ�ʹ�ö���ռ���ʱ�临�Ӷ�ΪO(n)�������������������? ����Լٶ����ص����鲻���ڶ���ռ��ڡ�
     *
     * ����:
     * [4,3,2,7,8,2,3,1]
     * ���:
     * [5,6]
     * ���ӣ�https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
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
