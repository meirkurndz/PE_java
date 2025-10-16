package com.Package;

public class Problem961 {

    boolean[] white_win = new boolean[262144];
    boolean[] black_win = new boolean[262144];
    long[] pows = new long[19];
    public void run(){
        setPows();
        search();
        long count = 0 ;
        for(int i = 0 ; i < white_win.length; i++){
            if (white_win[i]){
                //System.out.println(i + " , " + Integer.toBinaryString(i) + " , " +Integer.bitCount(i));
                count +=  pows[Integer.bitCount(i)];
            }
        }
        System.out.println("the answer = " + count);

    }

    public void search(){
        white_win[1] = true;
        black_win[1] = true;

        for(int i = 2; i < white_win.length; i++){
            boolean is_w_win = false;
            boolean is_b_win = false;
            String str = Integer.toBinaryString(i);
            //System.out.println(str);
            int len = str.length();
            for(int c = 0; c < len; c++){
                int temp = Integer.parseInt(str.substring(0,c)+str.substring(c+1),2);
                if (!black_win[temp]){
                    is_w_win = true;
                }
                if (!white_win[temp]){
                    is_b_win = true;
                }
            }
            white_win[i] = is_w_win;
            black_win[i] = is_b_win;
        }
    }

    public void setPows(){
        pows[0] = 1;
        for(int i = 1; i < pows.length; i++){
            pows[i] = pows[i-1]*9L;
        }
    }


}
