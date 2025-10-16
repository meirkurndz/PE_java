package com.Package;

public class Problem150 {

    static final long MOD = 1048576L;
    static final long SUB = MOD/2;

    long[][] triangle = new long[1000][];

    public void run(){
        long t1 = System.currentTimeMillis();
        setTriangle();
        long ans = search();
        System.out.println("the answer = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public long search(){
        long lowest = 0;

        for(int i = 0; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                //System.out.print("(" + i + "," + j + ") = ");
                long subTSum = 0;
                int start = j;
                int end = j;
                for(int row = i; row < triangle.length; row++){
                    for(int col = start; col <= end; col++){
                        subTSum += triangle[row][col];
                    }
                    if (subTSum < lowest){
                        lowest = subTSum;
                    }
                    end++;
                }
                //System.out.println(lowest);
            }
        }

        return lowest;
    }

    public void setTriangle(){
        for (int i = 0; i < triangle.length; i++){
            triangle[i] = new long[i+1];
        }
        //(615949*t + 797807) modulo 2^20
        // s_k := t−2^19
        long t = 0;
        for(int i = 0; i < triangle.length; i++){
            for (int j = 0; j < triangle[i].length; j++){
                t = (615949L*t + 797807L) % MOD;
                triangle[i][j] = t-SUB;
            }
        }
    }
}
