package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem569 {

    boolean[] isPrime = new boolean[86028122];
    BigInteger[][] peak = new BigInteger[86028122][2];

    public void run(){
        primeGenerator();
        setPeak();
        System.out.println("gen primes");
        for(int i = 0; i < isPrime.length; i++){
            if(isPrime[i]){
                System.out.println(i + ", (" + peak[i][0] + "," + peak[i][1] + ")");
            }
        }
    }

    public void setPeak(){
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        int dir = 1;
        for(int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){
                x = x.add(BigInteger.valueOf(i));
                y = y.add(BigInteger.valueOf(dir * i));
                peak[i][0] = x;
                peak[i][1] = y;
                dir *= -1;
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
