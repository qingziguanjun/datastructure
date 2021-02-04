package com.refactor.ch1.sy.refactor;


/**
 * @author songyi
 * @date 2021-01-26 18:53
 * @Description:
 */
public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented){
        double charge = 2;
        if(daysRented > 2 ){
            charge += (daysRented - 2) * 1.5;
        }
        return charge;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 0;
    }
}
