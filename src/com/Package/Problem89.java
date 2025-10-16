package com.Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problem89 {


    public void run() throws IOException {

        File file = new File("C:\\Users\\מאיר קורניץ\\ProjectEuler\\src\\com\\Package\\p089_roman.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        int count = 0;

        while ((line = br.readLine()) != null){
            int val = readRomanNum(line);
            count += digNumRoman(line) - digNumDecToRoman(val);
        }
        System.out.println(count);
    }

    public int digNumDecToRoman(int val){
        int digNum = 0;
        int temp = val;

        digNum += temp / 1000;
        temp = temp % 1000;

        switch (temp/100){
            case 8:
                digNum += 4;
                break;
            case 7:
            case 3:
                digNum += 3;
                break;
            case 9:
            case 6:
            case 4:
            case 2:
                digNum += 2;
                break;
            case 5:
            case 1:
                digNum += 1;
                break;
        }
        temp = temp % 100;

        switch (temp/10){
            case 8:
                digNum += 4;
                break;
            case 7:
            case 3:
                digNum += 3;
                break;
            case 9:
            case 6:
            case 4:
            case 2:
                digNum += 2;
                break;
            case 5:
            case 1:
                digNum += 1;
                break;
        }

        temp = temp % 10;

        switch (temp){
            case 8:
                digNum += 4;
                break;
            case 7:
            case 3:
                digNum += 3;
                break;
            case 9:
            case 6:
            case 4:
            case 2:
                digNum += 2;
                break;
            case 5:
            case 1:
                digNum += 1;
                break;
        }
        return digNum;
    }

    public int digNumRoman(String romanNum){
        return romanNum.length();
    }

    public int readRomanNum(String romanNum){

        int sum = 0;
        for(int index = 0 ; index < romanNum.length(); index++){
            char c = romanNum.charAt(index);
            switch (c){
                case 'M':
                    sum += 1000;
                    //System.out.println("letter number " + (index + 1) + " = " + c);
                    break;
                case 'D':
                    sum += 500;
                    //System.out.println("letter number " + (index + 1) + " = " + c);
                    break;
                case 'L':
                    sum += 50;
                    //System.out.println("letter number " + (index + 1) + " = " + c);
                    break;
                case 'V':
                    sum += 5;
                    //System.out.println("letter number " + (index + 1) + " = " + c);
                    break;
                case 'C':
                    if (index != romanNum.length()-1){
                    char temp = romanNum.charAt(index + 1);
                    if (temp == 'D'){
                            sum += 400;
                            index++;
                      //      System.out.println("letter number " + (index + 1) + " = " + c + "" + temp);
                            break;
                        }else if(temp == 'M'){
                            sum += 900;
                            index++;
                        //    System.out.println("letter number " + (index + 1) + " = " + c + "" + temp);
                            break;
                        }else{
                        sum += 100;
                        //System.out.println("letter number " + (index + 1) + " = " + c);
                        break;
                        }
                    }else{
                        sum += 100;
                        //System.out.println("letter number " + (index + 1) + " = " + c);
                        break;
                    }
                case 'X':
                    if (index != romanNum.length()-1){
                        char temp1 = romanNum.charAt(index + 1);
                        if (temp1 == 'L'){
                            sum += 40;
                            index++;
                          //  System.out.println("letter number " + (index + 1) + " = " + c + "" + temp1);
                            break;
                        }else if(temp1 == 'C'){
                            sum += 90;
                            index++;
                            //System.out.println("letter number " + (index + 1) + " = " + c + "" + temp1);
                            break;
                        }else{
                            sum += 10;
                            //System.out.println("letter number " + (index + 1) + " = " + c);
                            break;
                        }
                    }else{
                        sum += 10;
                        //System.out.println("letter number " + (index + 1) + " = " + c);
                        break;
                    }
                case 'I':
                    if(index != romanNum.length()-1) {
                        char temp2 = romanNum.charAt(index + 1);
                        if (temp2 == 'V') {
                            sum += 4;
                            index++;
                          //  System.out.println("letter number " + (index + 1) + " = " + c + "" + temp2);
                            break;
                        } else if (temp2 == 'X') {
                            sum += 9;
                            index++;
                            //System.out.println("letter number " + (index + 1) + " = " + c + "" + temp2);
                            break;
                        } else {
                            sum += 1;
                            //System.out.println("letter number " + (index + 1) + " = " + c);
                            break;
                        }
                    }else{
                        sum += 1;
                        //System.out.println("letter number " + (index + 1) + " = " + c);
                        break;
                    }
            }
        }
        return sum;
    }
}
