package com.Package;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem333 {

    boolean[] isPrime = new boolean[1000000];
    boolean[] threeSmooth = new boolean[1000000];
    int[] countPartitions = new int[1000000];

    public void run(){

        // 2, 3, 5, 7, 13, 17, 23, 43, 59, 61, 113, 181, 193, 199, 241, 467, 479, 499

        primeGenerator();
        genThreeSmooth();

        //preparing the list of number whom factors are 2 and 3
        LinkedList<Integer> canBeUsed = new LinkedList<>();
        for(int i = 2; i < threeSmooth.length; i++){
            if (threeSmooth[i])
                canBeUsed.add(i);
        }

        // gen all answers
        genCountPartition(0, canBeUsed);

        long sum = 0;
        for(int i = 2 ; i < isPrime.length; i++){
            if (isPrime[i] && countPartitions[i] == 1){
                sum += i;
            }
        }
        System.out.println("the answer = " + sum);
    }

    public void genCountPartition(int sum, LinkedList<Integer> canBeUsed){

        if (sum >= countPartitions.length){
            return;
        }
        if (isPrime[sum]){
            countPartitions[sum]++;
        }

        while (canBeUsed.size() != 0){
            int getI = canBeUsed.get(0);
            int nextSum = sum + getI;
            LinkedList<Integer> nextIter = new LinkedList<>();
            canBeUsed.remove(0);
            int size = canBeUsed.size();

            for(int i = 0; i < size; i++){
                int temp = canBeUsed.get(i);
                if (temp % getI != 0){
                    nextIter.add(temp);
                }
            }
            genCountPartition(nextSum, nextIter);
        }
    }

    public void genThreeSmooth(){
        for(int i = 2; i < threeSmooth.length; i++){
            int temp = i;
            while (temp % 2 == 0){
                temp /= 2;
            }
            if (temp == 1){
                threeSmooth[i] = true;
                continue;
            }
            while (temp % 3 == 0){
                temp /= 3;
            }
            if (temp == 1){
                threeSmooth[i] = true;
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
    }
}
