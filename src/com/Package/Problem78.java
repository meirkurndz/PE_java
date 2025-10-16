package com.Package;

import java.math.BigInteger;

public class Problem78 {



    public int[] pre;

    public int run(){

        pre = new int[100000];
        for(int j = 1; j < pre.length;j++){
            pre[j] = partition(j);
            if(pre[j] == 0){
                return j;
            }
        }
        return 0;
    }
    public int partition(int number){


        switch (number){
            case 3:
                return 3;
            case 2:
                return 2;
            case 1:
            case 0:
                return 1;
        }
        if(number < 0){
            return 0;
        }

        if(pre[number] != 0){
            return pre[number];
        }

        int sum = 0;

        for (int k = 1; k <= number; k++){

            //System.out.println("k = " + k);
            int pantagonal1 = (3*k*k - k)/2; // k = 1
            if(pantagonal1 > number ){
                break;
            }
            BigInteger temp1 = BigInteger.valueOf(partition(number - pantagonal1)).multiply(BigInteger.valueOf((((int) Math.pow(-1,k-1)))));
            temp1 = temp1.mod(BigInteger.valueOf(1000000));
            //System.out.println("temp1 = " + temp1);
            sum += Integer.parseInt(temp1.toString());


        }

        for(int k = -1; k >= -number; k--){
            //System.out.println("k = " + k);
            int pantagonal2 = (3*k*k - k)/2; // k = -1

            if(pantagonal2 > number){
                break;
            }
            BigInteger temp2 = BigInteger.valueOf(partition(number - pantagonal2)).multiply(BigInteger.valueOf((((int) Math.pow(-1,k-1)))));
            temp2 = temp2.mod(BigInteger.valueOf(1000000));
            //System.out.println("temp1 = " + temp1);
            sum += Integer.parseInt(temp2.toString());
            ;
        }

        pre[number] = (sum % 1000000);
        return (sum % 1000000);

    }
}
