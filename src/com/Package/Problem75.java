package com.Package;

public class Problem75 {

    int[] numOfTriangles = new int[1500001];
    public void run(){
        long count = 0;
        genPythagorans(numOfTriangles.length);
        for(int i = 1; i < numOfTriangles.length; i++){
            //System.out.println(i + " , " + numOfTriangles[i]);
            if (numOfTriangles[i] == 1){
                count++;
            }
        }
        System.out.println("the answer = " + count);
    }

    public void genPythagorans(long limit){

        for(long i = 1; i < limit; i+=2){
            for(long j = 2;  Math.abs((i*i)-(j*j)) + 2*i*j + (i*i) + (j*j) < limit; j+=2){
                if (gcd(i,j) == 1) {
                    long a = Math.abs((i*i)-(j*j));
                    long b = 2*i*j;
                    long c = (i*i) + (j*j);

                    long temp1 = a;
                    long temp2 = b;
                    long temp3 = c;

                    while (a+b+c <= 1500000) {
                        //System.out.println("{" + a + " , " + b + " , " + c + "}");
                        numOfTriangles[(int) a + (int) b + (int) c]++;
                        a += temp1;
                        b += temp2;
                        c += temp3;
                    }

                    //System.out.println("{" + a + " , " + b + " , " + c + "}");
                }
            }
        }
    }

    public long gcd(long n, long m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

/*

    public int generateTriangles(int limit){

        int[] numberOfTriangles = new int[limit + 1];

        for(long i = 0; i < 10000; i += 2){
            for (long j = 1; j < 10000; j += 1) {
                if (isCoPrime(i,j)){
                    long line1 = 2 * i * j;
                    long line2  = (long) (Math.pow(j , 2) - Math.pow(i , 2));
                    long line3 = (long) (Math.pow(i,2) + Math.pow(j,2));
                    System.out.println(i + " , " + j);
                    System.out.println(line1 + " , " + Math.abs(line2) + " , " + line3);
                    long temp = line1 + line2 + line3;
                    long theAdd = temp;
                    while (theAdd < limit){
                        numberOfTriangles[(int)temp]++;
                        theAdd += temp;
                    }
                }
            }

        }
        int count = 0;
        for (int i = 0; i< numberOfTriangles.length;i++){
            if (numberOfTriangles[i] == 1){
                count++;
            }
        }

        return count;
    }

    public boolean isCoPrime(long num1, long num2){

        return (gcd(num1,num2) == 1)? true: false;

    }

    public long gcd(long a, long b)
    {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return  a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);

        return gcd(a, b-a);
    }
*/
}
