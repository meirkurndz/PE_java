package com.Package;

import javax.xml.stream.FactoryConfigurationError;

public class Problem628 {

    long[] FAC_MOD = new long[100000001];
    static final long MOD = 1_008_691_207L;

    public void run(){
        long t1 = System.currentTimeMillis();
        genFacMod();
        System.out.println("the answer = " + count(100000000));
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }


    public long count(long len){
        long count = FAC_MOD[(int)len] - 1;
        for(int i = 1; i < len; i++){
            //System.out.println(i);
            int temp = (int)len - i;
            count -= 2 * FAC_MOD[(int)len-i];
            count %= MOD;
        }

        int a = (int)len-1;
        for(int i = 0; i < (int)len-1; i++,a--){
            //System.out.println(i);
            count += FAC_MOD[i] * a;
            count %= MOD;
        }
        return count;
    }

    public void genFacMod(){
        FAC_MOD[0] = 1;
        FAC_MOD[1] = 1;

        for(int i = 2; i < FAC_MOD.length; i++){
            FAC_MOD[i] = (FAC_MOD[i-1] * (long) i) % MOD;
        }

    }

    public long factorial(long number){
        if (number <= 1) return 1;
        return number * factorial(number-1);
    }

    /**
     *    -          +          +          +          +          +
     * 1 0 0 0    1 0 0 0    1 0 0 0    1 0 0 0    1 0 0 0    1 0 0 0
     * 0 1 0 0    0 1 0 0    0 0 1 0    0 0 1 0    0 0 0 1    0 0 0 1
     * 0 0 1 0    0 0 0 1    0 1 0 0    0 0 0 1    0 1 0 0    0 0 1 0
     * 0 0 0 1    0 0 1 0    0 0 0 1    0 1 0 0    0 0 1 0    0 1 0 0
     *
     *    +          +          +          -          +          -
     * 0 1 0 0    0 1 0 0    0 1 0 0    0 1 0 0    0 1 0 0    0 1 0 0
     * 1 0 0 0    1 0 0 0    0 0 1 0    0 0 1 0    0 0 0 1    0 0 0 1
     * 0 0 1 0    0 0 0 1    1 0 0 0    0 0 0 1    1 0 0 0    0 0 1 0
     * 0 0 0 1    0 0 1 0    0 0 0 1    1 0 0 0    0 0 1 0    1 0 0 0
     *
     *    +          +          +          -          -          -
     * 0 0 1 0    0 0 1 0    0 0 1 0    0 0 1 0    0 0 1 0    0 0 1 0
     * 1 0 0 0    1 0 0 0    0 1 0 0    0 1 0 0    0 0 0 1    0 0 0 1
     * 0 1 0 0    0 0 0 1    1 0 0 0    0 0 0 1    1 0 0 0    0 1 0 0
     * 0 0 0 1    0 1 0 0    0 0 0 1    1 0 0 0    0 1 0 0    1 0 0 0
     *
     *    -         -          -          -          -          -
     * 0 0 0 1   0 0 0 1    0 0 0 1    0 0 0 1    0 0 0 1    0 0 0 1
     * 1 0 0 0   1 0 0 0    0 1 0 0    0 1 0 0    0 0 1 0    0 0 1 0
     * 0 1 0 0   0 0 1 0    1 0 0 0    0 0 1 0    1 0 0 0    0 1 0 0
     * 0 0 1 0   0 1 0 0    0 0 1 0    1 0 0 0    0 1 0 0    1 0 0 0
     */
}
