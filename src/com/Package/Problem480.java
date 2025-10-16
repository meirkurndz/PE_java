package com.Package;

import java.util.Hashtable;

public class Problem480 {

    String theStr = "aaaaaacdeeeeeeffffghiiiiilmnnnnnorrrssssttttuuwy";
    long[] factorial = new long[20];
    static final long START = 611641151151344211L;
    String[] getCharWithPos = {"a","c","d","e","f","g","h","i","l","m","n","o","r","s","t","u","w","y"};
    int[] charCount = {6,1,1,6,4,1,1,5,1,1,5,1,3,4,4,2,1,1};

    public void run(){
        long t1 = System.currentTimeMillis();
        setFactorials();
        System.out.println("the answer = " + W(P("legionary") + P("calorimeters") - P("annihilate") + P("orchestrated") - P("fluttering")));
        //System.out.println(W(P("eminence") - P("costume") - P("attained") + P("myself") - P("dissimulation")));
        long t2 = System.currentTimeMillis();
        System.out.println("found in " + (t2-t1) + "ms");
    }

    public String W(long pos){
        String word = "";
        long currPos = 0;

        while (currPos != pos){
            for(int i = 1; i < getCharWithPos.length; i++){
                String temp = word.concat(getCharWithPos[i]);
                currPos = P(temp);
                //System.out.println(word);
                if (currPos > pos){
                    word = word.concat(getCharWithPos[i-1]);
                    currPos = P(word);
                    break;
                }
            }
        }
        return word;
    }

    public long P(String word){
        long before = 0;
        char[] wordArr = word.toCharArray();
        String start = "";
        for(int i = 0; i < wordArr.length; i++){
            int lim = charPos(wordArr[i]);
            before++;
            for(int j = 0; j < lim; j++){
                String currStart = start.concat(getCharWithPos[j]);
                long temp = numOfWordsStart(currStart);
                before += temp;
            }
            start = start.concat(getCharWithPos[lim]);
        }
        return before;
    }

    public long numOfWordsStart(String start){
        int len = 15 - start.length();
        long temp = START;
        char[] charArr = start.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            temp -= toSub(charArr[i]);
        }
        if (!isLegal(temp)){
            //System.out.println(start + " is not legal");
            return 0;
        }
        long numOfWords = 1;
        for(int i = 1; i <= len; i++) {
            long wordsLen = freq(temp,i);
            numOfWords += wordsLen;
            //System.out.println(temp);
        }
        //System.out.println("the number of words starts with " + start + " = " + numOfWords);
        return numOfWords;
    }

    public long freq(long letters, int len){
        //System.out.println("len = " + len + " , letters = " + letters);
        long temp = letters;
        int[] freq = new int[7];
        for(; temp != 0; ){
            int let = (int)(temp % 10);
            for(int j = let; j > 0; j--)
                freq[j]++;
            temp /= 10;
        }
        //display(freq);
        int[] cash = new int[freq.length];
        for(int i = 0; i < freq.length; i++){
            cash[i] = freq[i];
        }
        return count2(freq,cash,6,len,0);
    }

    public long count2(int[] freq, int[] cash, int index, int len, long num){

        if (len < 0 || index <= 0)
            return 0;

        if (len==0){
            //display(freq);
            //System.out.println(num);
            return calc(freq,num);
        }

        long calc = 0;
        if (cash[index] > 0) {
            for(int i = index; i > 0; i--)
                cash[i]--;
            calc += count2(freq, cash,index, len - index, num + (long) Math.pow(10, 2*(6 - index)));
            for(int i = index; i > 0; i--)
                cash[i]++;
        }
        calc += count2(freq,cash,index-1,len,num);
        return calc;
    }

    public long calc(int[] freq, long num){
        int[] newfreq = new int[freq.length];
        System.arraycopy(freq, 0, newfreq, 0, freq.length);
        long calc = 1;
        long divPerm = 1;
        int len = 0;
        for(int i = 6; i > 0; i--){
            int temp = (int)(num % 100);
            if (temp > 0) {
                long choose = choose(newfreq[i], temp);
                calc *= choose;
                for(int j = i-1; j > 0; j--)
                    newfreq[j]-= temp;
                divPerm *= Math.pow(factorial[i],temp);
                len += i*temp;
            }
            num /= 100;
        }
        return calc*(factorial[len]/divPerm);
    }

    public long choose(int n, int k){
        //System.out.println("n = " + n + ", k = " + k);
        if (n == k || k == 0) return 1;
        if (k > n/2)
            return choose(n,n-k);
        return factorial[n]/(factorial[k]*factorial[n-k]);
    }

    public void setFactorials(){
        factorial[0] = 1;
        factorial[1] = 1;
        for(int i = 2; i < factorial.length; i++){
            factorial[i] = factorial[i-1] * i;
        }
    }

    public boolean isLegal(long number){
        if (number <= 0)
            return false;
        while (number != 0){
            int temp = (int) (number % 10);
            if (temp > 6)
                return false;
            number /= 10;
        }
        return true;
    }

    public int charPos(char c){
        switch (c){
            case 'a':
                return 0;
            case 'c':
                return 1;
            case 'd':
                return 2;
            case 'e':
                return 3;
            case 'f':
                return 4;
            case 'g':
                return 5;
            case 'h':
                return 6;
            case 'i':
                return 7;
            case 'l':
                return 8;
            case 'm':
                return 9;
            case 'n':
                return 10;
            case 'o':
                return 11;
            case 'r':
                return 12;
            case 's':
                return 13;
            case 't':
                return 14;
            case 'u':
                return 15;
            case 'w':
                return 16;
            case 'y':
                return 17;
        }
        return 0;
    }

    public long toSub(char c) {
        switch (c){
            case 'a':
                return 100000000000000000L;
            case 'c':
                return 10000000000000000L;
            case 'd':
                return 1000000000000000L;
            case 'e':
                return 100000000000000L;
            case 'f':
                return 10000000000000L;
            case 'g':
                return 1000000000000L;
            case 'h':
                return 100000000000L;
            case 'i':
                return 10000000000L;
            case 'l':
                return 1000000000L;
            case 'm':
                return 100000000L;
            case 'n':
                return 10000000L;
            case 'o':
                return 1000000L;
            case 'r':
                return 100000L;
            case 's':
                return 10000L;
            case 't':
                return 1000L;
            case 'u':
                return 100L;
            case 'w':
                return 10L;
            case 'y':
                return 1L;
        }
        return 0;
    }

}
