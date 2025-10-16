package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem134 {

    boolean[] isPrime = new boolean[1000100];

    public void run(){
        primeGenerator();
        long sum = 0;
        int p1 = 5;
        int p2 = 0;
        while (p1 < 1000000){
            for(int j = (p1+2) ; j < 1000100; j+=2){
                if (isPrime[j]){
                    p2 = j;
                    break;
                }
            }
            long temp = findSmall(p1,p2);
            //System.out.println(p1 + " , " + p2 + " , " + temp);
            sum = sum + temp;
            p1 = p2;
        }

        System.out.println("the answer = " + sum);
    }

    public long findSmall(long p1, long p2){
        long ans = p1;
        int p1DigNum = digNum(p1);
        long toAdd = (int)Math.pow(10,p1DigNum);
        while (ans % p2 != 0){
            ans += toAdd;
        }
        return ans;
    }

    public int digNum(long number){
        int digNum = 0;
        while (number != 0) {
            digNum++;
            number /= 10;
        }
        return digNum;
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

}
