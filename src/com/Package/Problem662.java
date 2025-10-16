package com.Package;

import java.sql.SQLOutput;

public class Problem662 {

    static final long MOD = 1000000007L;
    static final int W = 10001;
    static final int H = 10001;
    long [][] memo = new long[W][H];
    long[] fibonacci = {1, 2, 3, 5, 8, 13, 21, 34, 55,
            89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946};
    int[] moveX = new int[88];
    int[] moveY = new int[88];

    public void run(){
        long time1 = System.currentTimeMillis();
        setPosMoves();
        long ans = preCount();
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public long preCount(){
        memo[W-1][H-1] = 1;
        for(int k = H-1; k > 0 ;k--){
            //System.out.println("k = " + k);
            for(int i = W-1, j = k; i >= 0 && j < memo[i].length; i--, j++){
                //System.out.print("(" + i +"," + j +") = ");
                for(int m = 0; m < moveX.length; m++){
                    if (i + moveX[m] < W && j + moveY[m] < H)
                        memo[i][j] += (memo[i + moveX[m]][j + moveY[m]]) % MOD;
                }
                memo[i][j] %= MOD;
                //System.out.print(memo[i][j] + " ");
            }
            //System.out.println();
        }

        for(int k = H-1; k >= 0; k--) {
            //System.out.println("k = " + k);
            for (int i = 0, j = k; i < memo.length && j >= 0; i++, j--) {
                for (int m = 0; m < moveX.length; m++) {
                    if (i + moveX[m] < W && j + moveY[m] < H)
                        memo[i][j] += (memo[i + moveX[m]][j + moveY[m]]) % MOD;
                }
                memo[i][j] %= MOD;
            }
        }
        return memo[0][0] % MOD;
    }

    public void setPosMoves(){
        int count = 0;
        for(int i = 0; i < fibonacci.length; i++){
            //System.out.println("fib " + i + " = " + fibonacci[i] + ":");
            long temp = fibonacci[i] * fibonacci[i];
            for(int j = 0; j <= fibonacci[i]; j++){
                for(int k = j; k <= fibonacci[i]; k++){
                    if (j*j + k*k == temp && (j < H && k < H)){
                        moveX[count] = j;
                        moveY[count] = k;
                        count++;
                        moveX[count] = k;
                        moveY[count] = j;
                        count++;
                    }
                }
            }
        }
    }
}
