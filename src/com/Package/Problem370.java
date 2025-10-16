package com.Package;

public class Problem370 {

    private static final long A_LIMIT = 8333330000000L;
    private static final long BIG = 100000000000000L;

    public void run(){
        long ans = 0;
        long t1 = System.currentTimeMillis();

        for(long a = 1; a < A_LIMIT; a++){
            long temp = (long)(0.5D * (Math.sqrt((BIG-3L*a)/(double)a)-1));
            System.out.println("a = " + a + " , " + 1 + " <= d <= " + temp);
        }

        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1) + "ms");
    }

}
