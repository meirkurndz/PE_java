package com.Package;

public class Problem749 {

    public void run(){

        long ans = 35L+ 75L+ 528757L+ 629643L+ 688722L+ 715469L+30405525L+ 31672867L+ 44936324L+ 63645890L+ 63645891L+ 71419078L+ 73495876L+ 1136483324L+ 310374095702L+ 785103993880L+ 785103993881L+ 989342580966L+ 23046269501054L + 37434032885798L + 50914873393416L + 75759895149717L + 4020913800954247L + 4023730658941129L +4586833243299785L;
        System.out.println("the answer = " + ans);
        long sum = 0;
        for(long i = 12; i < 10000000000000000L; i++){

            if (isPowerNearSum(i)) {
                System.out.println(i + " , ");
                sum += i;
            }
        }
        System.out.println("the answer = " + sum);
    }

    public boolean isPowerNearSum(long numebr){
        long temp = numebr;
        int digNum = digNum(numebr);
        int[] digits = new int[10];
        for(int i = 0; i < digNum; i++){
            int tempDig = (int)(temp % 10);
            digits[tempDig]++;
            temp /= 10;
        }

        if (digits[0] + digits[1] == digNum)
            return false;

        long powerSum = 0;
        int power = 0;
        while (powerSum < numebr + 2){
            powerSum = 0;
            power++;
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != 0) {
                    powerSum += digits[i] * Math.pow(i, power);
                }
            }
            if (powerSum == numebr - 1 || powerSum == numebr + 1){
                return true;
            }

        }
        return false;
    }


    public int digNum(long number){
        int digNum = 0;
        while (number != 0) {
            digNum++;
            number /= 10;
        }
        return digNum;
    }
}
