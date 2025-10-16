package com.Package;

public class Problem106 {

    public void run(){

        int[] set = {1,2,3,4,5,6,7,8,9,10,11,12};
        int count = 0;

        count += count2(set);
        count += count3(set);
        count += count4(set);
        count += count5(set);
        count += count6(set);

        System.out.println("the answer = " + count);
    }

    public int count2(int[] set){
        int count = 0;
        for(int e1 = 0; e1 < set.length; e1++){
            for(int e2 = e1 + 1; e2 < set.length; e2++){
                for(int o1 = 0; o1 < set.length; o1++){
                    if (o1 != e1 && o1 != e2) {
                        for (int o2 = o1 + 1; o2 < set.length; o2++) {
                            if (o2 != e1 && o2 != e2) {
                                if (!((set[e1] > set[o1] && set[e2] > set[o2]) ||
                                      (set[e1] < set[o1] && set[e2] < set[o2]))){
                                    //System.out.println(set[e1] + " , " + set[e2] + " , " + set[o1] + " , " + set[o2]);
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count/2;
    }
    public int count3(int[] set){
        int count = 0;
        for(int e1 = 0; e1 < set.length; e1++){
            for(int e2 = e1+1; e2 < set.length; e2++){
                for(int e3 = e2+1; e3 < set.length; e3++) {
                    for (int o1 = 0; o1 < set.length; o1++) {
                        if (o1 != e1 && o1 != e2 && o1 != e3) {
                            for (int o2 = o1 + 1; o2 < set.length; o2++) {
                                if (o2 != e1 && o2 != e2 && o2 != e3) {
                                    for(int o3 = o2+1; o3 < set.length; o3++) {
                                        if (o3 != e1 && o3 != e2 && o3 != e3) {
                                            if (!((set[e1] > set[o1] && set[e2] > set[o2] && set[e3] > set[o3]) ||
                                                  (set[e1] < set[o1] && set[e2] < set[o2] && set[e3] < set[o3]))) {
                                                count++;
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
        return count/2;
    }
    public int count4(int[] set){
        int count = 0;
        for(int e1 = 0; e1 < set.length; e1++){
            for(int e2 = e1+1; e2 < set.length; e2++){
                for(int e3 = e2+1; e3 < set.length; e3++) {
                    for(int e4 = e3+1; e4 < set.length; e4++) {
                        for (int o1 = 0; o1 < set.length; o1++) {
                            if (o1 != e1 && o1 != e2 && o1 != e3 && o1 != e4) {
                                for (int o2 = o1 + 1; o2 < set.length; o2++) {
                                    if (o2 != e1 && o2 != e2 && o2 != e3 && o2 != e4) {
                                        for (int o3 = o2 + 1; o3 < set.length; o3++) {
                                            if (o3 != e1 && o3 != e2 && o3 != e3 && o3 != e4) {
                                                for (int o4 = o3 + 1; o4 < set.length; o4++) {
                                                    if (o4 != e1 && o4 != e2 && o4 != e3 && o4 != e4) {
                                                        if (!((set[e1] > set[o1] && set[e2] > set[o2] && set[e3] > set[o3] && set[e4] > set[o4])
                                                            ||(set[e1] < set[o1] && set[e2] < set[o2] && set[e3] < set[o3] && set[e4] < set[o4]))) {
                                                            count++;
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
        return count/2;
    }
    public int count5(int[] set){
        int count = 0;
        for(int e1 = 0; e1 < set.length; e1++){
            for(int e2 = e1+1; e2 < set.length; e2++){
                for(int e3 = e2+1; e3 < set.length; e3++) {
                    for(int e4 = e3+1; e4 < set.length; e4++) {
                        for(int e5 = e4 +1; e5 < set.length; e5++) {
                            for (int o1 = 0; o1 < set.length; o1++) {
                                if (o1 != e1 && o1 != e2 && o1 != e3 && o1 != e4 && o1 != e5) {
                                    for (int o2 = o1 + 1; o2 < set.length; o2++) {
                                        if (o2 != e1 && o2 != e2 && o2 != e3 && o2 != e4 && o2 != e5) {
                                            for (int o3 = o2 + 1; o3 < set.length; o3++) {
                                                if (o3 != e1 && o3 != e2 && o3 != e3 && o3 != e4 && o3 != e5) {
                                                    for (int o4 = o3 + 1; o4 < set.length; o4++) {
                                                        if (o4 != e1 && o4 != e2 && o4 != e3 && o4 != e4 && o4 != e5) {
                                                            for (int o5 = o4 + 1; o5 < set.length; o5++) {
                                                                if (o5 != e1 && o5 != e2 && o5 != e3 && o5 != e4 && o5 != e5) {
                                                                    if (!((e1 > o1 && e2 > o2 && e3 > o3 && e4 > o4 && e5 > o5) ||
                                                                          (e1 < o1 && e2 < o2 && e3 < o3 && e4 < o4 && e5 < o5))) {
                                                                        count++;
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
                }
            }
        }
        return count/2;
    }
    public int count6(int[] set){
        int count = 0;
        for(int e1 = 0; e1 < set.length; e1++){
            for(int e2 = e1+1; e2 < set.length; e2++){
                for(int e3 = e2+1; e3 < set.length; e3++) {
                    for(int e4 = e3+1; e4 < set.length; e4++) {
                        for(int e5 = e4 +1; e5 < set.length; e5++) {
                            for(int e6 = e5 +1; e6 < set.length; e6++) {
                                for (int o1 = 0; o1 < set.length; o1++) {
                                    if (o1 != e1 && o1 != e2 && o1 != e3 && o1 != e4 && o1 != e5 && o1 != e6) {
                                        for (int o2 = o1 + 1; o2 < set.length; o2++) {
                                            if (o2 != e1 && o2 != e2 && o2 != e3 && o2 != e4 && o2 != e5 && o2 != e6) {
                                                for (int o3 = o2 + 1; o3 < set.length; o3++) {
                                                    if (o3 != e1 && o3 != e2 && o3 != e3 && o3 != e4 && o3 != e5 && o3 != e6) {
                                                        for (int o4 = o3 + 1; o4 < set.length; o4++) {
                                                            if (o4 != e1 && o4 != e2 && o4 != e3 && o4 != e4 && o4 != e5 && o4 != e6) {
                                                                for (int o5 = o4 + 1; o5 < set.length; o5++) {
                                                                    if (o5 != e1 && o5 != e2 && o5 != e3 && o5 != e4 && o5 != e5 && o5 != e6) {
                                                                        for (int o6 = o5 + 1; o6 < set.length; o6++) {
                                                                            if (o6 != e1 && o6 != e2 && o6 != e3 && o6 != e4 && o6 != e5 && o6 != e6) {
                                                                                if (!((e1 > o1 && e2 > o2 && e3 > o3 && e4 > o4 && e5 > o5 && e6 > o6) ||
                                                                                      (e1 < o1 && e2 < o2 && e3 < o3 && e4 < o4 && e5 < o5 && e6 < o6))) {
                                                                                    count++;
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
                            }
                        }
                    }
                }
            }
        }
        return count/2;
    }

}
