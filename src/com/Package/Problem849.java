package com.Package;

public class Problem849 {

    long[] arr = new long[100];

    static int count = 0;

    public void run(){
        arr[2] = 3;
        arr[7] = 32923;
        int[] res = {0,0};
        rec(res,2);

    }

    public void rec(int[] res, int left){
        if(left==0){
            count++;
            System.out.print(count + " = [");
            for(int i = 0; i < res.length-1; i++){
                System.out.print(res[i] + ",");
            }
            System.out.print(res[res.length-1]);
            System.out.println("]");
            return;
        }

        res[0] += 2;
        rec(res,left-1);
        res[0] -= 2;

        for(int i = 1; i < res.length; i++){
            if(res[i] + 2 < res[i-1]){
                res[i] += 2;
                rec(res,left-1);
                res[i] -= 2;
            }
        }

        res[0] += 1;
        res[1] += 1;
        rec(res,left-1);
        res[0] -= 1;
        res[1] -= 1;

        for(int i = 1; i < res.length-1; i++){
            if(res[i] + 1 < res[i-1]){
                res[i] += 1;
                res[i+1] += 1;
                rec(res,left-1);
                res[i] -= 1;
                res[i+1] -= 1;
            }
        }


    }
}
