package com.Package;

public class Problem686 {

    public final double LOG2 = Math.log10(2);//0.301029995663981195213;

    public void run(){
        int count = 0;
        int exponent = 8;
        while (count < 678910){
            if(lead3dig(exponent) == 123){
                count++;
            }
            exponent++;
        }
        System.out.println(exponent-1);
    }

    public int lead3dig(long exp){
        return (int)Math.floor(Math.pow(10,exp * LOG2 - numOfDig2Pow(exp) + 3));
    }


    public long numOfDig2Pow(long exp){
        return (1 + (long)Math.floor(exp * LOG2));
    }
}
