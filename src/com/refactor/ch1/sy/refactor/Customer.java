package com.refactor.ch1.sy.refactor;



import java.util.Enumeration;
import java.util.Vector;

/**
 * @author songyi
 * @date 2021-01-26 11:55
 * @Description:
 */
public class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer(String name){
        this.name = name;
    }
    public void addRental(Rental arg){
        rentals.add(arg);
    }

    public  String getName(){
        return name;
    }

    public String statement(){
        Enumeration rentalEnums = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentalEnums.hasMoreElements()){
            Rental each = (Rental) rentalEnums.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                each.getCharge() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration rentalEnums = rentals.elements();
        while (rentalEnums.hasMoreElements()){
            Rental each = (Rental) rentalEnums.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentalEnums = rentals.elements();
        while (rentalEnums.hasMoreElements()){
            Rental each = (Rental) rentalEnums.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
