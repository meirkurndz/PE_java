package com.Package;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem235 {

    static final long TARGET = -600_000_000_000L;
    public void run(){

        long t1 = System.currentTimeMillis();
        int digits = 0;
        double toAdd = 0.1;
        double r = 1.0;
        double currR = 1;
        double sum = 0;

        while (digits < 13) {
            sum = 0;
            currR = 1;
            for (int k = 1; k < 5001; k++) {
                sum += (900 - 3 * k) * currR;
                currR *= r;
            }
            if (sum > TARGET){
                r += toAdd;
            }else if(sum < TARGET){
                r -= toAdd;
                toAdd /= 10.0;
                digits++;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("P_235 = " + round(r,12));
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }


    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
