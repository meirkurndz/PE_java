package com.Package;

public class Problem463 {

    long[] seq = new long[1000000];
    public void run(){
        seq[1] = 1;
        seq[3] = 3;
        for(int i = 1; i < seq.length; i++){
            long temp = getSeq(i);
            System.out.println(i + " , " + temp);
        }
    }

    public long getSeq(int number){
        if (seq[number] != 0) return seq[number];

        if (number % 2 == 0)return getSeq(number/2);
        if (number % 4 == 1)return 2*getSeq(((number-1)/2)+1) - getSeq((number-1)/4);
        return 3*getSeq(((number-3)/2)+1) - 2*getSeq((number-3)/4);
    }
}
