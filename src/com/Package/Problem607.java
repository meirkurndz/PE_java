package com.Package;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem607 {

    double[] teta = new double[7];
    double[] time = new double[7];
    double[] dis = new double[7];
    double[] y = new double[7];
    static final double OUT = (50.0/Math.sqrt(2)) - 25D;
    static final double IN = 10D;


    public void run(){
        long t1= System.currentTimeMillis();
        double TARGET = round(100.0/Math.sqrt(2),12);//70.71067811865474
        //ans = 13.1265108586

        double delY = 0;
        double toAdd = 0.01;
        double angle = (Math.PI / 4.0);
        double delTime = 0;
        boolean isUp = false;
        while (delY != TARGET){
            for (;angle < (Math.PI / 2.0); angle += toAdd) {
                delY = 0;
                setTeta(angle);
                setY();
                setDis();
                setTime();
                delTime = 0;
                for (int i = 0; i < y.length; i++) {
                    delY += y[i];
                    delTime += time[i];
                }
                if (!isUp && delY >= TARGET) {
                    isUp = true;
                    toAdd /= -10.0;
                    break;
                }
                if (isUp && delY <= TARGET) {
                    isUp = false;
                    toAdd*= (-1)/10.0;
                    break;
                }
            }
        }
        long t2= System.currentTimeMillis();
        System.out.println("the answer = " + round(delTime,10));
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setTeta(double t0){
        teta[0] = t0;
        teta[1] = Math.asin((9/10.0) * Math.sin(teta[0]));
        teta[2] = Math.asin((8/9.0) * Math.sin(teta[1]));
        teta[3] = Math.asin((7/8.0) * Math.sin(teta[2]));
        teta[4] = Math.asin((6/7.0) * Math.sin(teta[3]));
        teta[5] = Math.asin((5/6.0) * Math.sin(teta[4]));
        teta[6] = Math.asin((10/5.0) * Math.sin(teta[5]));
    }

    public void setY(){
        y[0] = OUT * Math.tan(teta[0]);
        y[6] = OUT * Math.tan(teta[6]);
        for(int i = 1; i< y.length-1; i++){
            y[i] = IN * Math.tan(teta[i]);
        }
    }

    public void setDis(){
        dis[0] = OUT/ Math.cos(teta[0]);
        dis[6] = OUT/Math.cos(teta[6]);
        for(int i = 1; i< dis.length-1; i++){
            dis[i] = IN/Math.cos(teta[i]);
        }
    }

    public void setTime(){
        time[0] = dis[0]/10.0;
        time[1] = dis[1]/9.0;
        time[2] = dis[2]/8.0;
        time[3] = dis[3]/7.0;
        time[4] = dis[4]/6.0;
        time[5] = dis[5]/5.0;
        time[6] = dis[6]/10.0;
    }
}
