package com.leetcode.array;

import com.algs4.algs4.In;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author songyi
 * @date 2020-07-28 21:34
 * @Description: https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/solution/javaban-chao-jian-dan-jie-fa-by-wang_dong/
 */
public class S442DuplicateInArray {

    /**
     * ����һ���������� a������1 �� a[i] �� n ��nΪ���鳤�ȣ�, ������ЩԪ�س������ζ�����Ԫ�س���һ�Ρ�
     *
     * �ҵ����г������ε�Ԫ�ء�
     *
     * ����Բ��õ��κζ���ռ䲢��O(n)ʱ�临�Ӷ��ڽ�����������
     *
     * ʾ����
     *
     * ����:
     * [4,3,2,7,8,2,3,1]
     *
     * ���:
     * [2,3]
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     */

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
    //�Լ�����hash
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[Math.abs(nums[i]) - 1];
            if(num < 0){
                result.add(num);
            }else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) -1];
            }

        }
        return result;


    }

    public static void main(String[] args) {
        int[] array = {4,3,2,7,8,2,3,1};
        S442DuplicateInArray s = new S442DuplicateInArray();
        System.out.println(s.findDup(array));
        System.out.println(Arrays.toString(array));
    }



    public List<Integer> findDup(int[] nums){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int n = Math.abs(nums[i]);
            if(nums[n - 1] < 0){
                result.add(n);
            }
            nums[n-1] = -Math.abs(nums[n-1]);
        }
        return  result;
    }

}
