package com.Package;

import org.w3c.dom.ls.LSOutput;

public class Problem227 {
    static final int players = 100;
    double[] dis = new double[(players/2)+1];

    public void run(){
        dis[dis.length-1] = 1.0;
        double answer = 0.0;
        long t1 = System.currentTimeMillis();
        for(int i = 1; i < 100000; i++){
            double temp = play();
            answer += ((double)i) * temp;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + answer);
        System.out.println("found in " + (t2-t1) + "ms");

    }

    public double play(){
        double[] next = new double[dis.length];
        for(int i = 1; i < dis.length; i++){
            double p2 = 1.0/36.0;
            double p1 = 8.0/36.0;
            double not = 18.0/36.0;
            double m1 = 8.0/36.0;
            double m2 = 1.0/36.0;

            if(i == 1){
                not += m2;
                m2 = 0;
            }
            else if(i == 49){
                not += p2;
                p2 = 0;
            }
            else if(i == 50){
                m1 += p1;
                m2 += p2;
                p1=0;
                p2=0;
            }

            if(i >= 2){
                next[i-2] += m2 * dis[i];
            }
            next[i-1] += m1 * dis[i];
            next[i] += not * dis[i];
            if(i+1 < next.length) {
                next[i+1] += p1 * dis[i];
            }
            if (i + 2 < next.length) {
                next[i+2] += p2 * dis[i];
            }
        }

        for(int j = 1; j < next.length; j++){
            dis[j] = next[j];
        }
        return next[0];
    }
}
