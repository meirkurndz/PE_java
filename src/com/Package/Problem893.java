package com.Package;

public class Problem893 {

    long min_rep[] = new long[1000001];
    long min_rep_multi[] = new long[1000001];
    public void run(){
        long t1 = System.currentTimeMillis();
        long ans = 0;
        set_min_rep();
        for(int i = 1; i < 1000001; i++){
            min_rep[i] = gen_min_rep(i);
            ans += min_rep[i];
            //System.out.println(i + " = " + min_rep[i]);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long gen_min_rep(long number){
        if(min_rep[(int) number] != 0){
            return min_rep[(int)number];
        }

        long temp = min_rep_mul(number);
        for(long i = 1; i <= (number+1)/2 ; i++){
            temp = Math.min(temp, gen_min_rep(i) + 2 + gen_min_rep(number-i));
        }
        min_rep[(int) number] = temp;
        return temp;
    }

    public void set_min_rep(){
        min_rep[0] = 6;
        min_rep[1] = 2;
        min_rep[2] = 5;
        min_rep[3] = 5;
        min_rep[4] = 4;
        min_rep[5] = 5;
        min_rep[6] = 6;
        min_rep[7] = 3;
        min_rep[8] = 7;
        min_rep[9] = 6;

    }

    public long min_rep_mul(long number){
        if(min_rep_multi[(int)number] != 0){
            return min_rep_multi[(int)number];
        }
        long min = min_rep_dig(number);
        for(int i = 2; i * i <= number; i++){
            if(number % i == 0){
                long temp = 2 + min_rep_mul(i) + min_rep_mul(number/i);
                min = Math.min(min, temp);
            }
        }
        min_rep_multi[(int)number] = min;
        return min;
    }

    public long min_rep_dig(long number){
        long count = 0;
        while (number != 0){
            int dig = (int)(number % 10);
            number /=10;
            count += min_rep[dig];
        }
        return count;
    }
}
