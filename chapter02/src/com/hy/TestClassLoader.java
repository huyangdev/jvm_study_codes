package com.hy;
public class TestClassLoader {
    public static void main(String[] args) {
        long sum = 0;
        for (int i =1 ; i < 101; i++){
            sum = sum + i;
        }
        System.out.println(sum);

        // 获取系统类加载器
        /*ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // result：sun.misc.Launcher$AppClassLoader@dad5dc

        // 获取扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        // result: sun.misc.Launcher$ExtClassLoader@a57993

        // 获取 引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);
        // result: null

        // 获取用户自定义类的加载器
        ClassLoader userDefinedClassLoader = TestClassLoader.class.getClassLoader();
        System.out.println(userDefinedClassLoader);
        // result: sun.misc.Launcher$AppClassLoader@dad5dc

        // 获取Java核心类库的类加载器
        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader2);*/
        // result : null
    }


}
