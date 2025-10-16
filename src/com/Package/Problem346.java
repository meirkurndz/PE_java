package com.Package;

import java.util.*;

public class Problem346 {

    static final long LIMIT = 1000000000000L;
    HashSet<Long> strongRepuint = new HashSet<>();

    public void run(){
        long t1 = System.currentTimeMillis();
        long ans = 1;
        for(long b = 2; b*b < LIMIT; b++){
            long toAdd = b*b;
            long curr = 1+b;
            while (curr + toAdd < LIMIT){
                curr += toAdd;
                if (!strongRepuint.contains(curr)) {
                    ans += curr;
                    //System.out.println(curr);
                    strongRepuint.add(curr);
                }
                toAdd *= b;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }
}
