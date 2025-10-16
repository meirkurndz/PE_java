package com.Package;

import java.util.Arrays;

public class Problem155 {

    Frac[][] D = new Frac[19][];
    public void run(){
        long t1 = System.currentTimeMillis();
        D[1] = new Frac[1];
        D[1][0] = new Frac(60,1);
        rec();
        System.out.println("the answer = " + D[18].length);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void rec(){
        for(int i = 2; i < D.length; i++){
            int length = 0;
            int index = 0;
            for(int k = 1; k*2 <= i; k++){
                length += D[k].length*D[i-k].length*4;
            }
            D[i] = new Frac[length];
            Frac one = new Frac(1,1);
            for(int k = 1; k*2 <= i; k++){
                for(int l = 0; l < D[k].length; l++){
                    for(int r = 0; r < D[i-k].length; r++){
                        D[i][index++] = D[k][l].add(D[i-k][r]);
                        Frac temp = one.div(D[k][l]).add(one.div(D[i-k][r]));
                        D[i][index++] = one.div(temp);
                        D[i][index++] = D[k][l];
                        D[i][index++] = D[i-k][r];
                    }
                }
            }
            Arrays.sort(D[i]);
            D[i] = Frac.uniqueSorted(D[i]);
            /*for(int j = 0; j < D[i].length; j++){
                D[i][j].print();
                System.out.print(", ");
            }*/
            //System.out.println(i);
        }
    }
}
