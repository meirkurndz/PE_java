package com.Package;

public class Problem856 {
    static long NUMBER_OF_PAIRS = (13*4*3)/2;
    static final double d = 1/((double)52*51);
    double[] pair = new double[52];
    int[] cards = new int[13];
    public void run(){
        for(int i = 2; i < 53; i++){
            System.out.println(i + " = " + (pair_in(i)));
        }
    }

    public void rec(){
        double chance = 0.0;


    }

    public double pair_in(int num){
        return NUMBER_OF_PAIRS * 2 * (num-1) * d;
    }


}
