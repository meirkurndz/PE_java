package com.Package;

public class Problem94 {

    public void run(){
        long sum = 0;
        for(long i = 2; i <= 333333333; i++){
            if (isIntegralArea(i,i+1)){
                sum += 3 * i + 1;
            }
            if (isIntegralArea(i,i-1)){
                sum += 3 * i - 1;
            }
        }
        System.out.println("the answer = " + sum);
    }

    public boolean isIntegralArea(long towSides, long oneSide){

        long check = 4 * towSides * towSides - oneSide * oneSide;
        long sqrt = (long) Math.sqrt(check);
        return sqrt * sqrt == check;

    }


}
