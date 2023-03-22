package com.hhyy;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk6中：
 * -XX:PermSize=6m -XX:MaxPermSize=6m -Xms6m -Xmx6m
 *
 * jdk8中：
 * -XX:MetaspaceSize=6m -XX:MaxMetaspaceSize=6m -Xms6m -Xmx6m
 * @author shkstart  shkstart@126.com
 * @create 2020  0:36
 */
public class StringTable3{
    public static void main(String[] args) {
//        //使用Set保持着常量池引用，避免full gc回收常量池行为
//        Set<String> set = new HashSet<String>();
//        //在short可以取值的范围内足以让6MB的PermSize或heap产生OOM了。
//        short i = 0;
//        while(true){
//            set.add(String.valueOf(i++).intern());
//        }
//        testString3();
//        testString4();
//        testString6();
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3==s4);  // false
    }

    public static void testString3(){
        // 都是常量，前端编译期会进行代码优化
        // 通过idea直接看对应的反编译的class文件，会显示 String s1 = "abc"; 说明做了代码优化
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        // true，有上述可知，s1和s2实际上指向字符串常量池中的同一个值
        System.out.println(s1 == s2);
    }

    public static void testString4() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true 编译期优化
        System.out.println(s3 == s5); // false s1是变量，不能编译期优化
        System.out.println(s3 == s6); // false s2是变量，不能编译期优化
        System.out.println(s3 == s7); // false s1、s2都是变量
        System.out.println(s5 == s6); // false s5、s6 不同的对象实例
        System.out.println(s5 == s7); // false s5、s7 不同的对象实例
        System.out.println(s6 == s7); // false s6、s7 不同的对象实例

        String s8 = s6.intern();
        System.out.println(s3 == s8); // true intern之后，s8和s3一样，指向字符串常量池中的"javaEEhadoop"
        System.out.println(s4 == s8); // true intern之后，s8和s4一样，指向字符串常量池中的"javaEEhadoop"
    }

    public static void testString5(){
        String s0 = "beijing";
        String s1 = "bei";
        String s2 = "jing";
        String s3 = s1 + s2;
        System.out.println(s0 == s3); // false s3指向对象实例，s0指向字符串常量池中的"beijing"
        String s7 = "shanxi";
        final String s4 = "shan";
        final String s5 = "xi";
        String s6 = s4 + s5;
        System.out.println(s6 == s7); // true s4和s5是final修饰的，编译期就能确定s6的值了
    }

    public static void testString6(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3==s4);  // false
    }

}
