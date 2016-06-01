package jvm.resolve;

import java.io.Serializable;

/**
 * Created by maximus on 16-6-1.
 *
 * char > int > long > float > double
 * char 不会重载 byte 和 short 因为转型不安全
 */
public class Overload {

//    public static void sayHello(Object arg) {
//        System.out.println("hello  Object");
//    }

//    public static void sayHello(char arg) {
//        System.out.println("hello  char");
//    }
//
//    /**
//     * 不会重载 char
//     * @param arg
//     */
//    public static void sayHello(byte arg) {
//        System.out.println("hello  char");
//    }
//
//    /**
//     *  不会重载 char
//     * @param arg
//     */
//    public static void sayHello(short  arg) {
//        System.out.println("hello  char");
//    }
//    public static void sayHello(int arg) {
//        System.out.println("hello  int");
//    }
//
//    public static void sayHello(long arg) {
//        System.out.println("hello  long");
//    }
//
//    public static void sayHello(double arg) {
//        System.out.println("hello  double");
//    }
//
//    public static void sayHello(Character arg) {
//        System.out.println("hello  Character");
//    }
//
//    public static void sayHello(Serializable arg) {
//        System.out.println("hello  Serializable");
//    }

    /**
     * 变长参数优先级最低
     * @param arg
     */
//    public static void sayHello(char... arg) {
//        System.out.println("hello  char...");
//    }

    public static void sayHello(int... arg) {
        System.out.println("hello  int...");
    }
    public static void main(String[] args) {
        sayHello('a');
    }



}
