package com.Package;

import java.util.Arrays;

public class Problem90 {

    public void run(){
        long time1 = System.currentTimeMillis();
        int count = 0;
        int numOfCom = 0;
        for(int i1 = 0; i1 < 10; i1++){
            for(int j1 = i1+1; j1 < 10; j1++){
                for(int k1 = j1+1; k1 < 10; k1++){
                    for(int l1 = k1+1; l1 < 10; l1++){
                        for(int m1 = l1+1; m1 < 10; m1++){
                            for(int n1 = m1+1; n1 < 10; n1++){

                                for(int i2 = 0; i2 < 10; i2++){
                                    for(int j2 = i2+1; j2 < 10; j2++){
                                        for(int k2 = j2+1; k2 < 10; k2++){
                                            for(int l2 = k2+1; l2 < 10; l2++){
                                                for(int m2 = l2+1; m2 < 10; m2++){
                                                    for(int n2 = m2+1; n2 < 10; n2++){
                                                        numOfCom++;
                                                        int[] d1 = {i1,j1,k1,l1,m1,n1};
                                                        int[] d2 = {i2,j2,k2,l2,m2,n2};
                                                        if (check(d1,d2)) {
                                                            //System.out.print("("+i1 + ","+j1 + ","+k1 + ","+l1 + ","+m1 + ","+n1 + "),");
                                                            //System.out.println("("+i2 + ","+j2 + ","+k2 + ","+l2 + ","+m2 + ","+n2 + ")");
                                                            count++;
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
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + (count/2));
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public boolean check(int[] d1, int[] d2){
        boolean[] bd1 = new boolean[10];
        boolean[] bd2 = new boolean[10];
        for(int i = 0; i < d1.length; i++){
            bd1[d1[i]] = true;
            bd2[d2[i]] = true;
        }
        if(bd1[6]) bd1[9] = true;
        else if(bd1[9]) bd1[6] = true;
        if(bd2[6]) bd2[9] = true;
        else if(bd2[9]) bd2[6] = true;

        if(! ((bd1[0]&&bd2[1]) || (bd2[0]&&bd1[1]))) {
            //System.out.println("miss 04");
            return false;
        }
        if(! ((bd1[0]&&bd2[4]) || (bd2[0]&&bd1[4]))) {
            //System.out.println("miss 04");
            return false;
        }
        if(! ((bd1[0] && bd2[9]) || (bd2[0] && bd1[9]) )) {
            //System.out.println("miss 09");
            return false;
        }
        if(! ((bd1[1]&&bd2[6]) || (bd2[1]&&bd1[6]))) {
            //System.out.println("miss 16");
            return false;
        }
        if(! ((bd1[2]&&bd2[5]) || (bd2[2]&&bd1[5]))) {
            //System.out.println("miss 25");
            return false;
        }
        if(! ((bd1[3]&&bd2[6]) || (bd2[3]&&bd1[6]))) {
            //System.out.println("miss 36");
            return false;
        }
        if(! ((bd1[4]&&bd2[9]) || (bd2[4]&&bd1[9]))) {
            //System.out.println("miss 49");
            return false;
        }
        if(! ( (bd1[6]&&bd2[4]) || (bd2[6]&&bd1[4]) ) ) {
            //System.out.println("miss 64");
            return false;
        }
        if(! ((bd1[8]&&bd2[1]) || (bd2[8]&&bd1[1]))) {
            //System.out.println("miss 81");
            return false;
        }
        return true;
    }
}
