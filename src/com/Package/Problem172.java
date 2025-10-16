package com.Package;

public class Problem172 {
    static long BIG = 6402373705728000L;
    int[][] cases = {{3,3,3,3,3,3,0,0,0,0},
                     {3,3,3,3,3,2,1,0,0,0},
                     {3,3,3,3,3,1,1,1,0,0},
                     {3,3,3,3,2,2,2,0,0,0},
                     {3,3,3,3,2,2,1,1,0,0},
                     {3,3,3,3,2,1,1,1,1,0},
                     {3,3,3,3,1,1,1,1,1,1},
                     {3,3,3,2,2,2,2,1,0,0},
                     {3,3,3,2,2,2,1,1,1,0},
                     {3,3,3,2,2,1,1,1,1,1},
                     {3,3,2,2,2,2,2,2,0,0},
                     {3,3,2,2,2,2,2,1,1,0},
                     {3,3,2,2,2,2,1,1,1,1},
                     {3,2,2,2,2,2,2,2,1,0},
                     {3,2,2,2,2,2,2,1,1,1},
                     {2,2,2,2,2,2,2,2,2,0},
                     {2,2,2,2,2,2,2,2,1,1}};

    public void run(){

        long t1 = System.currentTimeMillis();
        long ans = count();
        long t2 = System.currentTimeMillis();
        System.out.println("PE_172 = " + ans);
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public long count(){
        long count = 0;
        for(int i = 0; i < cases.length; i++){
            long caseCount = factorial(10);
            long temp = BIG;
            int[] tempArr = new int[4];
            for(int j = 0; j < cases[i].length; j++){
                tempArr[cases[i][j]]++;
                temp /= factorial(cases[i][j]);
            }
            caseCount /= factorial(tempArr[0]);
            caseCount /= factorial(tempArr[1]);
            caseCount /= factorial(tempArr[2]);
            caseCount /= factorial(tempArr[3]);
            temp *= 9;
            temp /= 10;
            count += temp * caseCount;
        }
        return count;
    }

    public long factorial(long number){
        if (number <= 1) return 1;
        return number * factorial(number-1);
    }
}
