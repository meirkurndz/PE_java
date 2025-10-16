package com.Package;

import java.util.Arrays;

public class Problem306 {

    boolean[] isWin = new boolean[1000001];
    int[] nimValue = new int[1000001];
    public void run(){
        Arrays.fill(isWin, true);

        isWin[0] = false;
        isWin[1] = false;
        isWin[5] = false;
        isWin[9] = false;
        isWin[15] = false;
        isWin[21] = false;
        isWin[25] = false;
        isWin[29] = false;
        isWin[35] = false;
        isWin[39] = false;
        isWin[43] = false;
        isWin[55] = false;
        isWin[59] = false;
        isWin[63] = false;
        isWin[73] = false;

        for(int i = 74; i < isWin.length; i++){
            isWin[i] = isWin[i - 34];
        }

        int count = 0;
        for(int i = 0; i < isWin.length; i++){
            //System.out.println(i + " , " + isWin[i]);
            if (isWin[i]){
                count++;
            }
        }
        System.out.println("the answer = " + count);
    }

    public void genWins(){
        nimValue[0] = 0;
        nimValue[1] = 0;

        for(int i = 2; i < isWin.length; i++){
            boolean[] found = new boolean[10000000];
            isWin[i] = true;
            for(int j = 0; j < (i/2); j++){
                int rightSide = j;
                int leftSide = i - j - 2;
                int xored = nimValue[rightSide] ^ nimValue[leftSide];
                found[xored] = true;
            }
            for(int k = 0; k < found.length; k++){
                if (!found[k]){
                    nimValue[i] = k;
                    break;
                }
            }
            if (nimValue[i] == 0) isWin[i] = false;
            System.out.println(i + " , " + isWin[i]);
        }
    }


}
