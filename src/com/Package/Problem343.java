package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem343 {

    boolean[] isPrime = new boolean[200000000];
    public void run(){

        long time1 = System.currentTimeMillis();
        primeGenerator();
        long ans = 0;

        for(long i = 2000000; i > 0; i--){

            long temp1 = i+1;
            long temp2 = (i*i) - i + 1;
            long fracSeq = Math.max(LPF(temp1),LPF(temp2))-1;
            if (i % 1000 == 0)
                //System.out.println(i + ", f(" + i*i*i + ") = " + fracSeq);
            ans += fracSeq;
        }

        //System.out.println(LPF(18));

        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public long LPF(long number){
        if (number < isPrime.length-1 && isPrime[(int)number])
            return number;

        long temp = number;
        while (number%2==0)
            number /= 2;
        if(number==1)
            return 2;

        for(long i = 3; i < isPrime.length && i*i <= temp; i+=2){
            if (isPrime[(int)i]){
                if(i*i > number)
                    return number;
                while (number % i == 0){
                    number /= i;
                }
                if (number == 1)
                    return i;
            }
        }

        long start = (((int)(isPrime.length/6))*6)+5;
        for(long i = start; i*i <= temp; i+=6){
            if (i*i > number)
                return number;
            while (number % i == 0){
                number /= i;
            }
            if (number == 1)
                return i;
            while (number % (i+2) == 0){
                number /= i+2;
            }
            if (number == 1)
                return i;
        }

        return number;
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

    public long fracSeq(long num){
        long up = 1;
        long down = num;
        //System.out.println(up + "/" + down);
        while (down != 1){

            up++;
            down--;
            long gcd = gcd(up,down);
            up /= gcd;
            down /= gcd;
            //System.out.println(up + "/" + down);
        }
        System.out.println("f(" + num + ") = " + up);
        return up;
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
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
