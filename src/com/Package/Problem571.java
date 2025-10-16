package com.Package;

public class Problem571 {

    public void run(){
        long t1 = System.currentTimeMillis();
        int found = 0;
        long sum = 0;

        for(int a1 = 1; a1 < 12; a1++){
            if (found == 10)
                break;
            for(int a2 = 0; a2 < 12; a2++){
                if (a2 == a1)
                    continue;
                if (found == 10)
                    break;
                for(int a3 = 0; a3 < 12; a3++){
                    if (a3 == a1 || a3 == a2)
                        continue;
                    if (found == 10)
                        break;
                    for(int a4 = 0; a4 < 12; a4++){
                        if (a4 == a1 || a4 == a2 || a4 == a3)
                            continue;
                        if (found == 10)
                            break;
                        for(int a5 = 0; a5 < 12; a5++){
                            if (a5 == a1 || a5 == a2 || a5 == a3 || a5 == a4)
                                continue;
                            if (found == 10)
                                break;
                            for(int a6 = 0; a6 < 12; a6++){
                                if (a6 == a1 || a6 == a2 || a6 == a3 || a6 == a4 || a6 == a5)
                                    continue;
                                if (found == 10)
                                    break;
                                for(int a7 = 0; a7 < 12; a7++){
                                    if (a7 == a1 || a7 == a2 || a7 == a3 || a7 == a4 || a7 == a5 || a7==a6)
                                        continue;
                                    if (found == 10)
                                        break;
                                    for(int a8 = 0; a8 < 12; a8++){
                                        if (a8 == a1 || a8 == a2 || a8 == a3 || a8 == a4 || a8 == a5 || a8==a6 || a8==a7)
                                            continue;
                                        if (found == 10)
                                            break;
                                        for(int a9 = 0; a9 < 12; a9++){
                                            if (a9 == a1 || a9 == a2 || a9 == a3 || a9 == a4 || a9 == a5 || a9==a6 || a9==a7 || a9==a8)
                                                continue;
                                            if (found == 10)
                                                break;
                                            for(int a10 = 0; a10 < 12; a10++){
                                                if (a10 == a1 || a10 == a2 || a10 == a3 || a10 == a4 || a10 == a5 || a10==a6 || a10==a7 || a10==a8 || a10==a9)
                                                    continue;
                                                if (found == 10)
                                                    break;
                                                for(int a11 = 0; a11 < 12; a11++){
                                                    if (a11 == a1 || a11 == a2 || a11 == a3 || a11 == a4 || a11 == a5 || a11==a6 || a11==a7 || a11==a8 || a11==a9 || a11==a10)
                                                        continue;
                                                    if (found == 10)
                                                        break;
                                                    for(int a12 = 0; a12 < 12; a12++){
                                                        if (a12 == a1 || a12 == a2 || a12 == a3 || a12 == a4 || a12 == a5 || a12==a6 || a12==a7 || a12==a8 || a12==a9 || a12==a10 || a12==a11)
                                                            continue;
                                                        if (found == 10)
                                                            break;
                                                        //System.out.println(a1 + "," +a2 + "," +a3 + "," +a4 + "," +a5 + "," +a6 + "," +a7 + "," +a8 + "," +a9 + "," +a10 + "," +a11 + "," +a12);
                                                        long number = convertToB10(new int[]{a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12});
                                                        if (isSuperPandigital(number, 12)){
                                                            found++;
                                                            //System.out.println(a1 + "," +a2 + "," +a3 + "," +a4 + "," +a5 + "," +a6 + "," +a7 + "," +a8 + "," +a9 + "," +a10 + "," +a11 + "," +a12 + " = " + number);
                                                            sum += number;
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
        System.out.println("P_751 = " + sum);
        System.out.println("found in " + (t2-t1)/1000.0 + "s");
    }

    public boolean isSuperPandigital(long number, int upB){
        for(int b = upB -1; b >= 2; b--){
            if (!isPandigitalBase(number,b))
                return false;
        }
        return true;
    }

    public long convertToB10(int[] digits){
        long number = 0;

        for(int i = 0; i < digits.length; i++){
            number *= 12;
            number += digits[i];
        }
        return number;
    }

    public boolean isPandigitalBase(long number, int base){

        long bitMask = 0;
        long All1s = (1 << base)-1;

        while (number >= base){
            long dig = number % base;
            bitMask |= (1 << dig);
            number /= base;
        }
        bitMask |= (1 << number);

        return bitMask == All1s;
    }
}
