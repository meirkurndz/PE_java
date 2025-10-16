package com.Package;

public class Problem366 {
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
    long[] fractal = new long[79];
    public void run(){
        //doubleFib();
        long sum = 0;
        for(long i = 2; i <= 1000; i++){
            //long temp = win(i, smallestZekendorf(i));
            long temp = (tree(i) % 100000000);
            System.out.println(i + " , " + temp);
            sum += temp;
        }
        System.out.println(sum);
    }

    public long tree(long number){

        long temp = number;
        int lastIndex = trySearch(0,82,number);
        number -= fibonacci[lastIndex];
        while (fibonacci[lastIndex] <= 2 * number){
            int index = trySearch(0, lastIndex + 1, number);
            lastIndex = index;
            number -= fibonacci[index];
        }
        return number;
    }
    public int trySearch(int start, int end, long number){

        int mid = (start + end)/2;
        if (fibonacci[mid] == number) return mid;
        if (fibonacci[mid] < number){
            if (fibonacci[mid + 1] > number){
                return mid;
            }
            return trySearch(mid, end, number);
        }
        if (fibonacci[mid - 1] < number) return mid-1;
        return trySearch(start, mid, number);
    }

    public long win(long number, long fib){
        if (fib == 0) return 0;
        long temp = number - fib;
        if(temp * 2 >= fib){
            if (temp % 2 == 0) return (temp/2) - 1;
            return temp/2;
        }
        return temp;
    }

    public long smallestZekendorf(long number){
        if(isFib(number)) return 0;
        long tempNum = number;
        long smallest = 0;//fibonacci[82];
        int start = 0;
        int end = 82;
        int mid;
        mid = search(start, end, number);
        if (mid == 0) return 0;
        smallest = fibonacci[mid];
        if (smallest == tempNum ) return 0;
        return smallest;
    }

    public boolean isFib(long number){
        for(int i = 1; fibonacci[i] < number + 1; i++){
            if (fibonacci[i] == number) return true;
        }
        return false;
    }

    public int search(int start, int end, long number){

        int mid = (start + end)/2;
        if (fibonacci[mid] == number) return 0;
        if (fibonacci[mid] > number/2){
            if (fibonacci[mid - 1] < number/2){
                return mid;
            }
            return search(start, mid, number);
        }
        if (fibonacci[mid + 1] > number/2) return mid + 1;
        return search(mid, end, number);
    }
}
