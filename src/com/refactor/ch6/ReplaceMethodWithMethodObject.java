package com.refactor.ch6;

/**
 * @author songyi
 * @date 2021-02-02 11:05
 * @Description:
 */
public class ReplaceMethodWithMethodObject {




    int gamma(int inputVal, int quantity, int yearToDate){
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if((yearToDate - importantValue1) > 100){
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        //and so on
        return importantValue3 - 2 * importantValue1;
    }

    private int delta() {
        return 0;
    }

    //////
    //重构新建类
    private final Account account;
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;
    private int importantValue3;

    public ReplaceMethodWithMethodObject(Account source, int inputValArg, int quantityArg, int yearToDateArg) {
        account = source;
        inputVal = inputValArg;
        quantity = quantityArg;
        yearToDate = yearToDateArg;
    }

    int compute(){
        importantValue1 = (inputVal * quantity) + account.delta();
        importantValue2 = (inputVal * yearToDate) + 100;
        if((yearToDate - importantValue1) > 100){
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        return importantValue3 - 2 * importantValue1;
    }

    int gammaRefactor(int inputVal, int quantity, int yearToDate){
        return new ReplaceMethodWithMethodObject(null, inputVal, quantity, yearToDate).compute();
    }

}
