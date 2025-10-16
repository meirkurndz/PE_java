package com.Package;



public class Problem393 {

    //A216678
    static int len = 4;
    static int jump = 0;

    public void run(){
        int[][] grid = new int[len][len];
        System.out.println("the answer = " + count(grid,0,1));

    }

    public long count(int[][] grid, int fill, int loop){

        if (fill == grid.length*grid.length){
            //jump++;
            //System.out.println("jump number " + jump);
            //display(grid);
            //System.out.println();
            return 1;
        }

        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                if (grid[i][j] == 0){
                    return path(grid,fill,i,j,i,j,loop,0);
                }
            }
        }
        System.out.println("ERROR");
        return 0;
    }

    public long path(int[][] grid, int fill, int sI, int sJ, int cI, int cJ, int loop, int dir){
        //display(grid);
        //System.out.println();
        if(cI < 0|| cJ < 0 || cI == grid.length || cJ == grid[0].length){
            return 0;
        }
        if (grid[sI][sJ] == loop && cI == sI && cJ == sJ){
            //System.out.println("creat Loop");
            return count(grid, fill, loop+1);
        }

        if(grid[cI][cJ] != 0){
            return 0;
        }

        //copying the grid:
        int[][] nextGrid = new int[len][len];
        for(int i = 0; i < nextGrid.length; i++){
            nextGrid[i] = grid[i].clone();
        }

        nextGrid[cI][cJ] = loop;
        long count = 0;
        if(dir != 1)
            count += path(nextGrid,fill+1,sI,sJ,cI-1,cJ,loop,2);
        if(dir != 2)
            count += path(nextGrid,fill+1,sI,sJ,cI+1,cJ,loop,1);
        if(dir != 3)
            count += path(nextGrid,fill+1,sI,sJ,cI,cJ-1,loop,4);
        if(dir != 4)
            count += path(nextGrid,fill+1,sI,sJ,cI,cJ+1,loop,3);


        return count;
    }

    public void display(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
