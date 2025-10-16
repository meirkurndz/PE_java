package com.Package;

import java.math.BigInteger;

public class Problem239 {

    BigInteger[] B = new BigInteger[101];
    BigInteger[] F = new BigInteger[101];
    BigInteger ncr = BigInteger.valueOf(2300);

    public void run(){
        long time1 = System.currentTimeMillis();
        genF();
        BigInteger res = derangement(22,75);
        res = res.multiply(BigInteger.valueOf(2300));
        //System.out.println(res);
        long resl = Long.parseLong(res.toString().substring(0,11));
        long Fl = Long.parseLong(F[100].toString().substring(0,13));
        String ans = String.valueOf((double) resl/Fl).substring(0,14);
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public void genF(){

        F[0] = BigInteger.ONE;
        F[1] = BigInteger.ONE;

        for(int i = 2; i < F.length; i++){
            F[i] = F[i-1].multiply(BigInteger.valueOf(i));
        }
    }

    public BigInteger derangement(int move, int dontCare){
        if(move < 1){
            return F[dontCare];
        }
        move--;
        BigInteger res = BigInteger.valueOf(dontCare).multiply(derangement(move,dontCare));
        if(move > 0){
            res = res.add(BigInteger.valueOf(move).multiply(derangement(move-1,dontCare+1)));
        }
        return res;
    }

}
