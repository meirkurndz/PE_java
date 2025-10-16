package com.Package;

public class Problem109 {

    String[] turns =   {"S1 ","S2 ","S3 ","S4 ","S5 ","S6 ","S7 ","S8 ","S9 ",
                        "S10 ","S11 ","S12 ","S13 ","S14 ","S15 ","S16 ","S17 ","S18 ","S19 ","S20 ","S25 ",
                        "D1 ","D2 ","D3 ","D4 ","D5 ","D6 ","D7 ","D8 ","D9 ",
                        "D10 ","D11 ","D12 ","D13 ","D14 ","D15 ","D16 ","D17 ","D18 ","D19 ","D20 ","D25 ",
                        "T1 ","T2 ","T3 ","T4 ","T5 ","T6 ","T7 ","T8 ","T9 ",
                        "T10 ","T11 ","T12 ","T13 ","T14 ","T15 ","T16 ","T17 ","T18 ","T19 ","T20 "};

    int[] scores =     {1,2,3,4,5,6,7,8,9,10,
                        11,12,13,14,15,16,17,18,19,20,25,
                        2,4,6,8,10,12,14,16,18,20,
                        22,24,26,28,30,32,34,36,38,40,50,
                        3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,
                        48,51,54,57,60};

    public void run(){
        int count = 0;
        for(int total = 2; total < 100; total++){
            count += count(total,0,0,"");
        }
        System.out.println("the answer = " + count);
    }

    public int count(int total, int turn, int lastTurn, String str) {
        int count = 0;
        if(total == 0){
            return 1;
        }else if(turn == 3){
            return 0;
        }else{
            for(int i = 0; i < turns.length; i++){
                int score = scores[i];
                if (total == score){
                    if(i < 42 && i > 20){
                        count += count(0,turn + 1,i,str + turns[i]);
                    }
                }else if(i >= lastTurn){
                    count += count(total - score,turn + 1,i,str + turns[i]);
                }
            }
        }
        return count;
    }
}
