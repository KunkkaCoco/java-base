package jvm.classload;

/**
 * Created by maximus on 16-5-11.
 */
public class ConstClass {

    static {
        System.out.println("ConstantClass init!");

    }

    public static final String HELLOWORLD = "hello world!";

}
