package com.refactor.ch1.old;

import com.refactor.ch1.old.CustomerOld;
import com.refactor.ch1.old.MovieOld;
import com.refactor.ch1.old.RentalOld;
import com.refactor.ch1.sy.refactor.Movie;

/**
 * @author songyi
 * @date 2021-01-26 12:09
 * @Description:
 */
public class TestOld {
    public static void main(String[] args) {
        CustomerOld customer1 = new CustomerOld("huzi");
        CustomerOld customer2 = new CustomerOld("qiqi");
        MovieOld childMovie = new MovieOld();
        childMovie.setTitle("儿童片");
        childMovie.setPriceCode(Movie.CHILDREND);

        MovieOld regMovie = new MovieOld();
        regMovie.setPriceCode(Movie.REGULAR);
        regMovie.setTitle("常规片");

        MovieOld newMovie = new MovieOld();
        newMovie.setTitle("新发行");
        newMovie.setPriceCode(Movie.NEW_RELEASE);

        RentalOld chlidRentalOld2Day = new RentalOld(childMovie, 2);
        RentalOld regRentalOld3Day = new RentalOld(regMovie, 3);
        RentalOld newRel4Day = new RentalOld(newMovie, 4);

        customer1.addRental(chlidRentalOld2Day);
        customer1.addRental(regRentalOld3Day);
        customer2.addRental(regRentalOld3Day);
        customer2.addRental(newRel4Day);

        String statement = customer1.statement();
        String statement1 = customer2.statement();
        System.out.println(statement);
        System.out.println(statement1);
    }
}
