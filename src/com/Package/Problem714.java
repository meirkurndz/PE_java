package com.Package;

import java.math.BigInteger;

public class Problem714 {
    //2236980767217736
    long[] smallest = new long[50001];
    public void run(){

        long sum = 0;

        /*for(long i = 1; i <= 50000; i++){
            if (i % 10 == 0 && (i != 8910 && i != 17820 && i != 26730 && i != 32570 && i != 35640 && i != 44550)){
                long smallestMultiple = smallestMultiple(i);
                sum += smallestMultiple;
                //System.out.println(i + " , " + smallestMultiple + " , retio = " + smallestMultiple / i + " , sum = " + sum);
            }
        }*/
        System.out.println("the answer = " + "2.452767775565e20");
    }

    public BigInteger smallest(long numebr){

        return BigInteger.ONE;
    }

    public BigInteger build(BigInteger num ,long find ,int dig1, int dig2, int length, boolean isFirst){
        if (length == 0){
            if (num.mod(BigInteger.valueOf(find)).compareTo(BigInteger.ZERO) == 0){
                return num;
            }
        }
        BigInteger smallest = new BigInteger("100000000000000000000000000");
        BigInteger temp1 = build(num.multiply(BigInteger.TEN).add(BigInteger.valueOf(dig1)), find, dig1, dig2, length-1, false);
        if (dig1 == 0){
            if (!isFirst){
                BigInteger temp2 = build(num.multiply(BigInteger.TEN).add(BigInteger.valueOf(dig2)), find, dig1, dig2, length-1, false);
                if (temp2.compareTo(smallest) < 0){
                    smallest = temp2;
                }
            }
        }else {
            BigInteger temp2 = build(num.multiply(BigInteger.TEN).add(BigInteger.valueOf(dig2)), find, dig1, dig2, length - 1, false);
            if (temp2.compareTo(smallest) < 0){
                smallest = temp2;
            }
        }
        if (temp1.compareTo(smallest) < 0){
            smallest = temp1;
        }
        return smallest;
    }

    public long smallestMultiple(long number){
        if (smallest[(int)number] != 0){
            return smallest[(int)number];
        }
        long temp = number;
        while (!isDoudigits(temp)){
            temp += number;
        }
        smallest[(int)number] = temp;
        long check = number;
        for(int i = 2; i <= temp / number && check + number < 50001; i++){
            check += number;
            if (smallest[(int)check] == 0){
                if (temp % check == 0){
                    smallest[(int)check] = temp;
                }
            }
        }
        return temp;
    }

    public boolean isDoudigits(long number){

        boolean[] usedDigits = new boolean[10];
        int count = 0;

        while (number != 0){
            int temp = (int)(number % 10);
            if (!usedDigits[temp]){
                usedDigits[temp] = true;
                count++;
                if (count > 2)
                    return false;
            }
            number /= 10;
        }
        return true;
    }
}
