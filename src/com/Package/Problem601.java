package com.Package;

public class Problem601 {

    //P(a,b) = floor((b-2)/lcm(1,2,...,a)) - floor((b-2)/lcm(1,2,...,a,a+1))

    public void run(){
        long ans = 0;
        long pow4 = 4;
        long t1 = System.currentTimeMillis();

        for(int i = 1; i < 32; i++){
            ans += P(i,pow4);
            pow4 *= 4;
        }


        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1) + "ms");

    }

    public long P(long a,long b){
        long lcm1 = 1;
        long lcm2 = 1;
        for(int i = 2; i <= a; i++){
            lcm1 = lcm(lcm1,i);
        }
        lcm2 = lcm(lcm1,a+1);
        long f1 = (long) Math.floor(((double) b-2)/lcm1);
        long f2 = (long) Math.floor(((double) b-2)/lcm2);
        return f1-f2;
    }

    public long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}
