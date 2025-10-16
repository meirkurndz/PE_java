package com.Package;

public class Problem363 {
    //0.0000372091
    static final double step = 5000000000D;
    static final double pai4 = 0.785398163397448309D;
    static final double pai2 = 1.570796326794896619D;
    static final double u = 0.551778477804467717845D;//1.14159265358979323D;//1.141593053579D;
    //double[][] points = new double[step][2];

    public void run(){
        long t1 = System.currentTimeMillis();
        //setPoints();
        //double area = area();
        double L = L();
        double precent = precent(L);
        //System.out.println("area = " + area);
        System.out.println("L = " + L);
        System.out.println("precent = " + precent);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public double precent(double L){
        return 100 * ((L-pai2)/pai2);
    }

    /*public double area(){
        double area = 0;
        for(int i = 1; i < points.length; i++){
            double midy = (points[i-1][1] + points[i][1])/2;
            double diffX = points[i-1][0] - points[i][0];
            double temp = midy*diffX;
            //System.out.println(temp);
            area += temp;
        }
        return area;
    }*/

    public double L(){
        double L = 0D;
        double t = 0;
        double prevX = 1;
        double prevY = 0;
        double currX = tx(t,u);
        double currY = ty(t,u);
        for(int i = 1; i < step; i++){
            double a1 = prevX - currX;
            double a2 = prevY - currY;
            double temp = Math.sqrt(a1*a1 + a2*a2);
            //System.out.println(temp);
            L += temp;
            prevX = currX;
            prevY = currY;
            t += 1/(double)step;
            currX = tx(t,u);
            currY = ty(t,u);
        }
        return L;
    }

    /*public void setPoints(){
        double add = (double) 1/step;
        double t = 0;
        for(int i = 0; i < points.length; i++){
            points[i][0] = tx(t,u);
            points[i][1] = ty(t,u);
            //System.out.println("t = " + t + " , (" + points[i][0] + "," + points[i][1] + ")");
            //System.out.println();
            t += add;
        }
    }*/

    public double tx(double t, double u){
        return (1-t)*(1-t)*(1-t)+3*(1-t)*(1-t)*t+3*(1-t)*t*t*u;
    }

    public double ty(double t, double u){
        return 3*(1-t)*(1-t)*t*u+3*(1-t)*t*t+t*t*t;
    }
}
