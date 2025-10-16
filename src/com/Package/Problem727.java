package com.Package;

public class Problem727 {

    public void run(){

        int count = 0;
        double E = 0;
        for(int r_a = 1; r_a <= 100; r_a++){
            for(int r_b = r_a+1; r_b <= 100; r_b++){
                for(int r_c = r_b+1; r_c <= 100; r_c++){
                    if(gcd(gcd(r_a,r_b),r_c)==1) {
                        double d = d(r_a, r_b, r_c);
                        count++;
                        //System.out.println(count + ", " + r_a + "," + r_b + "," + r_c + " = " + d);
                        E += d;
                    }
                }
            }
        }
        System.out.println("the answer = " + (E/count));
    }

    public double d(int r_a, int r_b, int r_c){
        double R_c = Math.sqrt((r_a*r_b*r_c)/(double)(r_a+r_b+r_c));
        double R_i = 1.0/((1.0/r_a)+(1.0/r_b)+(1.0/r_c)+(2.0/R_c));
        return Math.sqrt(R_c*R_c+R_i*R_i-4*R_c*R_i);
    }

    public double area(double a, double b, double c, double p){
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

}
