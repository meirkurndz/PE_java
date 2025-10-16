package com.Package;

public class Problem834 {

    public void run(){
        for(int n = 3; n < 1000; n++){
            System.out.print(n + " = ");
            int tempSum = 0;
            for(int m = 1; m < 1000; m++){
                long temp1 = n*(m+1) + (m*(m+1))/2;
                long temp2 = n + m;
                if (temp1 % temp2 == 0) {
                    tempSum += m;
                    System.out.print(m + ", ");
                }
            }
            System.out.println( " = " + tempSum +",");
        }
    }
}
