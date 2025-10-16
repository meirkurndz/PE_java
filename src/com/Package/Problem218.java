package com.Package;

public class Problem218 {


    public void  run (){
        genPythagorans(1000000000L);
    }

    public void genPythagorans(long limit){
        int count = 0;
        for(int i = 1; i*i*i*i < limit; i+=2){
            for(int j = 2; (i*i + j*j)*(i*i+j*j) < limit; j+=2){
                if (gcd(i,j) == 1) {
                    long x = Math.abs((i*i)-(j*j));
                    long y = 2*i*j;
                    long z = (i*i) + (j*j);

                    long a = Math.abs((x*x)-(y*y));
                    long b = 2*x*y;
                    long c = z*z;

                    if(((a*b)/2) % 6 != 0 || ((a*b)/2) % 28 != 0){
                        count++;
                    }
                    //System.out.println("{" + a + " , " + b + " , " + c + "}");
                }
            }
        }
        System.out.println("the answer = " + count);
    }

    public long gcd(long a, long b) {
        if (a == 0 || b == 0)
            return 0;
        if (a == b)
            return  a;
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
}
