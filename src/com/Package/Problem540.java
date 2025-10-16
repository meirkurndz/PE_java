package com.Package;

public class Problem540 {

    static final long LIMIT = 3_141_592_653_589_793L;
    public void run(){
        long t1 = System.currentTimeMillis();
        long count = 0;

        for(long n = 1; n * n <= LIMIT; n += 1){
            System.out.println(n);
            for(long m = n+1; n*n + m*m <= LIMIT; m += 2){
                if (gcd(n,m) == 1) {
                    count++;
                }
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("P_540 = " + count);
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

    static long stainGCD(long a, long b)
    {
        // GCD(0, b) == b; GCD(a, 0) == a,
        // GCD(0, 0) == 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Finding K, where K is the greatest
        // power of 2 that divides both a and b
        int k;
        for (k = 0; ((a | b) & 1) == 0; ++k)
        {
            a >>= 1;
            b >>= 1;
        }

        // Dividing a by 2 until a becomes odd
        while ((a & 1) == 0)
            a >>= 1;

        // From here on, 'a' is always odd.
        do
        {
            // If b is even, remove
            // all factor of 2 in b
            while ((b & 1) == 0)
                b >>= 1;

            // Now a and b are both odd. Swap
            // if necessary so a <= b, then set
            // b = b - a (which is even)
            if (a > b)
            {
                // Swap u and v.
                long temp = a;
                a = b;
                b = temp;
            }

            b = (b - a);
        } while (b != 0);

        // restore common factors of 2
        return a << k;
    }
}
