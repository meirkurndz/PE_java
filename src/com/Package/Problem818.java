package com.Package;

public class Problem818 {

    int[][] cards = new int[81][4];
    boolean[][][] isSets = new boolean[81][81][81];

    public void run(){
        setCards();
        setIsSets();
        int[] numOfSets = new int[4];

        long sum = 0;
        for(int i = 0; i < cards.length; i++){
            for(int j = i+1; j < cards.length; j++){
                for(int k = j+1; k < cards.length; k++){
                    for(int l = k+1; l < cards.length; l++){
                        for(int m = l+1; m < cards.length; m++){
                            for(int n = m+1; n < cards.length; n++){
                                int[] temp = new int[]{i,j,k,l,m,n};
                                int count = countSets(temp);
                                numOfSets[count]++;
                                System.out.println(i + ", " + j + ", " + k + ", " + l + ", " + m + ", " + n + " = " + count);
                                sum += Math.pow(count, 4);
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < numOfSets.length; i++){
            System.out.println(i + " , " + numOfSets[i]);
        }
        System.out.println("the answer = " + sum);
    }

    public int countSets(int[] six){
        int count = 0;
        for(int i = 0; i < six.length; i++){
            for(int j = i+1; j < six.length; j++){
                for(int k = j+1; k < six.length; k++){
                    if (isSets[six[i]][six[j]][six[k]]) {
                        //display(i,j,k);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isNonSet(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length; k++){
                    if (isSets[arr[i]][arr[j]][arr[k]]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void display(int card1, int card2, int card3){
        System.out.println("set: " + card1 + ", " + card2 + ", " + card3);
        for(int i = 0; i < cards[card1].length; i++){
            System.out.print(cards[card1][i] + ", ");
        }
        System.out.println();

        for(int j = 0; j < cards[card2].length; j++){
            System.out.print(cards[card2][j] + ", ");
        }
        System.out.println();

        for(int k = 0; k < cards[card3].length; k++){
            System.out.print(cards[card3][k] + ", ");
        }
        System.out.println("\n");
    }

    private boolean isSet(int[] card1, int[] card2, int[] card3){
        boolean isSet = true;
        for(int i = 0; i < 4; i++){
            if (!(card1[i] == card2[i] && card1[i] == card3[i]) &&
                !(card1[i] != card2[i] && card1[i] != card3[i] && card2[i] != card3[i])) {
                isSet = false;
                break;
            }
        }
        return isSet;
    }

    public void setIsSets(){

        for(int i = 0; i < isSets.length; i++){
            for(int j = 0; j < isSets.length; j++){
                for(int k = 0; k < isSets.length; k++){
                    isSets[i][j][k] = false;
                    if (isSet(cards[i], cards[j], cards[k])){
                        isSets[i][j][k] = true;
                    }
                }
            }
        }
    }

    private void setCards(){
        int cardNum = 0;
        for(int num = 1; num <= 3; num++){
            for(int color = 1; color <= 3; color++){
                for(int shape = 1; shape <= 3; shape++){
                    for(int shade = 1; shade <= 3; shade++){
                        cards[cardNum][0] = num;
                        cards[cardNum][1] = color;
                        cards[cardNum][2] = shape;
                        cards[cardNum][3] = shade;
                        cardNum++;
                    }
                }
            }
        }
    }

}