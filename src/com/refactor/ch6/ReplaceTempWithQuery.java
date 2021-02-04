package com.refactor.ch6;

/**
 * @author songyi
 * @date 2021-02-01 19:49
 * @Description:
 */
public class ReplaceTempWithQuery {
    private static int quantity;
    private static int itemPrice;

    private double getPriceRefactor(){
        return basePrice() * discountFactor();
    }

    private double discountFactor(){
        if(basePrice() > 1000){
            return 0.95;
        }else {
            return 0.98;
        }
    }
    private int basePrice(){
        return quantity * itemPrice;
    }



    private double getPrice(){
        int basePrice = quantity * itemPrice;
        double discountFactor;
        if(basePrice > 1000) {
            discountFactor =  0.95;
        }
        else {
            discountFactor =  0.98;
        }
        return basePrice * discountFactor;
    }
    public static void main(String[] args) {






    }

}
