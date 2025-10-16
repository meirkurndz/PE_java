package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem148 {


    public void run(){
        //2129970655314432
        long t1 = System.currentTimeMillis();
        long ans = 0;

        for(long i = 0; i < 1000000000L; i++){
            ans += countNonDiv(i);
            //System.out.println(i);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public long countNonDiv(long row){

        long result = 1;

        while (row > 0){
            long temp = (row % 7) + 1;
            result *= temp;
            row /= 7;
        }
        return result;
    }
}
