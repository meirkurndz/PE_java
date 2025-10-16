package com.Package;

import java.util.HashMap;
import java.util.HashSet;

public class Problem165 {

    long[] t_n = new long[20000];
    boolean[][] points = new boolean[500][500];

    public void run(){
        set();
        System.out.println("count = " + count_intersections());

    }

    public long count_intersections(){
        long count = 0;
        //HashMap<Double,HashSet<Double>> points = new HashMap<>();

        for(int i = 0; i < t_n.length; i+=4){
            System.out.println("i = " + i);
            long x1 = t_n[i];
            long y1 = t_n[i+1];
            long x2 = t_n[i+2];
            long y2 = t_n[i+3];
            for(int j = i+4; j < t_n.length; j+=4){
                long x3 = t_n[j];
                long y3 = t_n[j+1];
                long x4 = t_n[j+2];
                long y4 = t_n[j+3];

                long p_x_d = ((x1-x2)*(y3-y4)) - ((y1-y2)*(x3-x4));
                long p_y_d = p_x_d;
                if(p_x_d == 0){continue;}

                long p_x_n = ((((x1*y2) - (y1*x2))*(x3-x4)) - ((x1-x2)*((x3*y4)-(y3*x4))));
                long p_y_n = ((((x1*y2) - (y1*x2))*(y3-y4)) - ((y1-y2)*((x3*y4)-(y3*x4))));

                double p_x = p_x_n/(double)p_x_d;
                double p_y = p_y_n/(double)p_y_d;
                if ((p_x - x1)*(p_x - x2) < 0 &&
                    (p_y - y1)*(p_y - y2) < 0 &&
                    (p_x - x3)*(p_x - x4) < 0 &&
                    (p_y - y3)*(p_y - y4) < 0){
                    /*if(points.containsKey(p_x)){
                        if (!points.get(p_x).contains(p_y)){
                            count++;
                            points.get(p_x).add(p_y);
                        }
                    }else{
                        points.put(p_x, new HashSet<>());
                        points.get(p_x).add(p_y);
                        count++;
                    }*/
                    count++;
                    //System.out.println("(" + p_x + "," + p_y + ")");
                }
            }
        }
        return count;
    }

    public void set(){
        t_n[0] = 290797L;
        for(int i = 1; i < t_n.length; i++){
            t_n[i] = t_n[i-1] * t_n[i-1];
            t_n[i] = t_n[i] % 50515093L;
        }

        for(int i = 0; i < t_n.length; i++){
            t_n[i] = t_n[i] % 500L;
        }
    }
}
