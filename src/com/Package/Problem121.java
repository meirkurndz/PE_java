package com.Package;

public class Problem121 {

    static int number = 1;
    public void run() {

        double temp = print(8,7,"") +
                            print(9,6,"") +
                            print(10,5,"") +
                            print(11,4,"") +
                            print(12,3,"") +
                            print(13,2,"") +
                            print(14,1,"") +
                            print(15,0,"");

        for(int i = 1000; i < 10000; i++){
            if(temp * i > 1){
                System.out.println("the answer = " + (i-1));
                break;
            }
        }
    }

    public double print(int blue, int red, String str){

        if(blue == 0 && red == 0) {
            double prob = prob(str,15);
            return prob;
        }
        else if(blue == 0){
            return print(blue, red-1,str + "0");
        }else if(red == 0){
            return print(blue-1, red,str + "1");
        }else{
            return print(blue, red-1,str + "0") +
                   print(blue-1, red,str + "1");
        }
    }

    public double prob(String str, int length){
        double ans = 1;
        for(int i = 2; i < length + 2; i++){
            if(str.charAt(i-2) == '0'){
                ans *= ((double)(i-1))/(i);
            }else{
                ans *= (double)(1)/i;
            }
        }
        return ans;
    }
}
