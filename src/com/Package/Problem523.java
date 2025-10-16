package com.Package;

public class Problem523 {

    public void run(){
        long t1 = System.currentTimeMillis();
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + seq(30));
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public double seq(int n){
        double sum = 0;
        for(int i = 1; i <= n; i++){
            sum += (Math.pow(2,i-1) - 1)/((double)i);
        }
        return sum;
    }
}
