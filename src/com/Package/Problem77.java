package com.Package;

import java.util.Arrays;

public class Problem77 {

    int limit = 100;
    boolean[] isPrime = new boolean[limit];
    int[] disPrimeFacSum = new int[limit];
    int[] eulerTransform = new int[limit];
    public void run(){

        primeGenerator();
        //System.out.println("finish generate primes");
        genPrimeFacSum();
        //System.out.println("finish generate sums");

        for(int i = 1; i < limit; i++){
            if (eulerTransform(i) > 5000) {
                System.out.println("the answer = " + i);
                break;
            }
        }

    }

    public int eulerTransform(int number){
        if (number == 1) return 0;
        if (eulerTransform[number] != 0) return eulerTransform[number];

        int primePartition = disPrimeFacSum[number];
        for(int i = 1; i < number; i++){
            primePartition += disPrimeFacSum[i] * eulerTransform(number - i);
        }
        primePartition /= number;
        eulerTransform[number] = primePartition;
        return primePartition;
    }

    public void genPrimeFacSum(){
        for(int i = 1; i < disPrimeFacSum.length; i++){
            //System.out.println(i);
            int sum = 0;
            int temp = i;
            for(int j = 2; j < isPrime.length; j++){
                if (isPrime[j] && temp % j == 0){
                    sum += j;
                    while (temp % j == 0){
                        temp /= j;
                    }
                    if (temp == 1) break;
                }
            }
            disPrimeFacSum[i] = sum;
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
