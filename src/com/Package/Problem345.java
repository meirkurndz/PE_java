package com.Package;

import java.util.Arrays;

public class Problem345 {

    public int[][] Matrix =
            {{7, 53, 183, 439, 863, 497, 383, 563, 79, 973, 287, 63, 343, 169, 583},
                    {627, 343, 773, 959, 943, 767, 473, 103, 699, 303, 957, 703, 583, 639, 913},
                    {447, 283, 463, 29, 23, 487, 463, 993, 119, 883, 327, 493, 423, 159, 743},
                    {217, 623, 3, 399, 853, 407, 103, 983, 89, 463, 290, 516, 212, 462, 350},
                    {960, 376, 682, 962, 300, 780, 486, 502, 912, 800, 250, 346, 172, 812, 350},
                    {870, 456, 192, 162, 593, 473, 915, 45, 989, 873, 823, 965, 425, 329, 803},
                    {973, 965, 905, 919, 133, 673, 665, 235, 509, 613, 673, 815, 165, 992, 326},
                    {322, 148, 972, 962, 286, 255, 941, 541, 265, 323, 925, 281, 601, 95, 973},
                    {445, 721, 11, 525, 473, 65, 511, 164, 138, 672, 18, 428, 154, 448, 848},
                    {414, 456, 310, 312, 798, 104, 566, 520, 302, 248, 694, 976, 430, 392, 198},
                    {184, 829, 373, 181, 631, 101, 969, 613, 840, 740, 778, 458, 284, 760, 390},
                    {821, 461, 843, 513, 17, 901, 711, 993, 293, 157, 274, 94, 192, 156, 574},
                    {34, 124, 4, 878, 450, 476, 712, 914, 838, 669, 875, 299, 823, 329, 699},
                    {815, 559, 813, 459, 522, 788, 168, 586, 966, 232, 308, 833, 251, 631, 107},
                    {813, 883, 451, 509, 615, 77, 281, 613, 459, 205, 380, 274, 302, 35, 805}};

    public int[][] theMatrix =
                     {{7, 53, 183, 439, 863, 497, 383, 563, 79, 973, 287, 63, 343, 169, 583},
                    {627, 343, 773, 959, 943, 767, 473, 103, 699, 303, 957, 703, 583, 639, 913},
                    {447, 283, 463, 29, 23, 487, 463, 993, 119, 883, 327, 493, 423, 159, 743},
                    {217, 623, 3, 399, 853, 407, 103, 983, 89, 463, 290, 516, 212, 462, 350},
                    {960, 376, 682, 962, 300, 780, 486, 502, 912, 800, 250, 346, 172, 812, 350},
                    {870, 456, 192, 162, 593, 473, 915, 45, 989, 873, 823, 965, 425, 329, 803},
                    {973, 965, 905, 919, 133, 673, 665, 235, 509, 613, 673, 815, 165, 992, 326},
                    {322, 148, 972, 962, 286, 255, 941, 541, 265, 323, 925, 281, 601, 95, 973},
                    {445, 721, 11, 525, 473, 65, 511, 164, 138, 672, 18, 428, 154, 448, 848},
                    {414, 456, 310, 312, 798, 104, 566, 520, 302, 248, 694, 976, 430, 392, 198},
                    {184, 829, 373, 181, 631, 101, 969, 613, 840, 740, 778, 458, 284, 760, 390},
                    {821, 461, 843, 513, 17, 901, 711, 993, 293, 157, 274, 94, 192, 156, 574},
                    {34, 124, 4, 878, 450, 476, 712, 914, 838, 669, 875, 299, 823, 329, 699},
                    {815, 559, 813, 459, 522, 788, 168, 586, 966, 232, 308, 833, 251, 631, 107},
                    {813, 883, 451, 509, 615, 77, 281, 613, 459, 205, 380, 274, 302, 35, 805}};

