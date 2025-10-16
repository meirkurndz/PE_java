package com.Package;

import java.math.BigInteger;

public class Problem369 {

    int[][] cards = new int[52][2];
    BigInteger[][] ncr = new BigInteger[52][52];

    public void run(){
        set_card();
        setChoose();
        BigInteger count = BigInteger.ZERO;
        for(int a = 0; a < cards.length; a++){
            System.out.println(get_card(cards[a][0],cards[a][1]));
            for(int b = a+1; b < cards.length; b++){
                for(int c = b+1; c < cards.length; c++){
                    for(int d = c+1; d < cards.length; d++){
                        for(int e = d+1; e < cards.length; e++){
                            System.out.println(get_card(cards[e][0],cards[e][1]));
                            int[][] hand5 = {cards[a],cards[b],cards[c],cards[d],cards[e]};
                            if (check_hand(hand5)){
                                //count = count.add(BigInteger.ONE);
                                count = count.add(ncr[52-e-1][8]);
                                continue;
                            }
                            for(int f = e+1; f < cards.length; f++) {
                                int[][] hand6 = {cards[a],cards[b],cards[c],cards[d],cards[e],cards[f]};
                                if (check_hand(hand6)){
                                    //count = count.add(BigInteger.ONE);
                                    count = count.add(ncr[52-f-1][7]);
                                    continue;
                                }
                                for (int g = f + 1; g < cards.length; g++) {
                                    int[][] hand7 = {cards[a],cards[b],cards[c],cards[d],
                                                     cards[e],cards[f],cards[g]};
                                    if (check_hand(hand7)){
                                        //count = count.add(BigInteger.ONE);
                                        count = count.add(ncr[52-g-1][6]);
                                        continue;
                                    }
                                    for (int h = g + 1; h < cards.length; h++) {
                                        //System.out.println(8 + " = " + get_card(cards[h][0],cards[h][1]));
                                        int[][] hand8 = {cards[a],cards[b],cards[c],cards[d],
                                                cards[e],cards[f],cards[g],cards[h]};
                                        if (check_hand(hand8)){
                                            //count = count.add(BigInteger.ONE);
                                            count = count.add(ncr[52-h-1][5]);
                                            continue;
                                        }
                                        for (int i = h + 1; i < cards.length; i++) {
                                            int[][] hand9 = {cards[a],cards[b],cards[c],cards[d],
                                                    cards[e],cards[f],cards[g],cards[h],cards[i]};
                                            if (check_hand(hand9)){
                                                //count = count.add(BigInteger.ONE);
                                                count = count.add(ncr[52-i-1][4]);
                                                continue;
                                            }
                                            for (int j = i + 1; j < cards.length; j++) {
                                                //System.out.println(get_card(cards[j][0],cards[j][1]));
                                                int[][] hand10 = {cards[a],cards[b],cards[c],cards[d],
                                                        cards[e],cards[f],cards[g],cards[h],cards[i],
                                                        cards[j]};
                                                if (check_hand(hand10)){
                                                    //count = count.add(BigInteger.ONE);
                                                    count = count.add(ncr[52-j-1][3]);
                                                    continue;
                                                }
                                                for (int k = j + 1; k < cards.length; k++) {
                                                    int[][] hand11 = {cards[a],cards[b],cards[c],cards[d],
                                                            cards[e],cards[f],cards[g],cards[h],cards[i],
                                                            cards[j],cards[k]};
                                                    if (check_hand(hand11)){
                                                        //count = count.add(BigInteger.ONE);
                                                        count = count.add(ncr[52-k-1][2]);
                                                        continue;
                                                    }
                                                    for (int l = k + 1; l < cards.length; l++) {
                                                        int[][] hand12 = {cards[a],cards[b],cards[c],cards[d],
                                                                cards[e],cards[f],cards[g],cards[h],cards[i],
                                                                cards[j],cards[k],cards[l]};
                                                        if (check_hand(hand12)){
                                                            //count = count.add(BigInteger.ONE);
                                                            count = count.add(ncr[52-l-1][1]);
                                                            continue;
                                                        }
                                                        for (int m = l + 1; m < cards.length; m++) {
                                                            int[][] hand13 = {cards[a],cards[b],cards[c],cards[d],
                                                                    cards[e],cards[f],cards[g],cards[h],cards[i],
                                                                    cards[j],cards[k],cards[l],cards[m]};
                                                            if (check_hand(hand13)){
                                                                count = count.add(BigInteger.ONE);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public boolean check_hand(int[][] hand){
        for (int c1 = 0; c1 < hand.length; c1++){
            for (int c2 = c1+1; c2 < hand.length; c2++){
                for (int c3 = c2+1; c3 < hand.length; c3++){
                    for (int c4 = c3+1; c4 < hand.length; c4++){
                        if (hand[c1][0] != hand[c2][0] &&
                            hand[c1][0] != hand[c3][0] &&
                            hand[c1][0] != hand[c4][0] &&
                            hand[c2][0] != hand[c3][0] &&
                            hand[c2][0] != hand[c4][0] &&
                            hand[c3][0] != hand[c4][0] &&
                                hand[c1][1] != hand[c2][1] &&
                                hand[c1][1] != hand[c3][1] &&
                                hand[c1][1] != hand[c4][1] &&
                                hand[c2][1] != hand[c3][1] &&
                                hand[c2][1] != hand[c4][1] &&
                                hand[c3][1] != hand[c4][1]){
                            /*System.out.println("[" + get_card(hand[c1][0],hand[c1][1]) + ","
                                                   + get_card(hand[c2][0],hand[c2][1]) + ","
                                                   + get_card(hand[c3][0],hand[c3][1]) + ","
                                                   + get_card(hand[c4][0],hand[c4][1]) + "]");*/
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    public String get_card(int rank, int shape){
        String card = "";
        switch (rank){
            case 1:
                card = card + "A";
                break;
            case 10:
                card = card + "T";
                break;
            case 11:
                card = card + "J";
                break;
            case 12:
                card = card + "Q";
                break;
            case 13:
                card = card + "K";
                break;
            default:
                card = card + rank;
        }
        switch (shape){
            case 0:
                card = card + "S";
                break;
            case 1:
                card = card + "H";
                break;
            case 2:
                card = card + "D";
                break;
            case 3:
                card = card + "C";
                break;
        }
        return card;
    }

    public void set_card(){
       int index = 0;
       for(int shape = 0; shape < 4; shape++){
           for(int rank = 1; rank < 14; rank++){
               cards[index][0] = rank;
               cards[index][1] = shape;
               index++;
           }
       }
    }

    public void setChoose(){
        for (int i = 0; i < ncr.length; i++){
            for(int j = 0; j < ncr[i].length; j++){
                ncr[i][j] = new BigInteger("0");

            }
        }
        for (int i = 0; i < ncr.length; i++){
            for(int j = 0; j <= i; j++){
                ncr[i][j] = choose(i,j);
                //System.out.println(ncr[i][j]);
            }
        }

    }

    public BigInteger choose(long n, long k){
        if (n==0 ||n == k || k == 0) return BigInteger.valueOf(1);
        if (k == 1) return BigInteger.valueOf(n);
        if (k > n/2)
            return choose(n,n-k);
        long temp = n-k;
        BigInteger answer = BigInteger.valueOf(1);
        for(long i = n; i > temp; i--){
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        return answer.divide(factorial(k));
    }

    public BigInteger factorial(long number){
        BigInteger ans = new BigInteger("1");
        for(int i = 1; i <= number; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
    /**
     *
     *
     * AS, 2S, 3S, 4S, 5S, 6S, 7S, 8S, 9S, 10S, JS, QS, KS
     * AH, 2H, 3H, 4H, 5H, 6H, 7H, 8H, 9H, 10H, JH, QH, KH
     * AD, 2D, 3D, 4D, 5D, 6D, 7D, 8D, 9D, 10D, JD, QD, KD
     * AC, 2C, 3C, 4S, 5C, 6C, 7C, 8C, 9C, 10C, JC, QC, KC
     *
     *
     *
     *   2H, 3H, 4H, 5H, 6H, 7H, 8H, 9H, 10H, JH, QH, KH
     *   2D, 3D, 4D, 5D, 6D, 7D, 8D, 9D, 10D, JD, QD, KD
     *   2C, 3C, 4S, 5C, 6C, 7C, 8C, 9C, 10C, JC, QC, KC
     *
     *
     *
     *    3D, 4D, 5D, 6D, 7D, 8D, 9D, 10D, JD, QD, KD
     *    3C, 4S, 5C, 6C, 7C, 8C, 9C, 10C, JC, QC, KC
     *
     *    4S, 5C, 6C, 7C, 8C, 9C, 10C, JC, QC, KC
     *
     */

}
