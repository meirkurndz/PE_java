package com.Package;

import java.util.Arrays;

public class Problem609 {
    static final long MOD = 1000000007L;
    boolean[] isPrime = new boolean[100000001];
    int[] pai = new int[100000001];
    int[] paiSeq = new int[100000001];

    public void run(){
        long time1 = System.currentTimeMillis();
        primeGenerator();
        setPai();

        for(int i = paiSeq.length-1; i > 1 ; i--){
            int count = 0;
            if(!isPrime[i])
                count++;
            int curr = i;
            while (curr != 1){
                curr = pai[curr];
                if(!isPrime[curr])
                    count++;
                paiSeq[count]++;
            }
        }
        long prod = 1;
        for(int i = 0; i < paiSeq.length; i++){
            if(paiSeq[i] != 0){
                prod *= paiSeq[i];
                prod %= MOD;
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + prod);
        System.out.println("found in " + (time2 - time1) + "ms");
    }

    public void setPai(){
        pai[0] = 0;
        pai[1] = 0;
        int count = 0;
        for(int i = 2; i < pai.length; i++){
            if(isPrime[i]){
                count++;
            }
            pai[i] = count;
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
    }
}
