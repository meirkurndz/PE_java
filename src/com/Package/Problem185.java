package com.Package;

import java.util.Random;

public class Problem185 {

    int[][] seq = {   {5,8,5,5,4,6,2,9,4,0,8,1,0,5,8,7}, //; 3 correct
                      {9,7,4,2,8,5,5,5,0,7,0,6,8,3,5,3}, //; 3 correct
                      {4,2,9,6,8,4,9,6,4,3,6,0,7,5,4,3}, //; 3 correct
                      {7,8,9,0,9,7,1,5,4,8,9,0,8,0,6,7}, //; 3 correct
                      {8,6,9,0,0,9,5,8,5,1,5,2,6,2,5,4}, //; 3 correct
                      {1,7,4,8,2,7,0,4,7,6,7,5,8,2,7,6}, //; 3 correct
                      {3,0,4,1,6,3,1,1,1,7,2,2,4,6,3,5}, //; 3 correct
                      {1,8,4,1,2,3,6,4,5,4,3,2,4,5,8,9}, //; 3 correct
                      {5,6,1,6,1,8,5,6,5,0,5,1,8,2,9,3}, //; 2 correct
                      {4,5,1,3,5,5,9,0,9,4,1,4,6,1,1,7}, //; 2 correct
                      {2,6,1,5,2,5,0,7,4,4,3,8,6,8,9,9}, //; 2 correct
                      {6,4,4,2,8,8,9,0,5,5,0,4,2,7,6,8}, //; 2 correct
                      {2,3,2,6,5,0,9,4,7,1,2,7,1,4,4,8}, //; 2 correct
                      {5,2,5,1,5,8,3,3,7,9,6,4,4,3,2,2}, //; 2 correct
                      {2,6,5,9,8,6,2,6,3,7,3,1,6,8,6,7}, //; 2 correct
                      {4,8,9,5,7,2,2,6,5,2,1,9,0,3,0,6}, //; 1 correct
                      {6,3,7,5,7,1,1,9,1,5,0,7,7,0,5,0}, //; 1 correct
                      {6,9,1,3,8,5,9,1,7,3,1,2,1,3,6,0}, //; 1 correct
                      {8,1,5,7,3,5,6,3,4,4,1,1,8,4,8,3}, //; 1 correct
                      {3,8,4,7,4,3,9,6,4,7,2,9,3,0,4,7}, //; 1 correct
                      {3,1,7,4,2,4,8,4,3,9,4,6,5,8,5,8}, //; 1 correct
                      {2,3,2,1,3,8,6,1,0,4,3,0,3,8,4,5}  //; 0 correct
    };

    int[] currects = {3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 0};

    public void run(){

        // third try:
        int[] gess = new int[16];
        Random rand = new Random();
        for(int i = 0; i < gess.length; i++){
            gess[i] = rand.nextInt(10);
        }

        int distance = distance(gess);
        int itarWithNoChange = 0;
        int best = 100;

        while (distance > 0){
            int indexToChange = rand.nextInt(16);
            int change = rand.nextInt(10);

            int[] nextGess = copy(gess);
            nextGess[indexToChange] = change;
            int nextDistance = distance(nextGess);

            if (nextDistance < distance){
                gess = copy(nextGess);
                distance = nextDistance;
                itarWithNoChange = 0;
            }else{
                itarWithNoChange++;
                if (itarWithNoChange > 30){
                    gess = copy(nextGess);
                    distance = nextDistance;
                    itarWithNoChange = 0;
                }
            }

            if (distance <= best) {
                best = distance;

                if (best == 0) {
                    System.out.print("the answer = ");
                    for (int value : gess) {
                        System.out.print(value);
                    }
                    //System.out.println(" distance = " + distance);
                    break;
                }
            }
        }
    }

    public int distance(int[] gess){
        int error = 0;
        for(int i = 0; i < seq.length; i++){
            int same = 0;
            for(int j = 0; j < seq[i].length; j++){
                if (gess[j] == seq[i][j]){
                    same++;
                }
            }
            if (same > currects[i]){
                error += same - currects[i];
            }else{
                error += currects[i] - same;
            }
        }
        return error;
    }

    public int[] copy(int[] ans){
        int[] copy = new int[16];
        for(int i = 0; i < 16; i++){
            copy[i] = ans[i];
        }
        return copy;
    }
}
