package java.lang;
public class User {
    public static void main(String[] args) {
        long sum = 0;
        for (int i =1 ; i< 1000000; i++){
            sum = sum + i;
        }
        System.out.println(sum);
//        System.out.println("hello User");
    }
}
/*
结果：
java.lang.SecurityException: Prohibited package name: java.lang
 */
