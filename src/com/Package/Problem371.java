package com.Package;

public class Problem371 {

    double[][] state = new double[500][2];

    public void run(){
        setState();
        System.out.println("the answer = " + state[0][0]);
    }

    public void setState(){
        state[499][1] = (double)1/(1-(((double)1/1000)+(double)499/1000));
        state[499][0] = (1+(((double)1/1000)*state[499][1]))/(1-(((double)500/1000)));
        for(int i = 498; i >= 0; i--){
            state[i][1] = (1+(((double)998-(2*i))/1000)*state[i+1][1])/(1-((double)(i+1)/1000));
            state[i][0] = (1+((((double)998-(2*i))/1000)*state[i+1][0]) +
                    (((double)1/1000)*state[i][1]))/(1-((double)(i+1)/1000));
        }
    }
}
