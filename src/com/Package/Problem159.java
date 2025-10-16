package com.Package;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem159 {

    int[] mdrs = new int[1000000];

    public void run(){

        for(int i = 0; i < mdrs.length; i++){
            mdrs[i] = drs(i);
        }

        for(int i = 2; i < mdrs.length; i++){
            for(int j = 2; j <= i && j * i < mdrs.length; j++){
                if (mdrs[i * j] < mdrs[i] + mdrs[j]){
                    mdrs[i * j] = mdrs[i] + mdrs[j];
                }
            }
        }

        long sum = 0;
        for(int i = 2; i < mdrs.length; i++){
            sum += mdrs[i];
            //System.out.println(i + " , " + mdrs[i]);
        }
        System.out.println("the answer = " + sum);
    }

    public int drs(int number){

        while (number >= 10){
            number = digitSum(number);
        }

        return number;
    }

    public int digitSum(int number){
        int sum = 0;
        while (number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
