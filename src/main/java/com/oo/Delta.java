package com.oo;

/**
 * Created by maximus on 17-2-15.
 */
interface Foo {}
    class Alpha implements Foo{}
    class Beta extends Alpha{}

public class Delta extends Beta{
    public static void main(String[] args) {
        Beta x= new Beta();
        Alpha a = x;
//        Foo f = (Delta)x;// Exception in thread "main" java.lang.ClassCastException: com.oo.Beta cannot be cast to com.oo.Delta
        Foo f1 = (Alpha)x;
        Beta b = (Beta)(Alpha)x;

    }
}
