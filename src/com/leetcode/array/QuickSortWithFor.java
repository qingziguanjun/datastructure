package com.leetcode.array;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author songyi
 * @date 2020-10-16 10:59
 * @Description:
 */
public class QuickSortWithFor {

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    static int partition(int[] arr, int begin, int end) {
        // pivot: ���λ�ã�counter: С��pivot��Ԫ�صĸ���
        int pivot = end, counter = begin;
        /**
         * ��ͷ��β�������飬���i��С�ڱ�ˣ��Ͱ�i����counter��������Ȼ��count����
         * ������ begin �� count++ ֮�䶼��С�� ��˵�
         */
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter]; arr[counter] = arr[i]; arr[i] = temp;
                counter++;
            }
        }
        //���ѱ�˵�ֵ��counterλ�ý�����̫������
        int temp = arr[pivot]; arr[pivot] = arr[counter]; arr[counter] = temp;
        return counter;
    }
    public static void main(String[] args) {
        //int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};

        //���Կ��ŵ�ִ���ٶ�
        // ����Ҫ��80000�������������
//        int num = 10;
//        int[] arr = new int[num];
//        for (int i = 0; i < num; i++) {
//            arr[i] = (int) (Math.random() * num); // ����һ��[0, 8000000) ��
//        }

        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561,50};
        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        quickSort(arr, 0, arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
        System.out.println("arr=" + Arrays.toString(arr));
    }

}
