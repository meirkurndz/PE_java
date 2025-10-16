package com.Package;

public class Problem126 {
    int[] count = new int[20000];
    public void run(){
        long t1 = System.currentTimeMillis();
        for(int a = 1; a < count.length; a++){
            for (int b = a; 2*a*b < count.length;b++){
                for(int c = b; 2*(a*b+b*c+a*c) < count.length;c++){
                    for(int n=1;n<1000;n++){
                        int layer = 2*(a*b+b*c+a*c)+4*(n-1)*(a+b+c+n-2);
                        if(layer>count.length-1){
                            break;
                        }else{
                            //System.out.println(a+","+b+","+c +", "+layer);
                            count[layer]++;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < count.length; i++){
            if(count[i]==1000){
                System.out.println("the answer = " + i);
                break;
            }
            //System.out.println(i+", " +count[i]);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }
}
