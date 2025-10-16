package com.Package;

import java.math.BigInteger;
import java.util.Hashtable;

public class Problem539 {

    static final BigInteger MOD = new BigInteger("987654321");

    public void run(){
        long t1= System.currentTimeMillis();
        BigInteger temp = new BigInteger("1000000000000000000");
        BigInteger ans = S(temp);
        ans = ans.mod(MOD);
        long t2= System.currentTimeMillis();
        System.out.println("P(1) = " + P(BigInteger.ONE));
        System.out.println("P(9) = " + P(BigInteger.valueOf(9)));
        System.out.println("P(1000) = " + P(BigInteger.valueOf(1000)));
        System.out.println("S(1000) = " + S(BigInteger.valueOf(1000)));
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public BigInteger S(BigInteger n){

        if(n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ZERO;

        BigInteger s = BigInteger.ZERO;
        BigInteger m = n.subtract(BigInteger.ONE).divide(BigInteger.TWO);
        if(n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0){
            s = (S(n.subtract(BigInteger.ONE)).add(P(n).mod(MOD))).mod(MOD);
        }else{
            s = BigInteger.ONE;
            s = s.add(BigInteger.TWO.multiply(m).multiply(m.and(BigInteger.ONE))).mod(MOD);
            s = s.add(BigInteger.valueOf(4).multiply(m)).mod(MOD);
            s = s.subtract(BigInteger.valueOf(4).multiply(S(m).mod(MOD))).mod(MOD);
        }
        s = s.mod(MOD);
        return s;
    }

    public BigInteger P(BigInteger n){
        if(n.compareTo(BigInteger.ONE) == 0) return BigInteger.ONE ;
        BigInteger temp = n.divide(BigInteger.TWO);
        BigInteger p = temp.add(BigInteger.ONE);
        p = p.subtract(P(temp));
        p = p.multiply(BigInteger.TWO);
        p = p.mod(MOD);
        return p;
    }
}
