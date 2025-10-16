package com.Package;

import java.util.Arrays;

public class Problem355 {
    int limit = 30;
    boolean[] isPrime = new boolean[limit];
    boolean[] inSet = new boolean[limit];

    public void run(){
        primeGenerator();
        for(int i = 0; i < isPrime.length; i++){
            if (isPrime[i])
                inSet[i] = true;
        }

        for(int i = 0; i < inSet.length; i++){
            if (inSet[i]){
                int temp = i;
                while (temp * i < limit)
                    temp *= i;
                inSet[i] = false;
                inSet[temp] = true;
            }
        }
        long sum = 0;
        for(int i = 0; i < inSet.length; i++){
            if (inSet[i]) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println("the answer = " + sum);

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
