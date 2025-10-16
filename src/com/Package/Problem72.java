package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem72 {


    boolean prime[] = new boolean[1000001];

    public BigInteger count(){

        //prime number generator
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= prime.length-1; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= prime.length - 1; i += p) {
                    prime[i] = false;
                }
            }
        }

        BigInteger sum = new BigInteger("0");

        for(int i = 1; i <= 1000000 ; i++){
            int temp = Math.round(eulerFunction(i));
            sum  =  sum.add(BigInteger.valueOf(temp));
            //System.out.println(i + " , " + temp);
        }
        return sum;
    }

    public float eulerFunction(int num){

        if(prime[num]){
            return num - 1;
        }
        float result = num;

        for(int i = 2; i <= num; i++){
            if(num % i == 0) {
                result *= (1 - (1/(float)i));
                while (num % i == 0) {
                    num = num / i;
                }
                if (num == 1)return result;
            }
        }
        return result;
    }
}
