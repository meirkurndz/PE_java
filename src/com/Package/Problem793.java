package com.Package;

import javafx.css.PseudoClass;

import java.util.Arrays;

public class Problem793 {
    static final int LEN = 1000003;
    long[] sec = new long[LEN];

    public void run(){
        setSec();
        long med = ((long) LEN*((long) LEN-1))/4;
        //System.out.println(med);
        int high = sec.length-1;
        boolean flag = false;
        for(int low = 202968; low < sec.length; low++){
            if (flag)break;
            while (low<high){
                long pos = count(low,high);
                long curr = sec[low]*sec[high];
                //System.out.println("(" + low + "," + high + ") = " + pos + " = " + curr);
                if (pos==med){
                    //System.out.println("(" + low + "," + high + ") = " + pos + " = " + curr);
                    System.out.println("the answer = " + curr);
                    flag = true;
                    break;
                }
                if (pos > med){
                    high--;
                }else{
                    break;
                }
            }
        }

    }

    public long count(int low, int high){

        long med = sec[low]*sec[high];
        long c = 0;
        int l = 0;
        int h = sec.length-1;

        while (l<h){

            long temp = sec[l]*sec[h];
            //System.out.println(l + ", " + h + " = " + temp);
            if (temp >= med){
                h--;
            }else{
                c += h-l;
                l++;
            }
        }
        return c;
    }

    public void setSec(){
        sec[0] = 290797L;
        for(int i = 1; i < sec.length; i++){
            sec[i] = (sec[i-1] * sec[i-1]) % 50515093L;
        }
        Arrays.sort(sec);
    }


}
