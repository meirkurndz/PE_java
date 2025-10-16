package com.Package;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem548 {

    boolean[] isPrime = new boolean[4000];
    static final long LIMIT = 10000000000000000L;
    public void run(){
        // 2^(2*p - 2)*p , p is odd prime
        primeGenerator();
        LinkedList<Long> answers = new LinkedList<>();

        long sum = 0;
        for(int i = 0; i < isPrime.length; i++){
            if (isPrime[i] && i != 2) {
                long power = 2 * i - 2;
                long toPrint = (long) Math.pow(2, power) * i;
                if (toPrint > LIMIT)
                    break;
                sum += toPrint;
                answers.add(toPrint);
                //System.out.println(toPrint);
            }
        }

        for(int i = 3; i < isPrime.length; i++){
            for(int j = i + 1; j < isPrime.length; j++){
                if (isPrime[i] && isPrime[j]) {
                    long temp = solve(i, j);
                    if (temp > LIMIT || temp < 0)
                        break;
                    if (temp != 0) {
                        sum += temp;
                        answers.add(temp);
                        //System.out.println(i + " , " + j + " , " + temp);
                    }
                }
            }
        }
        answers.sort(Long::compareTo);
        /*for(int i = 0; i < answers.size(); i++){
            System.out.println(answers.get(i));
        }*/
        sum += 29808;
        sum += 34753216512L;
        sum += 467515780104192L;
        sum += 5806013294837760L;

        System.out.println("the answer = " + sum);
    }

    public long solve(long p1, long p2){
        //If n^2 + 6*n + 6 = 2*p*q is twice
        // the product of two distinct odd
        // primes, 2^n*p*q belongs to the sequence
        long c = 6 - (2 * p1 * p2);
        long delta = 36 - (4 * c);
        long sqrt = (long)Math.sqrt(delta);
        if (sqrt*sqrt == delta){
            long power = (sqrt - 6)/2;
            return (long)Math.pow(2,power) * p1 * p2;
        }
        return 0;
    }


    public void primeGenerator() {

        // 1 is prime in here!!!!!!!!!!!!!! do not copy
        //                                           //
        //                                           //
        //                                           //
        //                                           //
        //                                           //
        //                                           //
        //                                           //
        //                                           //
        //                                           //
        ///////////////////////////////////////////////

        Arrays.fill(isPrime, true);
        for (int p = 2; p * p <= isPrime.length - 1; p++) {
            if (isPrime[p]) {
                for (int i = p * 2; i <= isPrime.length - 1; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        isPrime[1] = true;
        isPrime[0] = false;
    }
}
