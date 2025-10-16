package com.Package;

public class Problem679 {
    //[words][last4letters][strLength]
    long[][][] memo = new long[16][65536][30];

    public void run(){
        long time1 = System.currentTimeMillis();
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[i].length; j++){
                for(int k = 0; k < memo[i][j].length; k++){
                    memo[i][j][k] = -1;
                }
            }
        }

        System.out.println("the answer = " + build("", 30, false, false, false, false));
        long time2 = System.currentTimeMillis();
        System.out.println("found in: " + (time2-time1) + "ms");
    }

    public long build(String str, int length, boolean isFree, boolean isFare, boolean isArea, boolean isReef){

        if (length == 0){
            if (isArea && isFare && isFree && isReef) {
                //we found a string
                return 1;
            }
            return 0;
        }


        int hashWords = -1;
        int hashLast2 = -1;

        if(length < 26) {
            hashLast2 = hashLast4(str);
            hashWords = hashWords(isFree, isFare, isArea, isReef);

            //check for memo:
            if (memo[hashWords][hashLast2][length] != -1) {
                return memo[hashWords][hashLast2][length];
            }
        }

        String last3;
        if (str.length() >= 3) {
            last3 = str.substring(str.length() - 3);
        }else{
            last3 = str;
        }

        long count = 0;

        String temp1 = last3 + "A";
        String temp2 = last3 + "E";
        String temp3 = last3 + "F";

        if (temp1.equals("AREA")){
            if (!isArea){
                count += build(str + "A", length -1, isFree, isFare, true, isReef);
            }
        }else{
            count += build(str + "A", length -1, isFree, isFare, isArea, isReef);
        }
        if (temp2.equals("FREE")){
            if (!isFree){
                count += build(str + "E", length -1, true, isFare, isArea, isReef);
            }
        }else if (temp2.equals("FARE")){
            if (!isFare){
                count += build(str + "E", length -1, isFree, true, isArea, isReef);
            }
        }else{
            count += build(str + "E", length -1, isFree, isFare, isArea, isReef);
        }
        if (temp3.equals("REEF")){
            if (!isReef){
                count += build(str + "F", length -1, isFree, isFare, isArea, true);
            }
        }else{
            count += build(str+"F", length -1, isFree, isFare, isArea, isReef);
        }
        count += build(str + "R", length -1, isFree, isFare, isArea, isReef);
        if(hashLast2 != -1)
            //storing the count:
            memo[hashWords][hashLast2][length] = count;
        return count;
    }

    public int hashWords(boolean isFree, boolean isFare, boolean isArea, boolean isReef){
        int hash = 0;
        if(isFree) hash += 8;
        if(isFare) hash += 4;
        if (isArea) hash += 2;
        if (isReef)hash += 1;
        return hash;
    }

    public int hashLast4(String str){
        int hash = 0;
        char l1 = str.charAt(str.length()-4);
        char l2 = str.charAt(str.length()-3);
        char l3 = str.charAt(str.length()-2);
        char l4 = str.charAt(str.length()-1);

        switch (l1){
            case 'A':
                hash += 1;
                break;
            case 'E':
                hash += 2;
                break;
            case 'F':
                hash += 4;
                break;
            case 'R':
                hash += 8;
                break;
        }

        switch (l2){
            case 'A':
                hash += 16;
                break;
            case 'E':
                hash += 32;
                break;
            case 'F':
                hash += 64;
                break;
            case 'R':
                hash += 128;
                break;
        }

        switch (l3){
            case 'A':
                hash += 256;
                break;
            case 'E':
                hash += 512;
                break;
            case 'F':
                hash += 1024;
                break;
            case 'R':
                hash += 2048;
                break;
        }

        switch (l4){
            case 'A':
                hash += 4096;
                break;
            case 'E':
                hash += 8192;
                break;
            case 'F':
                hash += 16384;
                break;
            case 'R':
                hash += 32768;
                break;
        }
        return hash;
    }
}
