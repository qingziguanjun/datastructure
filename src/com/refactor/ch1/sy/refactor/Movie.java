package com.refactor.ch1.sy.refactor;


/**
 * @author songyi
 * @date 2021-01-26 11:52
 * @Description:
 */
public class Movie {
    public static final  int CHILDREND = 2;
    public static final  int REGULAR = 0;
    public static final  int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    private Price price;

    public Movie(String title, int priceCode){
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg){
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREND:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
        }
    }


    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public double getCharge1(int daysRented) {
        double charge = 0;
        //datermine amounts for each line
        switch (getPriceCode()){
            case Movie.REGULAR:
                charge += 2;
                if(daysRented > 2 ){
                    charge += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                charge += daysRented * 3;
                break;
            case Movie.CHILDREND:
                charge += 1.5;
                if(daysRented > 3){
                    charge += (daysRented -3) * 1.5;
                }
                break;
            default:
                break;
        }
        return charge;
    }


    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
    public int getFrequentRenterPoints1(int daysRented) {
        if((getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1){
            return 2;
        }
        return 1;
    }
}
