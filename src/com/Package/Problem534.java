package com.Package;

public class Problem534 {

    public void run(){
        long t1 = System.currentTimeMillis();
        //boolean[][] nn = {{false,true,false,false},{false,false,false,true},{false,true,false,false},{false,false,false,true}};
        //System.out.println(calcBoard(nn));
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    for(int l = 0; l < 4; l++){
                        boolean[][] test = new boolean[4][4];
                        test[0][i] = true;
                        test[1][j] = true;
                        test[2][k] = true;
                        test[3][l] = true;
                        int temp = calcBoard(test);
                        if (temp > 1) {
                            display(test);
                            System.out.println(calcBoard(test));
                            System.out.println();
                        }
                    }
                }
            }
        }
        /*for(int len = 14; len < 15; len++) {
            long count = 0;
            boolean[][] board = new boolean[len][len];
            for (int i = 2; i <= board.length; i++) {
                System.out.println("len = " + len + " , w = " + i);
                count += rec(board, board.length, i);
            }
            System.out.println("len = " + len + " , number of boards = " + count);
        }*/
        long t2 = System.currentTimeMillis();
        //System.out.println("the answer = " + count);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long rec(boolean[][] board, int qNum, int w){
        //display(board);
        long count = 0;
        if (qNum == 0){
            //System.out.println("final:");
            //display(board);
            return 1;
        }

        int currR = board.length-qNum;
        for (int col = 0; col < board[currR].length; col++){
            if (!board[currR][col]){
                boolean[][] next = creatBoard(currR, col, board, w);
                count += rec(next, qNum-1, w);
            }
        }
        return count;
    }

    public int calcBoard(boolean[][] board){
        //display(board);
        int calc = board.length-1;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if (board[i][j]){
                    //System.out.println("point is (" + i + "," + j + ")");
                    int temp = 1;
                    //down
                    for(int x = i+1; x < board.length; x++,temp++){
                        if (board[x][j]){
                            //System.out.println(temp);
                            calc = Math.min(calc,temp);
                        }
                    }

                    temp = 1;
                    //down right
                    for(int x = i+1,y = j+1; x < board.length && y < board[x].length; x++,y++,temp++){
                        if (board[x][y]){
                            calc = Math.min(calc,temp);
                        }
                    }

                    temp = 1;
                    //right
                    for(int y = j+1;y < board[i].length;y++,temp++){
                        if (board[i][y]){
                            calc = Math.min(calc,temp);
                        }
                    }

                    temp = 1;
                    //up right
                    for(int x = i-1,y = j+1; x > 0 && y < board[x].length; x--,y++,temp++){
                        if (board[x][y]){
                            calc = Math.min(calc,temp);
                        }
                    }

                    temp = 1;
                    //up
                    for(int x = i-1; x > 0; x--,temp++){
                        if (board[x][j]){
                            calc = Math.min(calc,temp);
                        }
                    }

                    temp = 1;
                    //up left
                    for(int x = i-1,y = j-1; x > 0 && y > 0; x--,y--,temp++){
                        if (board[x][y]){
                            calc = Math.min(calc,temp);
                        }
                    }

                    temp = 1;
                    //left
                    for(int y = j-1; y >0; y--,temp++){
                        if (board[i][y]){
                            calc = Math.min(calc,temp);
                        }
                    }

                    temp = 1;
                    //down left
                    for(int x = i+1,y = j-1; x < board.length && y > 0; x++,y--,temp++){
                        if (board[x][y]){
                            calc = Math.min(calc,temp);
                        }
                    }
                }
            }
        }
        return calc;
    }

    private boolean[][] creatBoard(int currR, int col, boolean[][] board, int w) {
        boolean[][] nextBoard = new boolean[board.length][board[0].length];
        for(int i = 0; i < nextBoard.length; i++){
            for(int j = 0; j < nextBoard[i].length; j++){
                nextBoard[i][j] = board[i][j];
            }
        }
        for(int j = 0; j < nextBoard[currR].length; j++){
            nextBoard[currR][j] = true;
        }
        nextBoard[currR][col] = false;

        //down
        for(int i = currR+1, j = col, move = w; i < nextBoard.length && move > 1; i++, move--){
            nextBoard[i][j] = true;
        }
        //down right
        for(int i = currR+1, j = col+1,move = w; i < nextBoard.length && j < nextBoard[i].length && move > 1; i++, j++, move--){
            nextBoard[i][j] = true;
        }
        //down left
        for(int i = currR+1, j = col-1,move = w; i < nextBoard.length && j >= 0 && move > 1; i++, j--, move--){
            nextBoard[i][j] = true;
        }
        return nextBoard;
    }

    public void display(boolean[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if (!board[i][j])
                    System.out.print(1 + "  ");
                else
                    System.out.print(0 + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
