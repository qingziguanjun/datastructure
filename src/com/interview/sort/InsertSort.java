package com.interview.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author songyi
 * @date 2020-02-19 07:20
 * @Description:
 */
public class InsertSort {

    public static void main(String[] args) {
        //int[] a = {3,1,4,2,8};
        int[] a = {1};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void insertSort(int[] arr){

        for(int i = 1;  i < arr.length; i++){
            //假定前i个按照从小到大排好序了， 前i个最大值是 arr[i-1]
            int insertVale = arr[i];
            int index = i - 1;
            //第i个是待插入的数据， 从第 i-1个开始比较，如果比 i-1个小， i-1个后移，继续和i-2个比较，如果比i-2个小，继续后移
            while (index >= 0 && insertVale < arr[index]){
                //第一个 index + 1 = i
                arr[index + 1] = arr[index];
                index--;
            }
            //最后找到了插入的位置，插入即可
            arr[index+1] = insertVale;
        }

        List<Integer> ls= IntStream.of(arr).boxed().collect(Collectors.toList());
        System.out.println(ls);

    }
}
