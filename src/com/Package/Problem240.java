package com.Package;

import java.math.BigInteger;

public class Problem240 {

    long[] factorial = new long[21];

    public void run(){
        long t1 = System.currentTimeMillis();
        setFactorial();
        BigInteger ans = BigInteger.ZERO;
        int[] dices = new int[21];
        for(int i = 12; i > 6; i--) {
            dices[0] = i;
            ans = ans.add(rec(dices, 1, i));
        }
        System.out.println("the answer = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public BigInteger rec(int[] dices, int numOfD, int sum){
        if (numOfD == 20){
            BigInteger temp = BigInteger.valueOf(countPrmu(dices));
            return temp;
        }
        BigInteger count = BigInteger.ZERO;

        if (numOfD == 10){
            if (sum != 70)
                return BigInteger.ZERO;
            else{
                for(int i = dices[numOfD-1]; i > 0; i--){
                    dices[numOfD] = i;
                    count = count.add(rec(dices,numOfD+1,sum+i));
                }
            }
        }else{
            for(int i = dices[numOfD-1]; i > 0; i--){
                dices[numOfD] = i;
                count = count.add(rec(dices,numOfD+1,sum+i));
            }
        }

        return count;
    }

    public long countPrmu(int[] dices){
        long temp = factorial[20];
        int countDice = 1;
        int curr = dices[0];
        for(int i = 1; i < dices.length; i++){
            if (dices[i] == curr)
                countDice++;
            else{
                temp /= factorial[countDice];
                curr = dices[i];
                countDice = 1;
            }
        }
        return temp;
    }

    public void setFactorial(){
        factorial[0]=1;
        factorial[1]=1;
        for(int i = 2; i < factorial.length; i++){
            factorial[i] = factorial[i-1]*i;
        }
    }
}
