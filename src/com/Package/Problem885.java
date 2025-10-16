package com.Package;

public class Problem885 {
    static final long MOD = 1123455689L;
    long[] f = new long[19];

    public void run(){
        long t1 = System.currentTimeMillis();
        setF();
        System.out.println("the answer = " + sum("",0));
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long sum(String str, int last){
        if(str.length() == 18) {
            //System.out.println(str);
            return perm(str) % MOD;
        }
        long ans = 0;
        for(int i = last; i < 10; i++){
            String next = str + i;
            ans += sum(next,i) % MOD;
            ans %= MOD;
        }
        return ans % MOD;
    }

    public long perm(String number){
        int[] rep = new int[10];
        rep[0] = 18;
        long num = Long.parseLong(number);
        long temp = num;
        while (temp != 0){
            int dig = (int)(temp % 10);
            rep[dig]++;
            rep[0]--;
            temp /= 10;
        }
        long ret = ((num%MOD) * (count(rep)%MOD)) % MOD;
        return ret;
    }

    public long count(int[] rep){
        long count = f[18];
        for(int i = 0; i < rep.length; i++){
            count /= f[rep[i]];
        }
        return count;
    }

    public void setF(){
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < f.length; i++){
            f[i] = f[i-1]*i;
        }
    }
}
