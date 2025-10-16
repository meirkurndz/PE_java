package com.Package;

public class Problem103 {

    public void run(){

        int best = 260;

        for(int min = 20; min < 100; min++){
            int sum = min;
            for(int max = 26; max < 100; max++){
                int sum1 = sum + max;
                if (sum1 > best)
                    break;
                for(int i = min + 1; i < max; i++){
                    int sum2 = sum1 + i;
                    if (sum2 > best)
                        break;
                    for(int j = i+1; j < max; j++){
                        int sum3 = sum2 + j;
                        if (sum3 > best)
                            break;
                        for(int k = j + 1; k < max; k++){
                            int sum4 = sum3 + k;
                            if (sum4 > best)
                                break;
                            for(int l = k + 1; l < max; l++){
                                int sum5 = sum4 + l;
                                if (sum5 > best)
                                    break;
                                for(int p = l + 1; p < max; p++){
                                    int sum6 = sum5 + p;
                                    if (sum6 > best)
                                        break;
                                    int[] set = {min, i, j, k, l, p, max};
                                    //System.out.println(min + "" + i + "" +  j + "" + k + "" + l + "" + p + "" + max + " sum = " + sum6);
                                    if (sum < best){
                                        if (check(set)){
                                            System.out.println("the answer = " + min + "" + i + "" +  j + "" + k + "" + l + "" + p + "" + max);
                                            best = sum;
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

    public boolean check(int[] set){

        for(int e1 = 0; e1 < set.length; e1++){
            for(int e2 = e1 + 1; e2 < set.length; e2++){
                int mainSum = set[e1] + set[e2];

                //1 ele:
                for(int o1 = 0; o1 < set.length; o1++){
                    if (o1 == e1 || o1 == e2)
                        continue;
                    if (set[o1] >= mainSum)
                        return false;

                    //2 ele
                    for(int o2 = o1 + 1; o2 < set.length; o2++) {
                        if (o2 == e1 || o2 == e2)
                            continue;
                        if (set[o1] + set[o2] == mainSum)
                            return false;
                    }
                }

                for(int e3 = e2 +1; e3 < set.length; e3++){

                    int mainSum1 = mainSum + set[e3];
                    //1 ele:
                    for(int o1 = 0; o1 < set.length; o1++){
                        if (o1 == e1 || o1 == e2 || o1 == e3)
                            continue;
                        if (set[o1] >= mainSum1)
                            return false;

                        //2 ele
                        for(int o2 = o1 + 1; o2 < set.length; o2++) {
                            if (o2 == e1 || o2 == e2 || o2 == e3)
                                continue;
                            if (set[o1] + set[o2] >= mainSum1)
                                return false;

                            //3 ele
                            for(int o3 = o2 + 1; o3 < set.length; o3++){
                                if (o3 == e1 || o3 == e2 || o3 == e3)
                                    continue;

                                /*System.out.println(set[e1] + " , " + set[e2] + " , " + set[e3] + " sum e = " + mainSum
                                + " , " + set[o1] + " , " + set[o2] + " , " + set[o3] + " sum o = " + (set[o1] + set[o2] + set[o3]));
*/

                                if ((set[o1] + set[o2] + set[o3]) == mainSum1) {
                                    //System.out.println("failed here");
                                    return false;
                                }
                            }
                        }
                    }

                    for(int e4 = e3 + 1; e4 < set.length; e4++){
                        int mainSum2 = mainSum1 + set[e4];
                        //1 ele:
                        for(int o1 = 0; o1 < set.length; o1++){
                            if (o1 == e1 || o1 == e2 || o1 == e3 || o1 == e4)
                                continue;
                            if (set[o1] >= mainSum2)
                                return false;

                            //2 ele
                            for(int o2 = o1 + 1; o2 < set.length; o2++) {
                                if (o2 == e1 || o2 == e2 || o2 == e3 || o2 == e4)
                                    continue;
                                if (set[o1] + set[o2] >= mainSum2)
                                    return false;

                                //3 ele
                                for(int o3 = o2 + 1; o3 < set.length; o3++){
                                    if (o3 == e1 || o3 == e2 || o3 == e3 || o3 == e4)
                                        continue;
                                    if (set[o1] + set[o2] + set[o3] >= mainSum2)
                                        return false;

                                }
                            }
                        }

                        for(int e5 = e4 + 1; e5 < set.length; e5++){
                            int mainSum3 = mainSum2 + set[e5];
                            //1 ele:
                            for(int o1 = 0; o1 < set.length; o1++){

                                if (o1 == e1 || o1 == e2 || o1 == e3 || o1 == e4 || o1 == e5)
                                    continue;
                                if (set[o1] >= mainSum3)
                                    return false;

                                //2 ele
                                for(int o2 = o1 + 1; o2 < set.length; o2++) {
                                    if (o2 == e1 || o2 == e2 || o2 == e3 || o2 == e4 || o2 == e5)
                                        continue;
                                    if (set[o1] + set[o2] >= mainSum3)
                                        return false;
                                }
                            }

                            for(int e6 = e5 + 1; e6 < set.length; e6++){
                                int mainSum4 = mainSum3 + set[e6];
                                //1 ele:
                                for(int o1 = 0; o1 < set.length; o1++){

                                    if (o1 == e1 || o1 == e2 || o1 == e3 || o1 == e4 || o1 == e5 || o1 == e6)
                                        continue;
                                    if (set[o1] >= mainSum4)
                                        return false;

                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
