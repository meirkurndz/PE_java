package com.Package;

public class Problem110 {

    int[] primes = new int[15];
    static final long LOW = 8_000_000L;
    static long MAX = 1;

    public void run(){
        long t1 = System.currentTimeMillis();
        setPrimes();
        for(int i = 0; i < primes.length; i++){
            MAX*=primes[i];
        }
        for(int a = 0; a < 60; a++){
            long num = (long) Math.pow(primes[14],a);
            if (num > MAX)break;
            for(int b = 0; b < 60; b++){
                long num1 = num * (long) Math.pow(primes[13],b);
                if (num1 > MAX || num1 < 0) break;
                for(int c = 0; c < 60; c++){
                    long num2 = num1 * (long) Math.pow(primes[12],c);
                    if (num2 > MAX || num2 < 0) break;
                    for(int d = 0; d < 13; d++){
                        long num3 = num2 * (long) Math.pow(primes[11],d);
                        if (num3 > MAX || num3 < 0) break;
                        for(int e = 0; e < 60; e++){
                            long num4 = num3 * (long) Math.pow(primes[10],e);
                            if (num4 > MAX || num4 < 0) break;
                            for(int f = 0; f < 60; f++){
                                long num5 = num4 * (long) Math.pow(primes[9],f);
                                if (num5 > MAX || num5 < 0) break;
                                for(int g = 0; g < 60; g++){
                                    long num6 = num5 * (long) Math.pow(primes[8],g);
                                    if (num6 > MAX || num6 < 0) break;
                                    for(int h = 0; h < 60; h++){
                                        long num7 = num6 * (long) Math.pow(primes[7],h);
                                        if (num7 > MAX || num7 < 0) break;
                                        for(int i = 0; i < 60; i++){
                                            long num8 = num7 * (long) Math.pow(primes[6],i);
                                            if (num8 > MAX || num8 < 0) break;
                                            for(int j = 0; j < 60; j++){
                                                long num9 = num8 * (long) Math.pow(primes[5],j);
                                                if (num9 > MAX || num9 < 0) break;
                                                for(int k = 0; k < 60; k++){
                                                    long num10 = num9 * (long) Math.pow(primes[4],k);
                                                    if (num10 > MAX || num10 < 0) break;
                                                    for(int l = 0; l < 60; l++){
                                                        long num11 = num10 * (long) Math.pow(primes[3],l);
                                                        if (num11 > MAX || num11 < 0) break;
                                                        for(int m = 0; m < 60; m++){
                                                            long num12 = num11 * (long) Math.pow(primes[2],m);
                                                            if (num12 > MAX || num12 < 0) break;
                                                            for(int n = 0; n < 60; n++){
                                                                long num13 = num12 * (long) Math.pow(primes[1],n);
                                                                if (num13 > MAX || num13 < 0) break;
                                                                for(int o = 0; o < 60; o++){
                                                                    long num14 = num13 * (long) Math.pow(primes[0],o);
                                                                    if (num14 > MAX || num14 < 0) break;
                                                                    int[] p = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o};
                                                                    long count = count_dives(p);
                                                                    if (count > LOW) {
                                                                        if (num14 <= MAX) {
                                                                            MAX = num14;
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
        long t2 = System.currentTimeMillis();
        System.out.println("the answer = " + MAX);
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public long count_dives(int[] p){

        long count = 1;
        for(int i = 0; i < p.length; i++){
            count *= ((2*p[i]) + 1);
        }
        return count;
    }
    public void setPrimes(){
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        primes[3] = 7;
        primes[4] = 11;
        primes[5] = 13;
        primes[6] = 17;
        primes[7] = 19;
        primes[8] = 23;
        primes[9] = 29;
        primes[10] = 31;
        primes[11] = 37;
        primes[12] = 41;
        primes[13] = 43;
        primes[14] = 47;

    }
}
