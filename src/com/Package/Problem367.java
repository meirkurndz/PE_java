package com.Package;

import java.util.Random;

public class Problem367 {

    int[][] ops = {{1,2,3},
                   {1,3,2},
                   {2,1,3},
                   {2,3,1},
                   {3,1,2},
                   {3,2,1}};

    public void run(){

        int[] arr;
        long sum = 0;
        int countArrays = 0;

        for(int i = 1; i <= 11; i++){
            for(int j = 1; j <= 11; j++){
                if(j == i)
                    continue;
                for(int k = 1; k <= 11; k++){
                    if(k == i || k == j)
                        continue;
                    for(int l = 1; l <= 11; l++){
                        if(l == i || l == j || l == k)
                            continue;
                        for(int m = 1; m <= 11; m++){
                            if(m == i || m == j || m == k || m == l)
                                continue;
                            for(int n = 1; n <= 11; n++){
                                if(n == i || n == j || n == k || n == l || n == m)
                                    continue;
                                for(int o = 1; o <= 11; o++){
                                    if(o == i || o == j || o == k || o == l || o == m || o == n)
                                        continue;
                                    for(int p = 1; p <= 11; p++){
                                        if(p == i || p == j || p == k || p == l || p == m || p == n || p == o)
                                            continue;
                                        for(int q = 1; q <= 11; q++){
                                            if(q == i || q == j || q == k || q == l || q == m ||
                                               q == n || q == o || q == p)
                                                continue;
                                            for(int r = 1; r <= 11; r++){
                                                if(r == i || r == j || r == k || r == l ||
                                                   r == m || r == n || r == o || r == p || r == q)
                                                    continue;
                                                for(int s = 1; s <= 11; s++){
                                                    if(s == i || s == j || s == k || s == l ||
                                                       s == m || s == n || s == o || s == p || s == q || s == r)
                                                        continue;
                                                    arr = new int[]{i, j, k, l, m, n, o, p, q, r, s};
                                                    display(arr);
                                                    int count = count(arr);
                                                    countArrays++;
                                                    sum += count;
                                                    System.out.println("ave = " + (sum/(float)countArrays) + " , countArrays = " + countArrays + " , count = " + count);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("finish iter");
    }

    public int count(int[] numbers){
        int count = 0;

        Random rand = new Random();

        while (!isSorted(numbers)){
            count++;
            int ind1 = 0, ind2 = 0, ind3 = 0;
            while (ind1 == ind2 || ind1 == ind3 || ind2 == ind3) {
                ind1 = rand.nextInt(11);
                ind2 = rand.nextInt(11);
                ind3 = rand.nextInt(11);
            }
            int nextOps = rand.nextInt(6);
            numbers = swap(numbers, ind1, ind2, ind3, nextOps);
            //display(numbers);
        }
        return count;
    }

    public void display(int[] arr){

        System.out.print(arr[0]);
        for(int i = 1; i < arr.length; i++){
            System.out.print(", " + arr[i]);
        }
        System.out.println();
    }

    public boolean isSorted(int[] numbers){
        for(int i = 0; i < 11; i++){
            if(numbers[i] != i + 1)
                return false;
        }
        return true;
    }


    public int[] swap(int arr[], int ind0, int ind1, int ind2, int nextOps){

        int temp0 = arr[ind0];
        int temp1 = arr[ind1];
        int temp2 = arr[ind2];

        if (ops[nextOps][0] == 1){
            if(ops[nextOps][1] == 3){
                arr[ind1] = temp2;
                arr[ind2] = temp1;
            }
        }else if(ops[nextOps][0] == 2){
            arr[ind0] = temp1;
            if(ops[nextOps][1] == 1){
                arr[ind1] = temp0;
            }else if(ops[nextOps][1] == 3){
                arr[ind1] = temp2;
                arr[ind2] = temp0;
            }
        }else if(ops[nextOps][0] == 3){
            arr[ind0] = temp2;
            if(ops[nextOps][1] == 2){
                arr[ind2] = temp0;
            }else if(ops[nextOps][1] == 1){
                arr[ind1] = temp0;
                arr[ind2] = temp1;
            }
        }

        return arr;
    }
}
