package com.sy.study.dp;

/**
 * @author songyi
 * @date 2020-05-30 07:19
 * @Description:
 */
public class SplitSteel {


    //自顶向下
    //使用递归不断拆分，缺点是重复计算，优化就是使用带有备忘录的
    public int bottom2Top(int[] price, int n){
        if(n == 0 ) return 0;
        int q = -1;
        for(int i = 1; i <= n; i ++){
            q = Math.max(q, price[i] + bottom2Top(price, n - i) );
        }
        return q;
    }

    public static void main(String[] args) {
        int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        SplitSteel splitSteel = new SplitSteel();
        int n = 10;
        for(int i = 1; i <= n; i++){
            int num = splitSteel.bottom2Top(price, i);
            System.out.println(num);
        }
    }

    //自底向上
    public int top2Bottom(){
        return 0;
    }
}
