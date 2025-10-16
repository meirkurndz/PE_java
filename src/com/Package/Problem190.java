package com.Package;

public class Problem190 {

    double[][] vals = new double[16][16];
    public void run(){
        long t1 = System.currentTimeMillis();
        setVals();
        long sum = 0;
        for(int m = 2; m <= 15; m++){
            double temp = 1;
            for(int n = 1; n <= m; n++){
                temp *= Math.pow(vals[m][n],n);
            }
            sum += Math.floor(temp);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + sum);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void setVals(){

        for(int m = 2; m < vals.length; m++){
            for(int n = 1; n <= m; n++){
                vals[m][n] = (2*n)/((double)(m+1));
            }
        }
    }
}
