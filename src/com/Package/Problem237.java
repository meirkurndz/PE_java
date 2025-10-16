package com.Package;

public class Problem237 {
    long[][] M = {{2,2,-2,1},{1,0,0,0},{0,1,0,0},{0,0,1,0}};
    static final long MOD = 100000000L;
    public void run(){
        long[] T = {8,4,1,1};
        long[] F = new long[4];
        M = power(M,999999999996L);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                //System.out.print(M[i][j] + " ");
                F[i] += M[i][j]*T[j];
            }
            //System.out.println();
        }
        System.out.println("the answer = " + F[0]%MOD);
    }


    public long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] %= MOD;
            }
        }
        return C;
    }

    public long[][] power(long[][] A, long n) {
        int size = A.length;
        // נתחיל מהמטריצה היחידה
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) result[i][i] = 1;

        long[][] base = A;
        while (n > 0) {
            if ((n & 1) == 1) result = multiply(result, base);
            base = multiply(base, base);
            n >>= 1;
        }
        return result;
    }
}
