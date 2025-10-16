package com.Package;

import java.util.Arrays;

public class Problem417 {

    long[] period = new long[100000001];
    boolean[] isPrime = new boolean[100000001];

    public void run(){
        primeGenerator();
        System.out.println("finish generating primes");

        for(long i = 6; i < isPrime.length; i++){
            if (i % 1000000 == 0){
                System.out.println("index = " + i);
            }
            if (isPrime[(int)i]) {

                long numPeriod = findPeriod(i);
                period[(int)i] = numPeriod;
                System.out.println(i + " , " + numPeriod);
            }
        }
        System.out.println("finish gen periods");
    }

    public long findPeriod(long number){

        int digNum = digNum(number);
        long mag = ((long) Math.pow(10,digNum));
        long current = mag % number;
        long count = digNum;

        while (current != 1){

            int tempCount = 0;

            while (current < number) {
                tempCount++;
                current *= 10;
            }

            current %= number;
            count += tempCount;
        }

        return count;
    }


    public int digNum(long number){
        int digNum = 0;
        while (number != 0) {
            digNum++;
            number /= 10;
        }
        return digNum;
    }

    public long powMod(long a, long exp, long p) {

        long res = 1;

        a = a % p;

        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * a) % p;

            exp = exp / 2;
            a = (a * a) % p;
        }
        return res;
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
