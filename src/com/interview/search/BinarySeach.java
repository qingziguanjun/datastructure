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

    //todo  ���ҳ���һ��  ���һ�� ���� ���еģ� �����ҵ���Ҫ���أ��������� �ҵ�һ�������������һ����  ����һ����������ȵ�
    public int binarySearch(int[] nums, int left, int right, int target){
        int mid = (left + right) >> 1 ;
        int result = -1;
        //û���ҵ�������Ҫ�����жϣ� Ϊʲô�Ǵ��ںţ���Ϊ������ left �� mid-1,������mid����mid���ǻ���
        if(left > right) {
            return result;
        }
        if (nums[mid] == target) {
            result = mid;
            //�����ǲ��ҵ�һ����ȵģ������ȵ�̫�ִ࣬�д����е��
//            while (target == nums[mid]){
//                mid--;
//            }
//            return mid+1;
        } else if (nums[mid] > target) {
            // �ֱ�ݲ�����mid��Ҫ��mid-1��
            result = binarySearch(nums, left, mid-1, target);
        } else {
            result = binarySearch(nums, mid + 1, right, target);
        }
        return result;
    }
}
