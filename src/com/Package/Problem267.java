package com.Package;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class Problem267 {

    static BigDecimal[][] ncr = new BigDecimal[1001][1001];
    static final int FLIPS = 1000;
    static final long BILLION = 1_000_000_000L;

    public void run(){
        int best_h = best_f();
        setNcr();
        BigDecimal answer = calc_prob(best_h);
        System.out.println("the answer = " + answer);
    }

    public BigDecimal calc_prob(int heads){
        BigDecimal sum = new BigDecimal("0");
        BigDecimal div = BigDecimal.valueOf(2).pow(1000);

        for(;heads <= 1000; heads++){
            BigDecimal temp = ncr(1000,heads);
            //System.out.println("(" + 1000 + "," + heads+") = " + temp);
            sum = sum.add(temp);
        }
        ;
        //System.out.println(sum);
        return sum.divide(div);
    }

    /*int foo(int n,int r)
    {
        if(n==r) return 1;
        if(r==1) return n;
        return foo(n-1,r) + foo(n-1,r-1);
    }*/

    public BigDecimal ncr(int n, int k){

        if(n==k) return BigDecimal.ONE;
        if(k==1) return BigDecimal.valueOf(n);
        if(ncr[n][k].compareTo(BigDecimal.ZERO) == 0){
            ncr[n][k] = ncr(n-1,k).add(ncr(n-1,k-1));
        }
        return ncr[n][k];
    }

    public int best_f(){
        double best_f = 1;
        int best_h = 1000;
        double f = 0.0;
        double inc = 0.01;
        while(f < 1){
            f += inc;
            int heads = 1000;
            while(winnings(heads,f) > BILLION){
                heads--;
            }
            if(heads+1<best_h){
                best_h = heads+1;
                best_f = f;
            }
        }
        //System.out.println("best f = " + best_f + ", best h = " + best_h);
        return best_h;
    }

    public double winnings(int h, double f){
        return Math.pow(1+2*f,h)*Math.pow(1-f,1000-h);
    }

    public void setNcr(){
        for(int i = 1; i < ncr.length; i++){
            for(int j = 1; j < ncr[i].length;j++){
                ncr[i][j] = new BigDecimal("0");
            }
        }
        for(int i = 1; i < ncr.length; i++){
            ncr[i][1] = BigDecimal.valueOf(i);
            ncr[i][i] = BigDecimal.ONE;

        }
    }
}
