package com.Package;

public class Problem655 {

    public void run(){
        long pos = 0;
        for(long i = 0 ; pos < Math.pow(10,32); i++){
            pos += 10000019;
            if (isPalindrom(pos)){
                System.out.println(pos + " , " + pos/10000019);
            }
        }

    }

    static boolean isPalindrom(long num) {
        String s = Long.toString(num);
        String sr = new StringBuilder(s).reverse().toString();
        return s.equals(sr);
    }
}
