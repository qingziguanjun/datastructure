package com.refactor.ch1.old;

/**
 * @author songyi
 * @date 2021-01-26 11:52
 * @Description:
 */
public class MovieOld {
    public static final  int CHILDREND = 2;
    public static final  int REGULAR = 0;
    public static final  int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }


}
