package com.Package;

import java.util.LinkedList;

public class Problem215 {

    long[][] allLayers = new long[3329][];
    long[][] matches = new long[3329][];
    long[][] found = new long[3329][11];
    int count = 0;

    public void run(){
        LinkedList<Integer> layer = new LinkedList<>();
        genLayers(layer,0);
        genMatches();
        System.out.println("the answer = " + count1());
    }

    public long count1(){

        for(int i = 0; i < found.length; i++){
            found[i][10] = 1;
        }

        for(int row = 9; row > 0; row--){
            for(int i = 0 ; i < found.length; i++){
                for(int k = 0 ; k < matches[i].length; k++){
                    long match = found[(int)matches[i][k]][row+1];
                    found[i][row] += match;
                }
            }
        }

        long sum = 0;
        for(int i = 0; i < found.length; i++){
            sum += found[i][1];
        }
        return sum;
    }

    public void genMatches(){

        for(int i = 0; i < allLayers.length; i++){

            LinkedList<Integer> match = new LinkedList<>();

            for(int j = 0; j < allLayers.length; j++){
                if (isMatch(allLayers[i], allLayers[j])){
                    match.add(j);
                }
            }

            matches[i] = new long[match.size()];

            for(int j = 0; j < matches[i].length; j++){
                matches[i][j] = match.get(j);
            }
        }
    }

    public boolean isMatch(long[] layer1, long[] layer2){

        for(int i = 0; i < layer1.length; i++){
            for(int j = 0; j < layer2.length; j++){
                if (layer2[j] > layer1[i])
                    break;
                if (layer2[j] == layer1[i])
                    return false;
            }
        }
        return true;
    }

    public void genLayers(LinkedList<Integer> layer, int sum){

        if (sum == 32){

            allLayers[count] = new long[layer.size() - 1];
            allLayers[count][0] = layer.get(0);

            for(int i = 1; i < allLayers[count].length; i++){
                allLayers[count][i] = allLayers[count][i-1] + layer.get(i);
            }
            count++;
        }else{
            if (sum + 2 <= 32) {
                layer.add(2);
                genLayers(layer, sum + 2);
                layer.remove(layer.size() - 1);
            }

            if (sum + 3 <= 32) {
                layer.add(3);
                genLayers(layer, sum + 3);
                layer.remove(layer.size() - 1);
            }
        }
    }

}
