package com.Package;


public class Problem389 {

    double[] T = new double[5];
    double[] C = new double[25];

    public void run(){
        setT();
        int[] temp = new int[19];
        for(int i = 1; i < 7; i++){
            for(int j = 1; j < 7; j++){
                for(int k = 1; k < 7; k++){
                    temp[i+j+k]++;
                }
            }
        }

        for(int i = 3; i < temp.length; i++){
            System.out.println(i + " = " + temp[i]);
        }
    }

    public void setT(){
        T[1] = 0.25;
        T[2] = 0.25;
        T[3] = 0.25;
        T[4] = 0.25;
    }

    public void setC(){
        int pos = 0;
        for(int i = 1; i < T.length; i++){
            pos += 6;
            int[] count = new int[25];

        }

    }

    public double E(double[] arr){
        double e = 0;
        for(int i = 1; i < arr.length; i++){
            e += i*arr[i];
        }
        return e;
    }

    public double E_square(double[] arr){
        double e = 0;
        for(int i = 1; i < arr.length; i++){
            e += i*i*arr[i];
        }
        return e;
    }

    public double var(double[] arr){
        double temp = E(arr);
        temp *= temp;
        return E_square(arr) - temp;
    }

    long set_ncr(int n,int r)
    {
        if(n==r) return 1;
        if(r==1) return n;

        return set_ncr(n-1,r) + set_ncr(n-1,r-1);
    }
}
