package com.Package;

public class Problem733 {

    static final long MOD = 10000019;
    long[] a = new long[1000000];

    public void run(){
        setSeq();
        rec(4,-1,-1,0,"");
    }

    public long rec(int k, int lastIndex, long lastNum, long sum, String str){
        if (k == 0){
            System.out.println(str);
            return sum;
        }

        for(int i = lastIndex+1; i < a.length; i++){
            if (a[i] > lastNum){
                rec(k-1,i,a[i],sum+a[i],str + ", i="+i+"," + a[i]);
            }
        }
        return 0;
    }

    public void setSeq(){
        long current = 1;
        for(int i = 0; i < a.length; i++){
            current *= 153L;
            current %= MOD;
            a[i] = current;
        }
    }
}
