package com.Package;

import java.util.Arrays;

public class Problem95 {

    int[] sumOfDiv = new int[1000001];
    boolean[] used = new boolean[1000001];

    public void run(){

        genSumOfDiv();
        Arrays.fill(used,false);

        int longest = 0;
        int lowestElement = 0;

        for(int i = 2 ; i < sumOfDiv.length; i++){

            int temp = amicableChain(i);

            if (temp > longest){
                longest = temp;
                lowestElement = i;
            }
        }

        System.out.println(lowestElement + " , chain length = " + longest);
    }

    public int amicableChain(int number){

        if (used[number]){
            return 0;
        }

        int length = 0;
        int base = number;
        int current = number;

        while (sumOfDiv[number] != 1 &&
               sumOfDiv[number] <= 1000000 &&
               current != 1){

            length++;
            if (length > 100){
                return 0;
            }

            current = sumOfDiv[current];

            if(current == base){
                //System.out.println(base + " , chain length = " + length);
                markChain(base);
                return length;

            }else if(current >= 1000000){
                return 0;

            }else if(used[current]){
                return 0;
            }
        }
        return 0;
    }

    public void markChain(int number){
        int base = number;
        used[base] = true;
        int current = sumOfDiv[number];
        while (current != number){
            current = sumOfDiv[current];

            used[current] = true;
        }
    }

    public void genSumOfDiv(){
        for(int i = 1; i <= 500000;i++){
            for(int j = 2; j * i <= 1000000;j++){
                sumOfDiv[i*j] += i;
            }
        }
    }
}
