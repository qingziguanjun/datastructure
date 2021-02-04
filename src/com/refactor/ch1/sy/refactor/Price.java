package com.refactor.ch1.sy.refactor;

/**
 * @author songyi
 * @date 2021-01-26 18:52
 * @Description:
 */
public abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented){
         return 1;
    }
}
