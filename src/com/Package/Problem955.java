package com.Package;

import java.math.BigInteger;

public class Problem955 {
    long[] triangles = new long[100000000];

    public void run(){
        int count = 1;
        BigInteger curr = new BigInteger("4");
        BigInteger last = new BigInteger("3");
        BigInteger make = new BigInteger("4");
        BigInteger next = new BigInteger("6");
        long index = 1;

        while(count <= 70){
            while(curr.compareTo(next) < 0){
                BigInteger temp = new BigInteger(curr.toString());
                curr = BigInteger.TWO.multiply(curr).subtract(last).add(BigInteger.ONE);
                //System.out.println(curr);
                last=temp;
                index++;
                //System.out.println(2);
            }
            if (curr.compareTo(next)==0){
                count++;
                System.out.println(index + " - the " + count + " triangle number is " + curr);
                last=curr;
                curr = curr.add(BigInteger.ONE);
                index++;
            }
            next = ((make).multiply(make.add(BigInteger.ONE))).divide(BigInteger.TWO);
            make = make.add(BigInteger.ONE);
        }

    }
    /*public void run(){
        setTriangles();
        System.out.println("set");
        System.out.println(triangles[triangles.length-1]);
        long curr = 3;
        long last1 = 0;
        long index = -1;
        int count = 1;
        while (count < 70){
            long temp = curr;
            index++;
            //System.out.println(index + " = " + curr);
            if (isTri(curr)){
                System.out.println(index + ", "+count+", "+curr + " is a triangle number!");
                curr++;
                count++;
            }else{
                curr = 2*curr - last1 + 1;
            }
            last1=temp;
        }

    }
*/
    public boolean isTri(long num){
        int low = 0;
        int high = triangles.length-1;
        while (low <= high){
            //System.out.println(low + ", " + high);
            int mid = (low+high)/2;
            if(triangles[mid] == num){
                return true;
            }
            if(triangles[mid] > num){
                high = mid-1;
            }else if(triangles[mid] < num){
                low = mid+1;
            }
        }
        return false;
    }

    public void setTriangles(){
        for(long i = 1; i < triangles.length; i++){
            triangles[(int)i] = (i*(i+1))/2;
        }
    }
}
