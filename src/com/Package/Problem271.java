package com.Package;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Problem271 { //4617456485273129588
                          //4855354787860356780
    static long x;
    static long y;
    int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43};
    int[][] mods = new int[44][44];

    public void run(){
        long t1 = System.currentTimeMillis();
        set_mods();
        System.out.println("the answer = " + solve());
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long solve(){
        ArrayList<Long> sol = new ArrayList<>();
        HashSet<Long> contane = new HashSet<>();
        long curr = 2;
        sol.add(1L);
        for(int i = 1; i < primes.length; i++){
           int p = primes[i];
           ArrayList<Long> next = new ArrayList<>();
           int size = sol.size();
           for(int a = 0; a < size; a++){
               long temp = sol.get(a);
               for(int k : mods[p]){
                   if (k == 0)break;
                   next.add(CRT(temp,curr,k,p));
               }
           }
           sol.clear();
           sol.addAll(next);
           curr *= p;
        }
        long sum = 0;
        int s = sol.size();
        for(int i = 1; i < sol.size();i++){
            long I = sol.get(i);
            sum += I;
            /*for(int j = i+1; j < sol.size(); j++){
                if(I == sol.get(j))sol.remove(j);
            }*/
        }
        return sum;
    }

    public long CRT(long a1, long m1, long a2, long m2){
        BigInteger ta1 = BigInteger.valueOf(a1);
        BigInteger ta2 = BigInteger.valueOf(a2);
        BigInteger tm1 = BigInteger.valueOf(m1);
        BigInteger tm2 = BigInteger.valueOf(m2);
        BigInteger tI1 = BigInteger.valueOf(mod_invers(m2,m1));
        BigInteger tI2 = BigInteger.valueOf(mod_invers(m1,m2));
        BigInteger ret1 = ta1.multiply(tm2).multiply(tI1);
        BigInteger ret2 = ta2.multiply(tm1).multiply(tI2);
        BigInteger ret = (ret1.add(ret2)).mod(BigInteger.valueOf(m1*m2));
        return Long.parseLong(ret.toString());
    }
    /*public long mod_invers(long a, long m){
        //return gcdExtended(a,m);
        long invers = 0;
        for(long i = 1; i < m; i++){
            invers += a;
            if(invers % m == 1){
                return i;
            }
        }
        return 0;
    }*/

    public void set_mods(){
        for(int i = 1; i < mods.length; i++){
            int count = 0;
            for(int j = 1; j < i; j++){
                if(j*j*j % i == 1){
                    mods[i][count] = j;
                    count++;
                }
            }
        }
    }

    static long gcdExtended(long a, long b, long[] x, long[] y) {

        // Base Case
        if (a == 0) {
            x[0] = 0;
            y[0] = 1;
            return b;
        }

        long[] x1 = {0}, y1 = {0};
        long gcd = gcdExtended(b % a, a, x1, y1);

        // Update x and y using results of
        // recursive call
        x[0] = y1[0] - (b / a) * x1[0];
        y[0] = x1[0];
        return gcd;
    }

    static long mod_invers(long a, long b) {
        long[] x = {1}, y = {1};
        gcdExtended(a, b, x, y);
        while (x[0]<0){
             x[0] += b;
        }
        return x[0];
    }


}
