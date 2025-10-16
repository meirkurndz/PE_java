package com.Package;

import java.math.BigDecimal;
import java.math.MathContext;

public class Problem183 {
    public void run(){
        long sum = 0;
        for(long i = 5; i <= 10000; i++){
            long gcd = Math.round((double) i/Math.E);
            while (gcd % 2 == 0)
                gcd/=2;
            while (gcd % 5 == 0)
                gcd /= 5;
            if(i % gcd == 0)
                sum -= i;
            else
                sum += i;
        }
        System.out.println("the answer = " + sum);
    }
}
