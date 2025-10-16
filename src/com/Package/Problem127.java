package com.Package;

import java.util.Arrays;

public class Problem127 {

    int limit = 120000;
    long[] rad = new long[limit];

    public void run(){
        long sum = 0;
        genRads();
        for(int a = 1; a < rad.length; a++){
            for(int b = a + 1; a + b < rad.length;b++){
                if (rad[a] * rad[b] * rad[a+b] < a+b && gcd(a,b) == 1){
                    //System.out.println(a + " , " + b + " , " + (a+b));
                    sum += a + b;
                }
            }
        }
        System.out.println("the answer = " + sum);
    }

    public void genRads(){
        Arrays.fill(rad,1);
        for(int i = 2; i < rad.length; i++){
            if (rad[i] == 1){
                for(int j = i; j < rad.length;j += i){
                    rad[j] *= i;
                }
            }
        }
    }

    public int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}


