package com.Package;

public class Problem491 {
    long[] factorial = new long[11];
    public void run(){
        setFactorial();
        System.out.println("the answer = " + rec(0,10,0));
    }

    public long rec(long number,int last ,int len){
        if (last==-1) return 0;
        if (len == 10){
            if (check(number))
                return count(number);
            else
                return 0;
        }
        int next = last - 1;
        long temp1 = number * 10 + next;
        long temp2 = temp1 * 10 + next;
        long sum = 0;
        sum += rec(number,next,len);
        sum += rec(temp1,next,len+1);
        sum += rec(temp2,next,len+2);
        return sum;
    }

    public long count(long number){
        int[] odd_fraq = new int[10];
        int[] eve_fraq = new int[10];
        while (number != 0){
            odd_fraq[(int)(number%10)]++;
            number /= 10;
        }
        for(int i = 0; i < odd_fraq.length; i++){
            eve_fraq[i] = 2-odd_fraq[i];
        }
        long odd_perm = factorial[10-odd_fraq[0]]*factorial[9]/(factorial[odd_fraq[0]]*factorial[9-odd_fraq[0]]);
        long eve_perm = factorial[10]/factorial[eve_fraq[0]];
        for(int i = 1; i < 10; i++){
            odd_perm /= factorial[odd_fraq[i]];
            eve_perm /= factorial[eve_fraq[i]];
        }
        return odd_perm*eve_perm;
    }

    public boolean check(long number){
        int dig_sum = 0;
        while (number !=0){
            dig_sum += number%10;
            number/=10;
        }

        return ((2*dig_sum-90) % 11 == 0);
    }

    public void setFactorial(){
        factorial[0]=1;
        for(int i = 1; i < factorial.length; i++){
            factorial[i] = factorial[i-1]*i;
        }
    }

}
