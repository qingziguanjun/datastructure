package com.interview.array;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-19 08:05
 * @Description:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * ѭ��һ�飬��¼���ظ��ĸ�����������ֲ��ظ��Ͱ�������ŵ� �����ϣ�����+1���������ֵ���Ǹ���
 *
 * ���ظ��ĸ������� ��������������� �ĸ������ҵ����ظ�����ǰ��
 */
public class DuplicateSortedArray {

    //ɾ������õ��ظ�����

    public static void main(String[] args) {
        int[] num ={1,1};
        DuplicateSortedArray duplicateSortedArray = new DuplicateSortedArray();
        duplicateSortedArray.removeDuplicates(num);
    }

    //�����ŵ�д��
    //���ӣ�https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
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
            //���ظ�
             if(nums[i] != temp){
                 temp = nums[i];
                 result++;
                 nums[index++] = nums[i];
             }
//             else {
//                 //�ظ�����
//                 duplicateNum++;
//             }

        }
        System.out.println(Arrays.toString(nums));

        return result;

    }
}
