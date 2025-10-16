package com.Package;

import java.math.BigDecimal;

public class Problem770 {

    int size = 1000;
    BigDecimal[][] memo = new BigDecimal[size][size];
    public void run(){

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                memo[i][j] = new BigDecimal(0);
            }
        }
        for(int a = 0; a < size; a++){
            for(int b = 0; b < size; b++) {
                memo[a][b] = req(a,b);
            }
        }
        for(int i = 0; i < size; i++){
            System.out.println(i + " = " + memo[i][i]);
        }
        System.out.println(memo[size-1][size-1]);
    }


    public BigDecimal req(int a, int b){
        if(memo[a][b].compareTo(BigDecimal.valueOf(0)) != 0){ return memo[a][b];}
        if(a == 0){
            return BigDecimal.ONE;
        }
        else if(b == 0){
            return BigDecimal.valueOf(Math.pow(2,a));
        }
        memo[a][b] = (BigDecimal.valueOf(2).multiply(req(a-1,b)).multiply(req(a,b-1))).divide(
                (req(a,b-1).add(req(a-1,b))));
        return memo[a][b];
    }
}
