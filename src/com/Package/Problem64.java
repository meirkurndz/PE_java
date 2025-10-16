package com.Package;

public class Problem64 {

    boolean[] isSquare = new boolean[10001];

    public void run(){
        genSquares();
        int count = 0;
        for(int i = 2 ; i < 10001; i++){
            if (!isSquare[i]){
                int temp = calcPeriod(i);
                if (temp % 2 == 1) {
                    count++;
                }
            }
        }
        System.out.println("the answer = " + count);
    }

    public int calcPeriod(int number){

        int count = 0;

        int root = (int)Math.sqrt(number);
        int numerator = 0;
        int denominator = 1;
        int a = (int)Math.floor(((double)root+numerator)/denominator);
        //System.out.print(number + " = [" + root + ";(");
        while (a != 2 * root){
            count++;
            numerator = a * denominator - numerator;
            int nextDenominator = (int)Math.floor( ((double)number - numerator * numerator) / denominator);
            a = (int)Math.floor(((double)root+numerator)/nextDenominator);
            //System.out.print("," + a);
            denominator = nextDenominator;
        }
        //System.out.println(")],period=" + count);
        return count;
    }

    public void genSquares(){
        for(int i = 1; i < 101; i++){
            isSquare[i*i] = true;
        }
    }

}
