package com.Package;

import java.math.BigInteger;

public class Problem377 {



    public void run(){

        BigInteger answer = BigInteger.valueOf(0);
        BigInteger n1 = new BigInteger("12");
        BigInteger n2 = new BigInteger("168");
        BigInteger n3 = new BigInteger("2196");
        BigInteger n4 = new BigInteger("28560");
        BigInteger n5 = new BigInteger("371292");
        BigInteger n6 = new BigInteger("4826808");
        BigInteger n7 = new BigInteger("62748516");
        BigInteger n8 = new BigInteger("815730720");
        BigInteger n9 = new BigInteger("10604499372");
        BigInteger n10 = new BigInteger("137858491848");
        BigInteger n11 = new BigInteger("1792160394036");
        BigInteger n12 = new BigInteger("23298085122480");
        BigInteger n13 = new BigInteger("302875106592252");
        BigInteger n14 = new BigInteger("3937376385699288");
        BigInteger n15 = new BigInteger("51185893014090759");
        BigInteger n16 = new BigInteger("665416609183179903");
        BigInteger n17 = new BigInteger("8650415919381338111");

        answer = answer.add(BigInteger.TWO.modPow(n1,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n2,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n3,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n4,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n5,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n6,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n7,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n8,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n9,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n10,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n11,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n12,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n13,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n14,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n15,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n16,BigInteger.valueOf(1000000000)));
        answer = answer.add(BigInteger.TWO.modPow(n17,BigInteger.valueOf(1000000000)));

        System.out.println(answer.mod(BigInteger.valueOf(1000000000)));
        /*BigInteger answer = new BigInteger("0");

        for(int i = 1; i <= 17 ;i++){
            BigInteger exp = BigInteger.valueOf((long) Math.pow(13,i)-1);
            BigInteger temp = (BigInteger.TWO).modPow(exp, BigInteger.valueOf(1000000000L));
            answer = answer.add(temp);
        }

        System.out.println(answer.mod(BigInteger.valueOf(1000000000L)));
*/
    }
}
