package com.Package;

public class Problem725 {

    public void run(){
        for(int i = 1; i < 10; i++){
            rec(i,i,1);
        }
    }

    public void rec(long number, int curr_sum, int len){
        if (len == 18 || curr_sum < 0) return;
        if (curr_sum == 0){
            System.out.println(number);
        }
        for(int dig = 1; dig < 10; dig++){
            long temp = number*10 + dig;
            rec(temp,curr_sum-dig,len+1);
        }
    }
}
