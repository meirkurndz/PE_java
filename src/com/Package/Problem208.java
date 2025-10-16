package com.Package;

import java.util.Arrays;

public class Problem208 {
    static final int LENGTH = 70;
    long[][][][][][] memo = new long[(LENGTH/5)+1][(LENGTH/5)+1][(LENGTH/5)+1][(LENGTH/5)+1][(LENGTH/5)+1][5];
    static int count = 0;
    public void run(){
        long t1 = System.currentTimeMillis();
        set_memo();
        long count = 0;
        int[] count_vis = new int[5];
        int curr = 0;
        count = rec(count_vis,curr,0);
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + count);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long rec(int[] count_vis, int curr, int move){
        if(memo[count_vis[0]][count_vis[1]][count_vis[2]][count_vis[3]][count_vis[4]][curr] != -1){
            return memo[count_vis[0]][count_vis[1]][count_vis[2]][count_vis[3]][count_vis[4]][curr];
        }
        if(move == LENGTH){
            if(curr != 0) return 0;
            if (count_vis[0] == count_vis[1] &&
                    count_vis[3] == count_vis[4] &&
                    count_vis[1]==count_vis[3] && count_vis[2]==count_vis[3]){
                return 1;
            }else{
                return 0;
            }
        }

        long count = 0;

        int next_l = (curr + 1) % 5;
        if(count_vis[next_l] < (LENGTH/5)) {
            count_vis[next_l]++;
            count += rec(count_vis, next_l, move + 1);
            count_vis[next_l]--;
        }

        int next_r = (curr - 1) % 5;
        if (next_r < 0) next_r += 5;
        if (count_vis[next_r] < (LENGTH/5)) {
            count_vis[next_r]++;
            count += rec(count_vis, next_r, move + 1);
            count_vis[next_r]--;
        }

        memo[count_vis[0]][count_vis[1]][count_vis[2]][count_vis[3]][count_vis[4]][curr] = count;
        return count;
    }

    public void set_memo(){
        for(int i = 0; i < (LENGTH/5)+1; i++){
            for(int j = 0; j < (LENGTH/5)+1; j++){
                for(int k = 0; k < (LENGTH/5)+1; k++){
                    for(int l = 0; l < (LENGTH/5)+1; l++){
                        for(int m = 0; m < (LENGTH/5)+1; m++){
                            for(int n = 0; n < 5; n++){
                                memo[i][j][k][l][m][n] = -1;
                            }
                        }
                    }
                }
            }
        }
    }
}
