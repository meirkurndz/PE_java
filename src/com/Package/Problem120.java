package com.Package;

public class Problem120 {

    public void run(){
        int sum = 0;
        for(int i = 3;i <= 1000;i++){
            sum += rMax(i);

        }

        System.out.println(sum);
    }

    public int rMax(int number){
        return 2*number*((number-1)/2);
    }
}
