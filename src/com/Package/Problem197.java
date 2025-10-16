package com.Package;

public class Problem197 {

    double c = 30.403243784;

    public void run(){

        double currentVal = -1;
        double ans = 0;
        for(long i = 0; i < 520; i++){
            currentVal = nextValue(currentVal);
        }
        ans = currentVal + nextValue(currentVal);
        System.out.println("the answer = " + ans);
    }

    public double nextValue(double lastValue){
        return Math.floor(Math.pow(2, c-(lastValue*lastValue))) * 0.000000001;
    }
}
