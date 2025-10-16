package com.Package;

public class Problem166 {

    public void run(){

        /*
        a  b  c  d
        e  f  g  h
        i  j  k  l
        m  n  o  p
         */
        int a, b, c, d;
        long ans = 0;

        for(a = 0; a < 5; a++){
            for(b = 0; b < 10; b++){
                for(c = 0; c < 10; c++){
                    for(d = 0; d < 10; d++){

                        int s = a+b+c+d;

                        for(int e = b; e < 10; e++) {
                            for (int f = 0; f < 10; f++) {
                                for (int g = 0; g < 10; g++) {
                                    int h = s - e - f - g;
                                    if(h < 0 || h > 9)
                                        continue;

                                    for(int i = 0; i < 10; i++){

                                        int m = s - i - e - a;
                                        if(m < 0 || m > 9)
                                            continue;

                                        int j = s - m - g - d;
                                        if(j < 0 || j > 9)
                                            continue;

                                        int n = s - j - f - b;
                                        if(n < 0 || n > 9)
                                            continue;

                                        for(int k = 0; k < 10 ;k++){

                                            int l = s - i - j - k;
                                            if(l < 0 || l > 9)
                                                continue;

                                            int o = s - c - g - k;
                                            if(o < 0 || o > 9)
                                                continue;

                                            int p = s - m - n - o;
                                            if(p < 0 || p > 9)
                                                continue;

                                            if (s != a + f + k + p)
                                                continue;

                                            ans++;
                                            if(b < e)
                                                ans++;
                                            //System.out.println(ans);
                                            //System.out.println(a + " " + b  + " " + c + " " + d);
                                            //System.out.println(e + " " + f  + " " + g + " " + h);
                                            //System.out.println(i + " " + j  + " " + k + " " + l);
                                            //System.out.println(m + " " + n  + " " + o + " " + p);
                                            //System.out.println();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("the answer = " + (2 * ans)); // 7130034
    }


}
