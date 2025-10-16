package com.Package;

public class Problem898 {

    public void run(){
        System.out.println(rec(0.2,1));
    }

    public int rec(double chance, int len){
        //System.out.println("c = " + chance);
        if (len == 4){
            System.out.println("c = "+chance);
            if (chance > 0.5) return 1;
            else return 0;
        }
        double p = 0.20 + (len * 0.20);
        System.out.println("p = " + p);
        double next_c_1 = (chance * p) / 0.5;
        double next_c_2 = (chance * (1-p)) / 0.5;

        int win_1 = rec(next_c_1,len+1);
        int win_2 = rec(next_c_2,len+1);
        return win_1+win_2;
    }
}
