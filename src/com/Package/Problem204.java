package com.Package;

import java.util.Arrays;

public class Problem204 {

    boolean[] isHamingNumber = new boolean[500000000];

    int[] primes = {2,3,5,7,11,13,17,19,23,29,
            31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};

    public void run(){
        System.out.println("the answer = " + hamming(1000000000, primes.length-1));
    }

    public int hamming(int lim, int primeIndex){
        if (primeIndex == 0) return (int) (Math.log(lim)/Math.log(2)) + 1;
        if (lim == 0) return 0;
        return hamming(lim,primeIndex-1) + hamming(lim/primes[primeIndex],primeIndex);
    }






/*
    public void run(){
        int count = 1;
        for(int i = 2; i < 1000000001;i++){
            int temp = i;
            while (temp % 2 == 0){
                temp /= 2;
            }
            for(int p = 3; p < 101; p+=2){
                while (temp % p == 0){
                    temp /= p;
                }
            }
            if (temp == 1) count++;
            //System.out.println(i + " , " + temp);
        }
        System.out.println(count);
    }*/
}
