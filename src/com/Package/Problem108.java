package com.Package;

import java.util.Arrays;

public class Problem108 {

    public void run(){

        for(int i = 1; ;i++){
            int temp = numOfDivisors(i);
            //System.out.println(i + " , " + temp);
            if (temp > 1000){
                System.out.println("the answer = " + i);
                break;
            }
        }
    }

    public int numOfDivisors(int n) {
        int count = 1;
        for(int i = 2; i * i <= n; i++) {
            int exponent = 1;
            while(n % i == 0) {
                exponent += 2;
                n /= i;
            }
            count *= exponent;
        }
        // Account for remaining prime factor from above while loop
        if(n != 1) {
            count *= 3; // Additional solution added (2(1) + 1 = 3)
        }
        return (count + 1) / 2;
    }
}
