package com.Package;

import org.w3c.dom.ls.LSOutput;

public class Problem300 {

    static final int LENGTH = 15;
    static int grids = 0;
    static int PRO = (int)Math.pow(2,LENGTH);
    static int[][] grid = new int[LENGTH*2][LENGTH*2];
    static int[] best = new int[PRO];
    public void run(){
        long t1 = System.currentTimeMillis();
        grid[LENGTH][LENGTH] = 1;
        rec(2,LENGTH+1,LENGTH);
        int sum = 0;
        for(int i = 0; i < best.length; i++){
            //System.out.println(i + ", " + best[i]);
            sum += best[i];
        }
        long t2 = System.currentTimeMillis();
        System.out.println(((double) sum)/best.length);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void rec(int len, int x, int y){
        grid[x][y] = len;
        if(len == LENGTH){
            grids++;
            if (y >= LENGTH) {
                //System.out.println(grids);
                check_grid();
            }
            return;
        }

        if(x > 0 && grid[x-1][y] == 0){
            rec(len+1,x-1,y);
            grid[x-1][y] = 0;
        }

        if(x < LENGTH*2-1 && grid[x+1][y] == 0){
            rec(len+1,x+1,y);
            grid[x+1][y] = 0;
        }

        if(y > 0 && grid[x][y-1] == 0){
            rec(len+1,x,y-1);
            grid[x][y-1] = 0;
        }

        if(y < LENGTH*2-1 && grid[x][y+1] == 0){
            rec(len+1,x,y+1);
            grid[x][y+1] = 0;
        }
    }

    public void check_grid(){
        /*System.out.println("grid number " + grids + ":");
            for(int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[i].length;j++){
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        System.out.println();*/
        int[] connections = new int[150];
        int i = LENGTH;
        int j = LENGTH;
        int countr = 0;
        for(int curr = 1; curr < LENGTH+1; curr++){
            int nextI = i;
            int nextJ = j;
            if (i > 0 && grid[i-1][j] != 0 && grid[i-1][j] > curr){
                connections[countr] = (1 << (LENGTH-curr)) | (1 << (LENGTH-grid[i-1][j]));
                //System.out.println(curr + ", "+grid[i-1][j]);
                countr++;
                if(grid[i-1][j] == curr+1){
                    nextI = i-1;
                }
            }
            if (i < LENGTH*2-1 && grid[i+1][j] != 0 && grid[i+1][j] > curr){
                connections[countr] = (1 << (LENGTH-curr)) | (1 << (LENGTH-grid[i+1][j]));
                //System.out.println(curr + ", "+grid[i+1][j]);
                countr++;
                if(grid[i+1][j] == curr+1){
                    nextI = i+1;
                }
            }
            if (j > 0 && grid[i][j-1] != 0 && grid[i][j-1] > curr){
                connections[countr] = (1 << (LENGTH-curr)) | (1 << (LENGTH-grid[i][j-1]));
                //System.out.println(curr + ", " + grid[i][j-1]);
                countr++;
                if(grid[i][j-1] == curr+1){
                    nextJ = j-1;
                }
            }
            if (j < LENGTH*2-1 && grid[i][j+1] != 0 && grid[i][j+1] > curr){
                connections[countr] = (1 << (LENGTH-curr)) | (1 << (LENGTH-grid[i][j+1]));
                //System.out.println(curr + ", "+grid[i][j+1]);
                countr++;
                if(grid[i][j+1] == curr+1){
                    nextJ = j+1;
                }
            }
            i=nextI;
            j=nextJ;
        }
        for(int p = 0; p < best.length;p++){
            //System.out.println(p +":");
            int connect = 0;
            for(int k = countr-1; k >= 0;k--){
                if((connections[k] & p) == 0){
                    //System.out.println(connections[k]);
                    connect++;
                }
            }
            if(best[p] < connect){
                best[p] = connect;
            }
        }
    }
}
