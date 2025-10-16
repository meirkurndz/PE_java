package com.Package;

import java.math.BigInteger;

public class Problem788 {
    BigInteger[] FAC_MOD = new BigInteger[3000];
    static final BigInteger MOD = new BigInteger("1000000007");
    static final long Mod = 1000000007L;
    public void run(){

        genFacMod();
        BigInteger count = BigInteger.ZERO;
        long t1 = System.currentTimeMillis();
        for(int N = 1; N <= 2022; N++){
            int half = (N+2)/2;
            for(;half < N; half++){
                count = count.add(count(N,half));
                count = count.mod(MOD);
            }
            count = count.add(BigInteger.valueOf(9));
        }

        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + count.mod(MOD));
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public BigInteger count(int N, int k){
        BigInteger count = BigInteger.ZERO;

        BigInteger temp1 = (FAC_MOD[N-1].divide((FAC_MOD[k-1].multiply(FAC_MOD[N-k])).mod(MOD))).mod(MOD);
        BigInteger temp2 = BigInteger.valueOf(powMod(9,N-k+1,Mod)%Mod);
        count = count.add((temp1.multiply(temp2)).mod(MOD));
        //System.out.println("count = " + count);


        BigInteger temp3 = (FAC_MOD[N-1].divide((FAC_MOD[k].multiply(FAC_MOD[N-k-1])).mod(MOD))).mod(MOD);
        BigInteger temp4 = BigInteger.valueOf(powMod(9,N-k,Mod)%Mod);
        count = count.add((temp3.multiply(temp4).multiply(BigInteger.valueOf(8))).mod(MOD).add(temp3.multiply(temp4)).mod(MOD));
        //System.out.println("N = " + N + " , k = " + k);
        //System.out.println("temp1 = " + temp1);
        //System.out.println("temp2 = " + temp2);
        //System.out.println("temp3 = " + temp3);
        //System.out.println("temp4 = " + temp4);
        //System.out.println();
        return count.mod(MOD);
    }

    public long powMod(long a, long exp, long p) {
        long res = 1;

        a = a % p;

        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * a) % p;

            exp = exp / 2;
            a = (a * a) % p;
        }
        return res;
    }
    public void genFacMod(){
        FAC_MOD[0] = BigInteger.ONE;
        FAC_MOD[1] = BigInteger.ONE;

        for(long i = 2; i < FAC_MOD.length; i++){
            FAC_MOD[(int)i] = (FAC_MOD[(int)i-1].multiply(BigInteger.valueOf(i))).mod(MOD);
            FAC_MOD[(int)i].mod(MOD);
        }
    }

    public boolean isDom(int number){
        int[] dig = new int[10];
        int half = 0;

        while (number != 0){
            int temp = number%10;
            dig[temp]++;
            number /= 10;
            half++;
        }
        half /= 2;

        for(int i = 0; i < dig.length; i++){
            if (dig[i] > half)
                return true;
        }
        return false;
    }
}