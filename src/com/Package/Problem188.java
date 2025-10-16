package com.Package;

import javax.swing.text.Position;
import java.math.BigInteger;

public class Problem188 {


    public void run(){
        long answer = hexp(1777,1855,100000000);
        System.out.println(answer);
    }

    static long cycleSize(long n, long m) {

        long num = n;
        long i = 1;
        for (; num != 1L; i++) {
            num = num * n;
            num = num % m;
        }

        return i;

    }


    static long hexp(long n, long hexp, long mod) {
        if (hexp == 1)
            return n % mod;
        long mod1 = cycleSize(n, mod);
        long exp = hexp(n, hexp - 1, mod1);
        long num = 1;
        for (long i = 0; i < exp; i++) {
            num = num * n;
            num = num % mod;
        }

        return num;
    }





}
