package com.Package;

public class Problem93 {

    boolean[] used = new boolean[3025];
    public void run(){
        int high = 0;
        long answer = 0;

        for(int a = 0; a <= 6 ; a++){
            for(int b = a + 1; b <= 7; b++){
                for(int c = b+1; c <= 8; c++){
                    for(int d = c+1; d <= 9; d++){
                        double[] temps = {a, b, c, d};
                        int temp = biggest(temps);
                        //System.out.println(a + " , " + b + " , " + c + " , " + d + " , " + temp);
                        if (temp > high){
                            high = temp;
                            answer = 1000 * a + 100 * b + c * 10 + d;
                        }
                        initUsed();
                    }
                }
            }
        }
        System.out.println("the answer = " + answer);
    }

    public void initUsed(){
        for(int i = 0; i < used.length;i++){
            used[i] = false;
        }
    }

    public int biggest(double[] set){
        if (set.length == 1){
            if (set[0] < 0) return 0;
            if ((int)set[0] == set[0]){
                return (int)set[0];
            }
            return 0;
        }

        for(int i = 0; i < set.length; i++){
            for(int j = 0; j < set.length; j++){
                if (i != j) {
                    if (set.length == 4) {
                        int k = 0;
                        int l = 0;
                        for (int m = 0; m < set.length; m++) {
                            if (m != i && m != j) {
                                k = m;
                            }
                        }
                        for (int n = 0; n < set.length; n++) {
                            if (n != i && n != j && n != k) {
                                l = n;
                            }
                        }
                        double[] temps = new double[3];
                        temps[0] = set[k];
                        temps[1] = set[l];
                        temps[2] = set[i] * set[j];
                        used[biggest(temps)] = true;
                        temps[2] = set[i] + set[j];
                        used[biggest(temps)] = true;
                        temps[2] = set[i] - set[j];
                        used[biggest(temps)] = true;
                        temps[2] = (double) set[i] / set[j];
                        used[biggest(temps)] = true;


                    }else if(set.length == 3){
                        int k = 0;

                        for (int m = 0; m < set.length; m++) {
                            if (m != i && m != j) {
                                k = m;
                            }
                        }
                        double[] temps = new double[2];
                        temps[0] = set[k];
                        temps[1] = set[i] * set[j];
                        used[biggest(temps)] = true;
                        temps[1] = set[i] + set[j];
                        used[biggest(temps)] = true;
                        temps[1] = set[i] - set[j];
                        used[biggest(temps)] = true;
                        temps[1] = (double) set[i] / set[j];
                        used[biggest(temps)] = true;
                    }else if(set.length == 2){
                        double[] temps = new double[1];
                        temps[0] = set[i] * set[j];
                        used[biggest(temps)] = true;
                        temps[0] = set[i] + set[j];
                        used[biggest(temps)] = true;
                        temps[0] = set[i] - set[j];
                        used[biggest(temps)] = true;
                        temps[0] = (double) set[i] / set[j];
                        used[biggest(temps)] = true;
                    }
                }
            }
        }

        for(int i = 1; i < used.length; i++){
            //System.out.println(i + " , " + used[i]);
            if (!used[i]) return i-1;
        }
        return 0;
    }

}
