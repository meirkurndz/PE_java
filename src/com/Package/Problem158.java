package com.Package;

public class Problem158 {

    char[] letters = {'a','b','c','d','e','f','g',
                      'h','i','j','k','l','m','n',
                      'o','p','q','r','s','t','u',
                      'v','w','x','y','z'};

    public void run() {
        long answer = 0;
        int index = 0;
        for(int i = 2; i <= 26 ;i++){
            long sum =  choose(26,i) * count(i) ;
            //System.out.println(i + " , " + sum);
            if (sum > answer){
                answer = sum;
                //index = i;
            }
        }
        System.out.println("the answer = " + answer);
    }
    String sss = "edcba, decba, dceba, dcbea, dcbae, ecdba, ecbda, ecbad, edbca, edbac, edcab, " +
                        " ecadb cedba, cbeda, cbaed, ebdca, ebadc, edacb, bedca, baedc, eadcb, aedcb, ";

    public long choose(long n, long k){
        if (n == k || k == 0) return 1;
        if (k > n/2)
            return choose(n,n-k);
        long temp = n-k;
        long answer = 1;
        for(long i = n; i > temp; i--){
            answer *= i;
        }
        return answer/factorial(k);
    }

    public long factorial(long number){
        if (number == 1) return 1;
        return number * factorial(number-1);
    }

    String str1 = "cba , bac bca cab acb";
    String str  = "dcba, cdba cbda cbad dbca dbac dcab bdca badc dacb adcb ";
    public long count(int length ){
        long sum = 0;

        for (int i = 1; i < length; i++){
            sum += choose(length,i) - 1;
        }

        return sum;
        /*long sum = 0;
        for(long i = 1; i < length; i++){
            for(int j = 1; j <= length - i; j++){
                sum += length - i - j + 1;
            }
        }
        return sum;*/
    }
}
