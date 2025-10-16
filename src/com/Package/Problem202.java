package com.Package;

public class Problem202 {

    static final long COL_LIM = 6008819573L;
    public void run(){

        long time1 = System.currentTimeMillis();
        long count = 0;
        long temp = 12017639147L;
        long row = (temp + 3)/2;
        long offset = 3 - (row % 3);

        long col = offset;
        row -= offset;

        while (row > col){
            if (gcd(row,col) == 1) {
                //System.out.println(count + " , row = " + row + " , col = " + col);
                count++;
            }
            row-=3;
            col+=3;
        }

        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + (count*2));
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}
