package com.Package;

public class Problem373 {
    static final long LIMIT = 10000000;
    public void run(){
        long t1 = System.currentTimeMillis();
        long sum = 0;

        for(int a = 1; a <= LIMIT*2; a++){
            for(int b = a; b <= LIMIT*2; b++){
                for(int c = b; c < a+b; c++) {
                    double R = radii(a,b,c);
                    if (R > LIMIT)
                        break;
                    if (R == (int)R) {
                        sum += R;
                        System.out.println("(" + a + "," + b + "," + c + ") , R = " + R);
                    }

                }
            }
        }
        System.out.println("the answer = " + sum);
        long t2 = System.currentTimeMillis();
    }

    public double radii(long a, long b, long c){
        double A = SHeron(a,b,c);
        return (double)(a*b*c)/(4.0*A);
    }

    public double SHeron(long a, long b, long c){
        double s = (double) (a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
