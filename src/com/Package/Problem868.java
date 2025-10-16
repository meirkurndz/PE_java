package com.Package;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Problem868 {

    static final int length = 6;
    int[] permut = new int[length];
    int[] location = new int[length];
    static long COUNT = 0;
    HashSet<Long> memo = new HashSet<>();
    Stack<Long> layer = new Stack<>();
    Stack<Long> tempLayer = new Stack<>();

    public void run(){
        set_permute();
        long key = key();
        memo.add(key);
        System.out.println(1 + ", " + int_to_str(key()));
        rec(1);

    }

    public void rec(int len){
        long key = key();
        for(int i = 0; i < length; i++){
            int loc = location[i];
            if (loc > 0){
                if(swap_left(loc,i)){
                    key = key();
                    memo.add(key);
                    System.out.println((len+1) + ", " + int_to_str(key));
                    print_loc();
                    rec(len+1);
                }
                int temp = permut[loc-1];
                permut[loc-1] = permut[loc];
                permut[loc]=temp;
                int temp_loc =  location[loc-1];
                location[loc-1] = location[loc];
                location[loc] = temp_loc;
            }
            if(loc < length-1){
                if(swap_right(loc,i)){
                    key = key();
                    memo.add(key);
                    System.out.println((len+1) + ", " + int_to_str(key));
                    print_loc();
                    rec(len+1);

                }
                int temp = permut[loc+1];
                permut[loc+1] = permut[loc];
                permut[loc]=temp;
                int temp_loc =  location[loc+1];
                location[loc+1] = location[loc];
                location[loc]=temp_loc;
            }
        }
    }

    public boolean swap_right(int index, int loc){
        int temp = permut[index+1];
        permut[index+1] = permut[index];
        permut[index]=temp;
        long key = key();
        //System.out.println("test " + key);
        if (memo.contains(key)){
            return false;
        }else{
            location[loc]++;
            int temp_loc = get_loc(permut[index+1]);
            location[loc-1]--;
            return true;
        }
    }


    public boolean swap_left(int index, int loc){
        int temp = permut[index-1];
        permut[index-1] = permut[index];
        permut[index]=temp;
        long key = key();
        //System.out.println("test " + key);
        if (memo.contains(key())){
            return false;
        }else{
            //int temp_loc =  get_loc(permut[index-1]);
            location[loc]--;
            int temp_loc = get_loc(permut[index-1]);
            location[loc+1]++;
            return true;
        }
    }

    public long key() {
        long ret = permut[0];
        for(int i = 1; i < length; i++){
            ret *= 10;
            ret += permut[i];
        }
        return ret;
    }

    public void set_permute(){
        //BELFRY
        permut[0]=2;
        permut[1]=5;
        permut[2]=6;
        permut[3]=12;
        permut[4]=18;
        permut[5]=25;
        /*permut[0]=;
        permut[0]=;
        permut[0]=;
        permut[0]=;
        permut[0]=;
        permut[0]=;
        permut[0]=;
        permut[0]=;
        permut[0]=;*/
        location[0] = 5;
        location[1] = 4;
        location[2] = 3;
        location[3] = 2;
        location[4] = 1;
        location[5] = 0;
    }

    public String int_to_str(long number){
        String str = "";
        for(int i = 0; i < permut.length; i++){
            str += int_to_char(permut[i]);
        }
        return str;
    }

    public char int_to_char(long number){
        return (char)(number + 64);
    }

    public void print_loc(){
        for(int i = 0; i < location.length; i++){
            System.out.print(location[i] + ",");
        }
        System.out.println();
    }

    public int get_loc(int number){
        for(int i = 0; i < permut.length;i++){
            if(permut[i] == number) return i;
        }
        return -1;
    }

}
