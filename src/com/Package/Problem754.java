package com.Package;

public class Problem754 {

    long[] gauss = new long[100000000];

    public void run(){

    }


    public int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}
