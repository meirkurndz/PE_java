package com.Package;

import java.math.BigInteger;

public class Problem303 {

    public void run() {


        BigInteger sum = new BigInteger("1111333355557778");
        for(int i = 1;i < 10001; i++){
            for(int j = 1; j < 30; j++) {
                if (i == 9999) continue;
                long temp = search(0, i, j);
                //System.out.println(i + " , " + j + " , " + temp);
                if (temp != 0 && temp != 1000000000000000000L) {
                    sum = sum.add(BigInteger.valueOf(temp / i));
                    //System.out.println(i + " , " + temp/i);
                    break;
                }
            }
        }
        System.out.println("the answer = " + sum);
    }


    public long search(long number,int div, int length){
        long answer = 1000000000000000000L;
        if (isOnly(div)) return div;
        if (length == 0){
            if (number % div == 0 && number != 0){
                //System.out.println(number  + " , " + number/div);
                return number;
            }
        }else {
            for (int i = 0; i < 3; i++) {
                long temp = 10 * number + i;
                long temp1 = search(temp,div, (length - 1));

                //System.out.println(div + " , " + temp1);
                if (temp1 < answer) answer = temp1;
            }
            //return answer;
        }
        return answer;
    }

    public boolean isOnly(long number){

        while (number != 0){
            long temp = number % 10;
            if (temp > 2) return false;
            number /= 10;
        }
        return true;
    }


    public BigInteger searchBig(BigInteger number, BigInteger div, int length){
        BigInteger answer = new BigInteger("1000000000000000000000");
        if (isOnlyBig(div)) return div;
        if (length == 0){
            if (number.mod(div).compareTo(BigInteger.ZERO) == 0 && number.compareTo(BigInteger.ZERO) != 0){
                //System.out.println(number  + " , " + number/div);
                return number;
            }
        }else {
            for (int i = 0; i < 3; i++) {
                BigInteger temp = number.multiply(BigInteger.TEN).add(BigInteger.valueOf(i));
                BigInteger temp1 = searchBig(temp,div, (length - 1));
                if (temp1.compareTo(answer) < 0) answer = temp1;
            }
            //return answer;
        }
        return answer;
    }

    public boolean isOnlyBig( BigInteger number){

        while (number.compareTo(BigInteger.ZERO) != 0){
            BigInteger temp = number.mod(BigInteger.TEN);
            if (temp.compareTo(BigInteger.TWO) > 0) return false;
            number = number.divide(BigInteger.TEN);
        }
        return true;
    }

}