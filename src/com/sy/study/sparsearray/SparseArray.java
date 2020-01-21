package com.sy.study.sparsearray;

/**
 * @author songyi
 * @date 2020-01-18 06:51
 * @Description:
 */
public class SparseArray {
    /**
     * 二位数组转稀疏矩阵
     *
     */
    public int[][] convert2SparseArray(int[][] origin){

        return null;
    }

    /**
     * 恢复稀疏矩阵
     * @return
     */
    public int[][] recover(){
        return null;
    }


    public  void printArray(int[][] array){

    }


    public static void main(String[] args) {
        int chessArray[][] = new int[11][11];
        chessArray[1][2]=1;
        chessArray[2][3]=2;
        for(int[] row: chessArray){
            for(int data: row){
                System.out.printf("%d ", data);
            }
            System.out.println();
        }

        int sum = 0;
        for(int i =0; i<chessArray.length; i++){
            for(int j = 0; j < chessArray[0].length; j++){
                if(chessArray[i][j] != 0){
                    sum++;
                }
            }
        }

        int[][] sparsArray = new int[sum+1][3];
        sparsArray[0][0] = chessArray.length;
        sparsArray[0][1] = chessArray[0].length;
        sparsArray[0][2] = sum;

        int count = 0;
        for(int i =0; i<chessArray.length; i++){
            for(int j = 0;j < chessArray[0].length; j++){
                if(chessArray[i][j] != 0){
                    count++;
                    sparsArray[count][0] = i;
                    sparsArray[count][1] = j;
                    sparsArray[count][2] = chessArray[i][j];
                }
            }
        }

        for(int i = 0; i < sparsArray.length; i++){
            System.out.printf("%d %d  %d ", sparsArray[i][0],sparsArray[i][1],sparsArray[i][2]);
            System.out.println();
        }

    }
}
