package com.Package;

import java.util.LinkedList;

public class Problem244 {

    int[][] grid = {{E,R,B,B},
                    {R,R,B,B},
                    {R,R,B,B},
                    {R,R,B,B}};
    int[][] target = {{E,B,R,B},
                      {B,R,B,R},
                      {R,B,R,B},
                      {B,R,B,R}};

    static final int TARGET = 9637;

    static final int[][] E_TO_I_J = {{0,0},{0,1},{0,2},{0,3},
                                     {1,0},{1,1},{1,2},{1,3},
                                     {2,0},{2,1},{2,2},{2,3},
                                     {3,0},{3,1},{3,2},{3,3}};
    static final int[][] I_J_TO_E = {{0,1,2,3},
                                     {4,5,6,7},
                                     {8,9,10,11},
                                     {12,13,14,15}};

    static final int B = 0; //blue tile
    static final int R = 1; //red tile
    static final int E = 2; //empty cell

    static final int DOWN = 68;
    static final int UP = 85;
    static final int RIGHT = 82;
    static final int LEFT = 76;
    static final int SCALE = 243;
    static final long MOD = 100000007L;


    boolean[] memo = new boolean[524033];
    LinkedList<int[][]> nextGrids = new LinkedList<>();
    LinkedList<Long> nextChecksum = new LinkedList<>();
    LinkedList<Integer> nextEmpty = new LinkedList<>();

    public void run(){
        long t1 = System.currentTimeMillis();
        long ans = rec();
        long t2 = System.currentTimeMillis();
        System.out.println("PE_244 = " + ans);
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public long rec(){
        nextGrids.addFirst(grid);
        nextEmpty.addFirst(0);
        nextChecksum.addFirst(0L);
        long sum = 0;

        boolean found = false;
        int steps = 0;
        while (nextGrids.size() != 0) {
            int size = nextGrids.size();
            //System.out.println("step " + steps + " number of positions = " + size);
            for(int n = 0; n < size; n++) {
                int[][] tempGrid = nextGrids.pollFirst();
                long tempChecksum = nextChecksum.pollFirst();
                int tempEmpty = nextEmpty.pollFirst();

                //display(tempGrid,tempChecksum,steps);

                int hash = hash(tempGrid,tempEmpty);
                memo[hash] = true;
                if (hash == TARGET){
                    sum += tempChecksum;
                    found = true;
                }

                int i = E_TO_I_J[tempEmpty][0];
                int j = E_TO_I_J[tempEmpty][1];

                //can slide down?
                if (i > 0) {
                    tempGrid[i][j] = tempGrid[i - 1][j];
                    tempGrid[i - 1][j] = E;

                    int[][] nextGrid = new int[4][4];
                    for(int x = 0; x < nextGrid.length; x++)
                        for (int y = 0; y < nextGrid[x].length; y++)
                            nextGrid[x][y] = tempGrid[x][y];
                    hash = hash(tempGrid,I_J_TO_E[i-1][j]);
                    if (!memo[hash]) {
                        nextGrids.addLast(nextGrid);
                        nextChecksum.addLast(((tempChecksum*SCALE) + DOWN) % MOD);
                        nextEmpty.addLast(I_J_TO_E[i - 1][j]);
                    }
                    tempGrid[i - 1][j] = tempGrid[i][j];
                    tempGrid[i][j] = E;
                }

                //can slide up?
                if (i < tempGrid.length-1) {
                    tempGrid[i][j] = tempGrid[i + 1][j];
                    tempGrid[i + 1][j] = E;

                    int[][] nextGrid = new int[4][4];
                    for(int x = 0; x < nextGrid.length; x++)
                        for (int y = 0; y < nextGrid[x].length; y++)
                            nextGrid[x][y] = tempGrid[x][y];
                    hash = hash(tempGrid,I_J_TO_E[i+1][j]);
                    if (!memo[hash]) {
                        nextGrids.addLast(nextGrid);
                        nextChecksum.addLast(((tempChecksum*SCALE) + UP) % MOD);
                        nextEmpty.addLast(I_J_TO_E[i + 1][j]);
                    }
                    tempGrid[i + 1][j] = tempGrid[i][j];
                    tempGrid[i][j] = E;
                }

                //can slide right?
                if (j > 0) {
                    tempGrid[i][j] = tempGrid[i][j-1];
                    tempGrid[i][j-1] = E;

                    int[][] nextGrid = new int[4][4];
                    for(int x = 0; x < nextGrid.length; x++) {
                        for (int y = 0; y < nextGrid[x].length; y++) {
                            nextGrid[x][y] = tempGrid[x][y];
                        }
                    }
                    hash = hash(tempGrid,I_J_TO_E[i][j-1]);
                    if (!memo[hash]) {
                        nextGrids.addLast(nextGrid);
                        nextChecksum.addLast(((tempChecksum*SCALE) + RIGHT) % MOD);
                        nextEmpty.addLast(I_J_TO_E[i][j - 1]);
                    }

                    tempGrid[i][j-1] = tempGrid[i][j];
                    tempGrid[i][j] = E;
                }

                //can slide left?
                if (j < tempGrid[i].length-1) {
                    tempGrid[i][j] = tempGrid[i][j+1];
                    tempGrid[i][j+1] = E;

                    int[][] nextGrid = new int[4][4];
                    for(int x = 0; x < nextGrid.length; x++)
                        for (int y = 0; y < nextGrid[x].length; y++)
                            nextGrid[x][y] = tempGrid[x][y];
                    hash = hash(tempGrid,I_J_TO_E[i][j+1]);
                    if (!memo[hash]) {
                        nextGrids.addLast(nextGrid);
                        nextChecksum.addLast(((tempChecksum*SCALE) + LEFT) % MOD);
                        nextEmpty.addLast(I_J_TO_E[i][j + 1]);
                    }
                    tempGrid[i][j+1] = tempGrid[i][j];
                    tempGrid[i][j] = E;
                }
            }
            if (found)
                break;
            steps++;
        }
        //System.out.println("reached in " + steps + " steps");
        return sum;
    }

    /*public long sum(){
        long sum = 0;
        int size = nextGrids.size();
        for(int i = 0; i < size; i++){
            int[][] grid = nextGrids.pollFirst();
            int empty = nextEmpty.peekFirst();
            long checksum = nextChecksum.pollFirst();
            int hash = hash(grid,empty);
            if (hash == TARGET){
                System.out.println("found math checksum = " + checksum);
                sum += checksum;
            }
        }
        return sum;
    }*/

    public int hash(int[][] grid, int empty){
        int hash = empty;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == E)
                    continue;
                else {
                    hash <<= 1;
                    hash += grid[i][j];
                }
            }
        }
        return hash;
    }

    public void display(int[][] grid, long checksum, int steps){
        System.out.println("steps = " + steps + " , checksum = " + checksum);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                int temp = grid[i][j];
                if (temp == B)
                    System.out.print("# ");
                else if(temp == R)
                    System.out.print("0 ");
                else{
                    System.out.print("E ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
