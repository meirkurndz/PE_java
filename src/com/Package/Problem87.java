package com.Package;

import java.util.Arrays;

public class Problem87 {

    boolean isPrime[] = new boolean[50000001];
    boolean[] isExp = new boolean[50000001];

    public void run(){
        primeGenerator();
        //System.out.println("finish gen");

        for(int i = 2; i*i < isPrime.length-1;i++){
            if (isPrime[i]) {
                int i2 = i*i;
                for (int j = 2; (j*j*j) + i2 < isPrime.length - 1; j++) {
                    if (isPrime[j]) {
                        int j3 = j*j*j;
                        for (int k = 2; (k*k*k*k) + i2 + j3 < isPrime.length - 1; k++) {
                            if (isPrime[k]) {
                                //System.out.println(i + " , " + j + " , " + k);
                                int temp = i2 +j3 + k*k*k*k;
                                if (temp < isExp.length) {
                                    //System.out.println(temp);
                                    isExp[temp] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        int count = 0;
        for(int i = 28; i < isExp.length-1;i++){
            if (isExp[i]){
                count++;
            }
        }
        System.out.println(count);
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
