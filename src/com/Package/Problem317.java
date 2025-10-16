package com.Package;

public class Problem317 {

    public void run(){
        long t1 = System.currentTimeMillis();
        double g = 9.81D;
        double h0 = 100D;
        double v = 20D;

        System.out.println("the answer = " + projectile(g,h0,v));
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public double projectile(double g, double h0, double v){
        double a = (v*v)/(2.0*g) + h0;
        double f = -g/(2*v*v);
        return (Math.PI/f) * (-((a*a)/2.0));
    }
}
