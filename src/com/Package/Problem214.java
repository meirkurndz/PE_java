package com.Package;

import java.util.Arrays;

public class Problem214 {

    int[] euler = new int[40000000];
    int[] countArr = new int[40000000];
    public void run(){
        long sum = 0;
        eulerFunction();

        for(int i = 1; i < euler.length; i++){
            countArr[i] = 1 + countArr[euler[i]];
            if(countArr[i] == 25 && euler[i] == i-1){
                sum += i;
                //System.out.println(i + " , " + countArr[i]);
            }
        }
        System.out.println(sum);
    }

    public void eulerFunction(){

        for(int i = 0 ;i < euler.length; i++){
            euler[i] = i;
        }

        for (int i = 2; i < euler.length; i++){
            if (euler[i] == i){
                for(int j = i ; j < euler.length;j += i){
                    euler[j] = (int)(euler[j] * (1-(1/(double)i)));
                }
            }
        }
    }
}
