package com.Package;

public class Problem230 {

    long[] fibonacci = {0, 1, 2, 3, 5, 8, 13, 21, 34, 55,
            89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368,
            75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887,
            9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
            433494437, 701408733, 1134903170, 1836311903, 2971215073L, 4807526976L, 7778742049L,
            12586269025L, 20365011074L, 32951280099L, 53316291173L, 86267571272L, 139583862445L,
            225851433717L, 365435296162L, 591286729879L, 956722026041L, 1548008755920L,
            2504730781961L, 4052739537881L, 6557470319842L, 10610209857723L, 17167680177565L,
            27777890035288L, 44945570212853L, 72723460248141L, 117669030460994L, 190392490709135L,
            308061521170129L, 498454011879264L, 806515533049393L, 1304969544928657L, 2111485077978050L,
            3416454622906707L, 5527939700884757L, 8944394323791464L, 14472334024676221L, 23416728348467685L,
            37889062373143906L,61305790721611591L, 99194853094755497L};

    String A = "1415926535897932384626433832795028841971" +
                 "6939937510582097494459230781640628620899" +
                 "86280348253421170679";
    String B =   "82148086513282306647" +
                 "0938446095505822317253594081284811174502" +
                 "8410270193852110555964462294895493038196";

    public void run(){
        String answer = "";
        for (int i = 0; i <= 17; i++){
            long mag = (long) Math.pow(10, i);
            long number = (127 + 19*i)*(long)Math.pow(7,i);
            int index = 0;
            for(int j = 0; j < fibonacci.length; j++){
                if (fibonacci[j] * 100 > number) {
                    index = j;
                    break;
                }
            }
            String temp = lowerIndex(number);
            //System.out.println(number + " , " + temp);
            answer = temp + answer;
        }
        System.out.println("the answer = " + answer);

    }

    public String lowerIndex(long number){
        int index = 0;
        for(int i = 0; i < fibonacci.length; i++){
            if (fibonacci[i] * 100 > number) {
                index = i;
                break;
            }
        }
        int tempIndex = index;
        while (index > 2){
            if (number > fibonacci[index-2] * 100){
                number -= fibonacci[index-2] * 100;
                index--;
                //tempIndex = index;
            }else{
                index -= 2;
            }
        }
        if (index == 1){
            if (number > 100)
            return String.valueOf(A.charAt((int) number - 101));
            return String.valueOf(B.charAt((int) number - 1));
        }
        if (index == 2){
            if (number > 100)
            return String.valueOf(B.charAt((int) number - 101));
            return String.valueOf(A.charAt((int) number - 1));
        }

        return "false";


/*
        if (index == 0){
            return String.valueOf(A.charAt((int) number - 1));
        }
        if (index == 1){
            return String.valueOf(B.charAt((int) number - 1));
        }
        int tempIndex = index;
        while (number < fibonacci[index - 1] * 100) {
            index -= 1;

            if (index == 1) {
                if (tempIndex % 2 == 1) {
                    return String.valueOf(B.charAt((int) number - 1));
                }else{
                    return String.valueOf(A.charAt((int) number - 1));
                }
            }

        }
        number -= fibonacci[index - 1] * 100;
        if (index >= 2) {
            if (number > fibonacci[index - 2] * 100) {
                return lowerIndex(number, index - 1);
            }
        }
        return lowerIndex(number, index - 2);*/
    }
}