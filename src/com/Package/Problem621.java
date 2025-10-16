package com.Package;

public class Problem621 {

    long[] triangles = new long[73092];
    static final long TARGET = 2671239140L;

    public void run(){
        long time1 = System.currentTimeMillis();
        long count = 0;
        setTriangles();
        for(int i = triangles.length-1; i >= 42200; i--){
            //System.out.println(i);
            long temp = TARGET - triangles[i];
            int hi = i;
            int lo = 0;
            while (hi >= lo){
                long sum = triangles[lo] + triangles[hi];
                if (sum < temp){
                    lo++;
                }else if(sum > temp){
                    hi--;
                }else{
                    count += calc(triangles[i],triangles[lo],triangles[hi]);
                    hi--;
                }
            }
        }
        count *= 161;
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + count);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public long rec(long n){
        if(n < 10)
            return lessThen10(n);

        long next = ((n-12)/9) + 1;
        return 3L * rec(next);
    }

    public int lessThen10(long n){
        if(n == 9)
            return 7;
        if (n == 8)
            return 3;
        if (n == 7)
            return 9;
        if (n == 6)
            return 6;
        if (n == 5)
            return 3;
        if (n == 4)
            return 6;
        if (n == 3)
            return 3;
        if (n == 2)
            return 3;
        if (n == 1)
            return 3;
        return 0;
    }

    public int calc(long tri1, long tri2, long tri3){
        if (tri1 == tri2){
            if(tri1 == tri3)
                return 1;
            else
                return 3;
        }else if(tri1 == tri3 || tri2 == tri3){
            return 3;
        }else{
            return 6;
        }
    }

    public void setTriangles() {

        for(int i = 0; i < triangles.length; i++){
            triangles[i] = ((long) i *((long) i+1L))/2L;
        }

    }
}
