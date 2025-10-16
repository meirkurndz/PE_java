package com.Package;

import java.util.Arrays;

public class Problem926 {

    static final long NUMBER = 10_000_000L;
    int[] factors = new int[(int)NUMBER];
    boolean[] isPrime = new boolean[(int)NUMBER];
    boolean[] visited = new boolean[(int)NUMBER+1];
    public void run(){
        long t1 = System.currentTimeMillis();
        primeGenerator();
        setFactors();
        for(int i = 0; i < isPrime.length; i++){
            if (isPrime[i]){
                System.out.println(i + ", " + factors[i]);
            }
        }


        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }


    public void setFactors(){
        for(int i = 2; i <= NUMBER; i++){
            //System.out.println(i);
            if (!isPrime[i]) {
                long temp = i;
                for (int p = 2; p <= temp; p++){
                    while (temp % p == 0){
                        //System.out.print(p + ", ");
                        temp/=p;
                        factors[p]++;
                    }
                    if (temp==1)break;
                }
            }else{
                factors[i]++;
            }

        }
    }

    /*public void setFactors(long curr, int[] f, int last_p){
        for(int i = last_p; i < NUMBER; i++){
            if (isPrime[i]){
                long temp = curr * i;
                if (temp <= NUMBER){
                    factors[i]++;
                    visited[(int)temp] = true;
                    //System.out.println(temp);
                    setFactors(temp,f,i);
                }else{
                    break;
                }
            }
        }
    }*/

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
