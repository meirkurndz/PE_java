package com.Package;

public class Problem199 {

    static double AREA = 0;

    public void run(){

        AREA += 3*Math.PI;
        double C = 3 - 2*Math.sqrt(3);
        tot_area(1,1,C,1);
        tot_area(C,1,1,1);
        tot_area(1,C,1,1);
        tot_area(1,1,1,1);
        double tot = (1/C)*(1/C)*Math.PI;

        System.out.println("the answer = " + (tot-AREA)/tot);
    }

    public void tot_area(double k1, double k2, double k3, int level){
        if (level > 10){
            return;
        }
        double k4 = k1+k2+k3 + 2*Math.sqrt((k1*k2) + (k2*k3) + (k1*k3));
        double r = 1/k4;
        AREA += r*r*Math.PI;
        tot_area(k1,k2,k4,level+1);
        tot_area(k2,k3,k4,level+1);
        tot_area(k1,k3,k4,level+1);
    }
}
