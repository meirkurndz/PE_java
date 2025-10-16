package com.Package;

import java.util.Arrays;

public class Problem128 {

    boolean[] isPrime = new boolean[900000];
    long[] C = new long[70000];
    public void run(){
        long time1 = System.currentTimeMillis();
        primeGenerator();
        setCorners();
        int R = 2;
        int index = 2;
        long ans = 0;
        int cor2000 = 0;
        while (true){
            //check the corner:
            if(isPrime[(int)( (C[R+1] - 1) - C[R]) ] &&
               isPrime[(int)( (C[R+1] + 1) - C[R]) ] &&
               isPrime[(int)( (C[R+2] - 1) - C[R]) ]){
                index++;
            }
            if (index == 2000){
                ans = C[R];
                cor2000 = R;
                break;
            }
            //check the other:
            if(isPrime[(int) (C[R+1] - 1 - C[R]) ] &&
               isPrime[(int) (C[R+1] - 1 - C[R-1]) ] &&
               isPrime[(int) (C[R+2] - 2 - (C[R+1] - 1))]){
                index++;
            }
            if (index == 2000){
                ans = C[R];
                cor2000 = R;
                break;
            }
            R++;
        }
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans + ", in ring " + cor2000);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public void setCorners(){
        C[0] = 1;
        C[1] = 2;
        long toAdd = 6;
        for(int i = 2; i < C.length; i++){
            C[i] = C[i-1] + toAdd;
            toAdd += 6;
        }
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
