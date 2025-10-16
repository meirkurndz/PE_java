package com.Package;

import java.math.BigDecimal;

public class Problem341 {

    public void run(){
        long sum = 0;
        for(long i = 1; i < 1000; i++){
            long temp = golomb(i*i*i);
            System.out.println(i*i*i + " , " + temp);
            sum += temp;
        }
        System.out.println("the answer = " + sum);
    }

    public long golomb(long index){
        BigDecimal FI = new BigDecimal("1.6180339887498948482045868343656381177203091798057628621354486227");

        return 3;
    }
}
