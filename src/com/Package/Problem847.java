package com.Package;

public class Problem847 {

    public void run(){

        for(long i = 1; i < 10000; i++){
            System.out.println(i + " = " + H(i));
        }

    }

    public int rec(long number){

        if (number == 1)
            return 0;
        if (number == 2)
            return 1;
        if (number == 3)
            return 2;

        long next = (number+1)/2;
        return 1 + rec(next);
    }

    public long H(long LIMIT){
        long count = 0;
        System.out.println(LIMIT + ":");
        for(long i = 1; i <= LIMIT; i++){
            for(long j = 1; j <= LIMIT; j++){
                if (i+j > LIMIT)
                    continue;
                for (long k = 1; k <= LIMIT; k++){
                    if (i+j+k > LIMIT)
                        continue;
                    long temp = rec(Math.max(i,Math.max(j,k)));
                    count += temp;
                    System.out.println("(" + i + "," + j + "," + k + ") = " + temp);
                }
            }
        }
        return count;
    }
}
