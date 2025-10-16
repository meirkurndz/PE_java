package com.Package;

public class Problem222 {
    public void run(){
        int[] order = {50,48,46,44,42,40,38,36,34,32,30,31,33,35,37,39,41,43,45,47,49};
        long time1 = System.currentTimeMillis();
        double ans = order[0] + order[20];
        for(int i = 0; i < order.length-1; i++){
            double temp = len(order[i], order[i+1]);
            ans += temp;
        }
        ans *= 1000;
        ans = Math.round(ans);
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + (int)ans);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public double len(int R1, int R2){
        double first = Math.pow(R1+R2,2);
        double second = Math.pow(100 - R1 - R2,2);
        return Math.sqrt(first - second);
    }
}
