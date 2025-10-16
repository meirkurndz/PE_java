package com.Package;

public class Problem577 {


    public void run(){
        long sum = 0;
        for(int i =0 ; i < 30; i++){
            System.out.println(i + " , " + countHex(i));
        }
    }

    public long countHex(int triLength){
        long sum = 0;
        int temp = triLength/3;
        for(int i = 1; i <= temp; i++){
            int line = triLength;
            while (line != i * 3 - 1){
                int temp1 = line - 2*i;
                int numInLine = 1 + temp1 - i;
                //System.out.println("in line " + line + " there is " + numInLine + " hex");
                sum += numInLine;
                line--;
            }
        }
        return sum;
    }
}
