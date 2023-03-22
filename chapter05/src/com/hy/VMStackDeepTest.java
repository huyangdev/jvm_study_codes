package com.hy;
public class VMStackDeepTest {
    private static int count = 1;
    /*
     在不设置 -Xss 的情况下： count 为 6298
     -Xss256k  count 为 4943
     -Xss512k count 为 10392
     */
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
