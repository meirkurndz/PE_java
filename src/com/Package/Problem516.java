package com.Package;
import java.math.BigInteger;
import java.util.*;

public class Problem516 {

    static final long MOD = 4294967296L;
    static final long LIMIT = 1_000_000_000_000L;
    long[] hammings = new long[3429];
    long[] primes = new long[545];
    BigInteger[] candidates = new BigInteger[336080]; //924405

    static int index = 0;

    public void run(){
        genHammingAndPrimes();
        System.out.println("gen ham and primes");
        System.out.println("ham size = " + hammings.length);
        System.out.println("primes size = " + primes.length);
        Arrays.sort(hammings);
        Arrays.sort(primes);
        System.out.println("sort ham and primes");

        genCandidates(BigInteger.ONE,0, "");
        System.out.println("gen candidates " + index);
        Arrays.sort(candidates);
        System.out.println("sort candidates");


        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < candidates.length; i++){
            for(int j = 0; j < hammings.length; j++){
                //System.out.println(candidates[i] + " , " + hammings[j]);
                BigInteger temp = candidates[i].multiply(BigInteger.valueOf(hammings[j]));
                if(temp.compareTo(BigInteger.valueOf(LIMIT)) > 0)
                    break;
                else{
                    //System.out.println(temp);
                    sum = sum.add(temp);
                }
            }
        }

        /*for(int i = 0; i < hammings.length; i++){
            sum = sum.add(BigInteger.valueOf(hammings[i]));
        }*/

        System.out.println("the answer = " + sum + " , " + (sum.mod(BigInteger.valueOf(MOD))));
        //939087315
    }

    public void genHammingAndPrimes(){
        int indexHam = 0;
        int indexP = 0;
        for(long tow = 1; tow <= LIMIT; tow *= 2){
            for(long three = 1; tow * three <= LIMIT; three*=3){
                for(long five = 1; five*tow*three <= LIMIT; five*=5){
                    long num = tow * three * five;
                    hammings[indexHam] = num;
                    indexHam++;
                }
            }
        }
        for(int i = 0; i < hammings.length; i++){
            if(isPrime(hammings[i]+1,3) && hammings[i] + 1 > 3){
                //System.out.println(indexP + " , " + hammings[i] + 1);
                primes[indexP] = hammings[i]+1;
                indexP++;
            }
        }
    }

    public void genCandidates(BigInteger product, int i, String str){

        if (product.compareTo(BigInteger.valueOf(MOD)) <= 0) {
            if (i == primes.length) {
                candidates[index] = product;
                //System.out.println(index + ", " + candidates[index] + str);
                index++;
            } else {
                long current = primes[i];
                genCandidates(product, i + 1, str);
                genCandidates(product.multiply(BigInteger.valueOf(current)), i + 1, str + " , " + current);
            }
        }
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
