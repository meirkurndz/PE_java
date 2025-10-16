package com.Package;

public class Problem301 {

    public void run(){
        int count = 0;
        for(int i = 1; i <= 1073741824; i++){
            if (isWining(i, 2*i, 3*i) == 0) count++;
        }
        System.out.println(count);
    }

    public int isWining(int n1, int n2, int n3){
        return (n1^n2)^n3;
    }
}
