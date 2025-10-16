package com.Package;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Problem881 {
    boolean[] isPrime = new boolean[9000000];
    public void run(){
        primeGenerator();
        int max = 0;
        System.out.println(does(21870000000L));
        /*for(long i = 10000000; ;i+=2){
            //System.out.println(i + " , ");
            int temp = does(i);
            if (temp >= max){
                System.out.println("new max = " + i + " = " + temp);
                max = temp;
                if (temp > 1000) {
                    System.out.println("the answer = " + temp);
                    break;
                }
            }
        }
*/
    }

    public int does(long number){

        //long number = 20922789888000L;//152125131763605L;//6541380665835015L;
        Stack<Long> numbers = new Stack<>();
        Stack<Long> next = new Stack<>();
        HashSet<Long> is = new HashSet<>();
        numbers.add(number);
        int level = 1;
        int max = 0;

        while (!numbers.isEmpty()){
            //System.out.println("level = " + level);
            level++;
            while (!numbers.isEmpty()) {
                long temp = numbers.pop();
                long temp1 = temp;
                if (temp == 1)
                    break;
                for (int i = 2; i <= temp; i++) {
                    if (isPrime[i] && temp % i == 0) {
                        long div = temp1 / i;
                        if (!is.contains(div)) {
                            next.push(div);
                            is.add(div);
                            //System.out.println(div + ", ");
                        }
                        while (temp % i == 0)
                            temp /= i;
                    }
                }
            }
            long levelCount = 0;
            while (!next.isEmpty()){
                levelCount++;
                long num = next.pop();
                numbers.push(num);
            }
            max = (int)Math.max(max,levelCount);
        }
        //System.out.println("the max = " + max);
        return max;
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
