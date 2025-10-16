package com.Package;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem161 {

    static ArrayList<HashMap<Long,Long>> memo = new ArrayList<>();
    public void run(){
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 12; ++i) {
            memo.add(new HashMap<>());
        }
        int[][] grid = new int[12][9];
        System.out.println("the answer = " + build(grid,1,0,0));
        long time2 = System.currentTimeMillis();
        System.out.println("found in " + (time2 - time1) + " ms");
    }

    public long key(int[][] grid, int row){
        long num = 0;
        int pow = 0;
        for(int i = row+2; i >= row; i--){
            if(i >= grid.length)
                continue;
            for(int j = grid[i].length - 1; j >= 0; j--,pow++){
                if(grid[i][j] != 0){
                    num += Math.pow(2,pow);
                }
            }
        }
        return num;
    }

    public long build(int[][] grid, int numOfTrios, int i, int j){

        if (numOfTrios == 37){
            //display(grid);
            return 1;
        }

        long key = key(grid,i);
        if(memo.get(i).containsKey(key)){
            return memo.get(i).get(key);
        }

        long count = 0;

        //trio 1:
        //O O
        //O
        if(j+1 < grid[i].length && i+1 < grid.length &&
            grid[i+1][j] == 0 && grid[i][j+1] == 0){
            int[][] temp = copyArr(grid);
            temp[i][j] = numOfTrios;
            temp[i+1][j] = numOfTrios;
            temp[i][j+1] = numOfTrios;
            int nextI = i;
            int nextJ = j;
            boolean isCall = false;

            while (!isCall) {
                if (temp[nextI][nextJ] == 0) {
                    count += build(temp, numOfTrios + 1, nextI, nextJ);
                    isCall = true;
                    break;
                }
                nextJ++;
                if(nextJ == grid[nextI].length){
                    nextI++;
                    nextJ = 0;
                }
                if(nextI == grid.length){
                    break;
                }
            }
            if (!isCall){
                count += build(temp, numOfTrios + 1, nextI, nextJ);
            }
        }


        //trio 2:
        //O O
        //  O
        if(j+1 < grid[i].length && i+1 < grid.length &&
                grid[i+1][j+1] == 0 && grid[i][j+1] == 0){
            int[][] temp = copyArr(grid);
            temp[i][j] = numOfTrios;
            temp[i+1][j+1] = numOfTrios;
            temp[i][j+1] = numOfTrios;
            int nextI = i;
            int nextJ = j;
            boolean isCall = false;
            while (!isCall) {
                if (temp[nextI][nextJ] == 0) {
                    count += build(temp, numOfTrios + 1, nextI, nextJ);
                    isCall = true;
                    break;
                }
                nextJ++;
                if(nextJ == grid[nextI].length){
                    nextI++;
                    nextJ = 0;
                }
                if(nextI == grid.length){
                    break;
                }
            }
            if (!isCall){
                count += build(temp, numOfTrios + 1, nextI, nextJ);
            }
        }

        //trio 3:
        //O
        //O O
        if(j+1 < grid[i].length && i +1 < grid.length &&
                grid[i+1][j] == 0 && grid[i+1][j+1] == 0){
            int[][] temp = copyArr(grid);
            temp[i][j] = numOfTrios;
            temp[i+1][j] = numOfTrios;
            temp[i+1][j+1] = numOfTrios;
            int nextI = i;
            int nextJ = j;
            boolean isCall = false;
            while (!isCall) {
                if (temp[nextI][nextJ] == 0) {
                    count += build(temp, numOfTrios + 1, nextI, nextJ);
                    isCall = true;
                    break;
                }
                nextJ++;
                if(nextJ == grid[nextI].length){
                    nextI++;
                    nextJ = 0;
                }
                if(nextI == grid.length){
                    break;
                }
            }
            if (!isCall){
                count += build(temp, numOfTrios + 1, nextI, nextJ);
            }
        }

        //trio 4:
        //  O
        //O O
        if(j-1 >= 0 && i+1 < grid.length &&
                grid[i+1][j] == 0 && grid[i+1][j-1] == 0){
            int[][] temp = copyArr(grid);
            temp[i][j] = numOfTrios;
            temp[i+1][j] = numOfTrios;
            temp[i+1][j-1] = numOfTrios;
            int nextI = i;
            int nextJ = j;
            boolean isCall = false;
            while (!isCall) {
                if (temp[nextI][nextJ] == 0) {
                    count += build(temp, numOfTrios + 1, nextI, nextJ);
                    isCall = true;
                    break;
                }
                nextJ++;
                if(nextJ == grid[nextI].length){
                    nextI++;
                    nextJ = 0;
                }
                if(nextI == grid.length){
                    break;
                }
            }
            if (!isCall){
                count += build(temp, numOfTrios + 1, nextI, nextJ);
            }
        }

        //trio 5:
        //O
        //O
        //O
        if(i+2 < grid.length &&
                grid[i+1][j] == 0 && grid[i+2][j] == 0){
            int[][] temp = copyArr(grid);
            temp[i][j] = numOfTrios;
            temp[i+1][j] = numOfTrios;
            temp[i+2][j] = numOfTrios;
            int nextI = i;
            int nextJ = j;
            boolean isCall = false;
            while (!isCall) {
                if (temp[nextI][nextJ] == 0) {
                    count += build(temp, numOfTrios + 1, nextI, nextJ);
                    isCall = true;
                    break;
                }
                nextJ++;
                if(nextJ == grid[nextI].length){
                    nextI++;
                    nextJ = 0;
                }
                if(nextI == grid.length){
                    break;
                }
            }
            if (!isCall){
                count += build(temp, numOfTrios + 1, nextI, nextJ);
            }
        }

        //trio 6:
        //O O O
        if(j+2 < grid[i].length &&
                grid[i][j+1] == 0 && grid[i][j+2] == 0){
            int[][] temp = copyArr(grid);
            temp[i][j] = numOfTrios;
            temp[i][j+2] = numOfTrios;
            temp[i][j+1] = numOfTrios;
            int nextI = i;
            int nextJ = j;
            boolean isCall = false;
            while (!isCall) {
                if (temp[nextI][nextJ] == 0) {
                    count += build(temp, numOfTrios + 1, nextI, nextJ);
                    isCall = true;
                    break;
                }
                nextJ++;
                if(nextJ == grid[nextI].length){
                    nextI++;
                    nextJ = 0;
                }
                if(nextI == grid.length){
                    break;
                }
            }
            if (!isCall){
                count += build(temp, numOfTrios + 1, nextI, nextJ);
            }
        }
        memo.get(i).put(key,count);
        return count;
    }

    public int[][] copyArr(int[][] grid){
        int[][] temp = new int[grid.length][grid[0].length];
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }

    public void display(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int temp = grid[i][j];
                if(temp < 10){
                    System.out.print(temp + "  ");
                }else{
                    System.out.print(temp + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}