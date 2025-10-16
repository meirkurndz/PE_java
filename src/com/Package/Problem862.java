package com.Package;

public class Problem862 {
    long[] factorail = new long[13];
    public void run(){
        setFactorail();
        long sum = rec(0,0);
        System.out.println("the answer = " + sum);
    }

    public long rec(long number, int len){
        if(len == 12){
            //System.out.println(number);
            return sum_perm(number);
        }
        long sum = 0;
        int last = (int)(number%10);
        for(int i = last; i < 10; i++){
            long next = (number*10) + i;
            sum += rec(next,len+1);
        }
        return sum;
    }

    public long sum_perm(long number){
        if (number==0)return 0;
        long temp = number;
        int[] freq = new int[10];
        int len = len(number);
        freq[0] = 12-len;
        while (number != 0){
            int dig = (int)(number%10);
            freq[dig]++;
            number/=10;
        }

        long ret = (factorail[12-freq[0]]*(factorail[12-1]/(factorail[freq[0]]*factorail[12-1-freq[0]])));
        for(int i = 1; i < freq.length; i++){
            ret /= factorail[freq[i]];
        }
        //System.out.println(temp + " = " +ret+", "+freq[0]);
        return (ret*(ret-1))/2;
    }

    public void setFactorail(){
        factorail[0] = 1;
        for(int i = 1; i < factorail.length; i++){
            factorail[i] = factorail[i-1]*i;
            //System.out.println(factorail[i]);
        }
    }

    public int len(long num){
        int len = 0;
        while (num!=0){
            len++;
            num/=10;
        }
        return len;
    }
}
