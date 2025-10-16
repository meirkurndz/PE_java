package com.Package;

import java.util.Arrays;

public class Problem518 {

    boolean[] isPrime = new boolean[100000001];

    public void run(){
        primeGenerator();
        long sum = 0;

        for (int x = 2 ; x * x < isPrime.length; x++){
            for (int k = 1 ; k*x*x < isPrime.length;k++){
                int temp1 = k*x*x - 1;
                if (isPrime[temp1]){
                    for (int y = 1; y < x; y++){
                        if ((x%2==0) && (y%2==0)){
                            y++;
                        }
                        int temp2 = k*x*y - 1;
                        int temp3 = k*y*y - 1;
                        if (isPrime[temp2] && isPrime[temp3]){
                            if (gcd(x,y) == 1){
                                sum += temp1 + temp2 + temp3;
         //                       System.out.println(temp1 + " , " + temp2 + " , " + temp3);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("the answer =  " + sum);
    }

    public long gcd(long a, long b)
    {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return  a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);

        return gcd(a, b-a);
    }

    public void primeGenerator() {
        //prime number generator
        Arrays.fill(isPrime, true);
        for (int p = 2; p * p <= isPrime.length - 1; p++) {
            if (isPrime[p]) {
                for (int i = p * 2; i <= isPrime.length - 1; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        isPrime[1] = false;
        isPrime[0] = false;
    }
}
