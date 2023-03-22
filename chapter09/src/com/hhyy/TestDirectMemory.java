package com.hhyy;

import java.nio.ByteBuffer;
import java.util.Scanner;

/*
以下程序执行后，可以通过任务管理器查看Java进行的占用情况。
 */
public class TestDirectMemory {
    static int memorySize = 1024 * 1024 * 1024; // 1GB
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(memorySize);
        System.out.println("分配直接内存....");

        Scanner in = new Scanner(System.in);
        in.next();

        byteBuffer = null;
        System.out.println("直接内存被释放");


        System.gc();
        in.next();
    }

}
