package com.Package;

public class Problem290 {

    public void run(){
        int count = 0;
        for(long i = 0; i <= 1000000000000000000L ;i += 9){

            if (digitSum(i) == digitSum(i * 137)){
                System.out.println(i + " , " + i*137);
                count++;

            }
        }
        System.out.println(count);
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
