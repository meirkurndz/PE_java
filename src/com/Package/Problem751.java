package com.Package;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Problem751 {

    long[] An = new long[300];
    BigDecimal[] Bn = new BigDecimal[500];


    public void run(){

        Bn[1] = new BigDecimal("2.223561019313554106173177");
        An[1] = Bn[1].intValue();
        for(int i = 2; i < 300; i++){
            BigDecimal temp = new BigDecimal(Bn[i-1].intValue());
            Bn[i] = temp.multiply((Bn[i-1].subtract(temp).add(BigDecimal.ONE)));
            An[i] = Bn[i].intValue();
        }
        System.out.print(An[1] + ".");

        for(int j = 2 ;j < 15; j++){
            System.out.print(An[j]);
        }

    }


}
