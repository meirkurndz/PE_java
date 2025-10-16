package com.Package;

public class Problem137 {

    public void run(){
        int count = 0;
        for(int i = 1; i < 1000000; i++){
            int midelUP = (int)((double)i * 1.61803398874989) + 1;
            for(int j = 0; j < 5; j++){
                if (midelUP > 0) {
                    if (gcd(i, midelUP) == 1) {
                        long temp = value(i, midelUP);
                        if (temp != 0) {
                            count++;
                            if (count == 15){
                                System.out.println("the answer = " + temp);
                                break;
                            }
                            //System.out.println((double) i / midelUP + " , " + i + "/" + midelUP + " = " + temp);
                        }
                    }
                }
                midelUP++;
            }
        }

    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

    public long value(long x, long y){

        long doubX = x * x;
        long doubY = y * y;
        long ansUp = x * y;
        long ansDown = doubY - ansUp - doubX;

        if (ansUp % ansDown == 0) return ansUp / ansDown;
        return 0;
    }
}
