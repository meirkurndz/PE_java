package com.Package;

public class Problem62 {


    long[] cubedNumbers = new long[1000000];

    public void cubeTheNumbers(){
        for(int i = 0; i< cubedNumbers.length;i++){
            cubedNumbers[i] = (long) Math.pow(i,3);
        }
    }

    public long check5family(){

        cubeTheNumbers();
/*
        for(int i = 10; cubedNumbers[i] < 1000;i++){
            int count = 0;
            for (int j = i + 1 ;cubedNumbers[j] < 1000; j++){
                if(cubedNumbers[j] != 0 && isPermuite(cubedNumbers[i],cubedNumbers[j])){
                    count++;
                    cubedNumbers[j] = 0;
                }
            }
            if(count == 5){
                return cubedNumbers[i];
            }
        }

        for(int i = 31; cubedNumbers[i] < 10000;i++){
            int count = 0;
            for (int j = i + 1 ;cubedNumbers[j] < 10000; j++){
                if(cubedNumbers[j] != 0 && isPermuite(cubedNumbers[i],cubedNumbers[j])){
                    count++;
                    cubedNumbers[j] = 0;
                }
            }
            if(count == 5){
                return cubedNumbers[i];
            }
        }
*/
        int start = 4642;
        int limit = 10000;

        for(int i = start; i < limit ;i++){
            if (cubedNumbers[i] != 0) {
                int count = 1;
                //System.out.print(i + " , " + cubedNumbers[i]);
                for (int j = i + 1 ; j < limit; j++) {
                    //System.out.println("the number = " + cubedNumbers[j]);
                    if (cubedNumbers[j] != 0 && isPermuite(cubedNumbers[i], cubedNumbers[j])) {
                        //System.out.print(" , " + cubedNumbers[j]);
                        count++;
                        cubedNumbers[j] = 0;
                    }
                }

                if (count == 5) {
                    //System.out.println();
                    return cubedNumbers[i];
                }
            }
            //System.out.println();
        }

        return 0;
    }

    public boolean isPermuite(long num1, long num2){

        int[] numbersArray = new int[10];
        long temp1 = num1;
        long temp2 =  num2;

        while (temp1 != 0){

            numbersArray[(int) (temp1 % 10)]++;
            numbersArray[(int) (temp2 % 10)]--;

            temp1 /= 10;
            temp2 /= 10;
        }

        for(int i = 0; i< numbersArray.length; i++){
            if (numbersArray[i] != 0) return false;
        }

        return true;
    }


}
