package com.Package;

import java.util.ArrayList;

public class Problem424 {
    String test = "7,X,X,X,X,(vJJ),(vCD),X,X,X,X,(hCG),O,O,(vCE),X,X,X,(hCI,vJB),C,O,O,X,(vB),(hJF,vJF),O,F,O,O,(hJA),F,G,O,O,X,X,(hCA),O,A,O,X,X,X,X,(hCF),O,O,X,X,X";
    public void run(){
        String[][] K = readKakuro(test);
        solve(K,new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},0,0);
    }

    public void solve(String[][] kakuro,int[] val_table, int x, int y){
        if (x == kakuro.length && y == kakuro.length){
            print(kakuro);
        }
        if (kakuro[x][y].charAt(0) == '('){
            String str = kakuro[x][y];
            if (str.contains("v")){
                String ver = str.substring(str.indexOf('v')+1,str.indexOf(','));
                if (ver.length()==1){

                }else if(ver.length()==2){

                }
            }
        }else{

        }


    }

    public String[][] readKakuro(String str){
        int len = Integer.parseInt(str.substring(0,1));
        String[][] kakuro = new String[len][len];
        int p = 1;
        for (int i = 0; i < kakuro.length; i++){
            for (int j = 0; j < kakuro[i].length; j++){
                if(str.charAt(p+1) != '('){
                    kakuro[i][j] = String.valueOf(str.charAt(p+1));
                    p += 2;
                    continue;
                }else{
                    int p2 = p+1;
                    while (str.charAt(p2) != ')')
                        p2++;
                    kakuro[i][j] = str.substring(p+2,p2);
                    p = p2 + 1;
                }
            }
        }
        return kakuro;
    }

    public void print(String[][] K){
        for(int i = 0; i < K.length; i++){
            for(int j = 0; j < K[i].length; j++){
                System.out.print(K[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
