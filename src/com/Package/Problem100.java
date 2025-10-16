package com.Package;

public class Problem100 {

    public void run(){
        long blue = 15;
        long red = 6;

        while (blue + red < 1000000000000L){
            long tempRed = 2 * blue + red - 1;
            long tempBlue = blue + 2 * tempRed;

            blue = tempBlue;
            red = tempRed;
        }
        System.out.println("the answer = " + blue);

    }

}
