package com.Package;

import java.math.BigInteger;

public class Problem168 {

    static final int MOD = 100000;

    public void run()
    {
        int sum = 0;
        for(int length = 2; length < 101; length++){
            for(int fd = 1; fd < 10; fd++){
                for(int mul = 1; mul < 10; mul++){
                    long temp = build(length,fd,mul);
                    sum += temp;
                    sum %= MOD;
                }
            }
        }
        System.out.println("the answer = " + sum);
    }

    public long build(int length, int firstDig, int mul){

        int carry = 0, current = firstDig;
        long num = 0;
        int mag = 1;

        for(int i = 0; i < length-1; i++){
            int temp = mul * current + carry;
            carry = temp/10;
            current = temp % 10;
            if(i == length-3 && current == 0)
                return 0;

            if(num < MOD){
                num += current * mag;
                mag *= 10;
            }
        }

        if(current == firstDig && carry == 0){
            long temp = ((num*10) + firstDig) % MOD;
            return temp;
        }
        return 0;
    }
}
