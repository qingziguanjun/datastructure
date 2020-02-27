package com.interview.sort;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-23 20:47
 * @Description:  �Ƚϡ��㷨���͡����ݽṹԭ�㷨 java��������
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
        //��仰�ǳ���Ҫ����ʾ�ݹ�Ľ�������
        if(left >= right) return;
        int pivot = partition4(a, left, right);
        qucikSort(a, left, pivot-1);
        qucikSort(a, pivot+1 , right);

    }
    //�Ե�leftΪ��׼
    //todo ����зֺܳ�ª��
    public int partition(int[] a, int left, int right){
        int i = left, j = right;
        int pivot = a[left];
        int temp = 0;
        while (i < j){
            // i j����ָ��ֱ�����ҿ�ʼɨ��
            while(a[i] <= pivot && i < right){
                i++;
            }
            while (a[j] > pivot){
                j--;
            }
            //if(i >= j) break;
            //���� i��j
            if(i < j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //Ϊʲô�����i��j�����أ� ���ʱ��i>= j��
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
            // i j����ָ��ֱ�����ҿ�ʼɨ��
            while(a[i] <= pivot ){
                i++;
                if(i == right) break;
            }
            while (a[j] > pivot){
                j--;
                if(j == left) break;
            }
            //���� i��j
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
     * �㷨P184����ʵ��
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
     * �������Ǵ�С�����ź�������
     * {3,1,4,2,-1,44,8}; Խ��
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static  int partition4(int[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true){
            //û�б߽��飬iԽ����
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


