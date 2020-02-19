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
            //�ٶ�ǰi�����մ�С�����ź����ˣ� ǰi�����ֵ�� arr[i-1]
            int insertVale = arr[i];
            int index = i - 1;
            //��i���Ǵ���������ݣ� �ӵ� i-1����ʼ�Ƚϣ������ i-1��С�� i-1�����ƣ�������i-2���Ƚϣ������i-2��С����������
            while (index >= 0 && insertVale < arr[index]){
                //��һ�� index + 1 = i
                arr[index + 1] = arr[index];
                index--;
            }
            //����ҵ��˲����λ�ã����뼴��
            arr[index+1] = insertVale;
        }

        List<Integer> ls= IntStream.of(arr).boxed().collect(Collectors.toList());
        System.out.println(ls);

    }
}
