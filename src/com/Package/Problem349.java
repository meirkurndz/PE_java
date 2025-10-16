package com.Package;

public class Problem349 {

    static final int SIZE = 100;
    boolean[][] grid = new boolean[SIZE][SIZE];
    //true = black , false = white

    public void run(){
        long t1 = System.currentTimeMillis();
        long blacks = 0;
        long calc104 = 0;
        int x = SIZE/2;
        int y = SIZE/2;
        int dir = 1;
        for(int i = 0; i < 10440; i++){
            if (i == 10336)
                calc104 -= blacks;
            if (grid[x][y]){
                grid[x][y] = false;
                blacks--;
                dir += 3;
                dir %= 4;
                x += addX(dir);
                y += addY(dir);
            }else{
                grid[x][y] = true;
                blacks++;
                dir += 1;
                dir %= 4;
                x += addX(dir);
                y += addY(dir);
            }
        }
        calc104 += blacks;
        blacks += ((1_000_000_000_000_000_000L - 10440L)/104) * calc104;

        long t2 = System.currentTimeMillis();
        System.out.println("PE_349 = " + blacks);
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public int addX(int dir){
        switch (dir) {
            case 1:
                return -1;
            case 2:
            case 0:
                return 0;
            case 3:
                return 1;
        }
        return 0;
    }

    public int addY(int dir){
        switch (dir) {
            case 0:
                return -1;
            case 1:
            case 3:
                return 0;
            case 2:
                return 1;
        }
        return 0;
    }
}
