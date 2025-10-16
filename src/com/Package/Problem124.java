package com.Package;

import java.util.Arrays;

public class Problem124 {

    int[] rad = new int[100001];
    boolean[] isPrime = new boolean[100001];

    int[][] sortRad =  new int[100001][2];
    //      [0] = number, [1] = rad[number];

    public void run(){
        primeGenerator();
        genRad();
        //sort();
        rad[0] = 0;
        //Arrays.sort(rad,1,rad.length);
        int count = 0;
        for(int i = 0; i < rad.length; i++){
            if (rad[i] == 1947){
               count++;
               if (count == 4){
                   System.out.println("the answer = " + i);
                   break;
               }
            }
            //System.out.println(i + " , " + rad[i]);
        }
    }

    public void sort(){
        for(int i = 0 ; i < rad.length; i++){
            int index = findPos(i , rad[i]);
            for(int j = sortRad.length-1; j > index; j--){
                sortRad[j][1] = sortRad[j-1][1];
                sortRad[j][0] = sortRad[j-1][0];
            }
        }
    }

    public int findPos(int number, int numRad){

        for(int i = 0; i < rad.length; i++){
            if (numRad > sortRad[i][1]){
                for(int j = i; j < sortRad.length; j++){
                    if (number < sortRad[i][0]) return i;
                    if (number > sortRad[i][0]) return i + 1;
                }
            }
        }
        return 0;
    }

    public void genRad(){
        Arrays.fill(rad,1);
        for(int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){
                for(int j = i; j < isPrime.length; j += i){
                    rad[j] *= i;
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
    }
}
