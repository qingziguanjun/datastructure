package com.refactor.ch6;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author songyi
 * @date 2021-02-01 10:46
 * @Description:
 */
public class ExtractMethod {
    Vector<Order> orders = new Vector();
    String name;
    void printOwing(){

        printBanner();
        double outstanding = getOutstanding();

        printDetails(outstanding);

    }

    private double getOutstanding() {
        Enumeration e = orders.elements();
        double result = 0.0;
        while (e.hasMoreElements()){
            Order order =(Order) e.nextElement();
            result += order.getAmount();
        }
        return result;
    }

    private void printDetails(double outstanding) {
        //print details
        System.out.println("name:" + name);
        System.out.println("amount " + outstanding);
    }

    private void printBanner() {
        //print banner
        System.out.println("****************************");
        System.out.println("******* Customer Owes **********");
        System.out.println("****************************");
    }

}
