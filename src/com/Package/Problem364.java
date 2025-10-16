package com.Package;

public class Problem364 {

    public void run(){
        long t1 = System.currentTimeMillis();
        long ans = rec(4,false,false);

        System.out.println("the answer = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long rec(int length, boolean isSeatL, boolean isSeatR){
        if (isSeatL)
            System.out.print("L ");
        System.out.print(length);
        if (isSeatR)
            System.out.print(" R");
        System.out.println();
        if (length == 0)
            return 0;
        if (length == 1)
            return 1;

        long count = 0;
        int start = 0;
        int end = length;
        if (isSeatL)
            start++;
        if (isSeatR)
            end--;

        for(;start <= end; start++){
            count += rec(start,isSeatL,true);
            count += rec(end-start-1,true,isSeatR);
        }
        return count;
    }
}
