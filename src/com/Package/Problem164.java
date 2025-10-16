package com.Package;

import java.nio.charset.IllegalCharsetNameException;

public class Problem164 {

    String[] towDig = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "20", "21", "22", "23", "24", "25", "26", "27",
                    "30", "31", "32", "33", "34", "35", "36", "40", "41", "42", "43", "44", "45", "50", "51", "52", "53",
                    "54", "60", "61", "62", "63", "70", "71", "72", "80", "81", "90"};

    long[][] memo = new long[21][100];

    public void run(){
        count();
        long sum = 0;
        for(int j = 0; j < 100; j++){
            sum += memo[20][j];
        }
        System.out.println("the answer = " + sum);
    }

    public void count(){
        /*if (length == 20){
            return 1;
        }
        long count = 0;
        long digOp = 9 - digitSum(number);

        for(int i = 0; i <= digOp; i++){
            int temp = ((number % 10) * 10) + i;
            count += count(temp, length + 1);
        }

        return count;
        */

        for(int i = 10; i < towDig.length; i++){
            memo[2][Integer.parseInt(towDig[i])]++;
        }
        for(int j = 1; j < towDig.length; j++){
            long digSum = digitSum(Integer.parseInt(towDig[j]));
            for(int k = 0; k <= 9 - digSum; k++){
                long temp = (Integer.parseInt(towDig[j]) * 10 + k) % 100;
                memo[3][(int)temp] += memo[2][ Integer.parseInt(towDig[j]) ];
            }
        }
        for (int i = 4; i <= 20; i++){
            for(int j = 0; j < towDig.length; j++){
                long digSum = digitSum(Integer.parseInt(towDig[j]));
                for(int k = 0; k <= 9 - digSum; k++){
                    long temp = (Integer.parseInt(towDig[j]) * 10 + k) % 100;
                    memo[i][(int)temp] += memo[i-1][ Integer.parseInt(towDig[j]) ];
                }
            }
        }

        /*
        long count = 0;
        if (length == 20) {
            System.out.println(str);
            return 1;
        }else {
            long number = Long.parseLong(str.substring(str.length() - 2));
            long digSum = digitSum(number);
            long pos = 9 - digSum;

            for (int i = 0; i <= pos; i++) {
                String tempStr = str.concat(String.valueOf(i));
                //System.out.println(tempStr);
                count += count(tempStr, length + 1);
            }
        }
        return count;*/
    }

    public long digitSum(long number){
        long sum = 0;
        while (number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
