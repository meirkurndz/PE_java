package com.Package;

import java.util.Arrays;

public class Problem249 {

    boolean[] is_prime = new boolean[1_550_000];
    static final long MOD = 10_000_000_000_000_000L;
    int[] primes = new int[669];
    long[] config = new long[1_550_000];
    static final long LIMIT = 18L;

    public void run(){
        long t1 = System.currentTimeMillis();
        set();
        config[0] = 1;
        for(int i = 0; i < primes.length; i++) {
            int p = primes[i];
            for(int j = config.length-p-1; j >=0;j--){
                config[j + p] += config[j];
                config[j + p] = config[j + p] % MOD;
            }
        }
        long sum = 0;
        for(int i = 0; i < config.length; i++){
            if (is_prime[i]){
                //System.out.println(i + ", " + config[i]);
                sum += config[i];
                sum = sum % MOD;
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + (sum%MOD));
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void set(){
        Arrays.fill(is_prime,true);
        is_prime[0] = false;
        is_prime[1] = false;
        int count = 0;
        for(int i = 2; i < is_prime.length; i++){
            if(is_prime[i]){
                for(int j = i*2; j < is_prime.length; j+=i){
                    is_prime[j] = false;
                }
            }
        }

        for(int i = 0; i < 5000; i++){
            if(is_prime[i])
                primes[count++] = i;
        }
    }
}
