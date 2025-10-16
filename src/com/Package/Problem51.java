package com.Package;

import java.util.Arrays;

public class Problem51 {

    boolean isPrime[] = new boolean[100000001];

    public void run(){
        primeGenerator();
        System.out.println("finish primes");
        int[] maskes1 = createMaskes(find1(121313));
        for(int i = 0; i < maskes1.length;i++){
            if (maskes1[i] != 0) {
                System.out.println(maskes1[i]);
            }
        }

        /*for(int i = 50000; i < 60000000; i++){
            findFamily(i);
        }*/
    }

    public void findFamily(int number){
        if (isPrime[number]) {
            int[] zeros = find0(number);
            int toAdd0 = createToAdd(zeros);
            int[] ones = find1(number);
            int toAdd1 = createToAdd(ones);
            if (toAdd0 != 0) {
                int count0 = 1;
                //System.out.println("0 family:");
                //System.out.print(number + " , ");
                for (int i = 0; i < 9; i++) {
                    number += toAdd0;
                    if (isPrime[number]) {
                        count0++;
                        //System.out.print(number + " , ");
                    }
                }
                if (count0 == 8) {
                    System.out.println(number + " count0 = " + count0);
                }
            }
            if (toAdd1 != 0) {
                //System.out.println();
                //System.out.println("1 family:");
                //System.out.print(number + " , ");
                int count1 = 1;
                for (int i = 0; i < 9; i++) {
                    number += toAdd1;
                    if (isPrime[number]) {
                        count1++;
                        //System.out.print(number + " , ");
                    }
                }
                if (count1 == 8) {
                    System.out.println(number + " count1 = " + count1);
                }
            }
            //System.out.println();
        }

    }

    public int[] find0(int number){
        int[] zeros = new int[digNum(number) - 1];
        String str = String.valueOf(number);
        int j = str.length() - 1;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '0'){
                zeros[j]++;
            }
            j--;
        }
        return zeros;
    }

    public int createToAdd(int[] mask){
        int toAdd = 0;
        for(int i = 0; i < mask.length; i++){
            if (mask[i] == 1){
                toAdd += Math.pow(10,i);
            }
        }
        return toAdd;
    }

    public int[] find1(int number){
        int[] ones = new int[digNum(number)];
        String str = String.valueOf(number);
        int j = str.length() - 1;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '1'){
                ones[j]++;
            }
            j--;
        }
        return ones;
    }

    public int[] createMaskes(int[] mask){
        int[] maskes = new int[64];
        maskes[0] = createToAdd(mask);
        int index = 1;
        for(int i = 0; i < mask.length; i++){
            if (mask[i] == 1){
                mask[i] = 0;
                int temp = createToAdd(mask);
                //System.out.println(temp);
                mask[index] = temp;
                mask[i] = 1;
                index++;
            }
        }

        for(int i = 0; i < mask.length; i++){
            if (mask[i] == 1) {
                for (int j = i + 1; j < mask.length; j++) {
                    if (mask[j] == 1){
                        mask[i] = 0;
                        mask[j] = 0;
                        int temp = createToAdd(mask);
                        maskes[index] = temp;
                        mask[i] = 1;
                        mask[j] = 1;
                        index++;
                    }
                }
            }
        }

        for(int i = 0; i < mask.length; i++){
            if (mask[i] == 1) {
                for (int j = i + 1; j < mask.length; j++) {
                    if (mask[j] == 1){
                        for(int k = j + 1 ;k < mask.length;k++) {
                            if (mask[k] == 1) {
                                mask[i] = 0;
                                mask[j] = 0;
                                mask[k] = 0;
                                int temp = createToAdd(mask);
                                maskes[index] = temp;
                                mask[i] = 1;
                                mask[j] = 1;
                                mask[k] = 1;
                                index++;
                            }
                        }
                    }
                }
            }
        }
        return maskes;
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
