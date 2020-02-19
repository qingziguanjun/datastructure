package com.interview.sort;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-19 07:09
 * @Description:
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {3,1,4,2,8};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void selectSort(int[] arr){

        //��һ�δӺ�N������С�ģ�������N-1����һֱ�����һ��
        for(int i = 0; i < arr.length; i++){
            int index = i;
            int min = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }

    }
}
