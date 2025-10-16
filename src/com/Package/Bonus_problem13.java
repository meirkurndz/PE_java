package com.Package;

import java.math.BigDecimal;
import java.math.MathContext;

public class Bonus_problem13 {
    public void run(){
        int sum = 0;
        BigDecimal number = new BigDecimal("13");
        MathContext mc = new MathContext(1001);
        number = number.sqrt(mc);
        //System.out.println(number);
        String str = number.toString();
        //System.out.println(str.length());
        for (int i = 2; i < str.length(); i++){
            int dig = Integer.parseInt(String.valueOf(str.charAt(i)));
            //System.out.println("dig = " + dig);
            sum += dig;
        }
        System.out.println("the answer = " + sum);
    }
}
