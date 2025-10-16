package com.Package;

import java.util.*;

public class Problem425 {


    boolean[] isPrime = new boolean[10000001];
    boolean[] DONE = new boolean[10000001];
    int[] path = new int[10000001];

    LinkedList<Integer>[] conections = new LinkedList[100000001];

    public void run() {
        primeGenerator();
        System.out.println("gen primes");
        genConections();
        System.out.println("gen conections");

        LinkedList<Integer> start = new LinkedList<>();
        start.add(2);
        DONE[2] = true;
        for(int i = 2; i < path.length; i++){
            if (isPrime[i]){
                path[i] = 10000000;
            }
        }
        path[2] = 2;
        System.out.println("init path");
        genPath(start,1);
        System.out.println("gen path");

        long sum = 0;
        for(int i = 0; i < path.length; i++){
            if (isPrime[i]){
                if (path[i] > i){
                    sum += i;
                    //System.out.println(i + " is not a 2 relative");
                }
            }
        }
        System.out.println("the answer = " + sum);
    }

    public void genPath(LinkedList<Integer> current, int iterations){

        int size = current.size();
        if (size == 0){
            return;
        }

        LinkedList<Integer> nextIteration = new LinkedList<>();
        //System.out.println("iteration " + iterations + "  , size of list = " + size);

        for(int i = 0; i < current.size(); i++){
            int num = current.get(i);
            //DONE[num] = true;
            //System.out.print(num + " , ");
            for(int j = 0; j < conections[num].size(); j++) {
                int temp = conections[num].get(j);
                if (!DONE[temp] && path[num] < path[temp]){
                    nextIteration.add(temp);
                    if (path[num] < path[temp]){
                        path[temp] = Math.max(temp, path[num]);
                    }
                    if  (path[temp] <= temp){
                        DONE[temp] = true;
                    }
                }
            }
        }
        //System.out.println();
        genPath(nextIteration, iterations + 1);
    }

    public void genConections(){
        // init LinkedList:
        for(int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){
                conections[i] = new LinkedList<>();
            }
        }

        for(int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){

                // add a digit to the left:
                int temp = i;
                int digNum = digNum(i);
                if (digNum < 7) {
                    int mag = (int) Math.pow(10, digNum);
                    for (int j = 0; j < 9; j++) {
                        temp += mag;
                        if (isPrime[temp]) {
                            conections[i].add(temp);
                            conections[temp].add(i);
                        }
                    }
                }
                // end digit to the left.

                for(int j = 0; j < digNum; j++){
                    int toMod = i;
                    String tempP = String.valueOf(i);
                    int dig = Integer.parseInt(tempP.substring(tempP.length()-j-1,tempP.length()-j));
                    int lim = 9 - dig;
                    int mag1 = (int)Math.pow(10, j);
                    for(int k = 0; k < lim; k++){
                        toMod += mag1;
                        if (isPrime[toMod]){
                            conections[i].add(toMod);
                            conections[toMod].add(i);
                        }
                    }
                }
            }
        }
        for(int i = 2; i < isPrime.length; i++){
            if (isPrime[i]){
                conections[i].sort(Integer::compareTo);
            }
        }
    }
    public int digNum(int number){
        int digNum = 0;
        while (number != 0) {
            digNum++;
            number /= 10;
        }
        return digNum;
    }

    public void primeGenerator() {
        //prime number generator
        Arrays.fill(isPrime, true);
        for (int p = 2; p * p <= isPrime.length - 1; p++) {
            if (isPrime[p]) {
                for (int i = p * 2; i <= isPrime.length - 1; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        isPrime[1] = false;
        isPrime[0] = false;
    }
}
