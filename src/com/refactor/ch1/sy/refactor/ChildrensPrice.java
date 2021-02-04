package com.refactor.ch1.sy.refactor;


/**
 * @author songyi
 * @date 2021-01-26 18:53
 * @Description:
 */
public class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREND;
    }

    @Override
    public double getCharge(int daysRented){
        double charge = 1.5;
        if(daysRented > 3){
            charge += (daysRented -3) * 1.5;
        }
        return charge;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 0;
    }
}
