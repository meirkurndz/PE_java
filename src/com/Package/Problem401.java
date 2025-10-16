package com.Package;

import java.math.BigInteger;

public class Problem401 {

    static final long MOD = 1000000000L;
    static final long LIMIT = 1000000000000000L;
    static final BigInteger MODULUS_BI = BigInteger.valueOf(MOD);
    static final BigInteger SIX_BI = BigInteger.valueOf(6);

    public void run() {

        long splitCount = BigInteger.valueOf(LIMIT).sqrt().longValue();
        splitCount = Math.max(splitCount / 3, 1);
        int splitAt = (int)(LIMIT / (splitCount + 1));

        long sum = 0;

        for (long i = 1; i <= splitAt; i++) {

            long count = (LIMIT / i) % MOD;
            long square = (i * i) % MOD;
            square = square * count % MOD;
            sum = (sum + square) % MOD;
        }

        for (long i = splitCount; i >= 1; i--) {

            long start = LIMIT / (i + 1);
            long end = LIMIT / i;
            long sumSquares = sumSquaresMod(end) - sumSquaresMod(start);
            sumSquares = (sumSquares + MOD) % MOD;
            sum = (sum + i * sumSquares % MOD) % MOD;
        }

        System.out.println("the answer = " + sum);
    }



    private static long sumSquaresMod(long n) {

        BigInteger x = BigInteger.valueOf(n);
        BigInteger y = x.multiply(x.add(BigInteger.ONE));
        y = y.multiply(x.shiftLeft(1).add(BigInteger.ONE));
        y = y.divide(SIX_BI);
        y = y.mod(MODULUS_BI);

        return y.longValue();
    }

}
