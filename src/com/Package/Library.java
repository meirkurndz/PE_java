package com.Package;

import java.util.Arrays;

public class Library {

}


 class Frac implements Comparable<Frac> {
    int _num;
    int _denum;

    Frac(){
        _num = 1;
        _denum = 1;
    }

    Frac(int num){
        _num = num;
        _denum = 1;
    }

    Frac(int num, int denum){
        _num = num;
        _denum = denum;
    }

    Frac(Frac other){
        _num = other._num;
        _denum = other._denum;
    }

    public Frac add(Frac other){
        Frac temp = new Frac((this._num * other._denum + this._denum * other._num),
                this._denum * other._denum);
        temp.red();
        return temp;
    }

    public Frac sub(Frac other){
        Frac temp = new Frac(-other._num, other._denum);
        return this.add(temp);
    }

    public Frac mul(Frac other){
        Frac temp = new Frac(this._num*other._num, this._denum*other._denum);
        temp.red();
        return temp;
    }

    public Frac div(Frac other){
        Frac temp = new Frac(this._num*other._denum,this._denum*other._num);
        //temp.red();
        return temp;
    }

    //@Override
    public boolean equals(Frac other){
        return this._num*other._denum == this._denum*other._num;
    }

    public void red(){
        int gcd = gcd(_num,_denum);
        _num /= gcd;
        _denum /= gcd;
            /*if (_denum < 0){
                _num = -_num;
                _denum = -_denum;
            }*/
    }

    public void print(){
        System.out.print(this._num + "/" + this._denum);
    }

    public int gcd(int n, int m) {
        if(m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }

    @Override
    public int compareTo(Frac other) {
        Long left = (long)this._num * other._denum;
        Long right = (long)this._denum * other._num;

        if(other._denum < 0){
            if(this._denum < 0){
                return left.compareTo(right);
            }else {
                return right.compareTo(left);
            }
        }else{
            if (this._denum < 0){
                return right.compareTo(left);
            }else {
                return left.compareTo(right);
            }
        }
    }

    static Frac[] uniqueSorted(Frac[] a) {
        if (a.length == 0) return a;
        int w = 1;                       // write index
        for (int i = 1; i < a.length; i++) {
            if (!a[i].equals(a[w-1])) {
                a[w++] = a[i];
            }
        }
        return Arrays.copyOf(a, w);
    }
}

class Point{
    long _x;
    long _y;

    Point(long x, long y){
        this._x = x;
        this._y = y;
    }

    public double dist(Point o){
        return Math.sqrt(Math.pow(this._x - o._x,2) +
                         Math.pow(this._y - o._y,2)   );
    }
}
