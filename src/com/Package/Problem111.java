package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem111 {
    static final int LEN = 10;
    public void run(){
        //1-9
        //2
        //3-9
        //4-9
        //5-9
        //6-9
        //7-9
        //8
        //9-9
        long sum = reg();
        sum += non();
        System.out.println("the answer = " + sum);

    }

    public long non(){
        long sum = 0;
        int[] num_arr = new int[LEN];
        Arrays.fill(num_arr, 2);
        long sum_2 = 0;
        for (int dig1 = 1; dig1 < 10; dig1+=1) {
            num_arr[LEN-1]=dig1;
            for (int dig = 0; dig < 10; dig++) {
                for (int j = 0; j < num_arr.length-1; j++) {
                    if (!(dig == 0 && j == 0)) {
                        num_arr[j] = dig;
                        long temp = creat(num_arr);
                        //System.out.println(temp);
                        num_arr[j] = 2;
                        if (isPrime(temp, 4)) {
                            sum_2 += temp;
                            //System.out.println(temp + " is a prime!");
                        }
                    }
                }
            }
        }
        sum+=sum_2;
        //System.out.println("sum_2 = " + sum_2);

        long sum_8 = 0;
        Arrays.fill(num_arr, 8);
        for (int dig1 = 1; dig1 < 10; dig1+=1) {
            num_arr[LEN-1] = dig1;
            for (int dig = 0; dig < 10; dig++) {
                for (int j = 0; j < num_arr.length-1; j++) {
                    if (dig == 0 && j == 0) continue;
                    num_arr[j] = dig;
                    long temp = creat(num_arr);
                    //System.out.println(temp);
                    num_arr[j] = 8;
                    //System.out.println(temp);
                    if (isPrime(temp, 5)) {
                        sum_8 += temp;
                        //System.out.println(temp + " is a prime!");
                    }

                }
            }
        }
        sum+=sum_8;
        //System.out.println("sum_8 = " + sum_8);

        long sum_0 = 0;
        Arrays.fill(num_arr, 0);
        for (int dig1 = 1; dig1 < 10; dig1++) {
            num_arr[0]=dig1;
            for (int dig = 1; dig < 10; dig++) {
                for (int j = 1; j < num_arr.length; j++) {
                    num_arr[j] = dig;
                    long temp = creat(num_arr);
                    //System.out.println(temp);
                    num_arr[j] = 0;
                    if (isPrime(temp, 5)) {
                        sum_0 += temp;
                        //System.out.println(temp + " is a prime!");
                    }

                }
            }
        }
        sum += sum_0;
        //System.out.println("sum_0 = " + sum_0);


        return sum;
    }

    public long reg(){
        long sum = 0;

        for(int d = 0;d < 10; d++) {
            if (d==0||d==2||d==8)continue;
            long sum_d = 0;
            int[] num_arr = new int[LEN];
            Arrays.fill(num_arr, d);

            for (int dig = 0; dig < 10; dig++) {
                for (int j = 0; j < num_arr.length; j++) {
                    if (dig == 0 && j == 0) continue;
                    num_arr[j] = dig;
                    long temp = creat(num_arr);
                    //System.out.println(temp);
                    num_arr[j] = d;
                    if (isPrime(temp, 5)) {
                        sum_d += temp;
                        //System.out.println(temp + " is a prime!");
                    }

                }
            }
            sum += sum_d;
            //System.out.println("sum_" + d + " = " + sum_d);
        }
        return sum;
    }

    public long creat(int[] num_arr){
        long num = num_arr[0];
        for(int i = 1; i < num_arr.length; i++){
            num *= 10;
            num += num_arr[i];
        }
        return num;
    }

    public int M(int d){
        boolean is9 = false;
        int m = 8;


        return 0;
    }

    public int N(int n, int d){
        return 0;
    }

    public int S(int n, int d){
        return 0;
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
