package com.Package;

public class Problem223 {
    static final long LIMIT = 25000000L;
    long[] squares = new long[(int)(LIMIT/2) + 1];
    public void run(){
        long time1 = System.currentTimeMillis();
        long count = 0;
        genSquares();
        System.out.println("gen squares");

        for(int i = 1; i < squares.length; i++){
            long sum = squares[i] + 1;
            int hi = i;
            int lo = 1;
            while (hi >= lo){
                long temp = squares[hi] + squares[lo];
                if(temp > sum){
                    hi--;
                }else if(temp < sum){
                    lo++;
                }else{
                    if(i + hi + lo < LIMIT) {
                        System.out.println(i + ", " + hi + ", " + lo);
                        count++;
                    }
                    hi--;
                }
            }
        }

        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + count);
        System.out.println("found in: " + (time2-time1) + "ms");
    }

    public void genSquares(){
        for(long i = 0; i < squares.length; i++){
            squares[(int)i] = i*i;
        }

    }

}
