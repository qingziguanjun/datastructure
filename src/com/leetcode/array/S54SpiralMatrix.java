package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songyi
 * @date 2020-08-21 17:41
 * @Description:
 */
public class S54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int botton = matrix.length -1;
        while (left <= right && top <= botton){

            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            //todo 这里需要等号，自己写错了
            for(int j = top + 1; j <= botton; j++){
                res.add(matrix[j][right]);
            }
            if(left < right && top < botton){
                //todo 下面竟然是right - 1,自己写错了
                for(int i = right - 1; i > left; i--){
                    res.add(matrix[botton][i]);
                }
                for(int j = botton; j > top; j--){
                    res.add(matrix[j][left]);
                }
            }
            left++;
            right--;
            top++;
            botton--;
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3 },
                {4, 5, 6 },
                {7, 8, 9 }
                };
        int[][] arr2= {{3}, {2}};
        S54SpiralMatrix s54SpiralMatrix = new S54SpiralMatrix();
        List<Integer> integers = s54SpiralMatrix.spiralOrder(arr2);
        System.out.println(integers);
    }

}
