package aop;

/**
 * Created by maximus on 16-8-30.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    public static void main(String[] args) {
        ApplicationContext ctx =new ClassPathXmlApplicationContext("comtext-main.xml");

        IHelloWorld helloWord = (IHelloWorld)ctx.getBean("helloWorld");
        helloWord.sayHello("Hello Word!!");
    }



}