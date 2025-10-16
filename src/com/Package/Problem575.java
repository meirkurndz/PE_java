package com.Package;

public class Problem575 {
    //0.000989640561
    static final int size = 1000;
    static final int iterations = 100000;
    double[][] pos_eq = new double[size][size];
    double[][] pos_half = new double[size][size];

    public void run() {
        move();
        double prob = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                long num = (i*size) + j + 1;
                if (is_square(num)){
                    prob += pos_eq[i][j] + pos_half[i][j];
                }
            }
        }
        System.out.println("the answer = " + (0.5*(prob)));
    }

    public boolean is_square(long number){
        long root = (long)Math.sqrt(number);
        return number == root*root;
    }

    public void move(){
        for(int i = 0; i < size;i++){
            for (int j = 0; j < size; j++){
                pos_eq[i][j] = 1.0/(size*size);
                pos_half[i][j] = 1.0/(size*size);
            }
        }
        for(int itr = 0; itr < iterations; itr++) {
            double[][] next_eq = new double[size][size];
            double[][] next_half = new double[size][size];
            for (int i = 1; i < pos_eq.length-1; i++) {
                for (int j = 1; j < pos_eq[i].length-1; j++) {

                    next_eq[i-1][j] +=  (1/5.0) * pos_eq[i][j];
                    next_eq[i+1][j] +=  (1/5.0) * pos_eq[i][j];
                    next_eq[i][j-1] +=  (1/5.0) * pos_eq[i][j];
                    next_eq[i][j+1] +=  (1/5.0) * pos_eq[i][j];
                    next_eq[i][j  ] +=  (1/5.0) * pos_eq[i][j];

                    next_half[i-1][j] += (1/8.0) * pos_half[i][j];
                    next_half[i+1][j] +=  (1/8.0) * pos_half[i][j];
                    next_half[i][j-1] +=  (1/8.0) * pos_half[i][j];
                    next_half[i][j+1] +=  (1/8.0) * pos_half[i][j];
                    next_half[i][j  ] +=  (1/2.0) * pos_half[i][j];
                }
            }

            //top row
            for (int j = 1; j < pos_eq[0].length-1; j++){
                next_eq[0][j-1] +=  (1/4.0) * pos_eq[0][j];
                next_eq[0][j+1] +=  (1/4.0) * pos_eq[0][j];
                next_eq[1][j  ] +=  (1/4.0) * pos_eq[0][j];
                next_eq[0][j  ] +=  (1/4.0) * pos_eq[0][j];

                next_half[0][j-1] += (1/6.0) * pos_half[0][j];
                next_half[0][j+1] += (1/6.0) * pos_half[0][j];
                next_half[1][j  ] += (1/6.0) * pos_half[0][j];
                next_half[0][j  ] += (1/2.0) * pos_half[0][j];
            }

            //bottom row
            for (int j = 1; j < pos_eq[size-1].length-1; j++){
                next_eq[size-1][j-1] +=  (1/4.0) * pos_eq[size-1][j];
                next_eq[size-1][j+1] +=  (1/4.0) * pos_eq[size-1][j];
                next_eq[size-2][j  ] +=  (1/4.0) * pos_eq[size-1][j];
                next_eq[size-1][j  ] +=  (1/4.0) * pos_eq[size-1][j];

                next_half[size-1][j-1] += (1/6.0) * pos_half[size-1][j];
                next_half[size-1][j+1] += (1/6.0) * pos_half[size-1][j];
                next_half[size-2][j  ] += (1/6.0) * pos_half[size-1][j];
                next_half[size-1][j  ] += (1/2.0) * pos_half[size-1][j];
            }


            //first column
            for (int i = 1; i < pos_eq.length-1; i++){
                next_eq[i-1][0] +=  (1/4.0) * pos_eq[i][0];
                next_eq[i+1][0] +=  (1/4.0) * pos_eq[i][0];
                next_eq[i][1  ] +=  (1/4.0) * pos_eq[i][0];
                next_eq[i][0  ] +=  (1/4.0) * pos_eq[i][0];

                next_half[i-1][0] += (1/6.0) * pos_half[i][0];
                next_half[i+1][0] += (1/6.0) * pos_half[i][0];
                next_half[i][1  ] += (1/6.0) * pos_half[i][0];
                next_half[i][0  ] += (1/2.0) * pos_half[i][0];
            }


            //last column
            for (int i = 1; i < pos_eq.length-1; i++){
                next_eq[i-1][size-1] += (1/4.0) * pos_eq[i][size-1];
                next_eq[i+1][size-1] += (1/4.0) * pos_eq[i][size-1];
                next_eq[i  ][size-2] += (1/4.0) * pos_eq[i][size-1];
                next_eq[i  ][size-1] += (1/4.0) * pos_eq[i][size-1];

                next_half[i-1][size-1] += (1/6.0) * pos_half[i][size-1];
                next_half[i+1][size-1] += (1/6.0) * pos_half[i][size-1];
                next_half[i  ][size-2] += (1/6.0) * pos_half[i][size-1];
                next_half[i  ][size-1] += (1/2.0) * pos_half[i][size-1];
            }

            //corners
            //top left
            next_eq[0][1] += (1/3.0) * pos_eq[0][0];
            next_eq[1][0] += (1/3.0) * pos_eq[0][0];
            next_eq[0][0] += (1/3.0) * pos_eq[0][0];

            //top right
            next_eq[0][size-2] += (1/3.0) * pos_eq[0][size-1];
            next_eq[1][size-1] += (1/3.0) * pos_eq[0][size-1];
            next_eq[0][size-1] += (1/3.0) * pos_eq[0][size-1];

            //bottom left
            next_eq[size-1][1] += (1/3.0) * pos_eq[size-1][0];
            next_eq[size-2][0] += (1/3.0) * pos_eq[size-1][0];
            next_eq[size-1][0] += (1/3.0) * pos_eq[size-1][0];

            //bottom right
            next_eq[size-1][size-2] +=  (1/3.0) * pos_eq[size-1][size-1];
            next_eq[size-2][size-1] +=  (1/3.0) * pos_eq[size-1][size-1];
            next_eq[size-1][size-1] +=  (1/3.0) * pos_eq[size-1][size-1];

            next_half[0][1] += (1/4.0) * pos_half[0][0];
            next_half[1][0] += (1/4.0) * pos_half[0][0];
            next_half[0][0] += (1/2.0) * pos_half[0][0];

            //top right
            next_half[0][size-2] += (1/4.0) * pos_half[0][size-1];
            next_half[1][size-1] += (1/4.0) * pos_half[0][size-1];
            next_half[0][size-1] += (1/2.0) * pos_half[0][size-1];

            //bottom left
            next_half[size-1][1] += (1/4.0) * pos_half[size-1][0];
            next_half[size-2][0] += (1/4.0) * pos_half[size-1][0];
            next_half[size-1][0] += (1/2.0) * pos_half[size-1][0];

            //bottom right
            next_half[size-1][size-2] += (1/4.0) * pos_half[size-1][size-1];
            next_half[size-2][size-1] += (1/4.0) * pos_half[size-1][size-1];
            next_half[size-1][size-1] += (1/2.0) * pos_half[size-1][size-1];


            for(int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    pos_eq[i][j] = next_eq[i][j];
                    pos_half[i][j] = next_half[i][j];
                }
            }
        }
    }
}
