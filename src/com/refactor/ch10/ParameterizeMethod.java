package com.refactor.ch10;


import com.algs4.algs4.In;
import com.cn.javass.dp.strategy.example5.DollarCash;

/**
 * @author songyi
 * @date 2021-02-07 20:02
 * @Description:
 */
public class ParameterizeMethod {
    // 10.5 令函数携带参数
    protected Dollars baseCharge(){
        double result = Math.min(lastUsage(), 100) * 0.03;
        if(lastUsage() > 100 ){
            result += (Math.min(lastUsage(), 200) - 100 ) * 0.05;
        }
        if(lastUsage() > 200){
            result += (lastUsage() - 200) * 0.07;
        }
        return new Dollars(result);
    }

    private int lastUsage() {
        return 0;
    }

    //重构如下
    protected Dollars baseChargeRefactor(){
        double result = usageInRange(0, 100) * 0.03;
        result += usageInRange(100, 200) * 0.05;
        result += usageInRange(200, Integer.MAX_VALUE) * 0.07;
        return new Dollars(result);
    }

    private double usageInRange(int start, int end) {
        if(lastUsage() > start){
            return Math.min(lastUsage(), end) - start;
        }
        return 0;
    }

}
class Dollars{
    private double result;

    Dollars(double result) {
        this.result = result;
    }
}
