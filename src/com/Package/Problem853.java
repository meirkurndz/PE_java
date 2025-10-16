package com.Package;

public class Problem853 {
    long[] F = new long[120];
    public void run(){
        setF();
        for(long f: F){
            System.out.println(f);
        }
        
    }

    public void setF(){
        F[0] = 1;
        F[1] = 1;
        for(int i = 2; i < F.length; i++){
            F[i] = F[i-1]+F[i-2];
        }
    }
}
