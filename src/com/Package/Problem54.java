package com.Package;
import java.io.*;

public class Problem54 {

    // Poker hands

    public Problem54() throws IOException {

        File file = new File("C:\\Users\\מאיר קורניץ\\ProjectEuler\\src\\com\\Package\\p054_poker.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        int p1wins = 0;
        int lineNum = 1;
        String first;
        String second;
        String temp;

        while (( temp = br.readLine()) != null){
            //System.out.println("line number " + lineNum);
            first = temp.substring(0,15);
            second = temp.substring(15);
            int score1 = calcHand(proses(first));
            int score2 = calcHand(proses(second));
            //System.out.println("first score " + score1 + "  " + "second score " + score2);
            if(score1 > score2){
                p1wins++;
            }
            if (score1 == score2){
                p1wins += heighstCard(proses(first), proses(second), score1);
            }
            //System.out.println("number of wins " + p1wins);
            lineNum++;
        }

        System.out.println("number of wins " + p1wins);

    }

    public int[] proses(String str){

        int[] numbers = new int[19];

        for(int index = 0; index < 14; index += 3){
            switch (str.charAt(index)) {
                case '2':
                    numbers[2]++;
                    break;
                case '3':
                    numbers[3]++;
                    break;
                case '4':
                    numbers[4]++;
                    break;
                case '5':
                    numbers[5]++;
                    break;
                case '6':
                    numbers[6]++;
                    break;
                case '7':
                    numbers[7]++;
                    break;
                case '8':
                    numbers[8]++;
                    break;
                case '9':
                    numbers[9]++;
                    break;
                case 'T':
                    numbers[10]++;
                    break;
                case 'J':
                    numbers[11]++;
                    break;
                case 'Q':
                    numbers[12]++;
                    break;
                case 'K':
                    numbers[13]++;
                    break;
                case 'A':
                    numbers[14]++;
                    break;
            }
            switch (str.charAt(index + 1)){
                case 'S':
                    numbers[15]++;
                    break;
                case 'H':
                    numbers[16]++;
                    break;
                case 'D':
                    numbers[17]++;
                    break;
                case 'C':
                    numbers[18]++;
                    break;
            }
        }
        return numbers;
    }

    public int calcHand(int[] hand){

        boolean is5set = false;
        boolean isStraight = false;
        boolean isTriple = false;
        int nuOfPer = 0;
        int index = 0;
        for(int i = 15; i < 19; i++){
            if (hand[i] == 5){
                is5set = true;
            }
        }
        while (index < 15){
            switch (hand[index]){
                case 0:
                    break;
                case 1:
                    if (index < 11){
                        if (hand[index+1] == 1 &&
                            hand[index+2] == 1 &&
                            hand[index+3] == 1 &&
                            hand[index+4] == 1   ){
                            isStraight = true;

                            if(is5set) {
                                if(hand[14] == 1){
                                    //System.out.println("Royal Flush");
                                    return 10;
                                }else{
                                    //System.out.println("Straight Flush");
                                    return 9;
                                }
                            }else{
                                //System.out.println("Straight");
                                return 5;
                            }
                        }
                        break;
                    }else{
                        break;
                    }
                case 4:
                    //System.out.println("Four of a Kind");
                    return 8;
                case 3:
                    isTriple = true;
                    if (nuOfPer == 1){
                        //System.out.println("full house");
                        return 7;
                    }
                    break;
                case 2:
                    nuOfPer++;
                    if (nuOfPer == 2){
                        //System.out.println("Two Pairs");
                        return 3;
                    }else if (isTriple){
                        //System.out.println("full house");
                        return 7;
                    }
            }
            index++;
        }
        if (isTriple){
            //System.out.println("Three of a Kind");
            return 4;
        }
        if (nuOfPer == 1){
            //System.out.println("One Pair");
            return 2;
        }
        if (is5set){
            //System.out.println("Flush");
            return 6;
        }
        //System.out.println("High Card");
        return 1;
    }

    public int heighstCard(int[] firstHand, int[] secondHand, int score){

        if(score == 1 || score == 6 || score == 5 || score == 9) {
            for (int i = 14; i > 0; i--) {
                int temp1 = firstHand[i];
                int temp2 = secondHand[i];
                if (temp1 > temp2) {
                    //System.out.println("first win");
                    return 1;
                } else if (temp2 > temp1) {
                   // System.out.println("second win");
                    return 0;
                }
            }
        } else if (score == 2 || score == 3 ){
            int pos1 = findPosition(firstHand, score);
            int pos2 = findPosition(secondHand, score);
            if(pos1 > pos2){
                return 1;
            }else if(pos1 == pos2){
                return heighstCard(firstHand, secondHand, 1);
            }
        }else if(score == 4 || score == 8 || score == 7){
            if(findPosition(firstHand,score) > findPosition(secondHand,score)){
                return 1;
            }else{
                return 0;
            }
        }

        return 0;
    }

    public int findPosition(int[] hand, int score){

        if(score == 2){
            for(int i = 14; i > 0;i--){
                if(hand[i] == 2){
                    return i;
                }
            }
        }
        if (score == 3){
            int[] pers = new int[2];
            int index = 0;
            for(int i = 14; i > 0;i--){
                if(hand[i] == 2){
                    pers[index] = i;
                    index++;
                }
            }
            return (pers[0] * 10 + pers[1]);
        }
        if(score == 4 || score == 7){
            for(int i = 14; i > 0;i--){
                if(hand[i] == 3){
                    return i;
                }
            }
        }
        if (score == 8){
            for(int i = 14; i > 0;i--){
                if(hand[i] == 4){
                    return i;
                }
            }
        }

        return 0;
    }
}