    //int count = 1;
    long maxSum = 0;
    boolean[] rows = new boolean[15];
    boolean[] cols = new boolean[15];

    public void run(){

        proMatrix();
/*
        for(int i = 0; i < theMatrix.length; i++){
            System.out.print("{" + theMatrix[i][0]);
            for(int j = 1; j < theMatrix.length; j++){
                System.out.print(" , " + theMatrix[i][j]);
            }
            System.out.println("}");
        }*/

        //System.out.println();
        hungarianAlgo();
        for(int y = 0; y < 300; y++) {
            for (int i = 0; i < rows.length; i++) {
                rows[i] = true;
                cols[i] = true;
            }
            //System.out.println("first mark:");
            markLines(0);
            //System.out.println("second mark:");
            markLines(1);
            //System.out.println("third mark:");
            markLines(1);
            doCalc();

            for(int i = 0; i < theMatrix.length; i++){
                System.out.print("{" + theMatrix[i][0]);
                for(int j = 1; j < theMatrix.length; j++){
                    System.out.print(" , " + theMatrix[i][j]);
                }
                System.out.println("}");
            }


            System.out.println();
            System.out.println();
        }
        System.out.println("solution : ");
        solution();

    }


    public void doCalc(){
        int min = 1000;

        for(int i = 0; i < theMatrix.length; i++){
            for(int j = 0; j < theMatrix.length; j++){
                if(cols[j] && !rows[i]){
                    if (theMatrix[i][j] < min){
                        min = theMatrix[i][j];
                    }
                }
            }
        }
        //System.out.println("min = " + min);

        for(int i = 0; i < theMatrix.length; i++){
            for(int j = 0; j < theMatrix.length; j++){
                if(cols[j] && !rows[i]){
                    theMatrix[i][j] -= min;
                } else if(!cols[j] && rows[i]){
                    theMatrix[i][j] += min;
                }
            }
        }
    }

    public void markLines(int number){

        boolean[] isTaken = new boolean[15];
        if (number == 0) {
            for (int i = 0; i < theMatrix.length; i++) {
                boolean isUp = false;
                for (int j = 0; j < theMatrix.length; j++) {
                    isUp = false;
                    if (theMatrix[i][j] == 0) {
                        for (int k = i - 1; k >= 0; k--) {
                            if (theMatrix[k][j] == 0) {
                                isUp = true;
                                break;
                            }
                        }
                        if (!isUp) {
                            rows[i] = true;
                            break;
                        } else {
                            rows[i] = false;
                        }
                    }
                }
            }
        }
        /*
        for(int i =0 ;i < rows.length; i++){
            if (!rows[i]){
                System.out.println("row " + i + " is marked" );
            }
        }
        System.out.println();
*/
        for(int i = 0; i < theMatrix.length; i++){
            if (!rows[i]) {
                for (int j = 0; j < theMatrix.length; j++) {
                    if (theMatrix[i][j] == 0){
                        cols[j] = false;

                    }
                }
            }
        }
        /*
        for(int j = 0; j < cols.length; j++){
            if (!cols[j]) {
                System.out.println("col " + j + " is marked");
            }
        }*/
        //System.out.println();
        for(int j = 0; j< theMatrix.length;j++){
            if(!cols[j]) {
                for (int i = 0; i < theMatrix.length; i++) {
                    if (theMatrix[i][j] == 0){
                        rows[i] = false;
                    }
                }
            }
        }
        /*
        for (int i = 0; i < theMatrix.length; i++) {
            if (!rows[i]){
                System.out.println("row " + i + " is marked");
            }
        }
        System.out.println();*/
    }

