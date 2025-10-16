package com.Package;

public class Problem207 {

    long[] pow2min1 = new long[50];
    static final double LIMIT = (double) 1/12345;
    public void run(){
        long t1 = System.currentTimeMillis();
        setPow2min1();
        long perfect = 0;
        long notPerfect = 0;
        int curr = 1;

        for(long i = 1; curr < pow2min1.length; i++){
            long k = i*(i+1);
            if (k == pow2min1[curr]){
                perfect++;
                curr++;
            }else{
                notPerfect++;
            }
            double prop = (double)perfect/(perfect+notPerfect);
            if (prop < LIMIT) {
                System.out.println("the answer = " + k);
                break;
            }
            //System.out.println("m = " + k + " , per = " + perfect + " , not = " + notPerfect + " , prop = " + prop);
        }

        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void setPow2min1(){
        pow2min1[0] = 1;
        pow2min1[1] = 1;
        for(int i = 2; i < pow2min1.length;i++){
            pow2min1[i] = ((pow2min1[i-1]+1)*2)-1;
        }

        for(int i = 0; i < pow2min1.length; i++){
            pow2min1[i] = pow2min1[i]*(pow2min1[i]+1);
        }
    }


}
