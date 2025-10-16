package com.Package;

import java.util.Arrays;

public class Problem139 {

    int[] isTile = new int[100000000];
    public void run(){

        genPythagorans(isTile.length);
        long count = 0;
        for(int i = 0; i < isTile.length; i++){
            count += isTile[i];
        }
        System.out.println("the answer = " + count);

    }


    public void genPythagorans(long limit){

        for(long i = 1; i < limit; i+=2){
            for(long j = 2; Math.abs((i*i)-(j*j)) + 2*i*j + (i*i) + (j*j) < limit; j+=2){
                if (gcd(i,j) == 1) {

                    long a = Math.abs((i*i)-(j*j));
                    long b = 2*i*j;
                    long c = (i*i) + (j*j);
                    //System.out.println("{" + a + " , " + b + " , " + c + "}");
                    long temp1 = a;
                    long temp2 = b;
                    long temp3 = c;

                    if (c % Math.abs(b-a) == 0 && a+b+c < limit){
                        //System.out.println("{" + a + " , " + b + " , " + c + "}");

                        while (a+b+c < limit){
                            isTile[(int)a + (int)b + (int)c]++;
                            //System.out.println((int)a+(int)b+(int)c);
                            a += temp1;
                            b += temp2;
                            c += temp3;
                        }
                    }
                    //System.out.println("{" + a + " , " + b + " , " + c + "}");
                }
            }
        }
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

}
