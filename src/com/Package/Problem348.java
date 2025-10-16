package com.Package;

import java.util.Map;
import java.util.TreeMap;

public class Problem348 {

    static boolean isPalindrom(long num) {
        String s = Long.toString(num);
        String sr = new StringBuilder(s).reverse().toString();
        return s.equals(sr);
    }

    public  void run() {
        TreeMap<Long, Integer> times = new TreeMap<Long, Integer>();

        long up = 1100000000L;  // upper bound for the answer
        for (long n = 2; n * n * n <= up; ++n) {
            for (long m = 2; n * n * n + m * m <= up; ++m) {
                long num = n * n * n + m * m;
                if (isPalindrom(num)) {
                    Integer val = times.get(num);
                    times.put(num, val == null ? 1 : 1 + val);
                }
            }
        }

        long ans = 0;
        int k = 0;
        for (Map.Entry<Long, Integer> ent : times.entrySet()) {
            if (ent.getValue() == 4) {
                ans += ent.getKey();
                if (++k == 5) {
                    System.out.println("ans = " + ans);
                    break;
                }
            }
        }
    }
}

/*

    int[] countForNumber = new int[200000000];
    public void run() {

        for(long i = 2; i*i < countForNumber.length; i++){
            long i2 = i*i;
            for(long j = 2; j*j*j + i2 < countForNumber.length;j++){
                long j3 = j*j*j;
                long temp = i2 + j3;
                if(isPalindrom(temp) && numOfDig(temp) % 2 == 0){
                    countForNumber[(int)temp]++;
                }
            }
        }

        for(int i = 0; i < countForNumber.length;i++){
            if (countForNumber[i] == 4){
                System.out.println(i);
            }
        }

    }

    public int numOfDig(long number){
        int num = 0;
        while (number != 0){
            num++;
            number /= 10;
        }
        return num;
    }

    public long revers(long number){
        long sum = 0;
        while(number > 0){
            long r = number % 10;
            sum = (sum*10)+r;
            number = number/10;
        }
        return sum;
    }

    public boolean isPalindrom(long number){
        if (number < 0){
            return false;
        }
        long temp = number;
        long sum = 0;
        while(number > 0){
            long r = number % 10;
            sum = (sum*10)+r;
            number = number/10;
        }
        if(temp==sum) {
            return true;

        }else {
            return false;
        }
    }
*/




