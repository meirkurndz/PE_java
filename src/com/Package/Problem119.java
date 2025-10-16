package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem119 {

    BigInteger[] numbers = new BigInteger[31];
    public void run(){
        Arrays.fill(numbers, BigInteger.ZERO);
        for(int j = 2; j <= 20; j++) {
            int limDigSum = 9 * j;
            BigInteger lim = (BigInteger.TEN).pow(j);
            for (int i = 2; i <= limDigSum; i++) {
                BigInteger toChack = BigInteger.valueOf(i);
                while (toChack.compareTo(lim) < 0) {
                    if (toChack.compareTo(BigInteger.TEN) >= 0) {
                        if (digitSum(toChack) == i) {
                            if (!isInList(toChack)){
                                putInList(toChack);
                                if (numbers[30].compareTo(BigInteger.ZERO) > 0) {
                                    break;
                                }
                            }
                        }
                    }
                    toChack = toChack.multiply(BigInteger.valueOf(i));
                }
            }
        }
        System.out.println("the answer = " + numbers[30]);
    }

    public void putInList(BigInteger number){
        for(int i = 1; i < numbers.length;i++){
            if (numbers[i].compareTo(BigInteger.ZERO) == 0){
                numbers[i] = number;
                break;
            }
        }
    }

    public boolean isInList(BigInteger number){
        for(int i = 1; i < numbers.length; i++){
            if (number.compareTo(numbers[i]) == 0) return true;
        }
        return false;
    }

    public int digitSum(BigInteger number){
        int sum = 0;
        while (number.compareTo(BigInteger.ZERO) > 0){
            sum += Integer.parseInt(number.mod(BigInteger.TEN).toString());
            number = number.divide(BigInteger.TEN);
        }
        return sum;
    }
}
