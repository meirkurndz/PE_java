package com.Package;

import java.util.Arrays;

public class Problem800 {
    boolean[] isPrime = new boolean[15704474];
    int[] indexs = new int[15704474];
    double[] logs = new double[15704474];

    static final double LIMIT =  10885567.8987921048235D;

    public void run(){
        long time1 = System.currentTimeMillis();
        primeGenerator();
        setLogsAndIndex();
        long count = 0;
        for(int p = 2; p < isPrime.length; p++){
            if(isPrime[p]) {
                boolean found = false;
                for (int q = p + 1; q < isPrime.length; q++) {
                    if(isPrime[q]){
                        if(isLess(p,q)){
                            if(!found){
                                //System.out.println("found for " + p);
                                found = true;
                            }
                            count++;
                            //System.out.println(p + ", " + q);
                        }else{
                            break;
                        }
                    }
                }
                if(!found)
                    break;
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + count);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public void setLogsAndIndex(){
        int index = 0;
        for(int i = 0; i < logs.length; i++){
            if (isPrime[i]){
                index++;
                indexs[i] = index;
                logs[i] = Math.log(i);
            }
        }
    }

    public boolean isLess(int p, int q){
        double temp = q*Math.log(p) + p*Math.log(q);
        if(temp <= LIMIT)
            return true;
        return false;
    }

    public void primeGenerator() {
        Arrays.fill(isPrime, true);
        for (int p = 2; p * p <= isPrime.length - 1; p++) {
            if (isPrime[p]) {
                for (int i = p * 2; i <= isPrime.length - 1; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        isPrime[1] = false;
        isPrime[0] = false;
    }


}
