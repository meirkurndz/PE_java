package com.Package;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem739 {

    long[] sum = new long[100000001];
    int mod = 1000000007;
    double FI = 1.6180339887498948482;

    public void run(){


        int lengh = 8;

        sum[1] = 1;
        sum[2] = 3;
        for(int i = 3; i < lengh+1; i++){
            sum[i] = sum[i-1] + sum[i-2];
        }

        for(int i = 1; i < lengh + 1;i+=1){
            for(int k = i; k < lengh + 1 ;k++){
                System.out.print(sum[k] + ", ");
            }
            System.out.println();

            for(int j = i+2; j < lengh + 1;j++){
                sum[j] += sum[j-1];
                sum[j] = sum[j] % mod;
            }

        }

        System.out.println(sum[lengh] % mod);
    }

}
