package com.Package;

import java.util.LinkedList;

public class Problem186 {

    LinkedList<Integer>[] grope = new LinkedList[1000000];
    long[] leader = new long[1000000];
    long[] seq = new long[100000000];
    static final int PRIME_MINISTER = 524287;
    static final long TARGET = 990000;

    public void run(){

        setLeader();
        genSeq();
        long PMFriends = 1;
        int call = 1;
        int count = 0;

        while (PMFriends < TARGET){

            long caller = getCaller(call);
            long called = getCalled(call);

            if (caller == called){
                call++;
                continue;
            }

            count++;
            call++;

            merge((int)caller, (int)called);

            //displayGrope((int)caller);

            PMFriends = countGrope(PRIME_MINISTER);
            //System.out.println(call + " , " + count + " , " + PMFriends);
        }

        System.out.println("the answer = " + count);
    }

    public void displayGrope(int caller){

        for(int i = 0; i < grope[caller].size(); i++){
            System.out.print(grope[caller].get(i) + " , ");
        }
        System.out.println();
    }

    public long countGrope(int number){

        int temp = (int)leader[number];
        if (grope[temp] != null) {
            return grope[temp].size();
        }
        return 1;
    }

    public long getCaller(int call){
        return seq[2 * call - 1];
    }

    public long getCalled(int call){
        return seq[2 * call];
    }

    public void merge(int g1, int g2){

        if (leader[g1] == leader[g2])
            return;

        int l1 = (int)leader[g1];
        int l2 = (int)leader[g2];

        if (grope[l1] == null){
            if (grope[l2] == null){
                //new list
                grope[l1] = new LinkedList<>();

                //adding
                grope[l1].add(g1);
                grope[l1].add(g2);

                //change leader
                leader[g2] = l1;
            }else{
                grope[l2].add(g1);
                leader[g1] = leader[g2];
            }
        }else{
            if (grope[l2] == null){
                grope[l1].add(g2);
                leader[g2] = leader[g1];
            }else{
                if (grope[l1].size() > grope[l2].size()){
                    //changing leaders:
                    for(int i = 0; i < grope[l2].size(); i++){
                        long get = grope[l2].get(i);
                        leader[(int)get] = leader[g1];
                    }

                    grope[l1].addAll(grope[l2]);
                    grope[l2] = null;
                }else{
                    //changing leaders:
                    for(int i = 0; i < grope[l1].size(); i++){
                        long get = grope[l1].get(i);
                        leader[(int)get] = leader[g2];
                    }

                    grope[l2].addAll(grope[l1]);
                    grope[l1] = null;
                }
            }
        }
    }

    public void setLeader(){
        for(int i = 0; i < leader.length; i++){
            leader[i] = i;
        }
    }

    public void genSeq(){
        //For 1 <= k <= 55, Sk = [100003 - 200003k + 300007k^3] (modulo 1000000).
        //For 56 <= k, seq[k] = (seq[k-24] + seq[k-55]) (modulo 1000000).

        for(long k = 1; k <= 55; k++){
            seq[(int)k] = (100003L - (200003L * k) % 1000000L + (300007L * (k * k * k))) % 1000000L;

        }

        for(int k = 56; k < seq.length; k++){
            seq[k] = (seq[k-24] + seq[k-55]) % 1000000;
        }
    }
}
