package com.Package;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem248 {

    boolean[] isPrime = new boolean[1000000000];
    ArrayList<Long> numbers = new ArrayList<>();

    public void run(){
        primeGenerator();
        System.out.println("gen primes");
        int[] products = new int[20];
        int[] bank = {2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,5,5,7,11,13};
        Arrays.fill(products,1);
        build(products,bank,0);
    }

    public void build(int[] products, int[] bank, int i){
        if(i == bank.length){
            //System.out.println("try");
            boolean is = true;
            long prod = 1;
            for(int k = 0; k < products.length; k++){
                if(products[k] >= isPrime.length)
                    return;
                if(products[k] != 1) {
                    //System.out.print((products[k] + 1) + ", ");
                    prod *= (products[k] + 1);
                }
                if(!isPrime[products[k] + 1])
                    is = false;
            }
            if(is){
                System.out.println("found " + prod);
                numbers.add(prod);
            }
        }else {
            for (int k = 0; k < products.length; k++) {
                int[] temp = products.clone();
                temp[k] *= bank[i];
                build(temp, bank, i + 1);
            }
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
