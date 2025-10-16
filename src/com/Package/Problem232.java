package com.Package;

public class Problem232 {

    double[][] prob = new double[101][101];

    public void run(){
        long t1 = System.currentTimeMillis();
        setProb();
        rec(0,0);
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + 0.5*(prob[0][0] + prob[1][0]));
        System.out.println("found in " +(t2-t1) + "ms");
    }

    public double rec(int p1,int p2){
        if(p2 >= 100){
            return 1;
        }
        if(prob[p1][p2] != -1){
            return prob[p1][p2];
        }
        double max = 0;
        double powOfHalf = 1;

        for(int points = 1; p2+points <= 10000; points*=2){
            powOfHalf *= 0.5;
            double next = 0.5 * powOfHalf * rec(p1+1,p2+points)
                            + 0.5 * powOfHalf * rec(p1,p2+points)
                            + 0.5 * (1-powOfHalf) * rec(p1+1,p2);
            next /= 1 - (1-powOfHalf)*0.5;
            max = Math.max(max,next);
        }
        prob[p1][p2] = max;
        return max;
    }

    public void setProb(){
        for(int i = 0; i < prob.length; i++){
            for(int j = 0; j < prob[0].length; j++){
                prob[i][j] = -1;
            }
        }
        for(int i = 0; i < prob.length-1;i++){
            prob[i][100] = 1;
            prob[100][i] = 0;
        }
        prob[100][100] = 1;
    }
}
