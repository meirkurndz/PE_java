package com.Package;

import java.nio.channels.Pipe;

public class Problem816 {

    static final int SIZE = 2000000;
    Point[] points = new Point[SIZE];
    static final int MOD = 50515093;

    public void run(){
        long t1 = System.currentTimeMillis();
        setPoints();
        quick_sort(points,0,points.length,0);
        /*for(int i = 0; i < points.length; i++){
            System.out.println("(" + points[i]._x + "," + points[i]._y + ")");
        }*/
        System.out.println("the answer = " + closestPoints(points,0,points.length));
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1 + "ms"));
    }

    public double closestPoints(Point[] points, int si, int endi){
        //System.out.println("(" + si + "," + endi + ")");
        if(endi - si < 4){
            return closestPointsBF(points, si, endi);
        }

        int midi = (endi + si) / 2;
        double dl = closestPoints(points, si,midi);
        double dr = closestPoints(points, midi ,endi);
        double d = Math.min(dl,dr);

        Point[] strip = new Point[endi];
        int j = 0;
        for(int i = midi-1; i >= si; i--){
            if(points[midi]._x - points[i]._x < d){
                strip[j] = points[i];
                j++;
            }else{
                break;
            }
        }

        for(int i = midi+1; i < endi; i++){
            if(points[i]._x - points[midi]._x < d){
                strip[j] = points[i];
                j++;
            }else{
                break;
            }
        }

        return Math.min(d,stripClosest(strip,j,d));
    }

    public double stripClosest(Point[] strip, int end, double d){
        quick_sort(strip,0,end,1);
        double min = d;
        for(int i = 0; i < end; i++){
            for(int j = i+1, c = 0; j < end && c < 7; j++, c++){
                double tempD = strip[i].dist(strip[j]);
                if (tempD < min){
                    min = tempD;
                }
            }
        }
        return min;
    }

    public double closestPointsBF(Point[] points, int si, int endi){
        double min = Double.MAX_VALUE;
        for(int i = si; i < endi; i++){
            for(int j = i + 1; j < endi; j++){
                double d = points[i].dist(points[j]);
                if(d < min){
                    min = d;
                }
            }
        }
        return min;
    }

    public void setPoints(){
        long[] S = new long[2*SIZE];
        S[0] = 290797;
        for(int i = 1; i < S.length; i++){
            S[i] = (S[i-1] * S[i-1]) % MOD;
        }

        for(int i = 0; i < points.length; i++){
            points[i] = new Point(S[2*i],S[(2*i)+1]);
        }
    }


    void quick_sort (Point[] points, int si, int endi, int sortType)
    {
        if (si < endi)
        {
            int pivot = partition (points, si, endi, sortType);
            int next_end = pivot;
            int next_start = pivot + 1;
            quick_sort (points,si, next_end, sortType);
            quick_sort (points, next_start, endi, sortType);
        }
    }

    int partition (Point[] points, int si, int endi, int sortType){
        if(sortType == 0)
        {
            int pivot = endi - 1;
            int less_index = si - 1;
            int loop_index = si;
            while (loop_index < endi)
            {
                if (points[loop_index]._x < points[pivot]._x)
                {
                    less_index++;
                    swap (points, less_index, loop_index);
                }
                loop_index++;
            }
            less_index++;
            swap (points, less_index, endi-1);
            return less_index;
        }else
        {
            int pivot = endi-1;
            int less_index = si - 1;
            int loop_index = si;
            while (loop_index < endi)
            {
                if (points[loop_index]._y < points[pivot]._y)
                {
                    less_index++;
                    swap (points, less_index, loop_index);
                }
                loop_index++;
            }
            less_index++;
            swap (points, less_index, endi-1);
            return less_index;
        }
    }

    void swap(Point[] points, int a, int b){
        Point temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
}
