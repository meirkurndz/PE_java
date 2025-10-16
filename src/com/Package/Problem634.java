package com.Package;

public class Problem634 {
    static final long NUMBER = 9000000000000000000L;
    public void run(){
        long count = 0;
        for(long i = 2; i <= 2080084; i++){
            long b3 = i*i*i;
            long lim = NUMBER/b3;
            lim = (long) Math.sqrt(lim);
            count += lim - 1;
            //System.out.println(i + ", " + lim);
        }

        for(long i = 2; i < 7000; i++){
            long temp = i*i*i*i*i;
            if(temp < NUMBER)
                count--;
            else
                break;
        }
        System.out.println("the answer = " + count);
    }
}
