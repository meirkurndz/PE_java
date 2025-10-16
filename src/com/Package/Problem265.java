package com.Package;

import java.util.Arrays;

public class Problem265 {

    public void run(){

        boolean[] used = new boolean[32];
        Arrays.fill(used, false);
        used[0] = true;
        System.out.println("the answer = " + count(5, "00000", used));

    }

    public long count(int length, String str, boolean[] used){

        if (length == 32){

            String[] tempStr = new String[4];

            tempStr[0] = str.substring(str.length()-4);
            tempStr[0] = tempStr[0].concat("0");

            tempStr[1] = str.substring(str.length()-3);
            tempStr[1] = tempStr[1].concat("00");

            tempStr[2] = str.substring(str.length()-2);
            tempStr[2] = tempStr[2].concat("000");

            tempStr[3] = str.substring(str.length()-1);
            tempStr[3] = tempStr[3].concat("0000");


            for(int i = 0; i < tempStr.length; i++){
                int temp = Integer.parseInt(tempStr[i], 2);
                if (used[temp]){
                    return 0;
                }
            }

            //System.out.println(str);
            return Long.parseLong(str,2);

        }else {

            long count = 0;
            String temp0 = str.concat("0");
            String temp1 = str.concat("1");

            int last5with0 = Integer.parseInt(temp0.substring(temp0.length() - 5), 2);
            int last5with1 = Integer.parseInt(temp1.substring(temp1.length() - 5), 2);

            if (!used[last5with0]) {
                used[last5with0] = true;
                count += count(length + 1, temp0, used);
                used[last5with0] = false;
            }

            if (!used[last5with1]) {
                used[last5with1] = true;
                count += count(length + 1, temp1, used);
                used[last5with1] = false;
            }
            return count;
        }
    }
}