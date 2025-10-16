package com.Package;

import java.util.Arrays;

public class Problem549 {

    boolean[] isPrime = new boolean[100000001];
    long[] kempners = new long[100000001];

    public void run(){
        primeGenerator();
        long sum = 0;

        for(int i = 2; i < 100000001; i++){
            long temp = kempner(i);
            System.out.println(i + " , " + temp);
            sum += temp;
        }
        System.out.println(sum);
    }

    public long kempner(int number){

        //if (kempners[number] != 0) return kempners[number];
        if (isPrime[number]) {
            kempners[number] = number;
            return number;
        }
        long max = 0;
        int limit = (number/2) + 1;
        for(int i = 2 ; i < limit; i++){
            if (number % i == 0) {
                int pow = 0;
                while (number % i == 0) {
                    pow++;
                    number /= i;
                }
                long temp = kempnerPrimePower(i,pow);
                //System.out.println(i + " , " + pow + " , " + temp);
                if (max < temp) max = temp;
            }
            //if (number == 1)break;
        }
        //kempners[number] = max;
        return max;
    }

    public long kempnerPrimePower(int prime, int pow) {

        int power = (int)Math.pow(prime,pow);
        if (kempners[power] != 0) return power;

        for(int i = 1; i < power; i++){
            long temp1 = i*prime;
            long temp = modFactorial(temp1, power);
            //System.out.println(i + " , " + prime + " , " + temp);
            if (temp == 0){
                kempners[power] = temp1;
                return kempners[power];
            }
        }
        return 0;
    }

    public long legendre(long factor, long num)
    {
        long count = 0, fac2 = factor;
        while (num >= factor)
        {
            count += num / factor;
            factor *= fac2;
        }
        return count;
    }

    public long modFactorial(long number, long mod){
        long result = 1;
        for(int i = 2; i < number; i++){
            result *= i;
            result %= mod;
            if (result == 0) break;
        }
        return result;
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
