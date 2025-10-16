package com.Package;

public class Problem149 {

    long[] seq = new long[4000001];
    long[][] matrix = new long[2000][2000];
    long[]  rowSums = new long[2000];
    long[]  colSums = new long[2000];
    long[] diagSums = new long[3999];
    long[] antiSums = new long[3999];
    public void run(){
        long max = 0;
        int index = 0;
        genSeq();
        for(int i = 0; i < 2000; i++){
            for(int j = 0; j < 2000; j++){
                matrix[i][j] = seq[index];
                long temp = matrix[i][j];
                index++;
            }
        }

        for(int i = 0; i < 2000; i++){
            int rowMaxSum = 0;
            int lineSum = 0;
            for(int j = 0 ; j < 2000;j++){
                lineSum += matrix[i][j];
                if (lineSum < 0) lineSum = 0;
                if (lineSum > rowMaxSum) rowMaxSum = lineSum;
            }
            if (rowMaxSum > max) max = rowMaxSum;
        }

        for(int j = 0; j < 2000; j++){
            int colMaxSum = 0;
            int colSum = 0;
            for(int i = 0 ; i < 2000;i++){
                colSum += matrix[i][j];
                if (colSum < 0) colSum = 0;
                if (colSum > colMaxSum) colMaxSum = colSum;
            }
            if (colMaxSum > max) max = colMaxSum;
        }
/*

        for(int i = 0; i < 2000; i++){
            for(int j = 0; j < 2000; j++){
                System.out.println(i + " , " + j);
                long sum = 0;
                for(int k = i; k < matrix[i].length; k++){
                    sum += matrix[k][j];
                    if (sum > max) max = sum;
                }
                //System.out.println("finsh rows");
                sum=0;
                for(int k = j; k < matrix[j].length; k++){
                    sum += matrix[i][k];
                    if (sum > max) max = sum;
                }
                //System.out.println("finsh colums");
                sum=0;
                for(int k=i,l=j; k < matrix[i].length; k++,l++){
                    sum += matrix[k][j];
                    if (sum > max) max = sum;
                }
                //System.out.println("finsh diagonals");
                sum=0;
                for(int k=i, l=j; k < matrix[i].length; k++,l--){
                    sum += matrix[k][j];
                    if (sum > max) max = sum;
                }
                //System.out.println("finsh all");
            }
        }
*/
        System.out.println("the answer = " + max);
    }


    public void genSeq(){

        for(int k = 1; k <= 55; k++){
            seq[k] = ((100003L - (200003L * k) + (300007L*k*k*k)) % 1000000) - 500000L;
        }

        for(int k = 56; k < seq.length; k++){
            seq[k] = ((seq[k-24] + seq[k-55] + 1000000L) % 1000000) - 500000L;
        }
    }
}
