package com.Package;

public class Problem73 {

    public void run(){
        int sum = 0;
        for(int i = 5; i <= 12000; i++){
            int temp = count(i);
            sum += temp;
        }
        System.out.println("the answer = " + sum);
    }

    public int count(int number){

        int start = (int)Math.ceil((double) number/3);
        int end = (int)Math.ceil((double) number/2);
        int count = 0;

        for(int i = start; i < end; i++){
            if (gcd(i, number) == 1) count++;
        }
        return count;
    }

    public int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}
