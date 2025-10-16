package com.Package;

public class Problem865 {
    static final long MOD = 998244353;
    long[] T = new long[10001];

    public void run(){
        long t1 = System.currentTimeMillis();
        long ans = 0;
        set_mod();

        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void set_mod(){
        T[3] = 9;
        for(int i = 6; i < T.length; i+=3){
            T[i] = (9*(i+1) + (i))*T[i-3];
        }

        for(int i = 0; i < T.length; i++){
            System.out.println(i + " = " + T[i]);
        }
    }

}
