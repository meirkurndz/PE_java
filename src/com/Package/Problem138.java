package com.Package;

public class Problem138 {

    public void run(){
        long[] seq = new long[13];
        seq[0] = 1;
        seq[1] = 17;
        long sum = 17;
        for(int i = 2; i < 13; i++){
            seq[i] = seq[i-1] * 18 - seq[i-2];
            sum += seq[i];
        }
        System.out.println("the answer = " + sum);
    }
}
