package com.Package;

import java.math.BigInteger;

public class Problem387 {


    public void run(){

        long sum = 0;
        for(int i = 1; i <= 9 ; i++) {
            sum += count(i, 1);
        }
        System.out.println("the answer = " + sum);
    }

    public long count(long number, int length){
        long count = 0;
        if (length == 13){
            if (isPrime(number/digitSum(number),3)) {
                for (int i = 1; i < 10; i += 2) {
                    long temp = number * 10 + i;
                    if (isPrime(temp, 3)) {
                        //System.out.println(temp);
                        count += temp;
                    }
                }
            }
        }else{
            if (isPrime(number/digitSum(number),3)) {
                for (int i = 1; i < 10; i += 2) {
                    long temp = number * 10 + i;
                    if (isPrime(temp, 3)) {
                        //System.out.println(temp);
                        count += temp;
                    }
                }
            }
            for(int i = 0; i <= 9 ;i++){
                long temp = number * 10 + i;
                if (isValid(temp)){
                    count += count(temp, length + 1);
                }
            }
        }
        return count;
    }

    public boolean isValid(long number){
        if (number % digitSum(number) == 0){
            return  true;
        }
        return false;
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


    public int digitSum(long number){
        int sum = 0;
        while (number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
