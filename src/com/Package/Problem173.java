package com.Package;

public class Problem173 {

    public void run(){
        int sum = 0;
        for(int i = 1; i < 1000001; i++){
            int temp = count(i);
            //System.out.println(i + " , " + temp);
            sum += temp;
        }
        System.out.println("the answer = " + sum);
    }

    public int count(int number){
        int count = 0;
        if (number % 4 == 0 && (number/4) - 1 > 0) {
            count++;
            number /= 4;
            int temp = number;
            for(int i = 2; i*i < temp + 1; i++){
                if (number % i == 0){
                    int temp1 = number/i;
                    if (i - (number/i) > 0){
                        count++;
                    }
                    if (temp1 - (number/temp1) > 0)count++;
                }
            }
            return count;
        }
        return 0;

    }
}
