package com.hy;

public class StackTestDemo {
    private static int a = 1;
    static {
        a = 2;
        // 在类的 linking 过程中 prepare过程会将 b 赋值为该类型的默认值 0
        // 之后执行到 initial 过程时，按照顺序会从新赋值为 20
        b = 20;
//        System.out.println(b); // 在定义之前调用，报错：Illegal forward reference
    }
    // 执行到此处会将 b 再次从新赋值为 10
    private static int b = 10;
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int q = i + j;
        System.out.println(a);
        System.out.println(b);
    }
}
