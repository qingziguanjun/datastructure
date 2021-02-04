package com.refactor.ch1.old;

/**
 * @author songyi
 * @date 2021-01-26 11:54
 * @Description:
 */
public class RentalOld {
    private MovieOld movie;
    private int daysRented;

    public RentalOld(MovieOld movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public MovieOld getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
