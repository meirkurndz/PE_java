package com.Package;

import java.util.Random;

public class Problem84 {


    public int ccQ = 0;
    public int chQ = 0;
    int[] ccCards = {0,10};
    int[] chCards = {5,10,11,24,39};
    public int[] visitCounts = new int[40];

    public void play(){

        int currentCell = 0;

        int doubleCount = 0;

        for(int i = 0; i < 1000000; i++){

            int move = roll44();
            int dice1 = move % 10;
            int dice2 = move / 10;

            //System.out.println("roll = " + dice1 + " , " + dice2);

            if (dice1 == dice2){
                doubleCount++;

                //System.out.println("double count = " + doubleCount);

            } else {
                doubleCount = 0;
            }

            if(doubleCount == 3){
                currentCell = 10;
                visitCounts[currentCell]++;

                //System.out.println("current cell is " + currentCell);

                continue;
            }

            int tempCell = (currentCell + (dice1 + dice2)) % 40;

            switch (tempCell){
                case 2 :
                case 17:
                case 33:
                    currentCell = ccCard(tempCell);
                    //System.out.println("community card " + currentCell);
                    ccQ = (ccQ + 1) % 16;
                    break;
                case 7:
                case 22:
                case 36:
                    currentCell = chCard(tempCell);
                    //System.out.println("chance card " + currentCell);
                    chQ = (chQ + 1) % 16;
                    break;
                case 30:
                    currentCell = 10; // G2J cell
                    break;
                default:
                    currentCell = tempCell;
                    break;
            }
            //System.out.println("final cell is " + currentCell);
            //System.out.println();
            visitCounts[currentCell]++;
        }

        int big = 0;
        int second = 0;
        int therd = 0;

        for(int i = 0; i < 40;i++){

            if(visitCounts[i] > visitCounts[big]){
                therd = second;
                second = big;
                big = i;
                //System.out.println(big + " , " + second + " , " + therd);
                continue;
            }else if (visitCounts[i] > visitCounts[second]){
                therd = second;
                second = i;
                continue;
            }else if (visitCounts[i] > visitCounts[therd]){
                therd = i;
            }

        }
        System.out.println(big + "" + second + "" + therd);
    }

    public int ccCard(int currentCell){
        if(ccQ <= 1){
            return ccCards[ccQ];
        }
        return currentCell;
    }

    public int chCard(int currentCell){

        if(chQ <= 4){
            return chCards[chQ];
        }

        if (chQ <= 6){
            switch (currentCell){
                case 7:
                    return 15;
                case 22:
                    return 25;
                case 36:
                    return 5;
            }
        }

        if(chQ <= 8){
            switch (currentCell){
                case 7:
                case 36:
                    return 12;
                case 22:
                    return 28;
            }
        }

        if(chQ == 10){
            if (currentCell == 36){
                ccQ++;
                return ccCard(33);
            }
            return currentCell - 3;
        }
        return currentCell;
    }

    public int roll66(){
        Random random = new Random();
        int cube1 = random.nextInt(6) + 1;
        int cube2 = random.nextInt(6) + 1;
        return cube1 + 10 * cube2;
    }

    public int roll44(){
        Random random = new Random();
        int cube1 = random.nextInt(4) + 1;
        int cube2 = random.nextInt(4) + 1;
        return cube1 + 10 * cube2;
    }

}
