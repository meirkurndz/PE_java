package com.Package;

import java.beans.BeanInfo;
import java.math.BigInteger;
import java.util.Arrays;

public class Problem123 {

    boolean[] isPrime = new boolean[100000000];
    int[] primes = new int[100000000];
    public void run(){

        primeGenerator();

        long limit = (long)Math.pow(10,10);
        BigInteger r = new BigInteger("0");
        int n = 7037;
        while (r.compareTo(BigInteger.valueOf(limit)) < 0) {
            n+=2;
            BigInteger p = BigInteger.valueOf(primes[n-1]);
            r = p.multiply(BigInteger.valueOf(2*n));
        }

        System.out.println(n);

/*

        System.out.println("finished");
        int n = 0;
        long lim = (long) Math.pow(10,10);
        for(int i = 0; n < isPrime.length ;i++){
            if(isPrime[i]){
                n++;
                System.out.println(n + " , " + i);
                BigInteger temp = new BigInteger(String.valueOf(i));
                BigInteger temp1 = temp.add(BigInteger.ONE).pow(n);
                BigInteger temp2 = temp.subtract(BigInteger.ONE).pow(n);
                if((temp1.add(temp2)).mod(BigInteger.valueOf((long)Math.pow(i,2))).compareTo(BigInteger.valueOf(lim)) > 0){
                    System.out.println("answer = " + n + " , " + i);
                }
            }

        }
*/


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
        int count = 1;
        for(int i = 0; i < isPrime.length;i++){
            if(isPrime[i]){
                primes[count] = i;
                count++;
            }
        }

    }


}
