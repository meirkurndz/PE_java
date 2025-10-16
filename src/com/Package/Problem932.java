package com.Package;

public class Problem932 {

    static final long LIMIT = 10000000000000000L;
    public void run(){
        System.out.println("the answer = " + sum());
    }

    public long sum(){
        long sum = 0;
        for(long b = 1; b < 100000000; b++){
            //System.out.println("b = " + b);
            int len = len(b);
            long delta = delta(b);
            if(delta >= 0){
                delta = (long) Math.sqrt(delta);
                long ten = (long) Math.pow(10,len);
                long a1 = (ten - (2*b) + delta)/2;
                long a2 = (ten - (2*b) - delta)/2;
                if(a1 > 0) {
                    long t1 = (ten * a1) + b;
                    if (t1 == (a1+b)*(a1+b) && t1 < LIMIT) {
                        //System.out.println(a1 + " " + b + " = " + t1);
                        sum += t1;
                    }
                }
                if(a2 > 0) {
                    long t2 = (ten * a2) + b;
                    if (t2 == (a2+b)*(a2+b) && t2 < LIMIT) {
                        //System.out.println(a2 + " " + b + " = " + t2);
                        sum += t2;
                    }
                }
            }
        }
        return sum;
    }

    public long delta(long b){
        int len = len(b);
        return 4*b*(1-(long)Math.pow(10,len)) + (long) Math.pow(10,2*len);
    }

    public int len(long number){
        int len = 0;
        while (number != 0){
            len++;
            number /= 10;
        }
        return len;
    }

}
