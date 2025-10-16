package com.Package;

public class Problem282 {

    long[][] ackermann = new long[7][10000000];

    public void run(){
        System.out.println(A(6,6));

    }

    public long A(long m, long n){
        if(ackermann[(int)m][(int)n] != 0)
            return ackermann[(int)m][(int)n];
        if(m == 0) {
            ackermann[(int)m][(int)n] = n+1;
            return n + 1;
        }
        if(m > 0){
            if(n == 0) {
                ackermann[(int)m][(int)n] = A(m - 1, 1);
                return ackermann[(int)m][(int)n];
            }
            else {
                ackermann[(int)m][(int)n] = A(m - 1, A(m, n - 1));
                return ackermann[(int)m][(int)n];
            }
        }
        return 0;
    }
}
