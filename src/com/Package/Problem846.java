package com.Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem846 {

    static final int LIMIT = 1000001;
    boolean[] numbers = new boolean[LIMIT];
    ArrayList<Integer>[] pairs = new ArrayList[LIMIT];

    public void run(){
        long t1 = System.currentTimeMillis();
        setNumbers();
        setPairs();
        long sum = 0;
        for(int i = 1; i < numbers.length; i++){
            if (numbers[i] && pairs[i] != null && pairs[i].size() > 1){
                HashSet<Integer> chain = new HashSet<>();
                sum += rec(i,0,i,i,chain);
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + (sum/2));
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public void setPairs(){
        for(int i = 0; i < numbers.length; i++){
            if (numbers[i]) {
                for (int j = i+1; j < numbers.length; j++) {
                    if (numbers[j]) {
                        long temp = ((long) i * (long) j) - 1;
                        double sqrt = Math.sqrt(temp);
                        if ((int)sqrt == sqrt) {
                            if (pairs[i] == null)
                                pairs[i] = new ArrayList<>();
                            if (pairs[j] == null)
                                pairs[j] = new ArrayList<>();
                            pairs[i].add(j);
                            pairs[j].add(i);
                        }
                    }
                }

                if (pairs[i] != null) {
                    if (pairs[i].size() == 1) {
                        int temp = pairs[i].get(0);
                        for(int in = 0; in < pairs[temp].size(); in++){
                            if (pairs[temp].get(in) == i) {
                                pairs[temp].remove(in);
                                break;
                            }
                        }
                        pairs[i] = null;
                        numbers[i] = false;
                    }
                }
            }
        }
    }

    public long rec(int head,int length, int curr, long sum, HashSet<Integer> used){

        if (curr == head && length > 0) {
            return sum-head;
        }

        long count = 0;
        for (int i = 0; i < pairs[curr].size(); i++){
            int next = pairs[curr].get(i);
            if (numbers[next] && pairs[next].size() > 1 && ((length > 1 && next >= head) || (next > head)) && !used.contains(next)){
                used.add(next);
                count += rec(head,length+1, next,sum+next,used);
                used.remove(next);
            }
        }
        return count;
    }

    public void setNumbers() {

        Arrays.fill(numbers, true);
        for (int p = 2; p * p <= numbers.length - 1; p++) {
            if (numbers[p]) {
                for (int i = p * 2; i <= numbers.length - 1; i += p) {
                    numbers[i] = false;
                }
            }
        }
        numbers[0] = false;

        for(int i = 3; i < numbers.length; i++){
            if (numbers[(int)i]){
                long curr = (long) i;
                while (curr < numbers.length){
                    numbers[(int)curr] = true;
                    if (curr * 2 < numbers.length)
                        numbers[2*(int)curr] = true;
                    curr *= i;
                }
            }
        }
        numbers[1] = true;
        numbers[2] = true;
    }
}
