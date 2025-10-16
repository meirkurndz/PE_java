package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem641 {
    static final BigInteger LIMIT = new BigInteger("1000000000000000000000000000000000000");
    //static final BigInteger LIMIT = new BigInteger("100000000");
    boolean[] isPrime = new boolean[500000000];
    int[] primes = new int[26355867];

    static long sum = 0;
    public void run(){
        primeGenerator();
        rec(BigInteger.valueOf(1),1,0);
        System.out.println("the answer = " + sum);
    }


    public void rec(BigInteger number,long div_num, int index){
        if (div_num % 6 == 1) {
            //System.out.println(number);
            sum += 1;
        }
        for(int i = index; i < primes.length; i++){
            long p = primes[i];
            int mul = 5;
            BigInteger temp = number.multiply(BigInteger.valueOf(p)).multiply(BigInteger.valueOf(p))
                    .multiply(BigInteger.valueOf(p)).multiply(BigInteger.valueOf(p));
            if (temp.compareTo(LIMIT) > 0) break;
            while (temp.compareTo(LIMIT) <= 0){
                if (mul%6!=3)
                    rec(temp,div_num*mul,i+1);
                mul++;
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
