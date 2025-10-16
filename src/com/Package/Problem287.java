package com.Package;

public class Problem287 {

    static final long N = 24;
    static final long SIZE = (long) Math.pow(2,N);
    static final long SUB = (long) Math.pow(2,N-1);
    static final long com = (long) Math.pow(2,(2*N)-2);

    public void run(){

        long time1 = System.currentTimeMillis();
        long length = 1L + quadTree(0L,0L,SIZE/2L) + quadTree(0L,SIZE/2L,SIZE/2L) +
                          quadTree(SIZE/2L,0L,SIZE/2L) + quadTree(SIZE/2L,SIZE/2L,SIZE/2L);
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + length);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public boolean isBlack(long x, long y){
        if(Math.pow(x-SUB,2) + Math.pow(y-SUB,2) <= com){
            return true;
        }
        return false;
    }

    public long quadTree(long row, long col, long size){
        if(size == 1L){
            return 2L;
        }

        boolean tr = isBlack(row,col);
        boolean tl = isBlack(row,col+size-1L);
        boolean br = isBlack(row + size-1L,col);
        boolean bl = isBlack(row+size-1L,col+size-1L);

        if (tr == tl && tr == br && tr == bl)
            return 2L;

        long newSize = size/2L;
        long trr = row;
        long trc = col;
        long tlr = row;
        long tlc = col + newSize;
        long brr = row + newSize;
        long brc = col;
        long blr = row + newSize;
        long blc = col + newSize;

        long temp = 1L + quadTree(trr,trc,newSize) + quadTree(tlr,tlc,newSize) +
                   quadTree(brr,brc,newSize) + quadTree(blr,blc,newSize);
        //System.out.println(temp);
        return temp;
    }
}
