package com.Package;

import java.util.*;

public class Problem757 {

    public void run(){

        int count = 0;
        /*for(int i = 2; i <= 1000000; i++){
            if (isStealthy(i)){
                count++;
            }
        }*/

        for(long x = 1; x*(x+1)*2 <= 100000000000000L; x++){
            for (long y = x; y*(y+1) * x*(x+1) <= 100000000000000L; y++){

                long temp = y*(y+1) * x*(x+1);
                //stealthy.add(temp);
            }
        }

        //System.out.println("the answer = " + stealthy.size());

    }

    public boolean isStealthy(int number){

        LinkedList<Integer> lowDivs = new LinkedList<>();
        LinkedList<Integer> highDivs = new LinkedList<>();

        for(int i = 1; i*i <= number; i++){
            if (number % i == 0){
                lowDivs.add(i);
                highDivs.add(number/i);
            }
        }

        for(int i = 0; i < lowDivs.size(); i++){
            for(int j = i + 1; j < lowDivs.size(); j++){
                int a = lowDivs.get(i) + highDivs.get(i);
                int b = lowDivs.get(j) + highDivs.get(j);
                if (b + 1 == a || a + 1 == b){
                    System.out.println(number + " , (" + lowDivs.get(i) + "," + highDivs.get(i) + ") + (" + lowDivs.get(j) + "," + highDivs.get(j) + ")");
                    return true;
                }
            }
        }

        return false;
    }

}
