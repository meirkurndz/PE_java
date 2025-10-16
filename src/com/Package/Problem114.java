package com.Package;

public class Problem114 {

    public long[] NUMBEROFWAYS = new long[51];

    public long run(){

        for(int i = 1; i < NUMBEROFWAYS.length; i++){
            blockCombinations(i);
        }

        return NUMBEROFWAYS[50];
    }

    public long blockCombinations(int units){
        if (NUMBEROFWAYS[units] != 0){
            return NUMBEROFWAYS[units];
        }
        switch (units){
            case 1:
            case 2:
                return 1;
            //case 3:
              //  return 2;
            case 0:
            case -1:
                return 1;
        }

        long sum = 1;
        sum += blockCombinations(units-1);

        for(int i = 3; i < units; i++){
            sum += blockCombinations(units - (i + 1));
        }

        return NUMBEROFWAYS[units] = sum;
    }
}
