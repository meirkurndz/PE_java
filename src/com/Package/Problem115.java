package com.Package;

public class Problem115 {

    public long[] NUMBEROFWAYS = new long[100000000];

    public long run(){

        for(int i = 1; i < NUMBEROFWAYS.length; i++){
            blockCombinations(i,50);
            if(NUMBEROFWAYS[i] > 1000000){
                return i;
            }
        }

        return 0;
    }

    public long blockCombinations(int units, int min){

        if (NUMBEROFWAYS[units] != 0){
            return NUMBEROFWAYS[units];
        }
        if (units < min){
            return 1;
        }

        long sum = 1;
        sum += blockCombinations(units-1,min);

        for(int i = min; i < units; i++){
            sum += blockCombinations(units - (i + 1), min);
        }

        return NUMBEROFWAYS[units] = sum;
    }
}


