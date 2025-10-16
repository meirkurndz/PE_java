package com.Package;

import java.util.Arrays;

public class Problem578 {

    boolean[] isPrime = new boolean[4000000];
    public void run(){
        primeGenerator();
        System.out.println("gen primes");


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
        isPrime[0] = false;
        isPrime[1] = false;
    }

}
