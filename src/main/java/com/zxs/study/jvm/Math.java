package com.zxs.study.jvm;

public class Math {

    public int computer(int a, int b) {
        return (a + b) * 10;
    }

    public static void main(String[] args) {
        Math math = new Math();
        int a = 1;
        int b = 2;
        int c = math.computer(a, b);
        System.out.println(c);
    }

}
