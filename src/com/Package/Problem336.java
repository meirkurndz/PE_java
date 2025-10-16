package com.Package;

public class Problem336 {

    public void run(){
        long time1 = System.currentTimeMillis();
        int count = 0;
        String str = "";
        for(int i = 0; i < 11 && count < 2011; i++){
            for(int j = 0; j < 11 && count < 2011; j++){
                if (j == i)
                    continue;
                for(int k = 0; k < 11 && count < 2011; k++){
                    if (k == i || k == j)
                        continue;
                    for(int l = 0; l < 11 && count < 2011; l++){
                        if (l == i || l == j || l == k)
                            continue;
                        for(int m = 0; m < 11 && count < 2011; m++){
                            if (m == i || m == j || m == k || m == l)
                                continue;
                            for(int n = 0; n < 11 && count < 2011; n++){
                                if (n == i || n == j || n == k || n == l || n == m)
                                    continue;
                                for(int o = 0; o < 11 && count < 2011; o++){
                                    if (o == i || o == j || o == k || o == l || o == m || o == n)
                                        continue;
                                    for(int p = 0; p < 11 && count < 2011; p++){
                                        if (p == i || p == j || p == k || p == l || p == m || p == n ||
                                            p == o)
                                            continue;
                                        for(int q = 0; q < 11 && count < 2011; q++){
                                            if (q == i || q == j || q == k || q == l || q == m || q == n ||
                                                q == o || q == p)
                                                continue;
                                            for(int r = 0; r < 11 && count < 2011; r++){
                                                if (r == i || r == j || r == k || r == l || r == m || r == n ||
                                                    r == o || r == p || r == q)
                                                    continue;
                                                for(int s = 0; s < 11 && count < 2011; s++){
                                                    if (s == i || s == j || s == k || s == l || s == m || s == n ||
                                                        s == o || s == p || s == q || s == r)
                                                        continue;
                                                    int[] arr = {i,j,k,l,m,n,o,p,q,r,s};
                                                    int temp = order(arr);
                                                    if(temp == 19) {
                                                        count++;
                                                        if(count == 2011){
                                                            arr = new int[]{i,j,k,l,m,n,o,p,q,r,s};
                                                            //System.out.println("(" + i + "," + j + "," + k + "," + l + "," + m + "," + n +"," + o + "," + p + "," + q + "," + r + "," + s + ") = " + temp);
                                                            for(int index = 0; index < arr.length; index++){
                                                                //System.out.println(arr[index] + ", " + buildStr(arr[index]));
                                                                str = str.concat(buildStr(arr[index]));
                                                            }
                                                            break;
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
                }
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println("the answer = " + str);
        System.out.println("found in " + (time2-time1) + "ms");
    }

    public String buildStr(int num){
        switch (num){
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            case 8:
                return "I";
            case 9:
                return "J";
            case 10:
                return "K";
        }
        return "";
    }

    public int order(int[] arr){
        int hi , lo;
        int count = 0;
        int full = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != i){
                int index = i + 1;
                while (arr[index] != i)
                    index++;
                hi = arr.length-1;
                lo = index;
                if(lo != hi) {
                    swap(arr, lo, hi);
                    count++;

                }
                swap(arr, full, hi);
                count++;
            }
            full++;
        }
        return count;
    }

    public void swap(int[] arr, int lo, int hi){
        while (hi > lo){
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            hi--;
            lo++;
        }
    }

}
