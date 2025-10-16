package com.Package;

public class Problem191 {


    public void run(){
        System.out.println("the answer = " + prize(30,0,false,""));
    }

    public long prize(int days, int numOfA, boolean isLate, String str){
        if(days == 0){
            //System.out.println(str);
            return 1;
        }
        long sum = 0;
        if(numOfA < 2){
            sum += prize(days-1,numOfA+1, isLate, str + 'A');
        }
        if(!isLate){
            sum += prize(days-1,0, true, str + 'L');
        }
        sum +=  prize(days-1,0, isLate, str + 'O');
        return sum;
    }
}
