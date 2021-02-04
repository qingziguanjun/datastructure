package com.refactor.ch1.old;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author songyi
 * @date 2021-01-26 11:55
 * @Description:
 */
public class CustomerOld {
    private String name;
    private Vector rentals = new Vector();
    public CustomerOld(String name){
        this.name = name;
    }
    public void addRental(RentalOld arg){
        rentals.add(arg);
    }

    public  String getName(){
        return name;
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentalEnums = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentalEnums.hasMoreElements()){
            double thisAmount = 0;
            RentalOld each = (RentalOld) rentalEnums.nextElement();

            //datermine amounts for each line
            switch (each.getMovie().getPriceCode()){
                case MovieOld.REGULAR:
                    thisAmount += 2;
                    if(each.getDaysRented() > 2){
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case MovieOld.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case MovieOld.CHILDREND:
                    thisAmount += 1.5;
                    if(each.getDaysRented() > 3){
                        thisAmount += (each.getDaysRented() -3) * 1.5;
                    }
                    break;
            }
            //add frequent renter points
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if((each.getMovie().getPriceCode() == MovieOld.NEW_RELEASE) &&
                each.getDaysRented() > 1){
                frequentRenterPoints++;
            }
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                String.valueOf(thisAmount) + "\n";

            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
