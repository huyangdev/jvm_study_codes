package com.hy;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;
/*
JDK6/7
    -XX:PermSize=10m-XX:MaxPermSize=10m
JDK8+
VM 参数
-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:-UseCompressedOops
 */
public class MethodAreaOOMTest extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            MethodAreaOOMTest methodAreaOOMTest = new MethodAreaOOMTest();
            for (int i=0; i<10000; i++){
                //创建Classwriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号，public，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                //类的加载
                methodAreaOOMTest.defineClass("Class" + i, code, 0, code.length); //CLass对象
                j++;
            }
        }finally {
            System.out.println(j);
        }
    }

}
