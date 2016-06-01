package jvm.classload;

/**
 * Created by maximus on 16-5-11.
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("subclass init!");
    }
}
