package com.Package;

public class Problem160 {

    static final long MOD = 100000L;
    public void run(){
        long t1= System.currentTimeMillis();
        long ans = 1;

        long limit = 1_000_000_000_000L;
        while (limit % MOD == 0)
            limit /=5;
        //System.out.println(limit);
        for(long i = 1; i <= limit; i++){
            long temp = i;

            ans *= (temp);
            while (ans % 10 == 0)
                ans /= 10;
            ans %= 1000000000L;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("PE_160 = " + ans % MOD);
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
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
