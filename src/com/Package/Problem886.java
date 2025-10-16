package com.Package;

import java.util.Hashtable;
import java.util.Stack;

public class Problem886 {

    public static int LIMIT = 25;
    int[][] cos = new int[LIMIT][];
    Hashtable<Long,Long>[] memo = new Hashtable[LIMIT];

    public void run(){
        long t1 = System.currentTimeMillis();
        setCos();
        setMemo();

        long ans = 0;
        boolean[] used = new boolean[LIMIT+1];
        int[] arr = new int[LIMIT-2];

        for(int i = 2; i < LIMIT; i++) {
            arr[0] = i;
            used[i] = true;
            ans += rec(arr, 1, used);
            used[i] = false;
        }

        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + ans);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long rec(int[] arr, int i, boolean[] used){
        if (i == arr.length) {
            //display(arr);
            return 1;
        }
        long key = makeKey(used);
        long count = 0;
        int last = arr[i-1];
        if (memo[last].containsKey(key))
            return memo[last].get(key);
        for(int k = 0; k < cos[last].length; k++){
            int curr = cos[last][k];
            if (!used[curr]){
                used[curr] = true;
                arr[i] = curr;
                count += rec(arr,i+1,used);
                used[curr] = false;
                arr[i] = 0;
            }
        }
        memo[last].put(key,count);
        return count;
    }

    public void setCos(){
        for(int i = 2; i < cos.length; i++){
            Stack<Integer> arrayList = new Stack<>();
            for(int j = 2; j < LIMIT; j++){
                if (i == j)
                    continue;
                if (gcd(i,j) == 1){
                    arrayList.push(j);
                }
            }

            int size = arrayList.size();
            cos[i] = new int[size];
            for(int k = 0; k < size; k++){
                int temp = arrayList.pop();
                cos[i][k] = temp;
            }
        }
    }

    public long makeKey(boolean[] used){
        long key = 0;
        long mag = 1;
        for(int i = 2; i < LIMIT; i++){
            if (used[i]){
                key += mag;
            }
            mag *= 2;
        }
        return key;
    }

    public void setMemo(){
        for(int i = 0; i < memo.length; i++){
            memo[i] = new Hashtable<>();
        }
    }

    public void display(int[] arr){
        System.out.print("(");
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1] + ")");
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

}
