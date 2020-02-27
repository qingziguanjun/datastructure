package com.interview.sort;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-23 20:47
 * @Description:
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {3,1,4,2,-1,44,8};
        int length = a.length;
        int[] tmp = new int[length];
        MergeSort sort = new MergeSort();
        sort.mergeSort(a, 0, a.length-1, tmp);
        System.out.println(Arrays.toString(a));
    }


    public void mergeSort(int a[], int left, int right, int[] tmp){
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid, tmp);
            mergeSort(a, mid+1, right, tmp);
            merge(a, left, mid, right, tmp);
        }
    }

    public void merge(int[] a, int left, int mid, int right, int[] tmp){

        int i = left;
        int j = mid +1;
        int index = 0;
        //这个条件必须是&& 而且是<=
        while (i <= mid && j <= right){
            if(a[i] <= a[j]){
                tmp[index++] = a[i++];
            }else if(a[i] > a[j]){
                tmp[index++] = a[j++];
            }
        }
        while (i <= mid){
            tmp[index++] = a[i++];
        }

        while (j <= right){
            tmp[index++] = a[j++];
        }

        index = 0;
        for(int k = left; k <= right; k++){
            a[k] = tmp[index++];
        }
    }
}
