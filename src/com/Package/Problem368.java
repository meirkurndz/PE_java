package com.Package;

import java.math.BigDecimal;
import java.math.MathContext;

public class Problem368 {

    public void run(){
        BigDecimal sum = new BigDecimal("0");

        for(int i = 1; i < 2000000000; i++){
            if (!is3eqDigInARow(i)){
                BigDecimal temp = BigDecimal.valueOf(i);
                BigDecimal temp2 = BigDecimal.ONE.divide(temp, MathContext.DECIMAL32);
                sum = sum.add(temp2);
                System.out.println(sum);
            }
        }

    }


    public boolean is3eqDigInARow(int number){
        String str = Integer.toString(number);
        for(int i = 0; i < str.length() - 2; i++){
            if(str.charAt(i) == str.charAt(i+1) && str.charAt(i) == str.charAt(i+2)){
                return true;
            }
        }
        return false;
    }
}
