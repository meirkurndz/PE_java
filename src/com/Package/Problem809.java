package com.Package;

public class Problem809 {
    long[][] memoFanc = new long[10000][10000];
    public void run(){
        System.out.println(func(1,6));
    }
    public long func(int up, int down){

        if (memoFanc[(int)up][(int)down] != 0){
            return memoFanc[(int)up][(int)down];
        }
        if (up % down == 0){
            memoFanc[up][down] = up/down;
            return up/down;
        }
        if (up < down){
            long temp = func(down,down-up);
            memoFanc[up][down] = temp;
            return temp;
        }
        long temp = func(up-down, down);
        int tempDown = (down * ((up/down) + 1)) - up;
        int tempUp = down - tempDown;
        tempUp += temp * tempDown;
        long temp1 = func(tempUp,tempDown);
        memoFanc[up][down] = temp1;
        return temp1;

    }
}
