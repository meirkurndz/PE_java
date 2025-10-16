package com.Package;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;

public class Problem501 {

    static final long LIMIT = 1000000000000L;
    boolean[] isPrime = new boolean[200000000];
    LinkedList<Long> primes = new LinkedList<>();

    public void run(){
        primeGenerator();

        for(long i = isPrime.length; i <= 125000000000L; i++){
            if (isPrime(i, 3)){
                System.out.println(i);
                primes.add(i);
            }
        }
        System.out.println("finish primes");

        long count = 0;
        long size = primes.size();
        for(int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                long temp = (long) Math.pow(primes.get(i), 3) * primes.get(j);
                if (temp > LIMIT)
                    break;
                count++;
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

        for(int i = 0; i < isPrime.length; i++){
            if (isPrime[i]){
                primes.add((long)i);
            }
        }
    }


    static boolean miillerTest(BigInteger d, long n) {

        long aB = 2 + (long)(Math.random() % (n - 4));
        BigInteger a = BigInteger.valueOf(aB);

        BigInteger x = power(a, d, BigInteger.valueOf(n));

        if (x.compareTo(BigInteger.ONE) == 0 || x.compareTo(BigInteger.valueOf(n-1)) == 0)
            return true;

        while (d.compareTo(BigInteger.valueOf(n - 1)) != 0) {
            x = (x.multiply(x)).mod(BigInteger.valueOf(n));
            d = d.multiply(BigInteger.TWO);

            if (x.compareTo(BigInteger.ONE) == 0)
                return false;
            if (x.compareTo(BigInteger.valueOf(n-1)) == 0)
                return true;
        }
        return false;
    }

    static boolean isPrime(long n, long k) {

        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;

        BigInteger d = BigInteger.valueOf(n - 1);

        while (d.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)
            d = d.divide(BigInteger.TWO);

        for (long i = 0; i < k; i++)
            if (!miillerTest(d, n))
                return false;
        return true;
    }

    static BigInteger power(BigInteger x, BigInteger y, BigInteger p) {

        BigInteger res = new BigInteger("1");

        x = x.mod(p);

        while (y.compareTo(BigInteger.ZERO) > 0) {

            if (y.mod(BigInteger.TWO).compareTo(BigInteger.ONE) == 0)
                res = (res.multiply(x)).mod(p);

            y = y.divide(BigInteger.TWO); // y = y/2
            x = (x.multiply(x)).mod(p);
        }
        return res;
    }

}
