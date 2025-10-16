package com.Package;

import java.math.BigInteger;

public class Problem162 {

    public void run(){

        BigInteger sum = new BigInteger("0");

        for(int i = 3; i <= 16; i++){
            sum = sum.add(numOfWords(i));
        }
        System.out.println(decToHex(sum));
    }

    public String decToHex(BigInteger number){
        BigInteger dec_num = number;
        int rem;
        String hexdec_num="";

        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(dec_num.compareTo(BigInteger.ZERO) > 0){

            rem = Integer.parseInt((dec_num.mod(BigInteger.valueOf(16))).toString());
            //System.out.println("rem  = " + rem);
            hexdec_num = hex[rem] + hexdec_num;
            dec_num =  dec_num.divide(BigInteger.valueOf(16));
        }
        return hexdec_num;
    }

    public BigInteger numOfWords(int length){

        BigInteger temp = BigInteger.valueOf(16).pow(length-1).multiply(BigInteger.valueOf(15));

        BigInteger A0 = BigInteger.valueOf(15).pow(length);
        BigInteger A1 = BigInteger.valueOf(15).pow(length-1).multiply(BigInteger.valueOf(14));
        BigInteger AA = BigInteger.valueOf(15).pow(length-1).multiply(BigInteger.valueOf(14));

        BigInteger A0A1 = BigInteger.valueOf(14).pow(length);
        BigInteger A0AA = BigInteger.valueOf(14).pow(length);
        BigInteger A1AA = BigInteger.valueOf(14).pow(length-1).multiply(BigInteger.valueOf(13));

        BigInteger A0A1AA = BigInteger.valueOf(13).pow(length);

        temp = temp.subtract(A0).subtract(A1).subtract(AA);
        temp = temp.add(A0A1).add(A0AA).add(A1AA);
        temp = temp.subtract(A0A1AA);

        return temp;
    }
}
