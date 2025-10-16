package com.Package;

public class Problem504 {

    int[][] gcd = new int[101][101];
    boolean[] isSquare = new boolean[20000];
    public void run(){
        for(int i = 0; i * i < isSquare.length; i++){
            isSquare[i * i] = true;
        }
        int count = 0;
        for(int a = 1; a < 101; a++){
            for(int b = 1; b < 101; b++){
                for(int c = 1; c < 101; c++){
                    for(int d = 1; d < 101; d++){
                        int numOfLatPo = calcLatticPoints(a, b, c, d);
                        if (isSquare[numOfLatPo]){
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("the answer = " + count);
    }

    public int calcLatticPoints(int a, int b, int c, int d){
        int boundary = calcPoints(a, b, c, d);
        double area = ((double) (a + c) * (b + d)) / 2;
        int numberOfLattic = (int) (area - ((double) boundary/2)) + 1;
        return numberOfLattic;
    }

    public int calcPoints(int a, int b, int c, int d){
        int count = 0;

        if (gcd[a][b] == 0){
            gcd[a][b] = (int) gcd(a,b);
            gcd[b][a] = gcd[a][b];
        }

        if (gcd[b][c] == 0){
            gcd[b][c] = (int) gcd(b,c);
            gcd[c][b] = gcd[b][c];
        }

        if (gcd[c][d] == 0){
            gcd[c][d] = (int) gcd(c,d);
            gcd[d][c] = gcd[c][d];
        }

        if (gcd[d][a] == 0){
            gcd[d][a] = (int) gcd(b,c);
            gcd[a][d] = gcd[d][a];
        }

        count += gcd[a][b];
        count += gcd[b][c];
        count += gcd[c][d];
        count += gcd[d][a];

        return count;
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}
