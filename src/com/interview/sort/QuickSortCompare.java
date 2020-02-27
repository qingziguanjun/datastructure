package com.interview.sort;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-23 20:47
 * @Description:  比较《算法》和《数据结构原算法 java》的区别
 */
public class QuickSortCompare {

    public static void main(String[] args) {
        //int[] a = {3,1,4,2,-1,44,8};
        //int[] a = {1,2,3,4,5};
        int[] a = {5,4,3,2,1};
        QuickSortCompare sort = new QuickSortCompare();
        sort.qucikSort(a, 0 , a.length-1);
        System.out.println(Arrays.toString(a));
    }


    public void qucikSort(int[] a, int left, int right){
        //这句话非常重要，表示递归的结束条件
        if(left >= right) return;
        int pivot = partition4(a, left, right);
        qucikSort(a, left, pivot-1);
        qucikSort(a, pivot+1 , right);

    }
    //以第left为基准
    //todo 这个切分很丑陋啊
    public int partition(int[] a, int left, int right){
        int i = left, j = right;
        int pivot = a[left];
        int temp = 0;
        while (i < j){
            // i j两个指针分别从左右开始扫描
            while(a[i] <= pivot && i < right){
                i++;
            }
            while (a[j] > pivot){
                j--;
            }
            //if(i >= j) break;
            //交互 i，j
            if(i < j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //为什么最后是i和j交换呢？ 这个时候i>= j，
        System.out.println("i = " + i + ", j = " + j);
        temp = a[j];
        a[j] = pivot;
        a[left] = temp;
        return j;
    }

    public int partition1(int[] a, int left, int right){
        int i = left, j = right;
        int pivot = a[left];
        int temp = 0;
        while (true){
            // i j两个指针分别从左右开始扫描
            while(a[i] <= pivot ){
                i++;
                if(i == right) break;
            }
            while (a[j] > pivot){
                j--;
                if(j == left) break;
            }
            //交互 i，j
            if(i >= j) break;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;

        }
        temp = a[j];
        a[j] = pivot;
        a[left] = temp;
        return j;
    }


    /**
     * 算法P184代码实现
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static  int partition3(int[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true){
            while(a[++i] < v)  if(i == hi) break;
            while (a[--j] > v) if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;

    }

    /**
     * 在数组是从小到大排好序正常
     * {3,1,4,2,-1,44,8}; 越界
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static  int partition4(int[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true){
            //没有边界检查，i越界了
            while(a[++i] < v)   {};
            while (a[--j] > v)  {};
            if(i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;

    }
    public static void exch(int[] a, int i , int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}


