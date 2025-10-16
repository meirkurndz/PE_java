package com.Package;

import java.math.BigInteger;

public class Problem622 {

    long[] divisors =  new long[4608];
    int[] primeFactors = {7,11,13,31,41,61,151,331,1321};
    int[] scale = {1,3,9,5,25,15,45,225,75};
    public void run(){

    long number = (long)(Math.pow(2,60))-1;

        genDiv();
        long sum = 0;
        for(int i = 0; i < divisors.length;i++){
            for(int j = 1; j < 60; j++){
                long temp = (long)(Math.pow(2,j))-1;
                if(temp % divisors[i] == 0){
                    divisors[i] = 0;
                    break;
                }
            }
            if (divisors[i] != 0) {
                sum += divisors[i] + 1;
            }
        }
        System.out.println("the answer = " + sum);

    }

    public void genDiv(){
        int index = 0;
        for(int i = 0; i < 512; i++){
            String str = Integer.toBinaryString(i);
            int temp1 = str.length();
            for(int k = 0; k < (9 - temp1); k++){
                str = "0" + str;
            }
            //System.out.println(str);
            long temp = genNumber(str);
            //System.out.println("temp = "+ temp);
            for(int j = 0; j < scale.length;j++){
                divisors[index + j] = temp * scale[j];
            }
            index += 9;
        }
    }

    public long genNumber(String binom){

        long number = 1;
        for(int i = 0; i < binom.length() ; i++){
            if (binom.charAt(i) == '1'){
                number *= (primeFactors[i]);
            }
        }
        return number;
    }
}
