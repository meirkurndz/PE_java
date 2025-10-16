package com.Package;

public class Problem205 {
    int[] coefficient66 = new int[37];
    double[] probability66 = new double[37];
    int[] coefficient94 = new int[37];
    double[] probability94 = new double[37];

    public void run(){
        generateProbabilitiy();

        double chance = 0;

        for(int i = 0; i < probability66.length; i++){
            for(int j = i + 1; j < probability94.length; j++){
                chance += probability66[i]*probability94[j];
            }
        }
        System.out.println(chance);
    }

    public void generateProbabilitiy(){
        for(int i = 1;i <= 6; i++){
            for(int j = 1; j <= 6; j++){
                for(int k = 1; k <= 6; k++){
                    for(int l = 1; l <= 6; l++){
                        for(int u = 1; u <= 6; u++){
                            for(int e = 1; e <= 6; e++){
                                coefficient66[i + j + k + l + u + e]++;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 1;i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                for(int k = 1; k <= 4; k++){
                    for(int l = 1; l <= 4; l++){
                        for(int u = 1; u <= 4; u++){
                            for(int e = 1; e <= 4; e++){
                                for(int m = 1; m <= 4; m++){
                                    for(int n = 1; n <= 4; n++){
                                        for(int b = 1; b <= 4; b++){
                                            coefficient94[i + j + k + l + u + e + m + n + b]++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        int sum66 = 0;
        int sum94 = 0;

        for(int i = 0; i < coefficient66.length;i++){
            sum66 += coefficient66[i];
            sum94 += coefficient94[i];
        }
        for(int j = 0; j < probability66.length;j++){
            probability66[j] = (double)coefficient66[j]/sum66;
            probability94[j] = (double)coefficient94[j]/sum94;
        }

    }
}

