package com.Package;

import java.math.BigInteger;

public class Problem216 {

    public void run(){

        long LIMIT = 50000000;
        int count = 0;
        for(long i = LIMIT; i > 1; i--){
            BigInteger temp = BigInteger.valueOf(2 * i * i - 1);
            if (temp.isProbablePrime(3)){
                count++;
            }
        }
        System.out.println("the answer = " + count);
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
