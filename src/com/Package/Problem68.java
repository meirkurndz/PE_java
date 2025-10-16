package com.Package;

public class Problem68 {

    public void run(){

        long max = 0;
        int[] in = new int[5];
        int[] out = new int[5];
        out[0] = 10;

        for(int a = 1; a <= 9; a++) {
            in[0] = a;
            for(int b = 1; b <= 9; b++) {
                if (b == a)
                    continue;
                in[1] = b;
                int sum = out[0] + in[0] + in[1];
                for(int c = 1; c <= 9; c++) {
                    if (c == a || c == b)
                        continue;
                    out[1] = c;
                    for(int d = 1; d <= 9; d++) {
                        if (d == a || d == b ||d == c)
                            continue;
                        in[2] = d;
                        if (out[1] + in[1] + in[2] != sum)
                            continue;
                        for(int e = 1; e <= 9; e++) {
                            if (e == a || e == b || e == c || e == d)
                                continue;
                            out[2] = e;
                            for(int f = 1; f <= 9; f++) {
                                if (f == a || f == b || f == c || f == d || f == e)
                                    continue;
                                in[3] = f;
                                if (out[2] + in[2] + in[3] != sum)
                                    continue;
                                for(int g = 1; g <= 9; g++) {
                                    if (g == a || g == b || g == c || g == d || g == e || g == f)
                                        continue;
                                    in[4] = g;
                                    for(int h = 1; h <= 9; h++) {
                                        if (h == a || h == b || h == c || h == d || h == e || h == f || h == g)
                                            continue;
                                        out[3] = h;
                                        if (out[3] + in[3] + in[4] != sum)
                                            continue;
                                        for(int i = 1; i <= 9; i++) {
                                            if (i == a || i == b || i == c || i == d || i == e || i == f || i == g || i == h)
                                                continue;
                                            out[4] = i;
                                            if (out[4] + in[4] + in[0] != sum)
                                                continue;

                                            long temp = Long.parseLong(display(in, out));
                                            if (temp > max)
                                                max = temp;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("the answer = " + max);
    }

    public String display(int[] in, int[] out){

        int lowOutIndex = 0;
        int low = 10;
        for(int i = 0; i < 5; i++){
            if (out[i] < low){
                low = out[i];
                lowOutIndex = i;
            }
        }

        String str = "";

        for(int i = 0; i < 5; i++){
            str = str.concat(String.valueOf(out[lowOutIndex]));
            str = str.concat(String.valueOf(in[lowOutIndex]));
            lowOutIndex = (lowOutIndex + 1) % 5;
            str = str.concat(String.valueOf(in[lowOutIndex]));
        }
        return str;
    }
}
