package com.Package;

public class Problem884 {

    long[] cubes = new long[1000000];

    public void run(){
        setCubes();

        for(int i = 1; i < 1000000; i++) {
            String str = "" + i;
            find(i,0, str);
        }



    }

    public int find(long num, int steps, String str){
        //System.out.println(str);
        if (num == 0){
            System.out.println("steps = " + steps + " ," + str);
            return steps;
        }

        int in = cubes.length;
        for(int i = cubes.length-1; i >= 0; i--){
            if (cubes[i] <= num){
                in = i;
                break;
            }
        }
        long next = num - cubes[in];
        str = str + " -> " + next;
        return find(next,steps+1,str);
    }

    public void setCubes(){
        for(int i = 0; i < cubes.length; i++){
            long t = i;
            cubes[i] = t*t*t;
        }
    }
}
