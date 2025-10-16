package com.Package;

public class Problem332 {

    public void run(){
        long t1 = System.currentTimeMillis();
        double ans = 0;
        //R = 6, area = 45.72581103588543(2,4,4)(4,2,4)(6,0,0)
        //R = 9, area = -29.58784265007463(-4,-8,-1)(-4,-4,7)(-3,-6,-6)
        //R = 9, area = NaN (-4,-4,-7)(-4,4,-7)(4,-4,7)
        //R = 3, area = -1.8966081904991938E-7(2,-1,2)(2,1,-2)(3,0,0)
        //R = 3, area = NaN(0,0,-3)(0,0,3)(1,2,2)
        //System.out.println("area = " + triangleArea(3,0,0,-3,0,0,3,1,2,2));


        for(int R = 1; R < 51; R++){
            int counter = 0;
            int[][] points = new int[700][3];
            for(int x = -R;x <= R; x++){
                for(int y = -R;y <= R; y++){
                    for(int z = -R;z <= R; z++){
                        double d = Math.sqrt(x*x + y*y + z*z);
                        if (d == (int)d && (int)d == R){
                            points[counter][0] = x;
                            points[counter][1] = y;
                            points[counter][2] = z;
                            counter++;
                        }
                    }
                }
            }
            double temp = minArea(R,points,counter);
            System.out.println("R = " + R + ", min = " + temp);
            ans += temp;
        }

        System.out.println("the answer = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public double minArea(int R, int[][] points, int counter){
        double min = Integer.MAX_VALUE;
        for(int i = 0; i < counter; i++){
            for(int j = i+1; j < counter; j++){
                for(int k = j+1; k < counter; k++){
                    int ax = points[i][0];
                    int ay = points[i][1];
                    int az = points[i][2];

                    int bx = points[j][0];
                    int by = points[j][1];
                    int bz = points[j][2];

                    int cx = points[k][0];
                    int cy = points[k][1];
                    int cz = points[k][2];

                    double area = triangleArea(R,ax,ay,az,bx,by,bz,cx,cy,cz);
                    if (area == 0)
                        continue;
                    min = Math.min(min,area);
                }
            }
        }
        return min;
    }

    public double triangleArea(int R, int ax, int ay, int az, int bx, int by, int bz, int cx, int cy, int cz){

        //angles between the vectors:
        double angAB = angle3Vec3D(ax,ay,az,0,0,0,bx,by,bz);
        double angAC = angle3Vec3D(ax,ay,az,0,0,0,cx,cy,cz);
        double angBC = angle3Vec3D(bx,by,bz,0,0,0,cx,cy,cz);

        //arc lengths:
        double arcAB = arcLength(R,angAB);
        double arcAC = arcLength(R,angAC);
        double arcBC = arcLength(R,angBC);
        if (angAB >= angAC + angBC || angAC >= angAB + angBC || angBC >= angAC + angAB)
            return 0;

        //inside angles:
        double cosAB = Math.cos(angAB);
        double cosAC = Math.cos(angAC);
        double cosBC = Math.cos(angBC);

        double sinAB = Math.sin(angAB);
        double sinAC = Math.sin(angAC);
        double sinBC = Math.sin(angBC);
        if (sinAB == 0 || sinAC == 0 || sinBC == 0)
            return 0;

        double angle1 = Math.acos((cosAB - (cosAC*cosBC))/(sinAC*sinBC));
        double angle2 = Math.acos((cosAC - (cosAB*cosBC))/(sinAB*sinBC));
        double angle3 = Math.acos((cosBC - (cosAC*cosAB))/(sinAC*sinAB));
        if (angle1 == 0 || angle2 == 0 || angle3 == 0 || Double.isNaN(angle1) || Double.isNaN(angle2)|| Double.isNaN(angle3))
            return 0;

        double area = R*R*((angle1 + angle2 + angle3) - Math.PI);
        return area <= 0.01 ? 0 : area;
    }


    public double arcLength(int R, double angle){
        return ((double)R)*angle;
    }

    public double angle3Vec3D(int ax, int ay, int az, int bx, int by, int bz, int cx, int cy, int cz){
        //vector from b to a
        int v1x = ax - bx;
        int v1y = ay - by;
        int v1z = az - bz;

        //vector from b to c
        int v2x = cx - bx;
        int v2y = cy - by;
        int v2z = cz - bz;

        //mags:
        double magv1 = Math.sqrt(v1x*v1x + v1y*v1y + v1z*v1z);
        double magv2 = Math.sqrt(v2x*v2x + v2y*v2y + v2z*v2z);
        //normalized:
        double nrmv1x = (double) v1x/magv1;
        double nrmv1y = (double) v1y/magv1;
        double nrmv1z = (double) v1z/magv1;

        double nrmv2x = (double) v2x/magv2;
        double nrmv2y = (double) v2y/magv2;
        double nrmv2z = (double) v2z/magv2;

        //dot product:
        double dotProd = nrmv1x*nrmv2x + nrmv1y*nrmv2y + nrmv1z*nrmv2z;
        double angle = Math.acos(dotProd);
        return angle;
    }

}
