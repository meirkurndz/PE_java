package com.Package;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problem500 {

    boolean[] isPrime = new boolean[10000000];
    LinkedList<Long> primes = new LinkedList<>();
    static final long LIMIT = 500500L;
    static final long MOd = 500500507L;

    public void run(){
        primeGenerator();
        create();
    }

    public long create(){
        int[] exponents = new int[primes.size()];

        //exponents[0]++;
        for(int i = 0; i < LIMIT; i++){
            System.out.println(i);
            int nextIndex = findLowIndex(exponents, primes);
            exponents[nextIndex] *= 2;
            exponents[nextIndex]++;
        }

        for(int j = 0; j < 30; j++){
            System.out.print(exponents[j] + " , ");
        }
        System.out.println();

        return 0;
    }

    public int findLowIndex(int[] exponents, LinkedList<Long> primes){
        int lowIndex = 0;
        int nextIter = 0;


        return lowIndex;
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

        for(int i = 0; i < isPrime.length; i++){
            if (isPrime[i]){
                primes.add((long)i);
            }
        }

    }
}
