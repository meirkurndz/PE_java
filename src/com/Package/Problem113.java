package com.Package;

public class Problem113 {

    long increase[][] = new long[101][10];
    long decrease[][] = new long[101][11];

    public void run(){

        for (int i = 1; i <= 9; i++){
            increase[1][i] = 1;
        }

        for(int i = 2; i < increase.length; i++){
            for(int j = 1; j <= 9; j++){
                for(int k = 1; k <= j; k++){
                    increase[i][j] += increase[i-1][k];
                }
            }
        }

        for (int i = 9; i >= 1; i--){
            decrease[1][i] = 1;
        }

        for(int i = 2; i < decrease.length; i++){
            for(int j = 9; j >= 0; j--){
                for(int k = 9; k >= j; k--){
                    decrease[i][j] += decrease[i-1][k];
                }
            }
        }

        long sum = 0;
        for(int i = 1; i < 101; i++) {
            for (int j = 1; j <= 9; j++) {
                sum += increase[i][j];
            }
            for (int j = 0; j <= 9; j++){
                sum += decrease[i][j];
            }
            sum -= 9;
        }
        System.out.println(sum);
        //System.out.println("inSum = " + inSum + " , deSum = " + deSum);
    }


    public long increaseNumbers(int length, int lastDig){

        if(length == 1){
            return 10 - lastDig;
        }

        long count = 0;
        for(int i = lastDig; i <= 9; i++){
            count += increaseNumbers(length - 1, i);
        }
        return count;
    }

    public long decreaseNumbers(int length, int lastDig){
        if (length == 1){
            return lastDig + 1;
        }
        long count = 0;
        for (int i = lastDig; i >= 0; i--) {
            count += decreaseNumbers(length - 1, i);
        }
        return count;
    }
}
