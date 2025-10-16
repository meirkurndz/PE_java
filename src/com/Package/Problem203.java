package com.Package;

import java.util.LinkedList;

public class Problem203 {

    long[][] pasclasTriangle = new long[52][52];
    long[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,};

    public void run(){
        pascalsTriangle(51);
        LinkedList<Long> distinct = new LinkedList<>();

        long sum = 0;
        for(int i = 1; i < 52; i++){
            for(int j = 1; j <= i; j++){
                long temp = pasclasTriangle[i][j];
                if (!distinct.contains(temp)){
                    distinct.add(temp);
                }
                //System.out.print(pasclasTriangle[i][j] + "  ");
            }
            //System.out.println();
        }
        int size = distinct.size();
        for(int i = 0; i < size; i++){
            long temp = distinct.get(i);
            if (isSquareFree(temp)){
                sum += temp;
            }
        }
        System.out.println("the answer = " + sum);
    }

    public void pascalsTriangle(int rows){

        pasclasTriangle[1][1] = 1;

        for(int i = 2; i <= rows; i++){
            pasclasTriangle[i][1] = 1;
            pasclasTriangle[i][i] = 1;

            for(int j = 2; j < i; j++){
                pasclasTriangle[i][j] = pasclasTriangle[i-1][j-1] + pasclasTriangle[i-1][j];
            }
        }
    }

    public boolean isSquareFree(long number){

        for (long prime : primes) {
            int count = 0;
            while (number % prime == 0) {
                count++;
                number /= prime;
            }

            if (count > 1)
                return false;

            if (number == 1)
                return true;
        }

        return true;
    }

}
