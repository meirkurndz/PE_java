package com.Package;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem310 {
    static final int LIMIT = 100001;
    long[] freq = new long[LIMIT];
    int[] grundy = new int[LIMIT];
    public void run(){
        long t1 = System.currentTimeMillis();
        Arrays.fill(grundy, -1);
        grundy[0] = 0;
        setGrundy();

        long count = 0;
        for(int a = LIMIT-1; a >= 0;a--){
            int g_a = grundy[a];
            for(int c = a; c < LIMIT;c++){
                freq[g_a^grundy[c]]++;
            }
            count += freq[g_a];
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + count);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void setGrundy(){
        for(int i=1; i<grundy.length;i++){
            grundy[i] = find_grundy(i);
        }
    }

    public int find_grundy(int number){
        if (grundy[number] != -1) return grundy[number];

        boolean[] mex = new boolean[number];
        for(int i = 1; i*i <= number; i++){
            int temp = find_grundy(number-(i*i));
            mex[temp] = true;
        }
        for(int i = 0; i < mex.length; i++){
            if(!mex[i]){
                grundy[number] = i;
                return i;
            }
        }
        return number;
    }
}
