package com.Package;

public class Problem225 {


    public void run() {
        int count = 0;
        for(int i = 3; ; i += 2){

            int t1 = 1;
            int t2 = 1;
            int t3 = 1;

            do {

                int next = (t1 + t2 + t3) % i;
                t1 = t2;
                t2 = t3;
                t3 = next;

                if (t3 == 0)
                    break;

            }while (!(t1 == 1 && t2 == 1 && t3 ==1));

            if (!(t3 == 0)) {
                count++;
                //System.out.println(count + " , " + i);
                if (count == 124) {
                    System.out.println("the answer = " + i);
                    break;
                }
            }
        }
    }

}
