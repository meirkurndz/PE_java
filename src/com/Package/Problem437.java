package com.Package;

import java.util.Arrays;

public class Problem437 {

    boolean[] isPrime = new boolean[100000000];
    int[] minDiv = new int[100000000];
    public void run() {
        primeGenerator();
        genMinDiv();
        long sum = 5;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] && (i % 10 == 9 || i % 10 == 1)) {
                long test = ((1 + modSqrt(5, i) % i) * modInverseOf2(i)) % i;
                long test1 = ((1 - modSqrt(5, i) % i) * modInverseOf2(i)) % i;
                if (test1 < 0)
                    test1 = i + test1;
                if (isFibonacciPrimitiveRoot(i, test)) {
                    sum += i;
                    continue;
                }
                if (isFibonacciPrimitiveRoot(i, test1)) {
                    sum += i;
                }

            }
        }
        System.out.println("the answer = " + sum);
    }

    public void genMinDiv(){
        minDiv[1] = 1;
        for(int i = 2; i < minDiv.length; i++){
            if (isPrime[i]){
                for(int j = i; j < minDiv.length; j+=i){
                    if (minDiv[j] == 0)
                        minDiv[j] = i;
                }
            }
        }
    }

    public long legendreSymbol(long a, long p) {
        long ls = powMod(a, (p - 1) / 2, p);
        return ls == p - 1 ? -1 : ls;
    }

    static long modInverseOf2(long p){
        return (p+1)/2;
    }

    public boolean isFibonacciPrimitiveRoot(long p, long test) {
        // testing cycle:
        long tempMod = (test * test) % p;
        if (tempMod != test + 1) {
            return false;
        }

        long tempP = p - 1;
        int factor = minDiv[(int)tempP];

        while (factor > 1) {
            long temp = powMod(test, ((p - 1) / factor), p);
            if (temp == 1)
                return false;
            while (tempP % factor == 0)
                tempP /= factor;
            factor = minDiv[(int)tempP];
        }
        return true;
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

    public long modSqrt(long a, long p){

        if(legendreSymbol(a, p) !=1)
                return 0;
        else if (a == 0)
                return 0;
        else if(p == 2)
                return 0;
        else if(p % 4 == 3)
                return powMod(a, (p +1) /4,p);

        long s = p - 1;
        long e = 0;
        while( s %2==0) {
            s /= 2;
            e += 1;
        }

        long n = 2;
        while(legendreSymbol(n, p) != -1)
            n += 1;
        long x = powMod(a, (s +1) /2,p);
        long b = powMod(a, s, p);
        long g = powMod(n, s, p);
        long r = e;

        while (true) {
            long t = b;
            long m;
            for (m = 0; m < r; m++) {
                if (t == 1)
                    break;
                t = powMod(t, 2, p);
            }
            if (m == 0)
                return x;

            long gs = powMod(g, (long) Math.pow(2, (r - m - 1)), p);
            g = (gs * gs) % p;
            x = (x * gs) % p;
            b = (b * g) % p;
            r = m;
        }
    }
}
