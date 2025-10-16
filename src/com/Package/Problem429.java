package com.Package;

import java.util.Arrays;

public class Problem429 {

    boolean[] isPrime = new boolean[100000001];
    public void run(){
        //primeGenerator();
        System.out.println("finish gen");
        int temp = 9*8*7*6*5*4*3*2;

        for(int i = 1; i*i < temp+1; i++){
            if (temp % i == 0){
                if (gcd(i, temp/i) == 1){
                    System.out.println(i + " , " + temp/i);
                }
            }
        }

    }

    public int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
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
