package com.Package;

public class Problem236 {

    static final int TOT_A = 18880;
    static final int TOT_B = 15744;
    static int[] A = {5248,1312,2624,5760,3936};
    static int[] B = {640,1888,3776,3776,5664};

    public void run(){
        for(int a_0 = 1; a_0 < A[0]; a_0++){
            System.out.println(a_0);
            for(int b_0 = (int)Math.ceil(((double)a_0/A[0])*B[0]); b_0 < B[0]; b_0++){
                //System.out.println(a_0 + ", " +b_0);
                double m = ((double)a_0*B[0])/(A[0]*b_0);
                //System.out.println("m = " + m);
                //if (m>=2)break;
                for(int a_1 = 1; a_1 < A[1]; a_1++){
                    if ((a_1*a_0*B[0]) % (A[0]*b_0) == 0){
                        int b_1 = (int)((a_1/A[1])*m*B[1]);
                        if ((double)a_1/A[1] < (double)b_1/B[1]){
                            for(int a_2 = 1; a_2 < A[2]; a_2++){
                                if ((a_2*a_0*B[0]) % (A[0]*b_0) == 0) {
                                    int b_2 = (int)((a_2/A[2])*m*B[2]);
                                    if ((double)a_2/A[2] < (double)b_2/B[2]){
                                        for(int a_3 = 1; a_3 < A[3]; a_3++){
                                            if ((a_3*a_0*B[0]) % (A[0]*b_0) == 0) {
                                                int b_3 = (int)((a_3/A[3])*m*B[3]);
                                                if ((double)a_3/A[3] < (double)b_3/B[3]){
                                                    for(int a_4 = 1; a_4 < A[4]; a_4++){
                                                        if ((a_4*a_0*B[0]) % (A[0]*b_0) == 0) {
                                                            int b_4 = (int)((a_4/A[4])*m*B[4]);
                                                            if ((double)a_4/A[4] < (double)b_4/B[4]){
                                                                int a_sum = a_0 + a_1 + a_2 + a_3 + a_4;
                                                                int b_sum = b_0 + b_1 + b_2 + b_3 + b_4;
                                                                if ((double)a_sum/TOT_A > (double)b_sum/TOT_B)
                                                                    System.out.println("(" + a_0 + "," + b_0 + ")" +"(" + a_1 + "," +b_1 + ")" +"(" + a_2 + "," +b_2 + ")" +"(" + a_3 + "," +b_3 + ")" +"(" + a_4 + "," +b_4 + ") , m = " + m);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
