package com.Package;

public class Problem430 {

    static final long N = 10000000000L;
    static final long FLIPS = 4000L;
    public void run(){
        double sum = 0;
        int last_index = 0;
        for(long i = 1; i <= N/2; i++){
            double[] P = new double[(int)FLIPS+1];
            P[0] = 1.0;
            double flip = 2*((double)i/N)*(((double)N-i+1)/N);
            //System.out.println(i + " flip = " + flip + ", no flip = " + (1-flip));
            for(int f = 1; f <= FLIPS; f++){
                //System.out.println("----- flip " + f + " -----");
                P[f] += P[f-1]*(1.0-flip) + (1.0-P[f-1])*flip;
                //System.out.println(i + " , " + P[f]);
            }
            sum += P[(int)FLIPS];
            if (P[(int)FLIPS] - 0.5 < 0.000000001){
                last_index = (int)i;
                break;
            }
        }
        System.out.println(2*(sum + ((((double) N/2)-last_index))*0.5));
    }
}
