package com.Package;

public class Problem351 {

    double[] phi = new double[100000001];
    public void run(){
        long sum = phiGenerator();
        long temp = (100000001L * 100000000L)/2L;
        System.out.println("H(" + 100000000 + ") = " + ((6 * (temp - sum)) - 6));
    }

    public long phiGenerator(){
        long sum = 0;
        for(int i = 0; i < phi.length; i++){
            phi[i] = i;
        }
        phi[1] = 0;
        for(int i = 2; i < phi.length; i++){
            if (phi[i] == i){
                for(int j = i; j < phi.length; j += i){
                    phi[j] *= (1 - (1 / ((double)i) ) );
                }
            }
            sum += phi[i];
        }
        return sum;
    }
}
