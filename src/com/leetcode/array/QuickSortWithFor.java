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
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        /**
         * 从头到尾遍历数组，如果i个小于标杆，就把i个和counter个交互，然后count自增
         * 这样从 begin 到 count++ 之间都是小于 标杆的
         */
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter]; arr[counter] = arr[i]; arr[i] = temp;
                counter++;
            }
        }
        //最后把标杆的值跟counter位置交换，太优秀了
        int temp = arr[pivot]; arr[pivot] = arr[counter]; arr[counter] = temp;
        return counter;
    }
    public static void main(String[] args) {
        //int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
//        int num = 10;
//        int[] arr = new int[num];
//        for (int i = 0; i < num; i++) {
//            arr[i] = (int) (Math.random() * num); // 生成一个[0, 8000000) 数
//        }

        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561,50};
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        quickSort(arr, 0, arr.length-1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        System.out.println("arr=" + Arrays.toString(arr));
    }

}
