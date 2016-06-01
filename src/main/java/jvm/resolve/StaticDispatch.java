package jvm.resolve;

/**
 * Created by maximus on 16-6-1.
 */
public class StaticDispatch {

    static abstract  class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("hello , guy!");
    }

    public  void sayHello(Man guy){
        System.out.println("hello ,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello , lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
        Woman wo = new Woman();
        sd.sayHello(wo);

        sd.sayHello((Man)man);
        sd.sayHello((Woman)woman);


        Woman wman = new Woman();
        sd.sayHello(wman);

    }

}

