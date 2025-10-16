package com.Package;

import java.util.ArrayList;
import java.util.Stack;


public class Problem736 {
    private static final long MAX = 10000000;
    static int smallest = 100;
    public void run(){
        long ans = 0;
        long t1 = System.currentTimeMillis();
        long X = 45;
        long Y = 90;
        int LEN = 1;
        String fStr = "";

        for (int temp = 2; temp < 100; temp++) {
            System.out.println("temp = " + temp);
            rec2(X,Y,1,temp+2,temp-2);
            rec2(X, Y, 1, temp, temp);
        }
        /*Stack<Long> Xs1 = new Stack<>();
        Stack<Long> Ys1 = new Stack<>();
        Stack<Long> Xs2 = new Stack<>();
        Stack<Long> Ys2 = new Stack<>();
        Xs1.push(X);
        Ys1.push(Y);

        for(;LEN<50; LEN++){
            System.out.println("Len = " + LEN);
            if (LEN % 2 == 1) {
                while (!Xs1.isEmpty()) {
                    long tempX = Xs1.pop();
                    long tempY = Ys1.pop();
                    if (tempX == tempY) {
                        System.out.println("found (" + tempX + "," + tempY + ") , len = " + LEN);
                    }else {
                        long rx = rx(tempX);
                        long ry = ry(tempY);
                        long sx = sx(tempX);
                        long sy = sy(tempY);
                        Xs2.push(rx);
                        Ys2.push(ry);
                        Xs2.push(sx);
                        Ys2.push(sy);
                    }
                }
            }else{
                while (!Xs2.isEmpty()) {
                    long tempX = Xs2.pop();
                    long tempY = Ys2.pop();
                    if (tempX == tempY) {
                        System.out.println("found (" + tempX + "," + tempY + ") , len = " + LEN);
                    } else {
                        long rx = rx(tempX);
                        long ry = ry(tempY);
                        long sx = sx(tempX);
                        long sy = sy(tempY);
                        Xs1.push(rx);
                        Ys1.push(ry);
                        Xs1.push(sx);
                        Ys1.push(sy);
                    }
                }
            }
        }
*/
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void rec2(long X, long Y, int len, int rNum, int sNum){
        if(rNum == 0 && sNum == 0 && X == Y){
            System.out.println("found (" +X + "," + Y + ") , len = " + len);
        }else{
            if (rNum > 0) {
                long rX = rx(X);
                long rY = ry(Y);
                rec2(rX,rY,len+1,rNum-1,sNum);
            }
            if (sNum > 0) {
                long sX = sx(X);
                long sY = sy(Y);
                rec2(sX,sY,len+1,rNum,sNum-1);
            }
            //String tempStrR = str + "(" + X + "," + Y + ")" + " -r-> ";
            //String tempStrS = str + "(" + X + "," + Y + ")" + " -s-> ";



        }

    }
    public void rec(long X, long Y, int len, int rNum, int sNum){
        if (len > smallest || Math.abs(X-Y) > MAX)
            return;
        if(X == Y){
            smallest = len;
            //System.out.println("len = " + len + " , " + str + "(" + X + "," + Y + ")");
            System.out.println("found (" +X + "," + Y + ") , len = " + len);
        }else{
            if (rNum > 0) {
                long rX = rx(X);
                long rY = ry(Y);
                rec(rX,rY,len+1,rNum-1,sNum);
            }
            if (sNum > 0) {
                long sX = sx(X);
                long sY = sy(Y);
                rec(sX,sY,len+1,rNum,sNum-1);
            }
            //String tempStrR = str + "(" + X + "," + Y + ")" + " -r-> ";
            //String tempStrS = str + "(" + X + "," + Y + ")" + " -s-> ";



        }

    }

    public long rx(long x){
        return x+1;
    }
    public long ry(long y){
        return 2*y;
    }
    public long sx(long x){
        return x*2;
    }
    public long sy(long y){
        return y+1;
    }




}
