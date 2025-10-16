package com.Package;

public class Problem684 {

    static final long MOD = 1000000007;
    long[] fibonacci = new long[91];


    public void run(){
        long time1 = System.currentTimeMillis();
        genFibonacci();
        //System.out.println(S(20));
        long ans = 0;
        for(int i = 2; i < fibonacci.length; i++){
            long temp = S(fibonacci[i]);
            ans+=temp;
            ans%=MOD;
        }
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + ((time2-time1)/1000.0) + "s");
    }

    public long S(long K){
        // (((r-1)*r + 10) * 10^n - 2*(r + 9*n + 4))/2
        //n = floor(k/9)
        //r = 2+(k mod 9)

        long n = K/9;
        long r = 2 + (K % 9);

        long temp1 = ((((r-1)*r + 10)%MOD) * (powMod(10,n,MOD)));
        long temp2 = 2 * ((r + 9*(n%MOD) + 4)%MOD);
        long temp3 = (temp1 - temp2)/2;
        return temp3;
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

    public void genFibonacci(){
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int i = 2; i< fibonacci.length;i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
    }

}
