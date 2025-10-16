package com.Package;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Problem286 {

    static final int SCORES = 20;
    static final int MAX_DISTANCE = 50;
    static final double TARGET = 0.02;
    static final double ERROR = 0.0000000000001;

    double[][] memo = new double[52][52];

    public void run(){
        long t1 = System.currentTimeMillis();
        double q = 50.0;
        double toAdd = 0.1;
        double probability = prob(q,1,0);
        while (probability > TARGET){
            q += toAdd;
            //clear the memo
            for(int i = 0; i < memo.length; i++)
                Arrays.fill(memo[i],0.0);

            probability = prob(q,1,0);
            //System.out.println(q + ", " + probability);
            if (probability < TARGET){
                q -= toAdd;
                toAdd /= 10.0;
                for(int i = 0; i < memo.length; i++)
                    Arrays.fill(memo[i],0.0);
                probability = prob(q,1,0);
            }
            if (probability - TARGET < ERROR)
                break;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("PE_286 = " + round(q,10));
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public double prob(double q, int dis, int TS){
        if (TS > SCORES)
            return 0;
        if (dis > MAX_DISTANCE){
            return TS == SCORES ? 1 : 0;
        }
        if (memo[dis][TS] != 0)
            return memo[dis][TS];

        double hitC = 1.0 - ((double) dis/q);
        double missC = 1.0 - hitC;

        double res = hitC * prob(q,dis+1,TS+1) + missC * prob(q,dis+1,TS);
        memo[dis][TS] = res;
        return res;
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
