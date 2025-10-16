package com.Package;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Problem151 {

    double[] prob = new double[10000];
    public void run(){
        long t1 = System.currentTimeMillis();
        prob[1111] = 1;
        Stack<Integer> base = new Stack<>();
        base.push(1111);
        setProb(base,1);
        System.out.println("p[A2] = " + prob[1000]);
        System.out.println("p[A3] = " + prob[100]);
        System.out.println("p[A4] = " + prob[10]);
        System.out.println("the ans = " + (prob[1000] + prob[100] + prob[10]));
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public void setProb(Stack<Integer> papers, int level){
        if(level == 14){return;}
        Stack<Integer> next_stack = new Stack<>();
        HashSet<Integer> next_set = new HashSet<>();
        //System.out.print("level = " + level + " ");
        while (!papers.isEmpty()){
            int num = papers.pop();
            //System.out.print(num + ",");
            int temp = num;
            int elem = dig_sum(num);
            int to_sub = 1;
            int to_add = 0;
            for(int i = 3; i >= 0; i--){
                int dig = temp % 10;
                temp /= 10;
                if(dig > 0){
                    int next = num - to_sub;
                    next += to_add;
                    prob[next] += prob[num] * (((double)dig)/(double)elem);
                    if(!next_set.contains(next)){
                        next_set.add(next);
                        next_stack.push(next);
                    }
                }
                to_sub *= 10;
                to_add *= 10;
                to_add++;
            }
        }
        //System.out.println();
        setProb(next_stack,level+1);
    }

    public int dig_sum(int number){
        int sum = 0;
        while (number != 0){
            sum += number % 10;
            number/=10;
        }
        return sum;
    }

    public void setProb(int[] papers, int elem){
        int key = key(papers);
        double p = prob[key];
        for(int i = 0; i < papers.length; i++){
            if(papers[i] != 0){
                papers[i]--;
                int next_elem = elem-1;
                for(int j = i+1; j < papers.length; j++){
                    papers[j]++;
                    next_elem++;
                }
                prob[key(papers)] += p*(((double)papers[i]+1)/(double)elem);
                setProb(papers,next_elem);
                papers[i]++;
                for(int j = i+1; j < papers.length; j++){
                    papers[j]--;
                }
            }
        }
    }

    public int key(int[] papers){
        int key = 0;
        int mul = 1;
        for(int i = papers.length-1; i >=0 ; i--){
            key += mul * papers[i];
            mul *= 10;
        }
        return key;
    }
}
