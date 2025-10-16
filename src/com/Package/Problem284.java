package com.Package;

public class Problem284 {



    public void run(){
        int[] num_1 = new int[10000];
        int[] num_2 = new int[10000];
        rec(num_1);
        rec(num_2);
    }

    public void rec(int[] num){
        for(int i = 1; i < num.length; i++){
            num[i] = find_next(num,i);

        }
    }

    public int find_next(int[] num, int index){
        for(int i = 0; i < 14; i++){
            int last = num[i];
        }
        return 0;
    }

}
