package com.Package;

import java.util.Arrays;

public class Problem938 {
    double[][] memo = new double[12346][12346];
    public void run(){
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < memo.length;i++){
            memo[i][0] = 0.0;
            memo[0][i]= 1.0;
        }
        rec();
        System.out.println("the answer = " + memo[12345][12345]);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void rec(){

        for (int R = 1; R < memo.length; R++){
            for(int B = 1; B < memo[R].length; B++){
                int total = 2*R + B;
                double RR = ((double)(2*R)/total)*((double)((2*R)-1)/(total-1));
                double BB = ((double)B/total)*((double)(B-1)/(total-1));
                double RB = ((double)(2*R)/total)*(((double)(B))/(total-1)) +
                        (((double)B)/total)*(((double)(2*R))/(total-1));
                double temp1 = memo[R-1][B];
                double temp2 = memo[R][B-1];
                memo[R][B] = (RR*temp1+RB*temp2)/(1-BB);
            }
        }
    }
}
