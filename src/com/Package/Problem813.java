package com.Package;

import java.math.BigInteger;

public class Problem813 {

    static final BigInteger MOD = new BigInteger("10000000007");
    static final BigInteger MOD_10 = new BigInteger("10000000000000");
    static final BigInteger AND = new BigInteger("34359738367");
    static final BigInteger LIMIT = new BigInteger("29548117155177824256");
    BigInteger[][] powers = new BigInteger[64][2];

    public void run(){

        long t1 = System.currentTimeMillis();
        gen();

        BigInteger currSize = powers[63][0];
        BigInteger currVal = powers[63][1];
        int index = 63;

        while (currSize.compareTo(LIMIT) < 0){
            if ((currSize.add(powers[index][0]).compareTo(LIMIT) > 0))
                index--;
            else {
                currSize = currSize.add(powers[index][0]);
                //currVal = xorMultiplyBigInt(currVal, powers[index][1]).mod(MOD);
                currVal = xorMultiplyBigInt(currVal, powers[index][1]).and(AND);
                System.out.println("index = " + index + " , currSize = " + currSize + " , currVal = " + currSize);
                index--;
            }
        }
        //BigInteger ans = currVal.mod(MOD);
        BigInteger ans = currVal.and(AND);
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1) + "ms");

    }

    public void gen(){
        BigInteger curr = BigInteger.valueOf(11);
        BigInteger size = BigInteger.ONE;
        powers[0][0] = BigInteger.ONE;
        powers[0][1] = BigInteger.valueOf(11);

        for(int i = 0; i < 64; i++){
            curr = xorMultiplyBigInt(curr,curr);
            //curr = curr.mod(MOD);
            curr = curr.and(AND);
            size = size.add(size);
            powers[i][0] = size;
            powers[i][1] = curr;
        }

        for(int i = 0; i < powers.length; i++){
            System.out.println(i + " , " + powers[i][0] + " , " + powers[i][1]);
        }

    }

    public long xorMultiply(long a, long b){

        long result = 0;
        while (b != 0){
            result ^= a * (b & 1);
            a <<= 1;
            b >>= 1;
        }
        return result;
    }

    public BigInteger xorMultiplyBigInt(BigInteger a, BigInteger b){

        BigInteger result = BigInteger.ZERO;
        while (b.compareTo(BigInteger.ZERO) != 0){
            result = result.xor(a.multiply(b.and(BigInteger.ONE)));
            a = a.shiftLeft(1);
            b = b.shiftRight(1);
        }
        return result;
    }
}
