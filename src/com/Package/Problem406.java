package com.Package;

public class Problem406 {

    public void run() {
        long t1 = System.currentTimeMillis();
        long ans = 0;
        long len = 500;
        double lowCost = Math.sqrt(2);
        double highCost = Math.sqrt(3);
        System.out.println(powMod(7,1000000000000L,1000000000000L));
        //System.out.println(rec(len,lowCost,highCost,(lowCost/(highCost+lowCost))));

        System.out.println("the answer = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public double rec(long len, double lowCo, double highCo, double q){
        if (len <= 1)
            return 0;
        if (len == 2)
            return Math.min(lowCo,highCo);
        int next = (int)Math.ceil((double)len * q);

        System.out.println("len = " + len + ", q = " + q + ", next = " + next);
        double max = Math.max(highCo + rec(next-1,lowCo,highCo,q), lowCo + rec(len - next,lowCo,highCo,q));
        //System.out.println("max = " + max);
        return max;
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
