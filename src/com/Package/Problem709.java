package com.Package;

public class Problem709 {

    static final int LIMIT = 24681;
    static final int MOD = 1020202009;
    int[][] E = new int[LIMIT][];

    public void run(){
        long t1= System.currentTimeMillis();
        setMemo();
        long t2= System.currentTimeMillis();
        System.out.println("the answer = " + E[24680][24680]);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void setMemo(){
        for(int k = 0; k < E.length; k++){
            E[k] = new int[k+1];
        }

        E[0][0] = 1;
        for(int n = 1; n < E.length; n++){
            E[n][0] = 0;
        }

        for(int n = 0; n < E.length; n++){
            for(int k = 1; k < E[n].length; k++){
                E[n][k] = (E[n][k-1] + E[n-1][n-k]) % MOD;
            }
        }
    }
}
