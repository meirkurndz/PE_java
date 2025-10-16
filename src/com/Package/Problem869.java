package com.Package;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Stack;

public class Problem869 {
    boolean[] isPrime = new boolean[100000000];
    int[][] primes = new int[5761455][2];
    String[] binary_p = new String[5761455];
    int[] lens = new int[5761455];
    int[] g = new int[100];
    public void run(){
        primeGenerator();
        Stack<Integer> p_0 = new Stack();
        Stack<Integer> p_1 = new Stack();
        int ones = 0;
        int zeros = 0;
        for (int p = 0; p < primes.length; p++){
            if (binary_p[p].charAt(lens[p]-1) == '1'){
                ones++;
            }else{
                zeros++;
            }
        }
        if (ones>zeros) {
            for (int p = 0; p < primes.length; p++) {
                if (binary_p[p].charAt(lens[p] - 1) == '1') {
                    p_1.push(p);
                    primes[p][1]++;
                } else {
                    p_0.push(p);
                }
            }
        }else{
            for (int p = 0; p < primes.length; p++) {
                if (binary_p[p].charAt(lens[p] - 1) == '1') {
                    p_1.push(p);
                } else {
                    p_0.push(p);
                    primes[p][1]++;
                }
            }
        }
        //System.out.println(p_0.size());
        //System.out.println(p_1.size());
        rec(p_0,2);
        rec(p_1,2);
        int count = primes.length;
        double E = 0;
        for(int i = 0; i < primes.length; i++){
            g[primes[i][1]]++;
        }
        for (int i = 1; i < g.length; i++){
            E += i*((double)g[i]/count);
        }
        System.out.println("the expected value is " + E);

    }

    public void rec(Stack<Integer> p_s, int pos){
        if (p_s.size()==0) return;
        //System.out.println("size = " + p_s.size());
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> next_0 = new Stack<>();
        Stack<Integer> next_1 = new Stack<>();
        int ones = 0;
        int zeros = 0;
        while (!p_s.isEmpty()){
            int p = p_s.pop();
            if (lens[p] >= pos) {
                if (binary_p[p].charAt(lens[p] - pos) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
                temp.push(p);
            }
        }

        if (ones > zeros){
            while (!temp.isEmpty()){
                int p = temp.pop();
                if (binary_p[p].charAt(lens[p]-pos)=='1'){
                    next_1.push(p);
                    primes[p][1]++;
                }else{
                    next_0.push(p);
                }
            }
        }else{
            while (!temp.isEmpty()){
                int p = temp.pop();
                if (binary_p[p].charAt(lens[p]-pos)=='1'){
                    next_1.push(p);
                }else{
                    next_0.push(p);
                    primes[p][1]++;
                }
            }
        }
        //System.out.println("s_0 = " + next_0.size());
        //System.out.println("s_1 = " + next_1.size());
        rec(next_0,pos+1);
        rec(next_1,pos+1);
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
        isPrime[0] = false;
        isPrime[1] = false;
        int count = 0;
        for(int i = 0; i < isPrime.length;i++){
            if(isPrime[i]){
                primes[count][0] = i;
                count++;
            }
        }

        for(int i = 0; i < binary_p.length; i++){
            binary_p[i] = Integer.toBinaryString(primes[i][0]);
            lens[i] = binary_p[i].length();
        }
    }
}
