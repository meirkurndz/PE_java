package com.Package;

import java.util.Arrays;

public class Problem750 {

    static int min = Integer.MAX_VALUE;
    static final int N = 976;
    int[] argT = new int[N];
    int[] argB = new int[N];

    public void run(){

        setArrange();
        display();
        int end = 0;
        for(int i = 0; i < argT.length; i++){
            if (argT[i] == N){
                end = i;
                break;
            }
        }
        System.out.println("ends in " + end);

        int min = rec(argT,argB,0,end);

        /*for(int i = 0; i < argT.length; i++){
            if (argT[i] == N)
                continue;
            int dis = move(i);
            distance += dis;
            System.out.println("move " + i + " , dis = " + dis);
            display();
        }*/

        System.out.println("total min distance = " + min);
    }

    public int rec(int[] argT, int[] argB, int path, int end){

        if (argT[end] == N && argB[end] == 1){
            //display();
            if (path < min){
                min = path;

                System.out.println("total = " + path);
                display();
            }
            return path;
        }

        int minPath = Integer.MAX_VALUE;

        for(int n = 0; n < argT.length; n++){
            if(n == end || argT[n] == 0)
                continue;

            int moveTop = argT[n];
            int moveBot = argB[n];
            int next = 0;
            for(int i = 0; i < argB.length; i++){
                if (argB[i] == moveTop + 1) {
                    next = i;
                    break;
                }
            }
            argB[next] = argB[n];
            argT[n] = 0;
            argB[n] = 0;
            int temp = rec(argT, argB,path + Math.abs(next - n), end);
            if (temp < minPath){
                minPath = temp;
            }
            //un moving:
            argB[next] = moveTop + 1;
            argT[n] = moveTop;
            argB[n] = moveBot;
        }

        return minPath;
    }

    public int move(int n){
        int T = argT[n];
        int next = 0;
        for(int i = 0; i < argB.length; i++){
            if (argB[i] == T + 1) {
                next = i;
                break;
            }
        }
        argB[next] = argB[n];
        argT[n] = 0;
        argB[n] = 0;
        return Math.abs(next - n);
    }

    public void display(){
        for(int i = 0; i < argT.length; i++){
            System.out.print(argT[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < argB.length; i++){
            System.out.print(argB[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void setArrange(){
        for(int n = 1; n <= argT.length; n++){
            argT[n-1] = (int) powMod(3,n,N+1);
            argB[n-1] = argT[n-1];
        }
    }

    public long powMod(long a, long exp, long p) {
        long res = 1;
        a = a % p;
        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * a) % p;

            exp = exp / 2;
            a = (a * a) % p;
        }
        return res;
    }
}
