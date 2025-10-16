package com.Package;

public class Problem625 {

    static final long MOD = 998244353L;
    static final long LIMIT = 100000000001L;
    public void run(){
        long sum = 0;

        for(long i = LIMIT;i > 0; i--){
            System.out.println(i);
            sum += sumOfGCDofPairs(i);
        }
        System.out.println("the answer = " + sum % MOD);
    }

    static long getCount(long d, long n)
    {
        long no = n / d;
        long result = no;

        // Consider all prime factors
        // of no. and subtract their
        // multiples from result
        for(long p = 2; p * p <= no; ++p)
        {

            // Check if p is a prime factor
            if (no % p == 0)
            {

                // If yes, then update no
                // and result
                while (no % p == 0)
                    no /= p;
                result -= result / p;
            }
        }

        // If no has a prime factor greater
        // than Math.sqrt(n) then at-most one such
        // prime factor exists
        if (no > 1)
            result -= result / no;

        // Return the result
        return result;
    }

    // Finding GCD of pairs
    static long sumOfGCDofPairs(long n)
    {
        long res = 0;

        for(long i = 1; i * i <= n; i++)
        {
            if (n % i == 0)
            {

                // Calculate the divisors
                long d1 = i;
                long d2 = n / i;

                // Return count of numbers
                // from 1 to N with GCD d with N
                res += d1 * getCount(d1, n);

                // Check if d1 and d2 are
                // equal then skip this
                if (d1 != d2)
                    res += d2 * getCount(d2, n);
            }
        }
        return res;
    }
}
