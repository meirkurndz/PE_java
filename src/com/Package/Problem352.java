package com.Package;

public class Problem352 {

    static final int SHEEPS = 25;
    double[][] best = new double[SHEEPS][3];

    public void run(){
        setBest();
        //System.out.println(rec(25));

    }

    public double rec(int sheeps){
        //System.out.println(sheeps);
        if (sheeps == 1)return 1.0;
        double min = sheeps;
        for(int i = 1; i < sheeps; i++){
            double free_1 = Math.pow(0.98,i);
            double free_2 = Math.pow(0.98,sheeps-i);

            double E = free_1+(1-free_1)*rec(i)+free_2+(1-free_2)*rec(sheeps-i);
            if (E < min){
                min = E;
            }
        }
        return min;
    }

    public void setBest(){
        best[1][0] = 1;
        best[1][1] = 0;
        best[1][2] = 0;
        for(int i = 2; i < best.length; i++){
            best[i][0] = i;
            best[i][1] = i-1;
            best[i][2] = i-1;

            double min_2 = i-1;

        }
    }
}
