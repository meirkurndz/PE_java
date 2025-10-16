package com.Package;

import java.util.Arrays;

public class Problem243 {

    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
    int numerator = 15499;
    int denominator = 94744;

    public void run(){
        long number = 1;
        long pre = 0;
        for(int i = 0; i < primes.length; i++){
            number *= primes[i];
            long euler = (long) eulerFunction(number);
            double resiliance = ((double)euler)/(number-1);
            if (resiliance < ((double)numerator/denominator)){
                pre = number / primes[i];
                //System.out.println(pre);
                break;
            }
        }

        long euler = (long) eulerFunction(pre);
        double resiliance = (double)euler/(pre-1);
        long newNumber = pre;

        while (resiliance > ((double)numerator/denominator)){
            newNumber += pre;
            euler = (long)eulerFunction(newNumber);
            resiliance = (double)euler/(newNumber-1);
            if (resiliance < ((double)numerator/denominator))
                break;
        }
        System.out.println("the answer = " + newNumber);
    }

    public double eulerFunction(long num){

        float result = num;

        for(int i = 2; i <= 100; i++){
            if(num % i == 0) {
                result *= (1 - (1/(double)i));
                while (num % i == 0) {
                    num = num / i;
                }
                if (num == 1)return result;
            }
        }
        return result;
    }
}
