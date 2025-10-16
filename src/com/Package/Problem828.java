package com.Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problem828 {

    static final long MOD = 1005075251L;

    public void run() throws IOException {

        //reading the file:
        File file = new File("C:\\Users\\meirk\\ProjectEuler\\src\\com\\Package\\p828_number_challenges.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        long sum = 0;
        int lineNum = 1;
        String line;

        while ((line = br.readLine()) != null){
            //reading the current line:
            int target = Integer.parseInt(line.substring(0,3));
            int[] nums = new int[6];
            line = line.substring(4);
            String[] tempStringArr = line.split(",");
            for(int i = 0; i < tempStringArr.length; i++){
                nums[i] = Integer.parseInt(tempStringArr[i]);
            }

            //calling the recursive algo:
            int minSum = minSum(target,nums,nums);
            if(minSum == Integer.MAX_VALUE)
                minSum = 0;

            long powMod = powMod(3,lineNum,MOD);
            powMod = (powMod * minSum) % MOD;
            sum += powMod;
            sum %= MOD;
            lineNum++;
        }
        System.out.println("the answer = " + sum);
    }

    public int minSum(int target, int[] nums, int[] use){

        if(nums.length == 1){
            //if the array length equals 1, we used all the numbers
            if(nums[0] == target) {
                return use[0];
            }
            else {
                return Integer.MAX_VALUE;
            }
        }

        //searching if we reached the target value:
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == target) {
                return use[i];
            }
        }

        int min = Integer.MAX_VALUE;
        //looping through all pairs of numbers:
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                //recursive call:
                int mod1 = oper(target,nums,use,i,j,1);
                int mod2 = oper(target,nums,use,i,j,2);
                int mod3 = oper(target,nums,use,i,j,3);
                int mod4 = oper(target,nums,use,i,j,4);
                int mod5 = oper(target,nums,use,i,j,5);
                int mod6 = oper(target,nums,use,i,j,6);
                //saving the minimum:
                min = Math.min(min,Math.min(Math.min(Math.min(mod1,mod2),Math.min(mod3,mod4)),Math.min(mod5,mod6)));
            }
        }
        return min;
    }

    public int oper(int target, int[] nums, int[] use, int i, int j, int type){
        //arrays to the next iteration:
        int[] nextNums = new int[nums.length - 1];
        int[] nextUse = new int[use.length - 1];

        //the new value created:
        int nextI = Integer.MIN_VALUE;

        //the operation depends on 'type':
        switch (type){
            case 1:
                nextI = nums[i] + nums[j];
                break;
            case 2:
                nextI = nums[i] - nums[j];
                break;
            case 3:
                nextI = nums[j] - nums[i];
                break;
            case 4:
                nextI = nums[i] * nums[j];
                break;
            case 5:
                if (nums[j] != 0 && nums[i] % nums[j] == 0)
                    nextI = nums[i] / nums[j];
                else
                    nextI = Integer.MIN_VALUE;
                break;
            case 6:
                if (nums[i] != 0 && nums[j] % nums[i] == 0)
                    nextI = nums[j] / nums[i];
                else
                    nextI = Integer.MIN_VALUE;
                break;
        }

        if (nextI != Integer.MIN_VALUE){
            //storing the new values created
            nextNums[i] = nextI;
            nextUse[i] = use[i] + use[j];

            int prevIndex = 0;
            for(int k = 0; k < nextNums.length; k++, prevIndex++){
                //copying the values to the next iteration arrays
                if (k == i)
                    //skipping i:
                    continue;
                if(k == j)
                    prevIndex++;
                //copying:
                nextUse[k] = use[prevIndex];
                nextNums[k] = nums[prevIndex];
            }
            //recursive call
            return minSum(target,nextNums,nextUse);
        }
        return Integer.MAX_VALUE;
    }

    //standard power mod algorithm
    public long powMod(long a, long exp, long p) {
        long res = 1;
        a = a % p;
        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * a) % p;
            exp = exp / 2;
            a = (a * a) % p;
        }
        return res;
    }
}
