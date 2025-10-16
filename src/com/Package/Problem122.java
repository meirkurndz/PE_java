package com.Package;

public class Problem122 {

    int[] chainLength = new int[201];

    public void run(){

        for(int maxDepth = 1; maxDepth < 12; maxDepth++) {
            int[] chain = new int[maxDepth+1];
            chain[0] = 1;
            buildChain(chain);
        }
        int sum = 0;
        for(int i = 1; i < chainLength.length; i++) {
            sum += chainLength[i];
            //System.out.println(i + " , " + chainLength[i]);
        }
        System.out.println("the answer = " + sum);

    }

    public void buildChain(int[] chain){
        if (chain[chain.length-1] != 0){
            if (chainLength[chain[chain.length-1]] == 0){
                chainLength[chain[chain.length-1]] = chain.length - 1;
            }
        }

        int index0 = 0;
        for(int i = 0; i < chain.length; i++){
            if (chain[i] == 0){
                index0 = i;
                break;
            }
        }
        int[] temp = chain.clone();
        for(int i = 0; i < index0; i++){
            int temporery = chain[index0 - 1] + chain[i];
            if (temporery <= 200) {
                temp[index0] = temporery;
                buildChain(temp);
                temp[index0] = 0;
            }
        }
    }
}
