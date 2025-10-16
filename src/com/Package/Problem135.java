package com.Package;

public class Problem135 {

    static final long LIMIT = 1000000;
    int[] solutions = new int[(int)LIMIT];
    public void run(){
        long time1 = System.currentTimeMillis();
        int ans = 0;

        for(long a = 1; a < LIMIT; a++){
            long temp = (int)Math.ceil(a/4.0);
            for(long b = temp; b < a; b++){
                long curr = a * ((4*b) - a);
                if(curr >= LIMIT)
                    break;
                solutions[(int)curr]++;
            }
        }

        for(int i = 0; i < solutions.length; i++){
            if (solutions[i] == 10)
                ans++;
        }
        System.out.println("the answer = " + ans);
        long time2 = System.currentTimeMillis();
        System.out.println("found in " + (time2 - time1) + "ms");
    }


}
