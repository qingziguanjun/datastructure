package com.refactor.ch1.sy.refactor;

/**
 * @author songyi
 * @date 2021-01-26 11:54
 * @Description:
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public double getCharge1() {
        double charge = 0;
        //datermine amounts for each line
        switch (getMovie().getPriceCode()){
            case Movie.REGULAR:
                charge += 2;
                if(getDaysRented() > 2){
                    charge += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                charge += getDaysRented() * 3;
                break;
            case Movie.CHILDREND:
                charge += 1.5;
                if(getDaysRented() > 3){
                    charge += (getDaysRented() -3) * 1.5;
                }
                break;
            default:
                break;
        }
        return charge;
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
    public int getFrequentRenterPoints1() {
        //add bonus for a two day new release rental
        if((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                getDaysRented() > 1){
            return 2;
        }
        return 1;
    }
}
