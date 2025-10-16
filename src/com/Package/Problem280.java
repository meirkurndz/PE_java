package com.Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Problem280 {
    //|1 |2 |3 |4 |5 |
    //|6 |7 |8 |9 |10|
    //|11|12|13|14|15|
    //|16|17|18|19|20|
    //|21|22|23|24|25|
    int[][] transition = {{},{2,6},{1,3,7},{2,4,8},{3,5,9},{4,10},{1,7,11},
            {2,6,8,12},{3,7,9,13},{4,8,10,14},{5,9,15},{6,12,16},
            {7,11,13,17},{8,12,14,18},{9,13,15,19},{10,14,20},
            {11,17,21},{12,16,18,22},{13,17,19,23},{14,18,20,24},
            {15,19,25},{16,22},{17,21,23},{18,22,24},{19,23,25},{20,24}};

    int[][] tran = new int[4413132][5];
    double[] prob = new double[4413132];
    boolean[] is_valid = new boolean[4413132];
    public void run(){
        long t1 = System.currentTimeMillis();
        setTransitions();
        /*for(int i = 0; i < 4; i++){
            System.out.println(tran[3100031][i]);
        }*/
        System.out.println("the answer = " + play());
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public double play(){
        prob[2200031] = 1.0;
        double E = 0;
        int iterations = 3191;
        for(int iter = 1; iter < iterations; iter++){
            double[] next_prob = new double[4413132];
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++){
                    for (int is_car = 0; is_car <= 1; is_car++) {
                        for (int seed_top = 0; seed_top < 32; seed_top++) {
                            for (int seed_bot = 0; seed_bot < 32; seed_bot++) {
                                int state = hash(i,j,is_car,seed_top,seed_bot);
                                if (is_valid[state]) {
                                    int n = tran[state][4];
                                    double fraq = 1.0/n;
                                    for(int t = 0; t < n; t++){
                                        int next_pos = tran[state][t];
                                        next_prob[next_pos] += prob[state] * fraq;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            double finish = 0;
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++){
                    for (int is_car = 0; is_car <= 1; is_car++) {
                        for (int seed_top = 0; seed_top < 32; seed_top++) {
                            for (int seed_bot = 0; seed_bot < 32; seed_bot++) {
                                int state = hash(i,j,is_car,seed_top,seed_bot);
                                if (is_valid[state]) {
                                    prob[state] = next_prob[state];
                                    if(seed_top == 31){
                                        finish += prob[state];
                                        prob[state] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            E += (iter*finish);
        }
        return E;
    }

    public void setTransitions(){

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++){
                for (int is_car = 0; is_car <= 1; is_car++) {
                    for (int seed_top = 0; seed_top < 32; seed_top++) {
                        for (int seed_bot = 0; seed_bot < 32; seed_bot++) {
                            int state = hash(i,j,is_car,seed_top,seed_bot);
                            if(is_valid(i,j,is_car,seed_top,seed_bot)){
                                is_valid[state] = true;
                                int cur = 0;
                                if (is_car == 1){
                                    int j_mask = (int) Math.pow(2, 4-j);

                                    if(i == 1) {
                                        if((j_mask & seed_top) == 0){
                                            int n_up = hash(i-1,j,0,seed_top | j_mask,seed_bot);
                                            tran[state][cur] = n_up;
                                            cur++;
                                        }else{
                                            int n_up = hash(i-1,j,1,seed_top ,seed_bot);
                                            tran[state][cur] = n_up;
                                            cur++;
                                        }
                                    }else if(i > 0){
                                        int n_up = hash(i-1,j,1,seed_top ,seed_bot);
                                        tran[state][cur] = n_up;
                                        cur++;
                                    }
                                    if(j > 0){
                                        if(i == 0 && ((2*j_mask) & seed_top) == 0){
                                            int n_l = hash(i, j - 1, 0, seed_top | (2*j_mask), seed_bot);
                                            tran[state][cur] = n_l;
                                            cur++;
                                        }else {
                                            int n_l = hash(i, j - 1, 1, seed_top, seed_bot);
                                            tran[state][cur] = n_l;
                                            cur++;
                                        }
                                    }
                                    if(j < 4){
                                        if(i == 0 && ((j_mask/2) & seed_top) == 0){
                                            int n_r = hash(i, j + 1, 0, seed_top | (j_mask/2), seed_bot);
                                            tran[state][cur] = n_r;
                                            cur++;
                                        }else {
                                            int n_r = hash(i, j + 1, 1, seed_top, seed_bot);
                                            tran[state][cur] = n_r;
                                            cur++;
                                        }
                                    }
                                    if(i < 4) {
                                        int n_d = hash(i + 1, j, 1, seed_top, seed_bot);
                                        tran[state][cur] = n_d;
                                        cur++;
                                    }
                                }else{
                                    int j_mask = (int) Math.pow(2, 4-j);

                                    if(i == 3) {
                                        if((j_mask & seed_bot) != 0){
                                            int n_d = hash(i+1,j,1,seed_top,seed_bot & (31-j_mask));
                                            tran[state][cur] = n_d;
                                            cur++;
                                        }else{
                                            int n_d = hash(i+1,j,0,seed_top,seed_bot);
                                            tran[state][cur] = n_d;
                                            cur++;
                                        }
                                    }else if( i < 4){
                                        int n_d = hash(i+1,j,0,seed_top ,seed_bot);
                                        tran[state][cur] = n_d;
                                        cur++;
                                    }
                                    if(j > 0){
                                        if(i == 4 && (seed_bot & (j_mask*2)) != 0){
                                            int n_l = hash(i,j-1,1,seed_top,seed_bot & (31-(2*j_mask)));
                                            tran[state][cur] = n_l;
                                            cur++;
                                        }else {
                                            int n_l = hash(i, j - 1, 0, seed_top, seed_bot);
                                            tran[state][cur] = n_l;
                                            cur++;
                                        }
                                    }
                                    if(j < 4){
                                        if(i == 4 && (seed_bot & (j_mask/2)) != 0){
                                            int n_r = hash(i,j+1,1,seed_top,seed_bot & (31-(j_mask/2)));
                                            tran[state][cur] = n_r;
                                            cur++;
                                        }else {
                                            int n_r = hash(i, j + 1, 0, seed_top, seed_bot);
                                            tran[state][cur] = n_r;
                                            cur++;
                                        }
                                    }
                                    if(i > 0) {
                                        int n_up = hash(i - 1, j, 0, seed_top, seed_bot);
                                        tran[state][cur] = n_up;
                                        cur++;
                                    }
                                }
                                tran[state][4] = cur;
                            }
                        }
                    }
                }
            }
        }
    }


    public boolean is_valid(int i, int j, int car, int top, int bot){
        int j_mask = (int) Math.pow(2,4-j);

        if(i == 0){
            if(car == 1 && ((j_mask & top) == 0) ){
                return false;
            }
        }
        else if(i == 4){
            if(car == 0 && ((j_mask & bot) != 0)){
                return false;
            }
        }
        int tow_pow = 1;
        int count_bits = 0;
        for(int k = 0; k < 5; k++){
            if((tow_pow & top) != 0){
                count_bits += 1;
            }
            if((tow_pow & bot) != 0){
                count_bits += 1;
            }
            tow_pow *= 2;
        }
        if((count_bits + car) != 5){
            return false;
        }
        return true;
    }

    public int hash(int i, int j, int is_car, int top, int bot){
        int hash = i;
        hash *= 10;
        hash += j;
        hash *= 10;
        hash += is_car;
        hash *= 100;
        hash += top;
        hash *= 100;
        hash += bot;
        return hash;
    }

}

/*for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++){
            for (int is_car = 0; is_car <= 1; is_car++) {
                for (int seed_top = 0; seed_top < 32; seed_top++) {
                    for (int seed_bot = 0; seed_bot < 32; seed_bot++) {
                        int state = hash(i,j,is_car,seed_top,seed_bot);
                        if (is_valid[state]) {
                            count++;
                            System.out.print(state + " = ");
                            for (int k = 0; k < tran[state].length; k++) {
                                if (tran[state][k] != 0) {
                                    System.out.print(tran[state][k] + ", ");
                                }
                            }
                            System.out.println();
                        }
                    }
                }
            }
        }
    }*/

