package com.Package;

public class Problem189 {

    int[][] connections = new int[64][];
    // [pos][lastCol][lastCols]
    long[][] memo = new long[64][6561];

    public void run(){
        long time1 = System.currentTimeMillis();
        setConnections();
        int[] colors = new int[64];
        long count = count(0, colors);
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + (count)); //10834893628237824
        System.out.println("found in " + (time2 - time1) + "ms");
    }

    public long count(int pos, int[] colors){
        if (pos == 64){
            return 1;
        }


        int hashLastRow = -1;
        if (pos > 1 && !isPlace(pos)) {
            hashLastRow = hashLastRow(colors, pos);
            if(memo[pos][hashLastRow] != 0){
                return memo[pos][hashLastRow];
            }
        }

        //1 red, 10 green, 100 blue.
        int length = connections[pos].length;
        int full = 111;
        if (length == 1){
            full -= colors[connections[pos][0]];
        }else if (length == 2){
            int temp0 = colors[connections[pos][0]];
            int temp1 = colors[connections[pos][1]];

            if (temp0 == temp1){
                full -= temp0;
            }else{
                full -= temp0;
                full -= temp1;
            }
        }
        //System.out.println(triangle + " , " + full);
        long count = 0;

        //check for blue
        if (full / 100 == 1){
            colors[pos] = 100;
            count += count(pos + 1, colors);
        }

        //check for green
        full %= 100;
        if (full / 10 == 1){
            colors[pos] = 10;
            count += count(pos + 1, colors);
        }

        //check for red
        if (full % 10 == 1){
            colors[pos] = 1;
            count += count(pos + 1, colors);
        }

        if(hashLastRow != -1)
            memo[pos][hashLastRow] = count;

        return count;
    }

    public boolean isPlace(int pos){
        if(pos <= 3){
            if(pos % 2 == 1)
                return true;
        }else if(pos <= 8){
            if(pos % 2 == 0)
                return true;
        }else if(pos <= 15){
            if(pos % 2 == 1)
                return true;
        }else if(pos <= 24){
            if(pos % 2 == 0)
                return true;
        }else if(pos <= 35){
            if(pos % 2 == 1)
                return true;
        }else if(pos <= 48){
            if(pos % 2 == 0)
                return true;
        }else if(pos <= 63){
            if(pos % 2 == 1)
                return true;
        }
        return false;
    }

    public int hashLastRow(int[] colors, int pos){
        int hashLastRow = 0;
        if(pos <= 3){
            int pow = 0;
            for(int i = 0; i < pos; i+=2) {
                int temp = colors[i];
                if (temp == 1) {
                    hashLastRow += 0;
                } else if (temp == 10) {
                    hashLastRow += 1 * Math.pow(3,pow);
                } else {
                    hashLastRow += 2 * Math.pow(3,pow);
                }
                pow++;
                if(i==0)
                    i--;
            }
        }else if(pos <= 8){
            int pow = 0;
            int i = pos-4;
            if(i % 2 ==0)
                i++;
            for(; i < pos; i+=2) {
                int temp = colors[i];
                if (temp == 1) {
                    hashLastRow += 0;
                } else if (temp == 10) {
                    hashLastRow += 1 * Math.pow(3,pow);
                } else {
                    hashLastRow += 2 * Math.pow(3,pow);
                }
                pow++;
                if(i==3)
                    i--;
            }
        }
        else if(pos <= 15){
            int pow = 0;
            int i = pos-6;
            if(i % 2 != 0)
                i++;
            for(; i < pos; i+=2) {
                int temp = colors[i];
                if (temp == 1) {
                    hashLastRow += 0;
                } else if (temp == 10) {
                    hashLastRow += 1 * Math.pow(3,pow);
                } else {
                    hashLastRow += 2 * Math.pow(3,pow);
                }
                pow++;
                if(i==8)
                    i--;
            }
        }
        else if(pos <= 24){
            int pow = 0;
            int i = pos-8;
            if(i % 2 ==0)
                i++;
            for(; i < pos; i+=2) {
                int temp = colors[i];
                if (temp == 1) {
                    hashLastRow += 0;
                } else if (temp == 10) {
                    hashLastRow += 1 * Math.pow(3,pow);
                } else {
                    hashLastRow += 2 * Math.pow(3,pow);
                }
                pow++;
                if(i==15)
                    i--;
            }
        }
        else if(pos <= 35){
            int pow = 0;
            int i = pos-10;
            if(i % 2 != 0)
                i++;
            for(; i < pos; i+=2) {
                int temp = colors[i];
                if (temp == 1) {
                    hashLastRow += 0;
                } else if (temp == 10) {
                    hashLastRow += 1 * Math.pow(3,pow);
                } else {
                    hashLastRow += 2 * Math.pow(3,pow);
                }
                pow++;
                if(i==24)
                    i--;
            }
        }
        else if(pos <= 48){
            int pow = 0;
            int i = pos-12;
            if(i % 2 == 0)
                i++;
            for(; i < pos; i+=2) {
                int temp = colors[i];
                if (temp == 1) {
                    hashLastRow += 0;
                } else if (temp == 10) {
                    hashLastRow += 1 * Math.pow(3,pow);
                } else {
                    hashLastRow += 2 * Math.pow(3,pow);
                }
                pow++;
                if(i==35)
                    i--;
            }
        }
        else if(pos <= 63){
            int pow = 0;
            int i = pos-14;
            if(i % 2 != 0)
                i++;
            for(; i < pos; i+=2) {
                int temp = colors[i];
                if (temp == 1) {
                    hashLastRow += 0;
                } else if (temp == 10) {
                    hashLastRow += 1 * Math.pow(3,pow);
                } else {
                    hashLastRow += 2 * Math.pow(3,pow);
                }
                pow++;
                if(i==48)
                    i--;
            }
        }
        return hashLastRow;
    }

    public void setConnections(){
        connections[0] = new int[0];
        connections[1] = new int[0];
        connections[2] = new int[]{0, 1};
        connections[3] = new int[]{2};
        connections[4] = new int[0];
        connections[5] = new int[]{1,4};
        connections[6] = new int[]{5};
        connections[7] = new int[]{6, 3};
        connections[8] = new int[]{7};
        connections[9] = new int[0];
        connections[10] = new int[]{4, 9};
        connections[11] = new int[]{10};
        connections[12] = new int[]{6,11};
        connections[13] = new int[]{12};
        connections[14] = new int[]{8,13};
        connections[15] = new int[]{14};
        connections[16] = new int[0];
        connections[17] = new int[]{9,16};
        connections[18] = new int[]{17};
        connections[19] = new int[]{11, 18};
        connections[20] = new int[]{19};
        connections[21] = new int[]{13,20};
        connections[22] = new int[]{21};
        connections[23] = new int[]{15,22};
        connections[24] = new int[]{23};
        connections[25] = new int[0];
        connections[26] = new int[]{16,25};
        connections[27] = new int[]{26};
        connections[28] = new int[]{18, 27};
        connections[29] = new int[]{28};
        connections[30] = new int[]{20, 29};
        connections[31] = new int[]{30};
        connections[32] = new int[]{22, 31};
        connections[33] = new int[]{32};
        connections[34] = new int[]{24,33};
        connections[35] = new int[]{34};
        connections[36] = new int[0];
        connections[37] = new int[]{25, 36};
        connections[38] = new int[]{37};
        connections[39] = new int[]{27, 38};
        connections[40] = new int[]{39};
        connections[41] = new int[]{29, 40};
        connections[42] = new int[]{41};
        connections[43] = new int[]{31,42};
        connections[44] = new int[]{43};
        connections[45] = new int[]{33,44};
        connections[46] = new int[]{45};
        connections[47] = new int[]{35, 46};
        connections[48] = new int[]{47};
        connections[49] = new int[0];
        connections[50] = new int[]{36,49};
        connections[51] = new int[]{50};
        connections[52] = new int[]{38,51};
        connections[53] = new int[]{52};
        connections[54] = new int[]{40,53};
        connections[55] = new int[]{54};
        connections[56] = new int[]{42,55};
        connections[57] = new int[]{56};
        connections[58] = new int[]{44,57};
        connections[59] = new int[]{58};
        connections[60] = new int[]{46,59};
        connections[61] = new int[]{60};
        connections[62] = new int[]{48,61};
        connections[63] = new int[]{62};

    }
}