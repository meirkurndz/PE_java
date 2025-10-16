package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem221 {

    //p (p+d) (p + (p^2 + 1)/d)

    BigInteger[] alexsandrian = new BigInteger[500000];
    public void run(){
        int count = 0;
        for(long i = 1; i < 1000000000; i++){
            long temp =  i * i + 1;
            for(long j = 1; j * j <= temp; j++){
                if (temp % j == 0){
                    BigInteger tempI = BigInteger.valueOf(i);
                    BigInteger tempIAddJ = BigInteger.valueOf(j + i);
                    BigInteger tempTEMP = BigInteger.valueOf(i + temp/j);
                    BigInteger toPrint = tempI.multiply(tempIAddJ).multiply(tempTEMP);
                    alexsandrian[count] = toPrint;
                    count++;
                }
                if (count == alexsandrian.length){
                    break;
                }
            }
            if (count == alexsandrian.length){
                break;
            }
        }
        Arrays.sort(alexsandrian);

        System.out.println("the answer = " + alexsandrian[149999]);
    }


}
