package com.Package;

public class Problem692 {
    long[] fibonacci = {1, 2, 3, 5, 8, 13, 21, 34, 55,
                        89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368,
                        75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887,
                        9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
                        433494437, 701408733, 1134903170, 1836311903, 2971215073L, 4807526976L, 7778742049L,
                        12586269025L, 20365011074L, 32951280099L, 53316291173L, 86267571272L, 139583862445L,
                        225851433717L, 365435296162L, 591286729879L, 956722026041L, 1548008755920L,
                        2504730781961L, 4052739537881L, 6557470319842L, 10610209857723L, 17167680177565L,
                        27777890035288L, 44945570212853L, 72723460248141L, 117669030460994L, 190392490709135L,
                        308061521170129L, 498454011879264L, 806515533049393L, 1304969544928657L, 2111485077978050L,
                        3416454622906707L, 5527939700884757L, 8944394323791464L, 14472334024676221L, 23416728348467685L,37889062373143906L};
    long[] fractal = new long[79];
    public void run(){

        for(int i = 0; i < 79;i++) {
            fractal(fibonacci[i], i);
        }
        System.out.println("the answer = " + fractal[78]);

            //System.out.println(i + " , " + fibonacci[i]+ " , " + fractal(fibonacci[i],i));
    }

    public long fractal(long fib, int index){
        if (fractal[index] != 0){
            return fractal[index];
        }
        if (fib == 1) return 1;
        if (fib == 0) return 0;
        long sum = 3;
        for(int i = 2; fibonacci[i] <= fib ;i++){
            sum += fibonacci[i];
            sum += fractal(fibonacci[i] - fibonacci[i - 1], i-2) - fibonacci[i-2];

        }
        fractal[index] = sum;
        return sum;
    }

    public long smallestZekendorf(long number){
        long smallest = 0;
        int start = 0;
        int end = 78;
        int mid;
        while (number != 0){
           mid = search(start, end, number);
           end = mid;
           number -= fibonacci[mid];
           smallest = fibonacci[mid];
        }
        return smallest;
    }

    public int search(int start, int end, long number){

        int mid = (start + end)/2;
        if (fibonacci[mid] == number)return mid;
        if (fibonacci[mid] < number){
            if (fibonacci[mid + 1] > number){
                return mid;
            }
            return search(mid, end, number);
        }
        if (fibonacci[mid - 1] < number) return mid-1;
        return search(start, mid, number);
    }
}
