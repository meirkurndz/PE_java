package com.Package;

public class Problem323 {

    public void run(){
        double E = 0;
        double half_pow = 1;

        for(int i = 1; i < 100; i++){
            E += i*(Math.pow(1-0.5*half_pow,32)-Math.pow(1-half_pow,32));
            half_pow *= 0.5;
        }
        System.out.println("the answer = " + E);
    }
}
