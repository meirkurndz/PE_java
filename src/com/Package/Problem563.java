package com.Package;

import java.util.Arrays;

public class Problem563 {

    long[] primes = {2, 3, 5, 7, 11, 13, 17, 19 ,23};
    long[] answers = new long[150];
    long[] numbers = new long[2306013];
    long LIMIT = 2300000000000000L;

    public void run(){
        long count = 0;
        Arrays.fill(answers, LIMIT);
        //recursive(1);
        for(long i = 0; i < 100; i++){
            long toCheck = 40 * (long) Math.pow(2, i);
            if (toCheck > LIMIT) break;
            for(long j = 0; j < 100; j++){
                long toCheck1 = (long) (toCheck * Math.pow(3, j));
                if (toCheck1 > LIMIT) break;
                for(long k = 0; k < 100; k++){
                    long toCheck2 = (long) (toCheck1 * Math.pow(5, k));
                    if (toCheck2 > LIMIT) break;
                    for(long l = 0; l < 100; l++){
                        long toCheck3 = (long) (toCheck2 * Math.pow(7, l));
                        if (toCheck3 > LIMIT) break;
                        for(long m = 0; m < 100; m++){
                            long toCheck4 = (long) (toCheck3 * Math.pow(11, m));
                            if (toCheck4 > LIMIT) break;
                            for(long n = 0; n < 100; n++){
                                long toCheck5 = (long) (toCheck4 * Math.pow(13, n));
                                if (toCheck5 > LIMIT) break;
                                for(long o = 0; o < 100; o++){
                                    long toCheck6 = (long) (toCheck5 * Math.pow(17, o));
                                    if (toCheck6 > LIMIT) break;
                                    for(long p = 0; p < 100; p++){
                                        long toCheck7 = (long) (toCheck6 * Math.pow(19, p));
                                        if (toCheck7 > LIMIT) break;
                                        for(long q = 0; q < 100; q++){
                                            long toCheck8 = (long) (toCheck7 * Math.pow(23, q));
                                            if (toCheck8 > LIMIT) break;
                                            count++;
                                            numbers[(int)count] = toCheck8;
                                            //System.out.println(count + " , " + toCheck8);
                                            /*int countToCheck = count(toCheck8);
                                            //System.out.println(toCheck8 + " , " + countToCheck);
                                            if (countToCheck > 1) {
                                                if (answers[countToCheck] > toCheck8) {
                                                    answers[countToCheck] = toCheck8;
                                                    System.out.println(countToCheck + " , " + answers[countToCheck]);
                                                }
                                            }*/
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Arrays.sort(numbers);
        answers[0] = 0;
        answers[1] = 0;
        answers[2] = numbers[936];
        answers[3] = numbers[2085];
        answers[4] = numbers[3957];
        answers[5] = numbers[7622];
        answers[6] = numbers[15759];
        answers[7] = numbers[26107];
        answers[8] = numbers[30060];
        answers[9] = numbers[42636];
        answers[10] = numbers[47564];
        answers[11] = numbers[53095];
        answers[12] = numbers[75891];
        answers[13] = numbers[84230];
        answers[14] = numbers[95974];
        answers[15] = numbers[105635];
        answers[16] = numbers[109133];
        answers[17] = numbers[131128];
        answers[18] = numbers[148438];
        answers[19] = numbers[164894];
        answers[20] = numbers[167014];
        answers[21] = numbers[179692];
        answers[22] = numbers[197185];
        answers[23] = numbers[202514];
        answers[24] = numbers[241170];
        answers[25] = numbers[276424];
        answers[26] = numbers[247548];
        answers[27] = numbers[309763];
        answers[28] = numbers[293634];
        answers[29] = numbers[355959];
        answers[30] = numbers[301217];
        answers[31] = numbers[380653];
        answers[32] = numbers[337184];
        answers[33] = numbers[376900];
        answers[34] = numbers[407530];
        answers[35] = numbers[424841];
        answers[36] = numbers[454465];
        answers[37] = numbers[496971];
        answers[38] = numbers[541823];
        answers[39] = numbers[490581];
        answers[40] = numbers[584028];
        answers[41] = numbers[510978];
        answers[42] = numbers[545840];
        answers[43] = numbers[588297];
        answers[44] = numbers[612246];
        answers[45] = numbers[653128];
        answers[46] = numbers[648440];
        answers[47] = numbers[711657];
        answers[48] = numbers[778719];
        answers[49] = numbers[730915];
        answers[50] = numbers[719061];
        answers[51] = numbers[743774];
        answers[52] = numbers[773233];
        answers[53] = numbers[904335];
        answers[54] = numbers[876191];
        answers[55] = numbers[855704];
        answers[56] = numbers[918857];
        answers[57] = numbers[895265];
        answers[58] = numbers[989098];
        answers[59] = numbers[929970];
        answers[60] = numbers[1132299];
        answers[61] = numbers[1081640];
        answers[62] = numbers[1038692];
        answers[63] = numbers[1088291];
        answers[64] = numbers[1014877];
        answers[65] = numbers[1175015];
        answers[66] = numbers[1119689];
        answers[67] = numbers[1363540];
        answers[68] = numbers[1314215];
        answers[69] = numbers[1227371];
        answers[70] = numbers[1498871];
        answers[71] = numbers[1199750];
        answers[72] = numbers[1351311];
        answers[73] = numbers[1370189];
        answers[74] = numbers[1475559];
        answers[75] = numbers[1453465];
        answers[76] = numbers[1321225];
        answers[77] = numbers[1445832];
        answers[78] = numbers[1413882];
        answers[79] = numbers[1628225];
        answers[80] = numbers[1610818];
        answers[81] = numbers[1523153];
        answers[82] = numbers[1692153];
        answers[83] = numbers[1554279];
        answers[84] = numbers[1706902];
        answers[85] = numbers[1698091];
        answers[86] = numbers[1986077];
        answers[87] = numbers[1917996];
        answers[88] = numbers[1897302];
        answers[89] = numbers[1787228];
        answers[90] = numbers[1863093];
        answers[91] = numbers[1856638];
        answers[92] = numbers[1823084];
        answers[93] = numbers[1959843];
        answers[94] = numbers[2069380];
        answers[95] = numbers[1998749];
        answers[96] = numbers[2132324];
        answers[98] = numbers[2091115];

        int count3 = 0;
        for(int i = 2132324; i <= numbers.length; i++){
            if (numbers[i] % 800 == 0) {
                int num2 = count(numbers[i]);
                if (answers[num2] > numbers[i]) {
                    answers[num2] = numbers[i];
                    //System.out.println(num2 + " , " + answers[num2] + " , " + i);
                    if (num2 <= 100){
                        count3++;
                        if (count3 == 3) break;
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 2; i <= 100; i++){
            sum += answers[i];
        }
        System.out.println("the answer = " + sum);
    }

    public int count(long i){

        long sqrt = (long)Math.sqrt(i);
        int count = 0;
        for(long a = sqrt; a > 0 ; a--) {
            if (i % a == 0){
                long b = i/a;
                if ((11*(double)a)/(double)10 < b) return count;
                //System.out.println(i + " , " + a + " , " + b);
                count++;
            }
        }
        return count;
    }

    public boolean is25Smooth(long number){

        for(int i = 0; i < primes.length; i++){
            while (number % primes[i] == 0){
                number /= primes[i];
            }
            if (number == 1) return true;
        }
        return false;
    }

    public boolean is10(long div1, long div2){
        double is10 = (double) div1 / 10;
        if ((double)div1 + is10 < div2) return false;
        return true;
    }



}
