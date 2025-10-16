package com.Package;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Problem407 {

    boolean[] isPrime = new boolean[10000001];
    boolean[] primesAndPP = new boolean[10000001];
    long[] largestPrime = new long[10000001];

    public void run(){

        primeGenerator();
        genLargestPrime();

        //when n = 1, a = 0:
        long sum = -1;

        for(int i = 1; i < isPrime.length; i++){
            long temp = find(i);
            sum += temp;
            //System.out.println(i + " , " + temp);
        }
        System.out.println("the answer = " + sum);
    }

    public long find(int number){
        if (primesAndPP[number]){
            return 1;
        }

        long p = largestPrime[number];
        long start = number - (number % p);
        for(long i = start; i >= p; i -= p){

            long next = i + 1;
            if ((next * next) % number == next){
                return next;
            }

            if ((i * i) % number == i){
                return i;
            }
        }

        return 1;
    }

    public void genLargestPrime(){
        for(int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){
                for(int j = i; j < isPrime.length; j += i){
                    largestPrime[j] = i;
                }
            }
        }
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

        for(int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){
                for(long j = i; j < isPrime.length; j *= i){
                    if (j > isPrime.length){
                        break;
                    }else {
                        primesAndPP[(int)j] = true;
                    }
                }
            }
        }
        primesAndPP[1] = true;
    }
}
