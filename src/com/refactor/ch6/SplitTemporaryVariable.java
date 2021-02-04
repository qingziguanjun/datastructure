package com.refactor.ch6;

/**
 * @author songyi
 * @date 2021-02-02 10:03
 * @Description:
 */
public class SplitTemporaryVariable {

    private  int primaryForce;
    private int  mass;
    private int delay;
    private  int secondaryForce;
    double getDistanceTravelled(int time){
        double result;
        double acc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if(secondaryTime > 0){
            double primaryVel = acc * delay;
            acc = (primaryForce * secondaryForce)/ mass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }

    double getDistanceTravelledRefactor(int time){
        double result;
        final double primaryAcc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if(secondaryTime > 0){
            double primaryVel = primaryAcc * delay;
            final double secondAcc = (primaryForce * secondaryForce)/ mass;
            result += primaryVel * secondaryTime + 0.5 * secondAcc * secondaryTime * secondaryTime;
        }
        return result;
    }


    double getDistanceTravelledRefactor2(int time){
        double result = getTravel(primaryAcc(), primaryTime(time));
        if(secondaryTime(time) > 0){
            result += primaryAcc() * delay * secondaryTime(time) +
                    getTravel(secondAcc(), secondaryTime(time));
        }
        return result;
    }

    private double primaryAcc(){
        return primaryForce / mass;
    }
    private int primaryTime(int time){
        return Math.min(time, delay);
    }
    private int secondaryTime(int time){
        return time - delay;
    }

    private double secondAcc(){
        return (primaryForce * secondaryForce)/ mass;
    }

    private double getTravel(double acc, int time){
        return 0.5 * acc * time * time;
    }
}
