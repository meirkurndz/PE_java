package com.Package;

import java.util.Arrays;

public class Problem131 {

    boolean[] isPrime = new boolean[1000001];

    public void run(){
        primeGenerator();
        int count = 0;
        for(int y = 1; ; y++){
            int x = y + 1;
            int p = x*x*x - y*y*y;
            if(p > isPrime.length)
                break;
            if(isPrime[p]){
                count++;
                //System.out.println(p);
            }
        }
        System.out.println("the answer = " + count);
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
