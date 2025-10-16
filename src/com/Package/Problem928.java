package com.Package;

public class Problem928 {
    //81108001093
    static final int CARD_TYPE = 14;
    int[][] choose = new int[5][5];

    public void run(){
        setChoose();
        long answer = 0;
        //int[] hand = {0,2,2,0,2,0,0,0,0,0,0,0,0,0};
        //System.out.println(cribbge_score(hand));
        for(int a = 0; a < 5; a++){
            for(int b = 0; b < 5; b++){
                for(int c = 0; c < 5; c++){
                    for(int d = 0; d < 5; d++){
                        for(int e = 0; e < 5; e++){
                            for(int f = 0; f < 5; f++){
                                for(int g = 0; g < 5; g++){
                                    for(int h = 0; h < 5; h++){
                                        for(int i = 0; i < 5; i++){
                                            for(int j = 0; j < 5; j++){
                                                for(int k = 0; k < 5; k++){
                                                    for(int l = 0; l < 5; l++){
                                                        for(int m = 0; m < 5; m++){
                                                            int[] hand = {0,a,b,c,d,e,f,g,h,i,j,k,l,m};

                                                            int hand_s = hand_score(hand);
                                                            int crib_s = cribbge_score(hand);
                                                            if (hand_s==crib_s) {
                                                                /*System.out.print("{");
                                                                for(int card = 1; card < 13; card++){
                                                                    System.out.print(hand[card] + ",");
                                                                }*/
                                                                int mul = mul(hand);
                                                                //System.out.println(hand[13] + "} " + hand_s + " , " + crib_s + " , mul = " + mul);
                                                                answer += mul;
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
        System.out.println("the answer = " + (answer-1));
    }

    public int mul(int[] hand){
        int score = 1;
        for(int i = 0; i < hand.length; i++){
            score *= choose[4][hand[i]];
        }
        return score;
    }

    public int cribbge_score(int[] hand){
        int score = 0;
        for(int i = 1; i < hand.length; i++){
            if (hand[i] > 1) {
                //pairs:
                //System.out.println(hand[i] + " = " + choose[hand[i]][2]);
                score += 2 * choose[hand[i]][2];
            }
        }
        //System.out.println("p = " + score);
        //15s':
        int c_15 = count_15(hand);
        //System.out.println("15 = " + c_15);
        score += 2 * c_15;
        //runs:
        int r = runs(hand);
        //System.out.println("r = " + r);
        score += r;

        return score;
    }

    public int hand_score(int[] hand){
        int score = 0;
        for(int i = 1; i < CARD_TYPE; i++){
            score += hand[i]*Math.min(i,10);
        }
        return score;
    }

    public int runs(int[] hand){
        int score = 0;
        int zero_1 = 0;
        int zero_2 = 1;
        while (zero_2 < 13){
            int run_s = 1;
            while (hand[zero_2] != 0){
                run_s *= hand[zero_2];
                zero_2++;
                if (zero_2 == 14)break;
            }
            if (zero_2-zero_1 > 3){
                //System.out.println("run_s = " + run_s);
                //System.out.println(zero_1 + "," + zero_2);
                score += (zero_2-zero_1-1) * run_s;
            }
            zero_1 = zero_2;
            zero_2++;
        }
        return score;
    }

    public int count_15(int[] hand){
        int[] sums = new int[16];
        sums[0] = 1;
        for(int i = hand.length-1; i > 0; i--){
            int[] to_add = new int[sums.length];
            for(int j = 1; j <= hand[i]; j++){
                int val = j*Math.min(i,10);

                //System.out.println("val = " + val);
                for(int t = sums.length-1; t > 0; t--){
                    if (t-val >= 0) {
                        //System.out.println("adding " + sums[t - val]);
                        to_add[t] += sums[t - val] * choose[hand[i]][j];
                    }
                }
            }
            for(int p = 0; p < sums.length; p++){
                sums[p] += to_add[p];
                //System.out.println(p + " = " + sums[p]);
            }
        }
        return sums[15];

    }

    public void setChoose(){
        choose[0][0] = 1;
        choose[1][0] = 1;
        choose[1][1] = 1;
        choose[1][2] = 0;
        choose[2][0] = 1;
        choose[2][1] = 2;
        choose[2][2] = 1;
        choose[3][0] = 1;
        choose[3][1] = 3;
        choose[3][2] = 3;
        choose[3][3] = 1;
        choose[4][0] = 1;
        choose[4][1] = 4;
        choose[4][2] = 6;
        choose[4][3] = 4;
        choose[4][4] = 1;

    }
}
