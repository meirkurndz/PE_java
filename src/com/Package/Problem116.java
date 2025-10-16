package com.Package;

public class Problem116 {

    public long[] numOfWaysAfterTile = new long[51];
    public long[] numOfWaysANoTile = new long[51];

    public void run(){

        long sum = 0;
        int length = 50;

        for(int tile = 2; tile < 5; tile++){
            sum += blockCombinations(length, tile, false);
            initArray();
        }
        System.out.println(sum);
    }

    public long blockCombinations(int units, int min, boolean isTile){

        if (isTile && numOfWaysAfterTile[units] != 0){
            return numOfWaysAfterTile[units];
        }
        if(!isTile && numOfWaysANoTile[units] != 0){
            return numOfWaysANoTile[units];
        }
        long sum = 0;
        if(!isTile) {

            if (units < min) return 0;
            if (units == min) return 1;
            sum += blockCombinations(units - 1, min, false);
            sum += blockCombinations(units - min, min, true);
            numOfWaysANoTile[units] = sum;
        }else{
            if (units < min) return 1;
            if (units == min) return 2;
            sum += blockCombinations(units - 1, min, true);
            sum += blockCombinations(units - min, min, true);
            numOfWaysAfterTile[units] = sum;
        }
        return sum;
    }

    public void initArray(){
        for(int i = 0; i < numOfWaysAfterTile.length;i++){
            numOfWaysAfterTile[i] = 0;
            numOfWaysANoTile[i] = 0;
        }
    }
}



