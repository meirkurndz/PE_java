package com.Package;

public class Problem872 {
    long[] powers = new long[100];
    public void run(){
        long t1 = System.currentTimeMillis();
        setPowers();
        long[] params = setParams();
        long sum = f(params[0],params[1]);
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + sum);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long f(long seed, long node){
        long sum = node;
        //System.out.println(node);
        while (node<seed){
            int next_p = 0;
            while (node + powers[next_p] <= seed)next_p++;
            next_p--;
            node += powers[next_p];
            sum+=node;
            //System.out.println(node);
        }
        return sum;
    }

    public long[] setParams(){
        long[] params = new long[2];
        params[0]=1;
        params[1]=1;
        for(int i = 0; i< 17; i++){
            params[0] *= 10L;
            params[1] *= 9L;
        }
        return params;
    }

    public void setPowers(){
        powers[0]=1;
        for(int i=1; i < powers.length; i++){
            powers[i] = powers[i-1]*2L;
        }
    }
}
