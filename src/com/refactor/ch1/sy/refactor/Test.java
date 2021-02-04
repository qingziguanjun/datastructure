package com.refactor.ch1.sy.refactor;


import com.sun.org.apache.bcel.internal.generic.MONITORENTER;

/**
 * @author songyi
 * @date 2021-01-26 12:09
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Customer customer1 = new Customer("huzi");
        Customer customer2 = new Customer("qiqi");
        Movie childMovie = new Movie("儿童片", Movie.CHILDREND);
        Movie regMovie = new Movie("常规片", Movie.REGULAR);
        Movie newMovie = new Movie("新发行", Movie.NEW_RELEASE);

        Rental chlidRentalOld2Day = new Rental(childMovie, 2);
        Rental regRentalOld3Day = new Rental(regMovie, 3);
        Rental newRel4Day = new Rental(newMovie, 4);

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
