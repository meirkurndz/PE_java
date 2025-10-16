package com.Package;

public class Problem117 {

    public long[] numOfWays = new long[51];

    public void run(){

        int i = 50;
        System.out.println(blockCombinations(i));
    }

    public long blockCombinations(int units){

        if (units < 0) return 0;
        if (units <=1 ){
            return 1;
        }

        if(numOfWays[units] != 0){
            return numOfWays[units];
        }

        long sum = 0;

        sum += blockCombinations(units - 1);

        for(int i = 2; i <= 4; i++){
            sum += blockCombinations(units - i);
        }
        numOfWays[units] = sum;
        return sum;
    }

}
