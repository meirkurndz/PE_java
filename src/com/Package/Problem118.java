package com.Package;

import java.util.Arrays;

public class Problem118 {

    static int COUNT = 0;
    static final int LIMIT = 100000000;
    boolean[] isPanPrime = new boolean[LIMIT];
    int[] mask = new int[LIMIT];
    int[] digNum = new int[LIMIT];

    public void run(){
        long time1 = System.currentTimeMillis();
        panPGen();
        setMask();
        long ans = 0;
        ans += rec(2,2,1);
        ans += rec(0,1,0);

        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (time2-time1)/1000.0 + "s");
    }

    public int rec(int usedMask, int last, int digN){
        if(usedMask == 511){
            return 1;
        }else if (last==2){
            int count = 0;
            for(int i = last+1; i < isPanPrime.length && i < Math.pow(10,9-digN); i+=2){
                if (isPanPrime[i] && (usedMask & mask[i]) == 0){
                    count += rec(usedMask | mask[i], i, digN + digNum[i]);
                }
            }
            return count;
        }else{
            int count = 0;
            for(int i = last+2; i < isPanPrime.length && i < Math.pow(10,9-digN); i+=2){
                if (isPanPrime[i] && (usedMask & mask[i]) == 0){
                    count += rec(usedMask | mask[i],i, digN + digNum[i]);
                }
            }
            return count;
        }
    }

    public void setMask(){
        for(int i = 0; i < mask.length; i++){
            if (isPanPrime[i]) {
                mask[i] = genMask(i);
                digNum[i] = digNum(i);
            }
        }
    }

    public int digNum(long number){
        int digNum = 0;
        while (number != 0) {
            digNum++;
            number /= 10;
        }
        return digNum;
    }

    public int genMask(int number){
        int mask = 0;
        while (number > 0){
            int dig = number % 10;
            mask += Math.pow(2,dig-1);
            number /= 10;
        }
        return mask;
    }

    public void panPGen() {
        //prime number generator
        Arrays.fill(isPanPrime, true);
        for (int p = 2; p * p <= isPanPrime.length - 1; p++) {
            if (isPanPrime[p]) {
                for (int i = p * 2; i <= isPanPrime.length - 1; i += p) {
                    isPanPrime[i] = false;
                }
            }
        }
        isPanPrime[1] = false;
        isPanPrime[0] = false;

        for(int i = 0; i < isPanPrime.length; i++){
            if (isPanPrime[i] && !isPandigital(i))
                isPanPrime[i] = false;
        }
    }

    public boolean isPandigital(int number){
        boolean[] use = new boolean[9];
        while (number > 0){
            int dig = number % 10;
            if(dig == 0 || use[dig-1])
                return false;
            else{
                use[dig-1] = true;
                number/=10;
            }
        }
        return true;
    }
}
