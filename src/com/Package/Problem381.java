package com.Package;

import java.util.Arrays;

public class Problem381 {
    boolean[] isPrime = new boolean[100000001];

    public void run(){
        primeGenerator();
        //System.out.println("finish prime gen");
        long sum = 0;
        for(long p = 5; p < isPrime.length ;p++){
            if (isPrime[(int)p]){
                long tempSum = 0;
                for(int j = 1; j <= 5;j++) {
                    long temp = modFact((int)p-j,(int)p) % p;
                    tempSum += temp;
                    tempSum %= p;
                }
                //System.out.println(p + " , " + tempSum);
                sum += tempSum;
            }
        }
        System.out.println("the answer = " + sum);
    }

    static long power(long x, long y, long p)
    {
        long res = 1;
        x = x % p;
        while (y > 0) {
            // If y is odd, multiply
            // x with result
            if ((y % 2) != 0)
                res = (res * x) % p;

            // y must be even now
            y = y/2; // y = y/2
            x = (x * x) % p;
        }
        return res % p;
    }

    static long modInverse(long a, long p) {
        return power(a, p - 2, p) % p;
    }

     long modFact(long n, long p) {
        if (p <= n)
            return 0;
        long res = (p - 1);
        for (long i = n + 1; i < p; i++)
            res = (res * modInverse(i, p)) % p;
        return res % p;
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
