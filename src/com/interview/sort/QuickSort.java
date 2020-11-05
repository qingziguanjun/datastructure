package com.interview.sort;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-23 20:47
 * @Description: 自己写的
 */
public class QuickSort {

    public static void main(String[] args) {
        //int[] a = {3,1,4,2,-1,44,8};
        //int[] a = {1,2,3,4,5};
        int[] a = {5,4,3,2,1};
        QuickSort sort = new QuickSort();
        sort.qucikSort(a, 0 , a.length-1);
        System.out.println(Arrays.toString(a));
    }


    public void qucikSort(int[] a, int left, int right){
        //这句话非常重要，表示递归的结束条件
        if(left >= right) return;
        int pivot = sort(a, left, right);
        qucikSort(a, left, pivot-1);
        qucikSort(a, pivot+1 , right);

    }

    /**
     * 这个函数和下面的类似，都是双指针，区别在于该函数 while是i < j,最后i可能大于j，所有最后的基准是j
     */
    public int partition(int[] a, int left, int right){
        int i = left, j = right;
        int pivot = a[left];
        int temp = 0;
        while (i < j){
            // i j两个指针分别从左右开始扫描
            while (a[j] > pivot){
                j--;
            }
            //这里先从左边
            while(a[i] <= pivot && i < right){
                i++;
            }
            //换 i，j
            if(i < j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        System.out.println("i = " + i + ", j = " + j);
        //最后第j个和 pivot交换，此时 i >= j 为什么不是第i个交换，第i个可能大于pivot
        temp = a[j];
        a[j] = pivot;
        a[left] = temp;
        return j;
    }

    /**
     * while的判断是 i!= j, 所以最后的基准是i，而一开始查找的顺序是先从右边开始,奇怪
     */
    public static int sort(int[] array, int left, int right) {
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        System.out.println("i = " + i + ", j = " + j);
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;
        return i;
    }



}


