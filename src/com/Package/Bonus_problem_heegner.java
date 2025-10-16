package com.Package;

public class Bonus_problem_heegner {
    static final int LIMIT = 1001;
    boolean[] is_square = new boolean[LIMIT];
    public void run(){
        set_is_square();

        int ans = 1;
        double min = 1.1;

        for(int n = 2;n < LIMIT; n++){
            if(!is_square[n]){
                double calc = Math.cos(Math.PI*Math.sqrt(n));
                double near = Math.min(Math.abs(calc-Math.floor(calc)),Math.abs(Math.ceil(calc)-calc));
                if(near < min){
                    System.out.println(n + ", "+calc+", " + near);
                    min = near;
                    ans = n;
                }
            }
        }
        for(int n =-LIMIT+1;n < 0; n++){
            if(!is_square[-n]){
                double calc = Math.cosh(Math.PI*Math.sqrt(-n));
                double near = Math.min(Math.abs(calc-Math.floor(calc)), Math.abs(Math.ceil(calc)-calc));
                if(near < min){
                    System.out.println(n + ", " + calc + ", " + near);
                    min = near;
                    ans = n;
                }
            }
        }
        System.out.println("the answer = " + ans);
    }

    public void set_is_square(){
        for(int i = 0; i*i < is_square.length; i++){
            is_square[i*i] = true;
        }
    }
}
