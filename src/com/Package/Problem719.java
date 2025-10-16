package com.Package;

public class Problem719 {

    long[] squares = new long[1000001];
    public void run(){

        genSquares();
        long sum = 0;

        for(int i = 4; i < squares.length; i++){
            if (isSNumber(String.valueOf(squares[i]), i, digNum(squares[i]))){
                //System.out.println(i + " , " + squares[i]);
                sum += squares[i];
            }
        }
        System.out.println("the answer = " + sum);

    }

    public boolean isSNumber(String number, long sum, int length){

        if (length == 0){
            if (sum == 0) {
                return true;
            }
            return false;
        }

        String strNum = String.valueOf(number);
        int digNum = number.length();
        for(int i = 1; i <= digNum; i++){
            long temp = Long.parseLong(strNum.substring(0,i));
            if (sum - temp >= 0) {
                //System.out.println(temp + " , " + sum + " , " + length);
                int newLength = length - i;
                if (newLength == 0){
                    if (sum - temp == 0){
                        return true;
                    }
                }else {
                    if (isSNumber(strNum.substring(i), sum - temp, length - i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int digNum(long number){
        int digNum = 0;
        while (number != 0) {
            digNum++;
            number /= 10;
        }
        return digNum;
    }

    public void genSquares(){
        for(long i = 0; i < squares.length; i++){
            squares[(int)i] = i * i;
        }
    }
}
