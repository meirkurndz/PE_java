package com.Package;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;

public class Problem146 {

    public void run(){
        long sum = 0;

        for(long i = 10; i < 150000000L; i+=10) {
            long temp = i * i;
            if (i % 3 == 0 || i % 7 == 0 && i % 13 == 0) continue;
            if (isPrime(temp + 1 ,1) &&
                    isPrime(temp + 3 ,1) &&
                    isPrime(temp + 7 ,1) &&
                    isPrime(temp + 9 ,1) &&
                    isPrime(temp + 13,1) &&
                    !isPrime(temp + 19 ,1) &&
                    !isPrime(temp + 21 ,1) &&
                    isPrime(temp + 27,1)){
            if (isPrime(temp + 1, 2) &&
                    isPrime(temp + 3, 2) &&
                    isPrime(temp + 7, 2) &&
                    isPrime(temp + 9, 2) &&
                    isPrime(temp + 13, 2) &&
                    !isPrime(temp + 19, 2) &&
                    !isPrime(temp + 21, 2) &&
                    isPrime(temp + 27, 2)) {

                    //System.out.println(i);
                    sum += i;
                }
            }
        }
        System.out.println("the answer = " + sum);
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
/*
    static long power(long x, long y, long p) {

        long res = 1; // Initialize result

        //Update x if it is more than or
        // equal to p
        x = x % p;

        while (y > 0) {

            // If y is odd, multiply x with result
            if ((y & 1) == 1)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }

        return res;
    }

    // This function is called for all k trials.
    // It returns false if n is composite and
    // returns false if n is probably prime.
    // d is an odd number such that d*2<sup>r</sup>
    // = n-1 for some r >= 1
    static boolean miillerTest(long d, long n) {

        // Pick a random number in [2..n-2]
        // Corner cases make sure that n > 4
        int a = 2 + (int)(Math.random() % (n - 4));

        // Compute a^d % n
        long x = power(a, d, n);

        if (x == 1 || x == n - 1)
            return true;

        // Keep squaring x while one of the
        // following doesn't happen
        // (i) d does not reach n-1
        // (ii) (x^2) % n is not 1
        // (iii) (x^2) % n is not n-1
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }

        // Return composite
        return false;
    }

    // It returns false if n is composite
    // and returns true if n is probably
    // prime. k is an input parameter that
    // determines accuracy level. Higher
    // value of k indicates more accuracy.
    static boolean isPrime(long n, long k) {

        // Corner cases
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;

        // Find r such that n = 2^d * r + 1
        // for some r >= 1
        long d = n - 1;

        while (d % 2 == 0)
            d /= 2;

        // Iterate given number of 'k' times
        for (int i = 0; i < k; i++)
            if (!miillerTest(d, n))
                return false;
        return true;
    }*/

}
