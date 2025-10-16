package com.Package;

import java.math.BigInteger;

public class Problem700 {
    long eulerCoin1 = 1504170715041707L;
    long divider = 4503599627370517L;

    public void run() {

        long currentCoin = 1504170715041707L;
        long sum = 1504170715041707L;
        long tempCoin = currentCoin;
        long toReduce = 1495258197287103L;
        int count = 1;

        while (currentCoin != 1) {

            tempCoin = tempCoin - toReduce;

            if (tempCoin < 0) {
                tempCoin = tempCoin + toReduce;
            }
            toReduce = reduce(toReduce, tempCoin);
            if (tempCoin < currentCoin) {
                count++;
                //System.out.println("coin number " + count + " = " + tempCoin);
                //System.out.println("sub = " + (currentCoin - tempCoin) + " , prop = " + ((double) currentCoin / tempCoin));
                sum = sum + tempCoin;
                currentCoin = tempCoin;
            }
        }
        System.out.println(sum);
    }

    public long reduce(long toReduce, long lastCoin){

        while (toReduce > lastCoin){
            toReduce -= lastCoin;
        }
        return toReduce;
    }
}