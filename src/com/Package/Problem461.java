package com.Package;

import java.util.Arrays;

public class Problem461 {

    static final double E = Math.E;
    static final double PI = Math.PI;
    double[] vals = new double[14211];
    double[] pairs = new double[201952521];

    public void run(){
        for(int i = 0; i < vals.length; i++){
            vals[i] = Math.pow(E,((double) i/10000))-1;
            //System.out.println(i + " = " + vals[i]);
        }
        int index = 0;
        for(int i = 0 ; i < vals.length; i++){
            for(int j = i; j < vals.length; j++){
                pairs[index] = vals[i] + vals[j];
                index++;
            }
        }
        //Arrays.sort(pairs);

        for(int j = 0; j < pairs.length; j++){
            System.out.println(pairs[j]);
        }

    }
}
