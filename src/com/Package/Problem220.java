package com.Package;

public class Problem220 {

    static final String a = "aRbFR";
    static final String b = "LFaLb";

    public void run(){

        String Dn = "Fa";


        long temp = 1;
        for(int i = 1; i <= 50 ;i++){
            temp *=2;
            temp++;
            System.out.println(i + " , " + temp);
        }

    }

    public String dragon(String Dn){
        String DnP1 = "";
        DnP1 = DnP1.concat(Dn).concat("R");
        long length = Dn.length();
/*
        for(long i = length-1; i >= 0; i--){
            if ()
        }*/


        return DnP1;
    }

    public String process(String DnMin1){
        String Dn = "";
        char[] DnMin1Arr = DnMin1.toCharArray();
        int size = DnMin1.length();
        for(int i = 0; i < DnMin1Arr.length; i++){
            switch (DnMin1Arr[i]){
                case 'a':
                    Dn = Dn.concat(a);
                    break;
                case 'b':
                    Dn = Dn.concat(b);
                    break;
                case 'L':
                    Dn = Dn.concat("L");
                    break;
                case 'R':
                    Dn = Dn.concat("R");
                    break;
                case 'F':
                    Dn = Dn.concat("F");
                    break;
            }
        }
        return Dn;
    }


}