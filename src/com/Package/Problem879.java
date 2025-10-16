package com.Package;

public class Problem879 {

    int[][] grid4 = new int[4][4];
    long[][] memo = new long[17][65537];

    public void run(){
        long t1 = System.currentTimeMillis();
        gen();
        long count = 0;
        boolean[] used = new boolean[17];
        for(int i = 0; i < grid4.length; i++){
            for(int j = 0; j < grid4[i].length; j++){
                int curr = getNum4(i,j);
                used[curr] = true;
                count += rec4(i,j,1,used);
                used[curr] = false;
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + count);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    private int getNum4(int i, int j) {
        return (i*4) + j + 1;
    }

    public long rec4(int row, int col, int len, boolean[] used){

        long count = 0;
        long tempMemo = genMemo(used);
        int curr = getNum4(row,col);
        if (memo[curr][(int)tempMemo] != 0)
            return memo[curr][(int)tempMemo];

        if (len > 1){
            count += 1;
        }

        int tempR = row;
        int tempC = col;
        //1: down
        while (tempR < grid4.length-1){
            boolean is = false;
            tempR++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count += rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //2: down right
        while (tempR < grid4.length-1 && tempC < grid4[tempR].length-1){
            boolean is = false;
            tempR++;
            tempC++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+= rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //3: right
        while (tempC < grid4[tempR].length-1){
            boolean is = false;
            tempC++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //4: up right
        while (tempR > 0 && tempC < grid4[tempR].length-1){
            boolean is = false;
            tempR--;
            tempC++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //5: up
        while (tempR > 0){
            boolean is = false;
            tempR--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //6: up left
        while (tempR > 0 && tempC > 0){
            boolean is = false;
            tempR--;
            tempC--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //7: left
        while (tempC > 0){
            boolean is = false;
            tempC--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //8: down left
        while (tempR < grid4.length-1 && tempC > 0){
            boolean is = false;
            tempR++;
            tempC--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //9: down2 right
        while (tempR < grid4.length-2 && tempC < grid4[tempR].length-1){
            boolean is = false;
            tempR+=2;
            tempC++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //10: down right2
        while (tempR < grid4.length-1 && tempC < grid4[tempR].length-2){
            boolean is = false;
            tempR++;
            tempC+=2;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //11: up right2
        while (tempC < grid4[tempR].length-2 && tempR > 0){
            boolean is = false;
            tempC+=2;
            tempR--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //12: up2 right
        while (tempR > 1 && tempC < grid4[tempR].length-1){
            boolean is = false;
            tempR-=2;
            tempC++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //13: up2 left
        while (tempR > 1 && tempC > 0){
            boolean is = false;
            tempR-=2;
            tempC--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //14: up left2
        while (tempR > 0 && tempC > 1){
            boolean is = false;
            tempR--;
            tempC-=2;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //15: left2 down
        while (tempC > 1 && tempR < grid4.length-1){
            boolean is = false;
            tempC-=2;
            tempR++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //16: down2 left
        while (tempR < grid4.length-2 && tempC > 0){
            boolean is = false;
            tempR+=2;
            tempC--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }

            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //17: down3 right
        while (tempR < grid4.length-3 && tempC < grid4[tempR].length-1){
            boolean is = false;
            tempR+=3;
            tempC++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //18: down3 right2
        while (tempR < grid4.length-3 && tempC < grid4[tempR].length-2){
            boolean is = false;
            tempR+=3;
            tempC+=2;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //19: down2 right3
        while (tempR < grid4.length-2 && tempC < grid4[tempR].length-3){
            boolean is = false;
            tempR+=2;
            tempC+=3;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //20: down right3
        while (tempR < grid4.length-1 && tempC < grid4[tempR].length-3){
            boolean is = false;
            tempR+=1;
            tempC+=3;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //21: up right3
        while (tempC < grid4[tempR].length-3 && tempR > 0){
            boolean is = false;
            tempC+=3;
            tempR--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //22: up2 right3
        while (tempC < grid4[tempR].length-3 && tempR > 1){
            boolean is = false;
            tempC+=3;
            tempR-=2;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //23: up3 right2
        while (tempR > 2 && tempC < grid4[tempR].length-2){
            boolean is = false;
            tempR-=3;
            tempC+=2;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //24: up3 right1
        while (tempR > 2 && tempC < grid4[tempR].length-1){
            boolean is = false;
            tempR-=3;
            tempC+=1;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //25: up3 left
        while (tempR > 2 && tempC > 0){
            boolean is = false;
            tempR-=3;
            tempC--;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //26: up3 left2
        while (tempR > 2 && tempC > 1){
            boolean is = false;
            tempR-=3;
            tempC-=2;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count += rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //27: up2 left3
        while (tempR > 1 && tempC > 2){
            boolean is = false;
            tempR-=2;
            tempC-=3;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //28: up left3
        while (tempR > 0 && tempC > 2){
            boolean is = false;
            tempR-=1;
            tempC-=3;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //29: left3 down
        while (tempC > 2 && tempR < grid4.length-1){
            boolean is = false;
            tempC-=3;
            tempR++;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //30: left3 down2
        while (tempC > 2 && tempR < grid4.length-2){
            boolean is = false;
            tempC-=3;
            tempR+=2;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count+=rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //31: down3 left2
        while (tempR < grid4.length-3 && tempC > 1){
            boolean is = false;
            tempR+=3;
            tempC-=2;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count += rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }
            if (is)
                break;
        }

        tempR = row;
        tempC = col;
        //32: down3 left
        while (tempR < grid4.length-3 && tempC > 0){
            boolean is = false;
            tempR+=3;
            tempC-=1;
            int get = getNum4(tempR, tempC);
            if (!used[get]){
                used[get] = true;
                is = true;
                count += rec4(tempR,tempC,len+1,used);
                used[get] = false;
            }

            if (is)
                break;
        }

        memo[curr][(int)tempMemo] = count;
        return count;
    }

    private long genMemo(boolean[] used) {
        int pow2 = 1;
        long memo = 0;
        for(int i = 1; i < used.length; i++){
            if (used[i]){
                memo += pow2;
            }
            pow2 *= 2;
        }
        return memo;
    }

    public void gen(){
        int a = 1;
        for(int i = 0; i < grid4.length; i++){
            for(int j = 0; j < grid4[i].length; j++){
                grid4[i][j] = a;
                a++;
            }
        }
        a=1;
        for(int i = 0; i < grid4.length; i++){
            for(int j = 0; j < grid4[i].length;j++){
                grid4[i][j] = a;
                a++;
            }
        }
    }
}
