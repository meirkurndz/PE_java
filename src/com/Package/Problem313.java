package com.Package;

import java.util.Arrays;

public class Problem313 {

    boolean[] isPrime = new boolean[1000000];

    public void run(){
        long time1 = System.currentTimeMillis();
        primeGenerator();
        long sum = 2;

        for(long i = 4; i < isPrime.length;i++){
            if(isPrime[(int)i]){
                sum += (i*i - 1)/12;
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + sum);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public void primeGenerator() {
        //prime number generator
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
