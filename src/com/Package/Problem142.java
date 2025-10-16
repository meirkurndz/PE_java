package com.Package;

public class Problem142 {

    long[] squares = new long[10000];

    public void run(){
        genSquares();
        long answers = 0;
        for(long a = 1; a < 10000; a++){
            for(long b = 1; b < a; b++){
                if ((a-b) % 2 == 0){
                    long x = (a*a + b*b)/2;
                    long y = a*a - x;
                    if (x > y){
                        for(long c = (long) Math.ceil(Math.sqrt(x)); c*c - x < y; c++){
                            long z = c*c - x;
                            if (isSquare(x-z, 1,squares.length-1) &&
                                isSquare(y+z, 1,squares.length-1) &&
                                isSquare(y-z, 1,squares.length-1) ){
                                answers++;
                                System.out.println("the answer = " + (x+y+z));
                                break;
                            }
                        }
                    }
                    if (answers == 1) break;
                }
            }
            if (answers == 1) break;
        }
    }

    public boolean isSquare(long number, int start, int end){

        int mid = (start+end)/2;
        if (squares[mid] == number || squares[end] == number) return true;
        if (mid == start) return false;
        if (squares[mid] > number){
            return isSquare(number, start, mid);
        }
        return isSquare(number, mid, end);
    }

    public void genSquares(){
        for(int i = 0; i < squares.length; i++){
            squares[i] = i*i;
        }
    }
}
