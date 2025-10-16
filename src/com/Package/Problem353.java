package com.Package;

import org.w3c.dom.ls.LSOutput;

public class Problem353 {

    public void run(){
        long t1 = System.currentTimeMillis();
        long ans = 0;
        for(int n = 1; n < 16; n++){
            int R = (int)Math.pow(2,n)-1;
            int count = 0;
            int[][] point = new int[1000][3];
            for(int x = 0; x <= R; x++){
                for(int y = 0; y <= R; y++){
                    if (x*x + y*y > R*R)
                        break;
                    for(int z = 0; z <= R; z++){
                        if (x*x + y*y + z*z > R*R)
                            break;
                        if (x*x + y*y + z*z == R*R){
                            count++;
                            //System.out.println("R = " + R + ", c = " + count + "(" + x + "," + y + "," + z + ")");
                        }
                    }
                }
            }
            System.out.println("R = " + R + ", points = " + count);

        }

        System.out.println("the answer = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    class Points{
        int _x,_y,_z;
        int _R;

        Points(){
            _x = 0;
            _y = 0;
            _z = 0;
            _R = 1;
        }

        Points(int R, int x, int y, int z){
            this._x = x;
            this._y = y;
            this._z = z;
            this._R = R;
        }

        Points(int x, int y, int z){
            this._x = x;
            this._y = y;
            this._z = z;
            this._R = (int)Math.sqrt(x*x + y*y + z*z);
        }

        public int getX(){
            return this._x;
        }

        public int getY(){
            return this._y;
        }

        public int getZ(){
            return this._z;
        }

        public int getR(){
            return this._R;
        }

        public void setX(int x){
            this._x = x;
        }

        public void setY(int y){
            this._y = y;
        }

        public void setZ(int z){
            this._z = z;
        }

        public void setR(int R){
            this._R = R;
        }
    }
}
