package com.hhyy;

public class StringTable4 {
    public static void main(String[] args) {
        test();
        /*
        上面这一行代码创建的对象：
        1. 创建一个 StringBuilder 对象 sb
        2. 创建一个 String 对象 s1
        3. 创建一个 “123” 放入常量池中
        5. 调用 sb.append(s1)
        6. 创建一个 String 对象 s2
        7. 创建一个 “456” 放入常量池中
        8. 调用 sb.append(s2)
        9. sb.toString() 返回一个新的 String 对象
        */
    }

    public static void test(){
        String s1 = new String("1");
        s1.intern();
        System.out.println(s1 == "1");

        String a = new String("1") + new String("1");
        a.intern();
        System.out.println(a == "11");
    }

}
