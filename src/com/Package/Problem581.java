package com.Package;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Problem581 {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        long LIMIT = 1111111111111L;
        long[] numbers = new long[13531849];
    public void run(){
        long sum = 0;
        long count = 0;
        for(long i = 0; i < 100; i++){
            long toCheck = (long) Math.pow(2, i);
            if (toCheck > LIMIT) break;
            for(long j = 0; j < 100; j++){
                long toCheck1 = (long) (toCheck * Math.pow(3, j));
                if (toCheck1 > LIMIT) break;
                for(long k = 0; k < 100; k++){
                    long toCheck2 = (long) (toCheck1 * Math.pow(5, k));
                    if (toCheck2 > LIMIT) break;
                    for(long l = 0; l < 100; l++){
                        long toCheck3 = (long) (toCheck2 * Math.pow(7, l));
                        if (toCheck3 > LIMIT) break;
                        for(long m = 0; m < 100; m++){
                            long toCheck4 = (long) (toCheck3 * Math.pow(11, m));
                            if (toCheck4 > LIMIT) break;
                            for(long n = 0; n < 100; n++){
                                long toCheck5 = (long) (toCheck4 * Math.pow(13, n));
                                if (toCheck5 > LIMIT) break;
                                for(long o = 0; o < 100; o++){
                                    long toCheck6 = (long) (toCheck5 * Math.pow(17, o));
                                    if (toCheck6 > LIMIT) break;
                                    for(long p = 0; p < 100; p++){
                                        long toCheck7 = (long) (toCheck6 * Math.pow(19, p));
                                        if (toCheck7 > LIMIT) break;
                                        for(long q = 0; q < 100; q++){
                                            long toCheck8 = (long) (toCheck7 * Math.pow(23, q));
                                            if (toCheck8 > LIMIT) break;
                                            for(long w = 0; w < 100; w++){
                                                long toCheck9 = (long) (toCheck8 * Math.pow(29, w));
                                                if (toCheck9 > LIMIT) break;
                                                for(long y = 0; y < 100; y++){
                                                    long toCheck10 = (long) (toCheck9 * Math.pow(29, y));
                                                    if (toCheck10 > LIMIT) break;
                                                    for(long x = 0; x < 100; x++){
                                                        long toCheck11 = (long) (toCheck10 * Math.pow(31, x));
                                                        if (toCheck11 > LIMIT) break;
                                                        for(long z = 0; z < 100; z++){
                                                            long toCheck12 = (long) (toCheck11 * Math.pow(37, z));
                                                            if (toCheck12 > LIMIT) break;
                                                            for(long v = 0; v < 100; v++){
                                                                long toCheck13 = (long) (toCheck12 * Math.pow(41, v));
                                                                if (toCheck13 > LIMIT) break;
                                                                for(long c = 0; c < 100; c++){
                                                                    long toCheck14 = (long) (toCheck13 * Math.pow(43, c));
                                                                    if (toCheck14 > LIMIT) break;
                                                                    for(long d = 0; d < 100; d++){
                                                                        long toCheck15 = (long) (toCheck14 * Math.pow(47, d));
                                                                        if (toCheck15 > LIMIT) break;
                                                                        numbers[(int)count] = toCheck15;
                                                                        count++;
                                                                        //System.out.println(count + " , " + toCheck15);
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
                        }
                    }
                }
            }
        }
        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length - 1; i++){
            if (numbers[i + 1] - numbers[i] == 1){
                sum += numbers[i];
            }
        }

        //System.out.println(count);
        System.out.println("the answer = " + sum);
    }

    public boolean is47Smooth(long number){
        for(int i = 0; i < primes.length; i++){
            while (number % primes[i] == 0){
                number /= primes[i];
            }
            if (number == 1) return true;
        }
        return false;
    }



}
