package com.Package;

import java.util.HashSet;
import java.util.Hashtable;

public class Problem295 {

    static final long LIMIT = 10;

    public void run(){
        long t1 = System.currentTimeMillis();
        HashSet<Long> doub = new HashSet<>();
        int[] countHoles = new int[100000];
        long ans = 0;

        for(long a = 0; a < LIMIT; a++){
            for(long b = a; a*a + b*b < LIMIT*LIMIT;b++){

                double c1 = Math.sqrt(b*b - 2*a - 1);
                double c2 = Math.sqrt(a*a - 2*b - 1);

                if (c1 == (int)c1){
                    int hole = (int)Math.abs(b-(int) c1);
                    long sum = a*a + b*b;
                    countHoles[hole]++;
                    System.out.println("sum = " + sum +" , (" + a + "," + b + ")" + " , ("+ (a+1) + "," + (int)c1 + ") , lenticular hole = " + hole);
                    if (doub.contains(sum)){
                        ans--;
                    }else{
                        doub.add(sum);
                    }
                }
                if (c2 == (int)c2){
                    //if (a == b+1 && b == (int)c2)
                      //  continue;
                    int hole = (int)Math.abs(a-(int)c2);
                    long sum = a*a + b*b;
                    countHoles[hole]++;
                    System.out.println("sum = " + sum +" , (" + a + "," + b + ")" + " , ("+ (b+1) + "," + (int)c2 + ") , lenticular hole = " + hole);
                    if (doub.contains(sum)){
                        ans--;
                    }else{
                        doub.add(sum);
                    }
                }
            }
        }

        for(int i = 0; i < countHoles.length; i++){
            //System.out.println(i + " = " + countHoles[i]);
            ans += (countHoles[i] * (countHoles[i]+1))/2;
        }

        System.out.println("the answer = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }
}
