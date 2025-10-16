package com.Package;

import java.util.Arrays;

public class Problem213 {

    double[][] dir = new double[30][30];
    double[][] emptyness = new double[30][30];

    public void run(){
        long time1 = System.currentTimeMillis();
        initEmptyness();
        initDir();

        for(int i = 0; i < 30; i++){
            for(int j = 0; j < 30; j++){
                double[][] pos = new double[30][30];
                pos[i][j] = 1;
                ring50(pos);
                updateEmptyness(pos);
            }
        }
        double sum = 0;
        for(int i = 0; i < emptyness.length; i++){
            for(int j = 0; j < emptyness[i].length; j++){
                sum += emptyness[i][j];
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + sum);
        System.out.println("found in " + (time2 - time1) + "ms");
    }

    public void ring50(double[][] pos){

        for(int i = 0; i < 50; i++){
            double[][] nextPos = new double[30][30];
            for(int x = 0; x < pos.length; x++){
                for (int y = 0; y < pos[x].length; y++){

                    if (x != 0){
                        nextPos[x-1][y] += dir[x][y] * pos[x][y];
                    }
                    if(x != 29){
                        nextPos[x+1][y] += dir[x][y] * pos[x][y];
                    }
                    if (y != 0){
                        nextPos[x][y-1] += dir[x][y] * pos[x][y];
                    }
                    if(y != 29){
                        nextPos[x][y+1] += dir[x][y] * pos[x][y];
                    }
                    //pos[x][y] = 0;
                }
            }

            for(int x = 0; x < pos.length; x++){
                for (int y = 0; y < pos[x].length; y++){
                    pos[x][y] = nextPos[x][y];
                }
            }
        }
    }

    public void updateEmptyness(double[][] pos){
        for(int i = 0; i < emptyness.length; i++){
            for(int j = 0; j < emptyness[i].length; j++){
                emptyness[i][j] *= 1D - pos[i][j];
            }
        }
    }

    public void initDir(){

        //corners:
        dir[0][0] = 0.5;
        dir[0][29] = 0.5;
        dir[29][0] = 0.5;
        dir[29][29] = 0.5;

        //edges:
        for(int j = 1; j < 29; j++){
            dir[0][j] = 1/3.0;
            dir[29][j] = 1/3.0;
        }
        for(int i = 1; i < 29; i++){
            dir[i][0] = 1/3.0;
            dir[i][29] = 1/3.0;
        }

        //inside:
        for(int i = 1; i < 29; i++){
            for(int j = 1; j < 29; j++){
                dir[i][j] = 0.25;
            }
        }

    }

    public void initEmptyness(){
        for(int i = 0; i < emptyness.length; i++){
            Arrays.fill(emptyness[i],1D);
        }
    }

    public void display(double[][] grid){

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
}
