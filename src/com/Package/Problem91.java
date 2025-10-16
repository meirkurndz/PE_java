package com.Package;

public class Problem91 {

    public void run(){

        int count = 0;
        for(int x1 = 0; x1 <= 50; x1++){
            for(int y1 = 0; y1 <= 50; y1++){
                for(int x2 = 0; x2 <= 50; x2++){
                    for(int y2 = 0; y2 <= 50; y2++){
                        if (!(x1 == x2 && y1 == y2) && !(x1 == 0 && y1 == 0) && !(x2 == 0 && y2 == 0)){
                            if (isRightTriangle(x1, y1, x2, y2)){
                                count++;
                                //System.out.println("(" + 0 + "," + 0 + ") , " + "(" + x1 + "," + y1 + ") , " + "(" + x2 + "," + y2 + ")");
                            }
                        }
                    }
                }
            }
        }
        System.out.println("the answer = " + count/2);
    }

    public boolean isRightTriangle(int x1, int y1, int x2, int y2){

        if ((y1 == 0 && x2 == 0) || (y2 == 0 && x1 == 0))
            return true;
        if (x1 == x2) {
            return (y1 == 0 || y2 == 0);
        }
        if (y1 == y2)
            return (x1 == 0 || x2 == 0);

        double len1 = Math.sqrt((double) x1*x1 + y1*y1);
        double len2 = Math.sqrt((double) x2*x2 + y2*y2);
        double len3 = Math.sqrt((double) (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

        if (len1 > len2){
            if ((x2 - x1) * x2 + (y2 - y1) * y2 == 0)
                return true;
        }else if(len2 > len1){
            if ((x1 - x2) * x1 + (y1 - y2) * y1 == 0)
                return true;
        }
        return false;

    }
}
