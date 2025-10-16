package com.Package;

public class Problem572 {

    public void run(){
        long t1 = System.currentTimeMillis();
        long ans = 0;
        ans = searchIdemMat(4);
        System.out.println("the answer = " + ans);
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long searchIdemMat(int n){
        long count = 0;
        for(int a = -n; a <= n; a++){
            for(int b = -n; b <= n; b++){
                for(int c = -n; c <= n; c++){
                    for(int d = -n; d <= n; d++){
                        for(int e = -n; e <= n; e++){
                            for(int f = -n; f <= n; f++){
                                for(int g = -n; g <= n; g++){
                                    for(int h = -n; h <= n; h++){
                                        for(int i = -n; i <= n; i++){
                                            if (isIdempotent(a,b,c,d,e,f,g,h,i)){
                                                count++;
                                                display(a,b,c,d,e,f,g,h,i);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public void display(int a, int b, int c, int d, int e, int f, int g, int h, int i){
        System.out.print(a + ",");
        System.out.print(b + ",");
        System.out.println(c);

        System.out.print(d + ",");
        System.out.print(e + ",");
        System.out.println(f);

        System.out.print(g + ",");
        System.out.print(h + ",");
        System.out.println(i);
        System.out.println();
    }

    public boolean isIdempotent(int a, int b, int c, int d, int e, int f, int g, int h, int i){

        //a pos
        int a2 = a*a;
        int bd = b*d;
        int cg = c*g;
        if (a2 + bd + cg != a)
            return false;

        //b pos
        int ab = a*b;
        int be = b*e;
        int ch = c*h;
        if (ab + be + ch != b)
            return false;

        //c pos
        int ac = a*c;
        int bf = b*f;
        int ci = c*i;
        if (ac + bf + ci != c)
            return false;

        //d pos
        int ad = a*d;
        int ed = d*e;
        int fg = f*g;
        if (ad + ed + fg != d)
            return false;

        //e pos
        int e2 = e*e;
        int fh = f*h;
        if (bd + e2 + fh != e)
            return false;

        //f pos
        int cd = c*d;
        int ef = f*e;
        int fi = f*i;
        if (cd + ef + fi != f)
            return false;

        //g pos
        int ag = a*g;
        int dh = d*h;
        int gi = g*i;
        if (ag + dh + gi != g)
            return false;

        //h pos
        int gb = g*b;
        int he = h*e;
        int hi = h*i;
        if (gb + he + hi != h)
            return false;

        //i pos
        int gc = g*c;
        int i2 = i*i;
        if (gc + fh + i2 != i)
            return false;

        return true;
    }
}
