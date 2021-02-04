package com.refactor.ch6;

/**
 * @author songyi
 * @date 2021-02-02 10:22
 * @Description:
 */
public class RemoveAssignments2Parameters {
    int discount(int inputVal, int quantity, int yearToDate){
        if(inputVal > 50){
            inputVal -= 2;
        }
        if(quantity > 100){
            inputVal -= 1;
        }

        if(yearToDate > 10000){
            inputVal -= 4;
        }
        return inputVal;
    }

    int discountRefactor(int inputVal, int quantity, int yearToDate){
        int result = inputVal;
        if(inputVal > 50){
            result -= 2;
        }
        if(quantity > 100){
            result -= 1;
        }

        if(yearToDate > 10000){
            result -= 4;
        }
        return result;
    }

    /**
     * java°´Öµ´«µÝ
     */
        public static void main(String[] args) {
            int x = 5;
            triple(x);
            System.out.println("x after triple:" + x);
        }
       static void triple(int arg){
            arg = arg * 3;
            System.out.println("arg int triple:" + arg);
        }
}
