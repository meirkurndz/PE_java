package com.Package;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem329 {

    String theString = "PPPPNNPPPNPPNPN";
    boolean[] isPrime = new boolean[501];

    public void run(){
        primeGenerator();
        long prob = 0;
        long deno = ((long)Math.pow(2,14)) * ((long)Math.pow(3,15)) * 500;

        for (int i = 1; i < isPrime.length; i++){
            long temp = check(i,0);
            prob += temp;
            //System.out.println( i + " , " + (temp));
        }
        System.out.println((prob/4) +"/"+(deno/4));
    }

    public long check(int number, int index){

        char pos = theString.charAt(index);

        if (index == 14){
            return (isPrime[number]) ? 1 : 2;
        }

        long probability;
        if(pos == 'N'){
            if (isPrime[number]){
                probability = 1;
            }else {
                probability = 2;
            }
        }else{
            if (isPrime[number]){
                probability = 2;
            }else{
                probability = 1;
            }
        }
        if(number != 500 && number != 1) {
            probability *= check(number-1,index+1) + check(number+1,index+1);
        }else if(number == 1){
            probability *= 2*check(number+1,index+1);
        }else{
            probability *= 2*check(number-1,index+1);
        }
        return probability;
    }

    public void primeGenerator() {

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
