package com.Package;

import java.util.Arrays;

public class Problem808 {

    int limit = 50000000;
    boolean[] isPrime = new boolean[limit];
    //boolean[] isSquarePrime = new boolean[limit * limit];

    public void run(){
        long sum = 0;
        primeGenerator();
        for(long i = 0; i < isPrime.length; i++) {
            if (isPrime[(int)i] && !isPalindrom(i)) {
                long square = i * i;
                if (!isPalindrom(square)) {
                    long revers = reverse(square);
                    double temp = Math.sqrt(revers);
                    if (temp == (int) temp && isPrime[(int) temp]) {
                        //System.out.println(i + " , " + (int) temp);
                        sum += square;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public boolean isPalindrom(long num) {
        String s = Long.toString(num);
        String sr = new StringBuilder(s).reverse().toString();
        return s.equals(sr);
    }

    public long reverse(long n){

        long rev = 0; // reversed number
        long rem;   // remainder

        while(n>0){
            rem = n % 10;
            rev = (rev * 10) + rem;
            n = n / 10;
        }

        return rev;
    }

    public void primeSquareGenerator() {
        //prime number generator
        for(int i = 0; i < isPrime.length;i++){
            if (isPrime[i]){
      //          isSquarePrime[i*i] = true;
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
