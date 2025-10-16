package com.Package;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;

public class Problem293 {


    boolean[] disPsFu = new boolean[200];
    LinkedList<Long> admissible = new LinkedList<>();
    static final long LIMIT = 1000000000L;

    public void run(){

        genAdmissibles2Powers();
        genAdmissibles2Factors();
        genAdmissibles3Factors();
        genAdmissibles4Factors();
        genAdmissibles5Factors();
        genAdmissibles6Factors();
        genAdmissibles7Factors();
        genAdmissibles8Factors();
        genAdmissibles9Factors();

        long sum = 0;
        int size = admissible.size();
        for(int i = 0; i < size; i++){
            long temp = admissible.get(i);
            long psFuTemp = pseudoFortunate(temp);
            sum += psFuTemp;
        }

        System.out.println("the answer = " + sum);
    }

    public void genAdmissibles2Powers(){
        long number = 2;
        while (number < LIMIT){
            admissible.add(number);
            number *= 2;
        }
    }

    public void genAdmissibles9Factors(){



        long p1 = 2;
        long p2 = 3;
        long p3 = 5;
        long p4 = 7;
        long p5 = 11;
        long p6 = 13;
        long p7 = 17;
        long p8 = 19;
        long p9 = 23;

        long first = p1 * p2 * p3 * p4 * p5 * p6 * p7 * p8 * p9;

        for(int j = 0; j < 100; j++){
            long toAdd = first * (long) Math.pow(p1, j);
            if (toAdd > LIMIT){
                break;
            }
            for(int k = 0; k < 100; k++){
                long toAdd1 = toAdd * (long) Math.pow(p2, k);
                if (toAdd1 > LIMIT){
                    break;
                }
                for(int l = 0; l < 100; l++){
                    long toAdd2 = toAdd1 * (long) Math.pow(p3, l);
                    if (toAdd2 > LIMIT){
                        break;
                    }
                    for(int m = 0; m < 100; m++){
                        long toAdd3 = toAdd2 * (long) Math.pow(p4, m);
                        if (toAdd3 > LIMIT){
                            break;
                        }
                        for(int n = 0; n < 100; n++){
                            long toAdd4 = toAdd3 * (long) Math.pow(p5, n);
                            if (toAdd4 > LIMIT){
                                break;
                            }
                            for(int c = 0; c < 100; c++){
                                long toAdd5 = toAdd4 * (long) Math.pow(p6, c);
                                if (toAdd5 > LIMIT){
                                    break;
                                }
                                for(int a = 0; a < 100; a++){
                                    long toAdd6 = toAdd5 * (long) Math.pow(p7, a);
                                    if (toAdd6 > LIMIT){
                                        break;
                                    }
                                    for(int b = 0; b < 100; b++){
                                        long toAdd7 = toAdd6 * (long) Math.pow(p8, b);
                                        if (toAdd7 > LIMIT){
                                            break;
                                        }
                                        for(int s = 0; s < 100; s++){
                                            long toAdd8 = toAdd7 * (long) Math.pow(p9, s);
                                            if (toAdd8 > LIMIT){
                                                break;
                                            }
                                            admissible.add(toAdd8);
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

    public void genAdmissibles8Factors(){



            long p1 = 2;
            long p2 = 3;
            long p3 = 5;
            long p4 = 7;
            long p5 = 11;
            long p6 = 13;
            long p7 = 17;
            long p8 = 19;

            long first = p1 * p2 * p3 * p4 * p5 * p6 * p7 * p8;

            for(int j = 0; j < 100; j++){
                long toAdd = first * (long) Math.pow(p1, j);
                if (toAdd > LIMIT){
                    break;
                }
                for(int k = 0; k < 100; k++){
                    long toAdd1 = toAdd * (long) Math.pow(p2, k);
                    if (toAdd1 > LIMIT){
                        break;
                    }
                    for(int l = 0; l < 100; l++){
                        long toAdd2 = toAdd1 *(long) Math.pow(p3, l);
                        if (toAdd2 > LIMIT){
                            break;
                        }
                        for(int m = 0; m < 100; m++){
                            long toAdd3 = toAdd2 * (long) Math.pow(p4, m);
                            if (toAdd3 > LIMIT){
                                break;
                            }
                            for(int n = 0; n < 100; n++){
                                long toAdd4 = toAdd3 * (long) Math.pow(p5, n);
                                if (toAdd4 > LIMIT){
                                    break;
                                }
                                for(int c = 0; c < 100; c++){
                                    long toAdd5 = toAdd4 * (long) Math.pow(p6, c);
                                    if (toAdd5 > LIMIT){
                                        break;
                                    }
                                    for(int a = 0; a < 100; a++){
                                        long toAdd6 = toAdd5 * (long) Math.pow(p7, a);
                                        if (toAdd6 > LIMIT){
                                            break;
                                        }
                                        for(int b = 0; b < 100; b++){
                                            long toAdd7 = toAdd6 * (long) Math.pow(p8, b);
                                            if (toAdd7 > LIMIT){
                                                break;
                                            }
                                            admissible.add(toAdd7);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }

    public void genAdmissibles7Factors(){

            long p1 = 2;
            long p2 = 3;
            long p3 = 5;
            long p4 = 7;
            long p5 = 11;
            long p6 = 13;
            long p7 = 17;

            long first = p1 * p2 * p3 * p4 * p5 * p6 * p7;

            for(int j = 0; j < 100; j++){
                long toAdd = first * (long) Math.pow(p1, j);
                if (toAdd > LIMIT){
                    break;
                }
                for(int k = 0; k < 100; k++){
                    long toAdd1 = toAdd * (long) Math.pow(p2, k);
                    if (toAdd1 > LIMIT){
                        break;
                    }
                    for(int l = 0; l < 100; l++){
                        long toAdd2 = toAdd1 * (long) Math.pow(p3, l);
                        if (toAdd2 > LIMIT){
                            break;
                        }
                        for(int m = 0; m < 100; m++){
                            long toAdd3 = toAdd2 * (long) Math.pow(p4, m);
                            if (toAdd3 > LIMIT){
                                break;
                            }
                            for(int n = 0; n < 100; n++){
                                long toAdd4 = toAdd3 * (long) Math.pow(p5, n);
                                if (toAdd4 > LIMIT){
                                    break;
                                }
                                for(int c = 0; c < 100; c++){
                                    long toAdd5 = toAdd4 * (long) Math.pow(p6, c);
                                    if (toAdd5 > LIMIT){
                                        break;
                                    }
                                    for(int a = 0; a < 100; a++){
                                        long toAdd6 = toAdd5 * (long) Math.pow(p7, a);
                                        if (toAdd6 > LIMIT){
                                            break;
                                        }
                                        admissible.add(toAdd6);
                                    }
                                }
                            }
                        }
                    }
                }
            }

    }

    public void genAdmissibles6Factors(){

        long p1 = 2;
        long p2 = 3;
        long p3 = 5;
        long p4 = 7;
        long p5 = 11;
        long p6 = 13;

            long first = p1 * p2 * p3 * p4 * p5 * p6;

            for(int j = 0; j < 100; j++){
                long toAdd = first * (long) Math.pow(p1, j);
                if (toAdd > LIMIT){
                    break;
                }
                for(int k = 0; k < 100; k++){
                    long toAdd1 = toAdd * (long) Math.pow(p2, k);
                    if (toAdd1 > LIMIT){
                        break;
                    }
                    for(int l = 0; l < 100; l++){
                        long toAdd2 = toAdd1 * (long) Math.pow(p3, l);
                        if (toAdd2 > LIMIT){
                            break;
                        }
                        for(int m = 0; m < 100; m++){
                            long toAdd3 = toAdd2 * (long) Math.pow(p4, m);
                            if (toAdd3 > LIMIT){
                                break;
                            }
                            for(int n = 0; n < 100; n++){
                                long toAdd4 = toAdd3 * (long) Math.pow(p5, n);
                                if (toAdd4 > LIMIT){
                                    break;
                                }
                                for(int c = 0; c < 100; c++){
                                    long toAdd5 = toAdd4 * (long) Math.pow(p6, c);
                                    if (toAdd5 > LIMIT){
                                        break;
                                    }
                                    admissible.add(toAdd5);
                                }
                            }
                        }
                    }
                }
            }

    }

    public void genAdmissibles5Factors(){

        long p1 = 2;
        long p2 = 3;
        long p3 = 5;
        long p4 = 7;
        long p5 = 11;

            long first = p1 * p2 * p3 * p4 * p5;

            for(int j = 0; j < 100; j++){
                long toAdd = first * (long) Math.pow(p1, j);
                if (toAdd > LIMIT){
                    break;
                }
                for(int k = 0; k < 100; k++){
                    long toAdd1 = toAdd * (long) Math.pow(p2, k);
                    if (toAdd1 > LIMIT){
                        break;
                    }
                    for(int l = 0; l < 100; l++){
                        long toAdd2 = toAdd1 * (long) Math.pow(p3, l);
                        if (toAdd2 > LIMIT){
                            break;
                        }
                        for(int m = 0; m < 100; m++){
                            long toAdd3 = toAdd2 * (long) Math.pow(p4, m);
                            if (toAdd3 > LIMIT){
                                break;
                            }
                            for(int n = 0; n < 100; n++){
                                long toAdd4 = toAdd3 * (long) Math.pow(p5, n);
                                if (toAdd4 > LIMIT){
                                    break;
                                }
                                admissible.add(toAdd4);
                            }
                        }
                    }
                }
            }

    }

    public void genAdmissibles4Factors(){

        long p1 = 2;
        long p2 = 3;
        long p3 = 5;
        long p4 = 7;

            long first = p1 * p2 * p3 * p4;



            for(int j = 0; j < 100; j++){
                long toAdd = first * (long) Math.pow(p1, j);
                if (toAdd > LIMIT){
                    break;
                }

                for(int k = 0; k < 100; k++){
                    long toAdd1 = toAdd * (long) Math.pow(p2, k);
                    if (toAdd1 > LIMIT){
                        break;
                    }

                    for(int l = 0; l < 100; l++){
                        long toAdd2 = toAdd1 * (long) Math.pow(p3, l);
                        if (toAdd2 > LIMIT){
                            break;
                        }

                        for(int m = 0; m < 100; m++){
                            long toAdd3 = toAdd2 * (long) Math.pow(p4, m);
                            if (toAdd3 > LIMIT){
                                break;
                            }
                            admissible.add(toAdd3);
                        }
                    }
                }
            }

    }

    public void genAdmissibles3Factors(){

        long p1 = 2;
        long p2 = 3;
        long p3 = 5;

            long first = p1 * p2 * p3;

            for(int j = 0; j < 100; j++){
                long toAdd = first * (long) Math.pow(p1, j);
                if (toAdd > LIMIT){
                    break;
                }
                for(int k = 0; k < 100; k++){
                    long toAdd1 = toAdd * (long) Math.pow(p2, k);
                    if (toAdd1 > LIMIT){
                        break;
                    }
                    for(int l = 0; l < 100; l++){
                        long toAdd2 = toAdd1 * (long) Math.pow(p3, l);
                        if (toAdd2 > LIMIT){
                            break;
                        }
                        admissible.add(toAdd2);
                    }
                }
            }

    }

    public void genAdmissibles2Factors(){

        long p1 = 2;
        long p2 = 3;

            long first = p1 * p2;

            for(int j = 0; j < 100; j++){
                long toAdd = first * (long) Math.pow(p1, j);
                if (toAdd > LIMIT){
                    break;
                }
                for(int k = 0; k < 100; k++){
                    long toAdd1 = toAdd * (long) Math.pow(p2, k);
                    if (toAdd1 > LIMIT){
                        break;
                    }
                    admissible.add(toAdd1);
                }
            }
    }


    public long pseudoFortunate(long number){

        long temp = number + 2;

        while (!isPrime(temp,3)){
            temp++;
        }
        long answer = temp - number;
        if (!disPsFu[(int)answer]){
            disPsFu[(int)answer] = true;
            return answer;
        }
        return 0;
    }

    static boolean miillerTest(BigInteger d, long n) {

        long aB = 2 + (long)(Math.random() % (n - 4));
        BigInteger a = BigInteger.valueOf(aB);

        BigInteger x = power(a, d, BigInteger.valueOf(n));

        if (x.compareTo(BigInteger.ONE) == 0 || x.compareTo(BigInteger.valueOf(n-1)) == 0)
            return true;

        while (d.compareTo(BigInteger.valueOf(n - 1)) != 0) {
            x = (x.multiply(x)).mod(BigInteger.valueOf(n));
            d = d.multiply(BigInteger.TWO);

            if (x.compareTo(BigInteger.ONE) == 0)
                return false;
            if (x.compareTo(BigInteger.valueOf(n-1)) == 0)
                return true;
        }
        return false;
    }

    static boolean isPrime(long n, long k) {

        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;

        BigInteger d = BigInteger.valueOf(n - 1);

        while (d.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0)
            d = d.divide(BigInteger.TWO);

        for (long i = 0; i < k; i++)
            if (!miillerTest(d, n))
                return false;
        return true;
    }

    static BigInteger power(BigInteger x, BigInteger y, BigInteger p) {

        BigInteger res = new BigInteger("1");

        x = x.mod(p);

        while (y.compareTo(BigInteger.ZERO) > 0) {

            if (y.mod(BigInteger.TWO).compareTo(BigInteger.ONE) == 0)
                res = (res.multiply(x)).mod(p);

            y = y.divide(BigInteger.TWO); // y = y/2
            x = (x.multiply(x)).mod(p);
        }
        return res;
    }
}
