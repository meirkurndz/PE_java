package com.Package;

public class Problem250 {

    static final long MOD = 10_000_000_000_000_000L;
    long[] numbers = new long[250251];
    long[] config = new long[251];
    long[] second = new long[251];

    public void run(){
        long t1 = System.currentTimeMillis();
        set();

        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < 250; j++){
                int index = (int)((numbers[i]+j) % 250);
                if(index < 0)index += 250;
                config[index] += second[j];
                config[index] %= MOD;
            }
            for(int j = 0; j < config.length; j++){
                second[j] = config[j];
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ((config[0]-1)%MOD));
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void set(){
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = powMod(i,i,250);
        }
        config[0] = 1;
        second[0] = 0;
    }

    public long powMod(long a, long exp, long p) {
        long res = 1;

        a = a % p;

        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * a) % p;

            exp = exp / 2;
            a = (a * a) % p;
        }
        return res;
    }
}
