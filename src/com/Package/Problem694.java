package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem694 {
    static final long LIMIT = 1000000000000000000L;
    boolean[] isPrime = new boolean[1000000];
    int[] primes = new int[78498];
    static long count = 0;
    static long sum = 0;
    //1339784153569958487
    //1055537336680447
    public void run(){
        primeGenerator();
        rec(1,0);
        System.out.println("the answer = " + sum);
    }


    public void rec(long number, int index){
        if (number>LIMIT || number<0)return;
        //System.out.println(number);
        sum += LIMIT/number;
        //System.out.println(sum);
        for(int i = index; i < primes.length; i++){
            long p = primes[i];
            BigInteger temp = BigInteger.valueOf(number).multiply(BigInteger.valueOf(p)).multiply(BigInteger.valueOf(p)).multiply(BigInteger.valueOf(p));
            if (temp.compareTo(BigInteger.valueOf(LIMIT)) > 0) break;
            long t = number *p*p*p;
            while (temp.compareTo(BigInteger.valueOf(LIMIT)) <= 0){
                rec(t,i+1);
                t *= p;
                temp = temp.multiply(BigInteger.valueOf(p));
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
        isPrime[0] = false;
        isPrime[1] = false;
        int count = 0;
        for(int i = 0; i < isPrime.length;i++){
            if(isPrime[i]){
                primes[count++] = i;
            }
        }
        //System.out.println(count);
    }
}
