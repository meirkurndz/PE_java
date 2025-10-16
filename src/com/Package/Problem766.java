package com.Package;

import java.math.BigInteger;
import java.util.*;

public class Problem766 {

    int[][][] P1 =          {{ {1,R},{1,R},{8,P},{0,W} },
                            { {1,R},{9,P},{10,P},{0,W} },
                            { {11,P},{12,P},{13,P},{15,P} }};

    int[][][] shapes = {{ {0,W}, {1,R},{1,R}, {2,G}, {3,R},{3,R} },
                        { {0,W}, {1,R},{2,G}, {2,G}, {3,R},{4,Y}},
                        { {8,P}, {9,P},{7,B}, {7,B}, {5,Y},{4,Y}},
                        {{10,P},{11,P},{7,B}, {7,B}, {5,Y},{6,G}},
                        {{12,P},{13,P},{14,T},{14,T},{6,G},{6,G}}};

    static final int P = 0;
    static final int R = 1;
    static final int G = 2;
    static final int Y = 3;
    static final int B = 4;
    static final int T = 5;
    static final int W = 6;

    static final int BLANK = 0;

    HashSet<BigInteger> memo = new HashSet<>();
    LinkedList<int[][][]> nextPositions = new LinkedList<>();

    public void run(){
        long t1 = System.currentTimeMillis();
        long ans = count(shapes);
        System.out.println("PE_766 = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public long count(int[][][] shapes){

        long count = 0;
        BigInteger key = hashColors(shapes);
        memo.add(key);
        nextPositions.add(shapes);

        while (nextPositions.size() != 0){
            int temp = nextPositions.size();
            count += temp;
            for(int i = 0; i < temp; i++){
                int[][][] pos = nextPositions.pollFirst();
                makeMoves(pos);
            }
        }
        return count;
    }

    public void makeMoves(int[][][] pos){
        BigInteger key;
        boolean[] used = new boolean[16];
        Arrays.fill(used,false);
        for (int i = 0; i < pos.length; i++){
            for(int j = 0; j < pos[i].length; j++){
                int shape = pos[i][j][0];
                if (!used[shape]){
                    used[shape] = true;
                    switch (shape){
                        case 1:
                        case 3:{
                            //  j
                            //i 0 0
                            //  0
                            //move up:
                            if (i > 0 && pos[i-1][j][0] == BLANK && pos[i-1][j+1][0] == BLANK){
                                //can move up
                                pos[i-1][j][0] = shape;
                                pos[i-1][j+1][0] = shape;
                                pos[i+1][j][0] = BLANK;
                                pos[i][j+1][0] = BLANK;
                                pos[i-1][j][1] = R;
                                pos[i-1][j+1][1] = R;
                                pos[i+1][j][1] = W;
                                pos[i][j+1][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);
                                }

                                pos[i-1][j][0] = BLANK;
                                pos[i-1][j+1][0] = BLANK;
                                pos[i+1][j][0] = shape;
                                pos[i][j+1][0] = shape;
                                pos[i-1][j][1] = W;
                                pos[i-1][j+1][1] = W;
                                pos[i+1][j][1] = R;
                                pos[i][j+1][1] = R;

                            }
                            //move down:
                            if (i < pos.length-2 && pos[i+2][j][0] == BLANK && pos[i+1][j+1][0] == BLANK){
                                //can move down
                                pos[i][j][0] = BLANK;
                                pos[i][j+1][0] = BLANK;
                                pos[i+2][j][0] = shape;
                                pos[i+1][j+1][0] = shape;
                                pos[i][j][1] = W;
                                pos[i][j+1][1] = W;
                                pos[i+2][j][1] = R;
                                pos[i+1][j+1][1] = R;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);
                                }

                                pos[i][j][0] = shape;
                                pos[i][j+1][0] = shape;
                                pos[i+2][j][0] = BLANK;
                                pos[i+1][j+1][0] = BLANK;
                                pos[i][j][1] = R;
                                pos[i][j+1][1] = R;
                                pos[i+2][j][1] = W;
                                pos[i+1][j+1][1] = W;

                            }
                            //move left:
                            if (j > 0 && pos[i][j-1][0] == BLANK && pos[i+1][j-1][0] == BLANK){
                                //can move left
                                pos[i][j+1][0] = BLANK;
                                pos[i+1][j][0] = BLANK;
                                pos[i][j-1][0] = shape;
                                pos[i+1][j-1][0] = shape;
                                pos[i][j+1][1] = W;
                                pos[i+1][j][1] = W;
                                pos[i][j-1][1] = R;
                                pos[i+1][j-1][1] = R;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);
                                }

                                pos[i][j+1][0] = shape;
                                pos[i+1][j][0] = shape;
                                pos[i][j-1][0] = BLANK;
                                pos[i+1][j-1][0] = BLANK;
                                pos[i][j+1][1] = R;
                                pos[i+1][j][1] = R;
                                pos[i][j-1][1] = W;
                                pos[i+1][j-1][1] = W;
                            }
                            //move right:
                            if (j < pos[0].length-2 && pos[i][j+2][0] == BLANK && pos[i+1][j+1][0] == BLANK){
                                //can move right
                                pos[i][j+2][0] = shape;
                                pos[i+1][j+1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i+1][j][0] = BLANK;
                                pos[i][j+2][1] = R;
                                pos[i+1][j+1][1] = R;
                                pos[i][j][1] = W;
                                pos[i+1][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);
                                }

                                pos[i][j+2][0] = BLANK;
                                pos[i+1][j+1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i+1][j][0] = shape;
                                pos[i][j+2][1] = W;
                                pos[i+1][j+1][1] = W;
                                pos[i][j][1] = R;
                                pos[i+1][j][1] = R;
                            }
                            //get out of the switch:
                            break;
                        }
                        case 2:
                        case 6:{
                            //    j
                            //i   0
                            //  0 0

                            //move up:
                            if (i > 0 && pos[i-1][j][0] == BLANK && pos[i][j-1][0] == BLANK){
                                //can move up
                                pos[i-1][j][0] = shape;
                                pos[i][j-1][0] = shape;
                                pos[i+1][j][0] = BLANK;
                                pos[i+1][j-1][0] = BLANK;
                                pos[i-1][j][1] = G;
                                pos[i][j-1][1] = G;
                                pos[i+1][j][1] = W;
                                pos[i+1][j-1][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i-1][j][0] = BLANK;
                                pos[i][j-1][0] = BLANK;
                                pos[i+1][j][0] = shape;
                                pos[i+1][j-1][0] = shape;
                                pos[i-1][j][1] = W;
                                pos[i][j-1][1] = W;
                                pos[i+1][j][1] = G;
                                pos[i+1][j-1][1] = G;
                            }
                            //move down:
                            if (i < pos.length-2 && pos[i+2][j][0] == BLANK && pos[i+2][j-1][0] == BLANK){
                                //can move down
                                pos[i][j][0] = BLANK;
                                pos[i+1][j-1][0] = BLANK;
                                pos[i+2][j][0] = shape;
                                pos[i+2][j-1][0] = shape;
                                pos[i][j][1] = W;
                                pos[i+1][j-1][1] = W;
                                pos[i+2][j][1] = G;
                                pos[i+2][j-1][1] = G;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j][0] = shape;
                                pos[i+1][j-1][0] = shape;
                                pos[i+2][j][0] = BLANK;
                                pos[i+2][j-1][0] = BLANK;
                                pos[i][j][1] = G;
                                pos[i+1][j-1][1] = G;
                                pos[i+2][j][1] = W;
                                pos[i+2][j-1][1] = W;

                            }
                            //move left:
                            if (j > 1 && pos[i][j-1][0] == BLANK && pos[i+1][j-2][0] == BLANK){
                                //can move left
                                pos[i][j][0] = BLANK;
                                pos[i+1][j][0] = BLANK;
                                pos[i][j-1][0] = shape;
                                pos[i+1][j-2][0] = shape;
                                pos[i][j][1] = W;
                                pos[i+1][j][1] = W;
                                pos[i][j-1][1] = G;
                                pos[i+1][j-2][1] = G;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j][0] = shape;
                                pos[i+1][j][0] = shape;
                                pos[i][j-1][0] = BLANK;
                                pos[i+1][j-2][0] = BLANK;
                                pos[i][j][1] = G;
                                pos[i+1][j][1] = G;
                                pos[i][j-1][1] = W;
                                pos[i+1][j-2][1] = W;
                            }
                            //move right:
                            if (j < pos[0].length-1 && pos[i][j+1][0] == BLANK && pos[i+1][j+1][0] == BLANK){
                                //can move right
                                pos[i][j+1][0] = shape;
                                pos[i+1][j+1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i+1][j-1][0] = BLANK;
                                pos[i][j+1][1] = G;
                                pos[i+1][j+1][1] = G;
                                pos[i][j][1] = W;
                                pos[i+1][j-1][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j+1][0] = BLANK;
                                pos[i+1][j+1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i+1][j-1][0] = shape;
                                pos[i][j+1][1] = W;
                                pos[i+1][j+1][1] = W;
                                pos[i][j][1] = G;
                                pos[i+1][j-1][1] = G;
                            }
                            //get out of the switch:
                            break;
                        }
                        case 4:
                        case 5:{
                            //  j
                            //i 0
                            //  0

                            //move up:
                            if (i > 0 && pos[i-1][j][0] == BLANK){
                                //can move up
                                pos[i-1][j][0] = shape;
                                pos[i+1][j][0] = BLANK;
                                pos[i-1][j][1] = Y;
                                pos[i+1][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i-1][j][0] = BLANK;
                                pos[i+1][j][0] = shape;
                                pos[i-1][j][1] = W;
                                pos[i+1][j][1] = Y;
                            }
                            //move down:
                            if (i < pos.length-2 && pos[i+2][j][0] == BLANK){
                                //can move up
                                pos[i+2][j][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i+2][j][1] = Y;
                                pos[i][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i+2][j][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i+2][j][1] = W;
                                pos[i][j][1] = Y;
                            }
                            //move left:
                            if (j > 0 && pos[i][j-1][0] == BLANK && pos[i+1][j-1][0] == BLANK){
                                //can move up
                                pos[i][j-1][0] = shape;
                                pos[i+1][j-1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i+1][j][0] = BLANK;
                                pos[i][j-1][1] = Y;
                                pos[i+1][j-1][1] = Y;
                                pos[i][j][1] = W;
                                pos[i+1][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j-1][0] = BLANK;
                                pos[i+1][j-1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i+1][j][0] = shape;
                                pos[i][j-1][1] = W;
                                pos[i+1][j-1][1] = W;
                                pos[i][j][1] = Y;
                                pos[i+1][j][1] = Y;
                            }
                            //move right:
                            if (j < pos[0].length-1 && pos[i][j+1][0] == BLANK && pos[i+1][j+1][0] == BLANK){
                                //can move up
                                pos[i][j+1][0] = shape;
                                pos[i+1][j+1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i+1][j][0] = BLANK;
                                pos[i][j+1][1] = Y;
                                pos[i+1][j+1][1] = Y;
                                pos[i][j][1] = W;
                                pos[i+1][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j+1][0] = BLANK;
                                pos[i+1][j+1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i+1][j][0] = shape;
                                pos[i][j+1][1] = W;
                                pos[i+1][j+1][1] = W;
                                pos[i][j][1] = Y;
                                pos[i+1][j][1] = Y;
                            }                            //move right:
                            //get out of the switch:
                            break;
                        }
                        case 7:{
                            //  j
                            //i 0 0
                            //  0 0

                            //move up:
                            if (i > 0 && pos[i-1][j][0] == BLANK && pos[i-1][j+1][0] == BLANK){
                                //can move up
                                pos[i-1][j][0] = shape;
                                pos[i-1][j+1][0] = shape;
                                pos[i+1][j][0] = BLANK;
                                pos[i+1][j+1][0] = BLANK;
                                pos[i-1][j][1] = B;
                                pos[i-1][j+1][1] = B;
                                pos[i+1][j][1] = W;
                                pos[i+1][j+1][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }
                                pos[i-1][j][0] = BLANK;
                                pos[i-1][j+1][0] = BLANK;
                                pos[i+1][j][0] = shape;
                                pos[i+1][j+1][0] = shape;
                                pos[i-1][j][1] = W;
                                pos[i-1][j+1][1] = W;
                                pos[i+1][j][1] = B;
                                pos[i+1][j+1][1] = B;

                            }
                            //move down:
                            if (i < pos.length-2 && pos[i+2][j][0] == BLANK && pos[i+2][j+1][0] == BLANK){
                                //can move down
                                pos[i+2][j][0] = shape;
                                pos[i+2][j+1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i][j+1][0] = BLANK;
                                pos[i+2][j][1] = B;
                                pos[i+2][j+1][1] = B;
                                pos[i][j][1] = W;
                                pos[i][j+1][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i+2][j][0] = BLANK;
                                pos[i+2][j+1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i][j+1][0] = shape;
                                pos[i+2][j][1] = W;
                                pos[i+2][j+1][1] = W;
                                pos[i][j][1] = B;
                                pos[i][j+1][1] = B;
                            }
                            //move left:
                            if (j > 0 && pos[i][j-1][0] == BLANK && pos[i+1][j-1][0] == BLANK){
                                //can move left
                                pos[i][j+1][0] = BLANK;
                                pos[i+1][j+1][0] = BLANK;
                                pos[i][j-1][0] = shape;
                                pos[i+1][j-1][0] = shape;
                                pos[i][j+1][1] = W;
                                pos[i+1][j+1][1] = W;
                                pos[i][j-1][1] = B;
                                pos[i+1][j-1][1] = B;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j+1][0] = shape;
                                pos[i+1][j+1][0] = shape;
                                pos[i][j-1][0] = BLANK;
                                pos[i+1][j-1][0] = BLANK;
                                pos[i][j+1][1] = B;
                                pos[i+1][j+1][1] = B;
                                pos[i][j-1][1] = W;
                                pos[i+1][j-1][1] = W;
                            }
                            //move right:
                            if (j < pos[0].length-2 && pos[i][j+2][0] == BLANK && pos[i+1][j+2][0] == BLANK){
                                //can move right
                                pos[i][j+2][0] = shape;
                                pos[i+1][j+2][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i+1][j][0] = BLANK;
                                pos[i][j+2][1] = B;
                                pos[i+1][j+2][1] = B;
                                pos[i][j][1] = W;
                                pos[i+1][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j+2][0] = BLANK;
                                pos[i+1][j+2][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i+1][j][0] = shape;
                                pos[i][j+2][1] = W;
                                pos[i+1][j+2][1] = W;
                                pos[i][j][1] = B;
                                pos[i+1][j][1] = B;
                            }
                            //get out of the switch:
                            break;
                        }
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 15:{
                            //  j
                            //i 0

                            //move up:
                            if (i > 0 && pos[i-1][j][0] == BLANK){

                                //can move up
                                pos[i-1][j][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i-1][j][1] = P;
                                pos[i][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i-1][j][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i-1][j][1] = W;
                                pos[i][j][1] = P;
                            }
                            //move down:
                            if (i < pos.length-1 && pos[i+1][j][0] == BLANK){
                                //can move down:
                                pos[i+1][j][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i+1][j][1] = P;
                                pos[i][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i+1][j][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i+1][j][1] = W;
                                pos[i][j][1] = P;
                            }
                            //move left:
                            if (j > 0 && pos[i][j-1][0] == BLANK){
                                //can move up
                                pos[i][j-1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i][j-1][1] = P;
                                pos[i][j][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j-1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i][j-1][1] = W;
                                pos[i][j][1] = P;
                            }
                            //move right:
                            if (j < pos[0].length-1 && pos[i][j+1][0] == BLANK){
                                //can move right
                                pos[i][j+1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i][j+1][1] = P;
                                pos[i][j][1] = W;


                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j+1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i][j+1][1] = W;
                                pos[i][j][1] = P;
                            }                            //get out of the switch:
                            break;
                        }
                        case 14:{
                            //  j
                            //i 0 0

                            //move up:
                            if (i > 0 && pos[i-1][j][0] == BLANK && pos[i-1][j+1][0] == BLANK){

                                //can move up
                                pos[i-1][j][0] = shape;
                                pos[i-1][j+1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i][j+1][0] = BLANK;
                                pos[i-1][j][1] = T;
                                pos[i-1][j+1][1] = T;
                                pos[i][j][1] = W;
                                pos[i][j+1][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i-1][j][0] = BLANK;
                                pos[i-1][j+1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i][j+1][0] = shape;
                                pos[i-1][j][1] = W;
                                pos[i-1][j+1][1] = W;
                                pos[i][j][1] = T;
                                pos[i][j+1][1] = T;
                            }
                            //move down:
                            if (i < pos.length-1 && pos[i+1][j][0] == BLANK && pos[i+1][j+1][0] == BLANK){
                                //can move down:
                                pos[i+1][j][0] = shape;
                                pos[i+1][j+1][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i][j+1][0] = BLANK;
                                pos[i+1][j][1] = T;
                                pos[i+1][j+1][1] = T;
                                pos[i][j][1] = W;
                                pos[i][j+1][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i+1][j][0] = BLANK;
                                pos[i+1][j+1][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i][j+1][0] = shape;
                                pos[i+1][j][1] = W;
                                pos[i+1][j+1][1] = W;
                                pos[i][j][1] = T;
                                pos[i][j+1][1] = T;
                            }
                            //move left:
                            if (j > 0 && pos[i][j-1][0] == BLANK){
                                //can move left
                                pos[i][j-1][0] = shape;
                                pos[i][j+1][0] = BLANK;
                                pos[i][j-1][1] = T;
                                pos[i][j+1][1] = W;

                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j-1][0] = BLANK;
                                pos[i][j+1][0] = shape;
                                pos[i][j-1][1] = W;
                                pos[i][j+1][1] = T;
                            }
                            //move right:
                            if (j < pos[0].length-2 && pos[i][j+2][0] == BLANK){
                                //can move right
                                pos[i][j+2][0] = shape;
                                pos[i][j][0] = BLANK;
                                pos[i][j+2][1] = T;
                                pos[i][j][1] = W;


                                key = hashColors(pos);
                                if (!memo.contains(key)){
                                    memo.add(key);
                                    int[][][] temp = new int[pos.length][pos[0].length][2];
                                    for(int x = 0 ;x < temp.length; x++){
                                        for (int y = 0; y < temp[x].length;y++){
                                            temp[x][y][0] = pos[x][y][0];
                                            temp[x][y][1] = pos[x][y][1];
                                        }
                                    }
                                    nextPositions.addLast(temp);

                                }

                                pos[i][j+2][0] = BLANK;
                                pos[i][j][0] = shape;
                                pos[i][j+2][1] = W;
                                pos[i][j][1] = T;
                            }                            //get out of the switch:
                            break;
                        }
                        default:
                            break;
                    }
                }
            }
        }
    }

    public void display(int[][][] shapes){
        for(int i = 0; i < shapes.length;i++){
            for(int j = 0; j < shapes[i].length; j++){
                if (shapes[i][j][0] < 10)
                    System.out.print(" ");
                System.out.print(shapes[i][j][0] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public BigInteger hashColors(int[][][] shapes){
        BigInteger hash = BigInteger.ZERO;
        for(int i = 0; i < shapes.length; i++){
            for(int j = 0; j < shapes[0].length; j++){
                hash = hash.multiply(BigInteger.valueOf(7));
                hash = hash.add(BigInteger.valueOf(shapes[i][j][1]));
            }
        }
        return hash;
    }
}
