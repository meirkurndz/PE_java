package com.Package;

import org.w3c.dom.ls.LSOutput;

public class Problem610 {
    //319.3020749653885
    static final int size = 30000;
    String[] romans = new String[size];
    int[] len = new int[size];
    double[] prob = new double[size];
    double[] p_pow = new double[150];
    double[] geo = new double[150];
    double[] ave = new double[150];
    double[] val_prob = new double[size];

    public void run(){
        set_p_pow();
        set_romans();
        set_geo();
        set_val_prob();
        set_ave();
        //double E = expected(0);
        double E1 = 0;
        for(int i = 0; i < size; i++){
            E1 += i*val_prob[i];
        }
        System.out.println("the answer = " + E1);
        //System.out.println(E);
    }

    public double expected(int number){
        //System.out.println(number);
        String s_num = romans[number];
        //System.out.println("the s = " + s_num);
        int[] next = new int[7];
        int count = 0;
        if(is_reduce(s_num.concat("M"))) {
            next[count] = val(s_num.concat("M"));
            count++;
        }
        if(is_reduce(s_num.concat("D"))) {
            next[count] = val(s_num.concat("D"));
            count++;
        }
        if(is_reduce(s_num.concat("C"))) {
            next[count] = val(s_num.concat("C"));
            count++;
        }
        if(is_reduce(s_num.concat("L"))) {
            next[count] = val(s_num.concat("L"));
            count++;
        }
        if(is_reduce(s_num.concat("X"))) {
            next[count] = val(s_num.concat("X"));
            count++;
        }
        if(is_reduce(s_num.concat("V"))) {
            next[count] = val(s_num.concat("V"));
            count++;
        }
        if(is_reduce(s_num.concat("I"))) {
            next[count] = val(s_num.concat("I"));
            count++;
        }

        if(count == 0){
            return number;
        }else{
            double sum = 0;
            double div = 0.02;
            for(int i = 0; i < count; i++){
                //System.out.print(next[i]);
                div += 0.14;
                sum += 0.14*expected(next[i]);
            }
            return (0.02*number + sum)/div;
        }

    }

    public void set_val_prob(){
        val_prob[0] = 0.02;
        for(int num = 1; num < size; num++){
            double p = 0.14;
            String s_num = romans[num];
            for(int i = 1; i < len[num]; i++){
                int count = 0;
                if(is_reduce(s_num.substring(0,i).concat("M"))) count++;
                if(is_reduce(s_num.substring(0,i).concat("D"))) count++;
                if(is_reduce(s_num.substring(0,i).concat("C"))) count++;
                if(is_reduce(s_num.substring(0,i).concat("L"))) count++;
                if(is_reduce(s_num.substring(0,i).concat("X"))) count++;
                if(is_reduce(s_num.substring(0,i).concat("V"))) count++;
                if(is_reduce(s_num.substring(0,i).concat("I"))) count++;
                if (count > 0){
                    p *= 0.14/(((count)*0.14)+0.02);
                }
            }
            int count = 0;
            if(is_reduce(s_num.concat("M"))) count++;
            if(is_reduce(s_num.concat("D"))) count++;
            if(is_reduce(s_num.concat("C"))) count++;
            if(is_reduce(s_num.concat("L"))) count++;
            if(is_reduce(s_num.concat("X"))) count++;
            if(is_reduce(s_num.concat("V"))) count++;
            if(is_reduce(s_num.concat("I"))) count++;
            if (count > 0){
                p *= 0.02/(((count)*0.14)+0.02);
            }
            val_prob[num] = p;
        }
    }

    public boolean is_reduce(String number){
        int val = val(number);
        if(val >= size){
            return false;
        }
        if(number.equals(romans[val])){
            return true;
        }
        return false;
    }

    public int val(String number){
        int len = number.length();
        if(len == 0){
            return 0;
        }
        if(len == 1){
            switch (number){
                case "M":
                    return 1000;
                case "D":
                    return 500;
                case "C":
                    return 100;
                case "L":
                    return 50;
                case "X":
                    return 10;
                case "V":
                    return 5;
                case "I":
                    return 1;
            }
        }else{
            switch (number.charAt(0)){
                case 'M':
                    return 1000 + val(number.substring(1));
                case 'D':
                    return 500 + val(number.substring(1));
                case 'C':
                    if(number.charAt(1) == 'M'){
                        return 900 + val(number.substring(2));
                    }else if(number.charAt(1) == 'D'){
                        return 400 + val(number.substring(2));
                    }else{
                        return 100 + val(number.substring(1));
                    }
                case 'L':
                    return 50 + val(number.substring(1));
                case 'X':
                    if(number.charAt(1) == 'C'){
                        return 90 + val(number.substring(2));
                    }else if(number.charAt(1) == 'L'){
                        return 40 + val(number.substring(2));
                    }else{
                        return 10 + val(number.substring(1));
                    }
                case 'V':
                    return 5 + val(number.substring(1));
                case 'I':
                    if(number.charAt(1) == 'X'){
                        return 9 + val(number.substring(2));
                    }else if(number.charAt(1) == 'V'){
                        return 4 + val(number.substring(2));
                    }else{
                        return 1 + val(number.substring(1));
                    }
                default:
                    return 0;
            }
        }
        return 0;
    }

    public void set_geo(){
        geo[0] = 0.02;
        for(int i = 1; i < geo.length; i++){
            geo[i] = 0.98 * geo[i-1];
        }
    }

    public void set_ave(){

        for(int i = 0; i < romans.length; i++){
            ave[len[i]] += i*val_prob[i];
        }

    }
    public void set_p_pow(){
        p_pow[0] = 0.02;
        for(int i = 1; i < p_pow.length; i++){
            p_pow[i] = 0.14*p_pow[i-1];
        }
    }

    public void set_romans(){
        romans[0] = "";
        romans[1] = "I";
        romans[2] = "II";
        romans[3] = "III";
        romans[4] = "IV";
        romans[5] = "V";
        romans[6] = "VI";
        romans[7] = "VII";
        romans[8] = "VIII";
        romans[9] = "IX";
        for(int i = 10; i < romans.length; i++){
            romans[i] = make_roman(i);
        }

        for(int i = 0; i < len.length;i++){
            len[i] = romans[i].length();
            prob[i] = p_pow[len[i]];
        }


    }

    public String make_roman(int number){

        if(number == 0){
            return "";
        }
        if(number >= 1000){
            return "M" + romans[number-1000];
        }
        if(number < 500){
            if(number >= 400){
                return "CD" + romans[number-400];
            }else if(number >= 100){
                return "C" + romans[number-100];
            }else{
                if(number < 50){
                    if(number >= 40){
                        return "XL" + romans[number-40];
                    }else{
                        if(number >= 10){
                            return "X" + romans[number-10];
                        }else{
                            return romans[number];
                        }
                    }
                }else{
                    if(number >= 90){
                        return "XC" + romans[number-90];
                    }else{
                        return "L" + romans[number-50];
                    }
                }
            }
        }else{
            if(number >= 900){
                return "CM" + romans[number-900];
            }else{
                return "D" + romans[number-500];
            }
        }
    }


}
