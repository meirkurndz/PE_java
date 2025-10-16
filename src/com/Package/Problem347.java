package com.Package;

import java.util.Arrays;

public class Problem347 {
    boolean[] isPrime = new boolean[10000001];
    boolean[] used = new boolean[10000001];
    int[] numOfDis = new int[10000001];

    public void run(){
        primeGenerator();
        gen();
        long sum = 0;
        for(int i = 2; i * i < isPrime.length; i++){
            for(int j = i + 1; j < isPrime.length;j++){
                if (isPrime[i] && isPrime[j]){
                    if(i * j > isPrime.length-1) break;
                    int temp = search(i,j);
                    sum += temp;
                    //System.out.println( i + " , " + j + " , " + temp);
                }
            }
        }
        System.out.println("the answer = " + sum);
    }

    public void gen(){
        for(int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){
                for(int j = i; j < isPrime.length; j += i){
                    numOfDis[j]++;
                }
            }
        }
    }

    public int search(int p1, int p2){
        int first = p2;
        while (first < isPrime.length - p2){
            first += p2;
        }
        for (int i = first; i >= p1*p2; i-= p2){
            if (numOfDis[i] == 2 && !used[i] && i % p1 == 0 && i % p2==0) {
                int temp = i;
                while (temp % p1 == 0) {
                    temp /= p1;
                }
                while (temp % p2 == 0) {
                    temp /= p2;
                }
                if (temp == 1) {
                    used[i] = true;
                    return i;
                }
            }
        }
        return 0;
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
