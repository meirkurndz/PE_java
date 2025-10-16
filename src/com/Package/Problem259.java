package com.Package;

import java.util.Arrays;

public class Problem259 {

    static long sum = 0;
    static Frac[] numbers = new Frac[9];
    public void run(){
        long tm1 = System.currentTimeMillis();
        long sum = 0;
        setNumbers();
        Frac[] ans = rec(0,8);
        int size = ans.length;
        for(int i = 0; i < size; i++){
            Frac temp = ans[i];
            if(temp._denum == 1 && temp._num > 0){
                //System.out.println(temp._num);
                sum += temp._num;
            }
        }
        long tm2 = System.currentTimeMillis();
        System.out.println("the answer = " +sum);
        System.out.println("found in " + (tm2 - tm1) + "ms");
    }

    public Frac[] rec(int low, int high){

        if(low == high){
            Frac[] ret = new Frac[1];
            ret[0] = numbers[low];
            return ret;
        }
        //System.out.println(low + "," + high);
        Frac[][][] ret = new Frac[high-low][2][];
        int index_all = 0;
        int concat = numbers[low]._num;
        int mul = 10;
        for(int i = low+1; i <= high; i++){
            concat *= mul;
            concat += numbers[i]._num;
        }
        Frac con = new Frac(concat,1);

        for(int i = 0; i < high-low; i++) {
            ret[i][0] = rec(low, low + i);
            ret[i][1] = rec(low + i + 1, high);
            index_all += ret[i][0].length*ret[i][1].length*4;
        }
        Frac[] ans = new Frac[index_all+1];
        int index = 0;
        for(int k = 0; k < high-low; k++){
            for(int l = 0;l < ret[k][0].length; l++){
                for(int r = 0; r < ret[k][1].length; r++) {
                    Frac[] temps = new Frac[4];
                    temps[0] = ret[k][0][l].add(ret[k][1][r]);
                    temps[1] = ret[k][0][l].sub(ret[k][1][r]);
                    temps[2] = ret[k][0][l].mul(ret[k][1][r]);
                    temps[3] = ret[k][0][l].div(ret[k][1][r]);
                    int len = 4;
                    if (temps[3]._denum != 0) {
                        temps[3].red();
                    } else {
                        temps[3] = temps[0];
                    }
                    for (int t = 0; t < len; t++) {
                        ans[index] = temps[t];
                        index++;
                    }
                }
            }
        }
        ans[ans.length-1] = con;
        Arrays.sort(ans);
        ans = Frac.uniqueSorted(ans);
        return ans;
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

    public void setNumbers(){
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = new Frac(i+1,1);
        }
    }



}
