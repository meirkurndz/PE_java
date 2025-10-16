package com.Package;

public class Problem86 {

    public void run(){

        long sum = 0;
        int a = 0;
        while (sum < 1000000){
            sum += count(++a);
        }
        System.out.println("the ansewr = " + a);

    }

    public int combinations(int a, int b_c){

        if (2 * a < b_c)
            return 0;

        if (a >= b_c)
            return b_c/2;

        return a - (b_c - 1) / 2;
    }

    public long count(int a){

        long sum = 0;

        for(int b_c = 1; b_c <= 2*a; b_c++){
            int diagonal = a * a + b_c * b_c;
            int sqrt = (int)Math.sqrt(diagonal);

            if (sqrt * sqrt == diagonal)
                sum += combinations(a, b_c);
        }

        return sum;
    }

}
