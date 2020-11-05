package com.interview.sort;

import java.util.Arrays;

/**
 * @author songyi
 * @date 2020-02-23 20:47
 * @Description: �Լ�д��
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
        //��仰�ǳ���Ҫ����ʾ�ݹ�Ľ�������
        if(left >= right) return;
        int pivot = sort(a, left, right);
        qucikSort(a, left, pivot-1);
        qucikSort(a, pivot+1 , right);

    }

    /**
     * �����������������ƣ�����˫ָ�룬�������ڸú��� while��i < j,���i���ܴ���j���������Ļ�׼��j
     */
    public int partition(int[] a, int left, int right){
        int i = left, j = right;
        int pivot = a[left];
        int temp = 0;
        while (i < j){
            // i j����ָ��ֱ�����ҿ�ʼɨ��
            while (a[j] > pivot){
                j--;
            }
            //�����ȴ����
            while(a[i] <= pivot && i < right){
                i++;
            }
            //�� i��j
            if(i < j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        System.out.println("i = " + i + ", j = " + j);
        //����j���� pivot��������ʱ i >= j Ϊʲô���ǵ�i����������i�����ܴ���pivot
        temp = a[j];
        a[j] = pivot;
        a[left] = temp;
        return j;
    }

    /**
     * while���ж��� i!= j, �������Ļ�׼��i����һ��ʼ���ҵ�˳�����ȴ��ұ߿�ʼ,���
     */
    public static int sort(int[] array, int left, int right) {
        // base�д�Ż�׼��
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // ˳�����Ҫ���ȴ��ұ߿�ʼ�����ң�ֱ���ҵ���baseֵС����
            while(array[j] >= base && i < j) {
                j--;
            }

            // �ٴ������ұ��ң�ֱ���ҵ���baseֵ�����
            while(array[i] <= base && i < j) {
                i++;
            }

            // �����ѭ��������ʾ�ҵ���λ�û���(i>=j)�ˣ������������������е�λ��
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        System.out.println("i = " + i + ", j = " + j);
        // ����׼���ŵ��м��λ�ã���׼����λ��
        array[left] = array[i];
        array[i] = base;
        return i;
    }



}


