package com.refactor.ch9;

import java.util.Date;

/**
 * @author songyi
 * @date 2021-02-07 08:53
 * @Description:
 */
public class SimplifyConditionalExpression {

    // 9.1 Decompose Conditional 分解条件表达式
    private static final Date SUMMER_START = null;
    private static final Date SUMMER_END = null;

    private double winterRate;
    private double winterServiceCharge;
    private double summerRate;

    private double countPrice(Date date, int quantity) {
        double charge;
        if (date.before(SUMMER_START) || date.after(SUMMER_END)) {
            charge = quantity * winterRate + winterServiceCharge;
        } else {
            charge = quantity * summerRate;
        }
        return charge;
    }

    private double countPriceRefactor(Date date, int quantity) {
        double charge;
        if (notSummer(date)) {
            charge = winterCharge(quantity);
        } else {
            charge = summerCharge(quantity);
        }
        return charge;
    }

    private double summerCharge(int quantity) {
        return quantity * summerRate;
    }

    private double winterCharge(int quantity) {
        return quantity * winterRate + winterServiceCharge;
    }

    private boolean notSummer(Date date) {
        return date.before(SUMMER_START) || date.after(SUMMER_END);
    }


    //9.2 Consolidate Conditional Expression 合并条件表达式


    private int seniority;
    private int monthDisabled;
    private boolean isPartTime;

    double disabilityAmount() {
        if (seniority < 2) {
            return 0;
        }
        if (monthDisabled > 12) {
            return 0;
        }
        if (isPartTime) {
            return 0;
        }
        //compute the disability amount
        return 0;
    }

    double disabilityAmountRefactor() {
        if (isNotEligableForDisability()) {
            return 0;
        }
        //compute the disability amount
        return 0;
    }

    //使用逻辑与
    private boolean isNotEligableForDisability() {
        return ((seniority < 2) || (monthDisabled > 12) || (isPartTime));
    }

    //使用逻辑或
    /**
     if(onVacation())
     if(lengthOfService() > 10)
     return 1;
     return 0.5;


     if(onVacation() && lengthOfService() > 10) return 1;
     else return 0.5;
     也可以使用三元操作
     return (onVacation() && lengthOfService() > 10) ? 1 : 0.5;

     */


    //9.3 Consolidate Duplicate Conditional Fragments 合并重复条件片段

    /**
     * if(isSpecialDeal()){
     * total = price * 0.95;
     * send();
     * }
     * else{
     * total = price * 0.98;
     * send();
     * }
     * <p>
     * <p>
     * if(isSpecialDeal()){
     * total = price * 0.95;
     * }else{
     * total = price * 0.98;
     * }
     * send();
     * <p>
     * 是不是可以这样：
     * total = price * getRate();
     * send()
     * <p>
     * double getRate(){
     * if(isSpecialDeal()){
     * return 0.95;
     * }
     * return 0.98;
     * }
     */


    // 9.4 Remove Control Flag 移除控制标记
    void checkSecurity(String[] people) {
        boolean found = false;
        for (int i = 0; i < people.length; i++) {
            if (!found) {
                if (people[i].equals("Don")) {
                    sendAlert();
                    found = true;
                }
                if (people[i].equals("John")) {
                    sendAlert();
                    found = true;
                }
            }
        }
    }

    private void sendAlert() {
    }


    void checkSecurityRefactor(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals("Don")) {
                sendAlert();
                break;
            }
            if (people[i].equals("John")) {
                sendAlert();
                break;
            }
        }
    }

    // return 返回控制标记
    void checkSecurityReturn(String[] people) {
        String found = "";
        for (int i = 0; i < people.length; i++) {
            if (found.equals("")) {
                if (people[i].equals("Don")) {
                    sendAlert();
                    found = "Don";
                }
                if (people[i].equals("John")) {
                    sendAlert();
                    found = "John";
                }
            }
        }
        // someLaterCode(found);
    }

    void checkSecurityReturnRefactor(String[] people) {
        String found = foundMiscreant(people);
        //someLateCode
    }

    private String foundMiscreant(String[] people) {
        String found = "";
        for (int i = 0; i < people.length; i++) {
            if (found.equals("")) {
                if (people[i].equals("Don")) {
                    sendAlert();
                    found = "Don";
                }
                if (people[i].equals("John")) {
                    sendAlert();
                    found = "John";
                }
            }
        }
        return found;
    }

    private String foundMiscreantRefactor(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals("Don")) {
                sendAlert();
                return "Don";
            }
            if (people[i].equals("John")) {
                sendAlert();
                return "John";
            }
        }
        return "";
    }

    //9.5 Replace Nested Conditional with Guard Clauses 以卫语句取代嵌套条件表达式
    private boolean isDead;
    private boolean isSeparated;
    private boolean isRetired;

    double getPayAmount() {
        double result;
        if (isDead) {
            result = deadAmount();
        } else {
            if (isSeparated) {
                result = separatedAmount();
            } else {
                if (isRetired) {
                    result = retiredAmount();
                } else {
                    return normalPayAmount();
                }
            }
        }
        return result;
    }

    private double normalPayAmount() {
        return 0;
    }

    private double retiredAmount() {
        return 0;
    }

    private double separatedAmount() {
        return 0;
    }

    private double deadAmount() {
        return 0;
    }


    double getPayAmountRefactor() {
        double result;
        if (isDead) {
            return deadAmount();
        }
        if (isSeparated) {
            return separatedAmount();
        }
        if (isRetired) {
            return  retiredAmount();
        }
        return normalPayAmount();
    }
}
