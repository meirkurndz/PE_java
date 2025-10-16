package com.Package;

import java.util.Arrays;

public class Problem88 {

    int[] sets = new int[12001];
    boolean[] used = new boolean[22001];

    public void run(){
        Arrays.fill(sets, 1000000);

        int last = 11999;
        int index = 4;
        while (last != 0){
            last -= getMinK(index, index, index, 0);
            index++;
        }
        long sum = 0;
        for(int i = 2; i < sets.length; i++){
            //System.out.println(i + " , " + sets[i]);
            if (!used[sets[i]]){
                used[sets[i]] = true;
                sum += sets[i];
            }
        }
        System.out.println("the answer = " + sum);
    }

    public int getMinK(int n, int product, int sum, int length){
        //System.out.println(n + " , pro = " + product + " , sum = " + sum + " , len = " + length);

        if (length > 12000)
            return 0;

        if (product == 1){
            int setLength = length + sum;
            if (setLength != 1 && setLength < sets.length) {
                if (sets[setLength] > n) {
                    sets[setLength] = n;
                    //System.out.println(n + " , " + setLength);
                    return 1;
                }
            }
            return 0;
        }

        int count = 0;

        for(int i = 2; i*i <= product ; i++){
            if (product % i == 0){
                int temp = product/i;
                count += getMinK(n, temp, sum-i, length + 1);
                count += getMinK(n, i, sum - temp, length + 1);
            }
        }
        count += getMinK(n, 1, sum-product, length + 1);

        return count;
    }
}
