package com.Package;

public class Problem682 {

    static final int LIMIT = 100000000;
    boolean[] isHamming = new boolean[LIMIT];
    long[] omega = new long[LIMIT];
    long[] sum = new long[LIMIT];


    public void run(){
        generateHamming();
        System.out.println("gen");
        long count = 0;
        System.out.println(omega[300]);
        System.out.println(sum[300]);
        for(int i = 1; i < isHamming.length; i++){
            if(isHamming[i]){
                for(int j = 1; j < isHamming.length; j++){
                    if(isHamming[j] && omega[i] == omega[j] && sum[i] + sum[j] == 100){
                        if(i == j){
                            count++;
                            System.out.println(count + " = (" + i + "," + j + ")");
                        }else{
                            count++;
                            System.out.println(count + " = (" + i + "," + j + ")");
                            count++;
                            System.out.println(count + " = (" + j + "," + i + ")");
                        }
                    }
                }
            }
        }
        System.out.println("the answer = " + count);
    }

    public void generateHamming(){

        for(int i = 1; i <= LIMIT; i *= 2) {
            for(int j = 1; j*i < LIMIT; j *= 3){
                for(int k = 1; k*i*j < LIMIT; k *= 5){
                    int hamm = i*j*k;
                    int temp = hamm;
                    isHamming[hamm] = true;
                    while (hamm % 2 == 0){
                        omega[temp]++;
                        sum[temp] += 2;
                        hamm /= 2;
                    }
                    while (hamm % 3 == 0){
                        omega[temp]++;
                        sum[temp] += 3;
                        hamm /= 3;
                    }
                    while (hamm % 5 == 0){
                        omega[temp]++;
                        sum[temp] += 5;
                        hamm /= 5;
                    }
                }
            }
        }
    }



}
