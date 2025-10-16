package com.Package;

import java.util.Arrays;

public class Problem234 {
    static final long LIMIT = 999966663333L;
    boolean[] isPrime = new boolean[10000000];
    public void run(){
        primeGenerator();
        long sum = 0;
        long curr = 2;
        while (curr * curr <= LIMIT){
            long next = curr + 1;
            while (!isPrime[(int)next])
                next++;

            long from = curr * curr;
            long to = next * next;

            for(long i = from + curr; i < to && i <= LIMIT; i += curr)
                sum += i;

            while (to - next > LIMIT)
                to -= next;

            for(long i = to - next; i > from; i -= next)
                sum += i;

            for(long i = from - from % (curr*next); i < to && i <= LIMIT; i += curr*next){
                if(i <= from)
                    continue;
                if(i > LIMIT)
                    break;
                sum -= (i+i);
            }

            curr = next;
        }
        System.out.println("the answer = " + sum);
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
        isPrime[0] = false;
        isPrime[1] = false;
    }



}
