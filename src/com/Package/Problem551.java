package com.Package;

public class Problem551 {

    public void run(){
        long lastVal = 1;
        for(long i = 1; i < 5000; i++){
            System.out.println(i + " , " + lastVal);
            lastVal += digitSum(lastVal);
        }
        System.out.println(lastVal);
    }

    public long digitSum(long number){
        long sum = 0;
        while (number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
