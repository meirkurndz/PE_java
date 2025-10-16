package com.Package;

public class Problem178 {

    static long[][][] memo = new long[10][1024][41];
    static long hash[] = new long[1024*40*10];
    public void run(){
        //126461847755
        //1305304684600
        int mask = 0;
        long sum = 0;

        for(int target = 10; target < 41; target++){
            System.out.println("len = " + target);
            for(int last = 1; last < 4; last++){
                int next_mask = mask | (int)Math.pow(2,last);
                sum += 2*req(last,next_mask,target-1);
            }
            sum += req(9,(int)Math.pow(2,9),target-1);
        }
        System.out.println("the answer = " + sum);
    }

    public long req(int last, int mask, int len){
        int key = mask * 40 * 10 + (len-1) * 10 + last;
        if(hash[key] != 0){
            return hash[key];
        }
        /*if (memo[last][mask][len] != 0){
            return memo[last][mask][len];
        }*/
        if(len == 0){
            if(mask == 1023){
                return 1;
            }else{
                return 0;
            }
        }
        long sum = 0;
        if(last > 1){
            int next_mask = mask | (int)Math.pow(2,last-1);
            sum += req(last-1, next_mask,len-1);
        }
        if(last < 9){
            int next_mask = mask | (int)Math.pow(2,last+1);
            sum += req(last+1, next_mask,len-1);
        }
        hash[key] = sum;
        return hash[key];
        /*memo[last][mask][len] = sum;
        return memo[last][mask][len];*/
    }

}
