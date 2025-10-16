package com.Package;

import java.util.Arrays;

public class Problem451 {

    static int size = 20 * 1000 * 1000;
    static int[] pfactor = new int[size+1];

    public void run(){
        setPfactor();

        long sum = 0;
        long val;
        for(int i = 3; i <= size; i++){
            //System.out.println(i);
            val = calc(i);
            sum += val;
        }
        System.out.println("the answer = " + sum);

    }

    public void setPfactor(){
        for(int i = 0; i < pfactor.length; i++) pfactor[i] = i;
        for(int i = 2; i < pfactor.length; i++){
            if (pfactor[i] == i){
                for (int j = 2*i; j < pfactor.length; j+=i)
                    pfactor[j] = i;
            }
        }
    }


    public static long calc(int n){
        if (pfactor[n] == n){ return 1;}
        for(long i = n-pfactor[n]; i > n/2-1; i -= pfactor[n]){
            long a = i*i, b = 2*i;
            if (i+2 != n && ( (a+b)%n == 0)) return i+1;
            if ( (a-b) %n == 0) return i-1;
        }
        return 1;
    }
}