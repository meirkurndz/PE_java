package com.Package;

import java.util.Arrays;

public class Problem231 {

    long[] sumOfFactors = new long[20000001];
    boolean[] isPrime = new boolean[20000001];

    public void run(){

        primeGenerator();
        genSum();

        long sum = 0;
        for(int i = 15000001; i < sumOfFactors.length; i++){
            sum += sumOfFactors[i];
        }

        for(int i = 2; i < 5000001; i++){
            sum -= sumOfFactors[i];
        }

        System.out.println("the answer = " + sum);
    }

    public void genSum(){
        for(int i = 0 ; i < isPrime.length; i++){
            if (isPrime[i]){
                for(long j = i; j < sumOfFactors.length; j += i){
                    long temp = j;
                    while (temp % i == 0){
                        sumOfFactors[(int)j] += i;
                        temp /= i;
                    }
                }
            }
        }

        for(int i = 0; i < sumOfFactors.length; i++){
            if (sumOfFactors[i] == 0){
                sumOfFactors[i] = i;
            }
        }
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
