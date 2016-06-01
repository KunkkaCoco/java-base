package jvm.resolve;

/**
 * Created by maximus on 16-6-1.
 */
public class StaticResolution {

    public  static void sayHello(){
        System.out.println("hello world");

    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
