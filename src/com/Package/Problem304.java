package com.Package;

import java.math.BigInteger;

// f(a(0)) = 466445297471
// f(a(1)) = 428562224098

public class Problem304 {

    long[] primes = new long[100001];
    long[] fibonaccis = new long[100001];
    long[] memo = new long[100000000];
    public void run(){

        //System.out.println(genFibo(1000000000030L));
        //System.out.println(genFibo(1000000000031L));
        genPrimes();
        System.out.println("finish gen primes");
        long sum = 0;
        for(int i = 1; i < fibonaccis.length; i++){
            sum += fibonaccis[i];
            sum %= 1234567891011L;
        }
        System.out.println("the answer = " + sum);
    }

    public void genPrimes(){
        //100000000000031
        int index = 3;
        primes[1] = 0;
        //fibonaccis[0] = 921144120792L;
        fibonaccis[1] = 921144120792L;
        fibonaccis[2] = 199461219007L;
        //System.out.println(0 + " , " + primes[0]);
        for(long i = 100000000000032L; index < 100001; i++){
            if (isPrime(i, 4)){
                primes[index] = i - 100000000000031L;
                fibonaccis[index] = nextFibonacci(primes[index] - primes[index-1] - 1,
                                                          fibonaccis[index-1],
                                                          fibonaccis[index-2]);
                //System.out.println(index + " , " + primes[index]);
                index++;
            }
        }
    }

    public long genFibo(long index){
        //System.out.println(index);
        if (index < memo.length) {
            if (memo[(int)index] != 0) return memo[(int)index];
        }
        if (index == 0) return 0;
        if (index == 1) return 1;
        if (index % 2 == 0){
            long temp = genFibo(index/2) % 1234567891011L;
            BigInteger toReturn = BigInteger.valueOf(temp).multiply(BigInteger.valueOf((2 * (genFibo((index/2)-1) % 1234567891011L))% 1234567891011L + temp)).mod(BigInteger.valueOf(1234567891011L));
            if (index < memo.length){
                memo[(int) index] = Long.parseLong(toReturn.toString());
            }
            return Long.parseLong(toReturn.toString());
        }else{
            long index1 = (index + 1)/2;
            long index2 = index1-1;
            long temp1 = genFibo(index1) % 1234567891011L;
            long temp2 = genFibo(index2) % 1234567891011L;
            BigInteger toReturnBig = ((BigInteger.valueOf(temp1).multiply(BigInteger.valueOf(temp1))).mod(BigInteger.valueOf(1234567891011L)).add(BigInteger.valueOf(temp2).multiply(BigInteger.valueOf(temp2))).mod(BigInteger.valueOf(1234567891011L))).mod(BigInteger.valueOf(1234567891011L));
            long toReturn = Long.parseLong(toReturnBig.toString());
            if (index < memo.length){
                memo[(int)index] = toReturn;
            }
            return toReturn;
        }
    }

    public long nextFibonacci(long iteration, long F1, long F2){
        long F3 = 0;
        for(long i = 0; i < iteration;i++){
             F3 = (F1+F2) % 1234567891011L;
             F1 = F2;
             F2 = F3;
        }
        return F3;
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

    static boolean miillerTest(long d, long n) {

        long aB = 2 + (long)(Math.random() % (n - 4));
        long a = aB;

        long x = power(a, d, n);

        if (x == 1 || x == n-1)
            return true;

        while (d != n - 1) {
            x = (x * x) % n;
            d = d * 2;

            if (x == 1)
                return false;
            if (x == n-1)
                return true;
        }
        return false;
    }

    static boolean isPrime(long n, long k) {

        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;

        long d = n - 1;

        while (d % 2 == 0)
            d = d / 2;

        for (long i = 0; i < k; i++)
            if (!miillerTest(d, n))
                return false;
        return true;
    }

    static long power(long x, long y, long p) {

        long res = 1;

        x = x % p;

        while (y > 0) {

            if (y % 2 == 1)
                res = (res * x) % p;

            y = y / 2; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }
*/


}