    public void solution(){
        boolean[] isOcc = new boolean[15];
        int[] sol = new int[15];
        Arrays.fill(sol, -1);
        for(int i = 0; i < theMatrix.length; i++){
            System.out.print(i + " = ");
            int numOf0 = 0;
            int index = 100;
            for(int j = 0; j < theMatrix.length; j++){
                if (theMatrix[i][j] == 0){
                    System.out.print(j + " , ");
                    numOf0++;
                    index = j;
                }
            }
            System.out.println();
            if(numOf0 == 1 && !isOcc[index]){
                isOcc[index] = true;
                sol[i] = index;
            }
        }/*
        for(int i = 0; i < sol.length; i++){
            System.out.println(i + " , " + sol[i]);
        }*/
    }

    public void proMatrix(){
        for(int i = 0; i < theMatrix.length;i++){
            for(int j = 0; j < theMatrix.length; j++){
                theMatrix[i][j] = 1000 - theMatrix[i][j];
            }

        }
    }

    public void hungarianAlgo(){

        for(int i = 0; i < theMatrix.length; i++){
            int lowestInRow = 1000;
            for(int j = 0; j < theMatrix.length; j++){
                if (theMatrix[i][j] < lowestInRow){
                    lowestInRow = theMatrix[i][j];
                }
            }
            for(int j = 0; j < theMatrix.length; j++){
                theMatrix[i][j] -= lowestInRow;
            }
        }

        for(int i = 0; i < theMatrix.length; i++){
            int lowestInCol = 1000;
            for(int j = 0; j < theMatrix.length; j++){
                if (theMatrix[j][i] < lowestInCol){
                    lowestInCol = theMatrix[j][i];
                }
            }
            for(int j = 0; j < theMatrix.length; j++){
                theMatrix[j][i] -= lowestInCol;
            }
        }
    }





}
    /*
    public long matrixSum(long[][] matrix){

        if (matrix.length == 2){
            long temp1 = matrix[0][0] + matrix[1][1];
            long temp2 = matrix[0][1] + matrix[1][0];
            long max = Math.max(temp1, temp2);
            //System.out.println("max = " + max);
            return max;
        }

        long corner1 = matrix[0][0];
        long corner2 = matrix[0][matrix[0].length-1];
        long corner3 = matrix[matrix.length-1][matrix[0].length-1];
        long corner4 = matrix[matrix.length-1][0];

        //System.out.print(" corner 1 is = " + corner1);
        //System.out.println(" corner 2 is = " + corner2);
        //System.out.print(" corner 3 is = " + corner3);
        //System.out.println(" corner 4 is = " + corner4);
        //System.out.println();

        long sum1 = corner1 + matrixSum(reducedMatrix(matrix, 0 ,0));
        long sum2 = corner2 + matrixSum(reducedMatrix(matrix, 0 ,matrix.length-1));
        long sum3 = corner3 + matrixSum(reducedMatrix(matrix, matrix.length-1 ,matrix.length-1));
        long sum4 = corner4 + matrixSum(reducedMatrix(matrix, matrix.length-1 ,0));

        System.out.println("sum 1 = " + sum1);
        System.out.println("sum 2 = " + sum2);
        System.out.println("sum 3 = " + sum3);
        System.out.println("sum 4 = " + sum4);
        System.out.println();

        maxSum = Math.max(Math.max(sum1,sum2),Math.max(sum3,sum4));

        return maxSum;

    }


    public long[][] reducedMatrix(long[][] matrix,int row, int column) {

        long[][] newMatrix = new long[matrix.length-1][matrix.length-1];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                    newMatrix[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = column + 1; j < matrix[i].length; j++){
                newMatrix[i][j-1] = matrix[i][j];
            }
        }
        for(int i = row + 1; i < matrix.length; i++){
            for(int j = 0; j < column; j++){
                newMatrix[i-1][j] = matrix[i][j];
            }
        }
        for(int i = row + 1; i < matrix.length; i++){
            for(int j = column + 1; j < matrix.length; j++){
                newMatrix[i-1][j-1] = matrix[i][j];
            }
        }

        for(int i =0 ; i< newMatrix.length;i++){
            for(int j =0 ; j< newMatrix.length;j++){
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        return newMatrix;

    }
}
*/