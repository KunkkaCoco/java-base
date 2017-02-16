package aop;

/**
 * Created by maximus on 16-8-30.
 */
public class HelloWorld implements IHelloWorld {
    @Override
    public void sayHello(String message) {
        System.out.printf(message);
    }
}
