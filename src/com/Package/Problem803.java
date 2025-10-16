package com.Package;

public class Problem803 {
    //16813736630 = PuzzleWaX
    static double ADD = 65536D;
    static final long MUL = 25214903917L;
    static final long MOD = 281474976710656L;
    public void run(){

        sec(100);
        for(long m = 41; m < MOD; m += 52) {
            for (long i = (long) ADD * m; i < (long) ADD * (m+1); i++) {
                sec(i);
            }
        }
    }

    public void sec(long number) {

        char b_0 = trans((long)((Math.floor(number/ADD) % 52)));
        if (b_0=='P'){
            long a_1 = mulMod(number,MUL,MOD) + 11;
            char b_1 = trans((long) ((Math.floor(a_1/ADD) % 52)));
            if (b_1=='u'){
                long a_2 = mulMod(a_1,MUL,MOD) + 11;
                char b_2 = trans((long) ((Math.floor(a_2/ADD) % 52)));
                if (b_2=='z'){
                    long a_3 = mulMod(a_2,MUL,MOD) + 11;
                    char b_3 = trans((long) ((Math.floor(a_3/ADD) % 52)));
                    if (b_3=='z'){
                        long a_4 = mulMod(a_3,MUL,MOD) + 11;
                        char b_4 = trans((long) ((Math.floor(a_4/ADD) % 52)));
                        if (b_4=='l'){
                            long a_5 = mulMod(a_4,MUL,MOD) + 11;
                            char b_5 = trans((long) ((Math.floor(a_5/ADD) % 52)));
                            if (b_5=='e'){
                                long a_6 = mulMod(a_5,MUL,MOD) + 11;
                                char b_6 = trans((long) ((Math.floor(a_6/ADD) % 52)));
                                if (b_6=='O'){
                                    long a_7 = mulMod(a_6,MUL,MOD) + 11;
                                    char b_7 = trans((long) ((Math.floor(a_7/ADD) % 52)));
                                    if (b_7=='n'){
                                        long a_8 = mulMod(a_7,MUL,MOD) + 11;
                                        char b_8 = trans((long) ((Math.floor(a_8/ADD) % 52)));
                                        if (b_8=='e'){
                                            System.out.println(number + " = " +b_0+""+b_1+""+b_2+""+b_3+""+b_4+""+b_5+""+b_6+""+b_7+""+b_8);
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

    public static long mulMod(long a, long b, long m) {
        long res = 0;
        a %= m; // Ensure 'a' is within the modulus range initially

        while (b > 0) {
            // If 'b' is odd, add 'a' to the result (modulo m)
            if ((b & 1) == 1) {
                res = (res + a) % m;
            }
            // Double 'a' (modulo m)
            a = (2 * a) % m;
            // Halve 'b'
            b >>= 1;
        }
        return res;
    }

    public char trans(long number){
        switch ((int)number){
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            case 8:
                return 'i';
            case 9:
                return 'j';
            case 10:
                return 'k';
            case 11:
                return 'l';
            case 12:
                return 'm';
            case 13:
                return 'n';
            case 14:
                return 'o';
            case 15:
                return 'p';
            case 16:
                return 'q';
            case 17:
                return 'r';
            case 18:
                return 's';
            case 19:
                return 't';
            case 20:
                return 'u';
            case 21:
                return 'v';
            case 22:
                return 'w';
            case 23:
                return 'x';
            case 24:
                return 'y';
            case 25:
                return 'z';
            case 26:
                return 'A';
            case 27:
                return 'B';
            case 28:
                return 'C';
            case 29:
                return 'D';
            case 30:
                return 'E';
            case 31:
                return 'F';
            case 32:
                return 'G';
            case 33:
                return 'H';
            case 34:
                return 'I';
            case 35:
                return 'J';
            case 36:
                return 'K';
            case 37:
                return 'L';
            case 38:
                return 'M';
            case 39:
                return 'N';
            case 40:
                return 'O';
            case 41:
                return 'P';
            case 42:
                return 'Q';
            case 43:
                return 'R';
            case 44:
                return 'S';
            case 45:
                return 'T';
            case 46:
                return 'U';
            case 47:
                return 'V';
            case 48:
                return 'W';
            case 49:
                return 'X';
            case 50:
                return 'Y';
            case 51:
                return 'Z';

        }
        System.out.println(number);
        return '!';
    }

}
