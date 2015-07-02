package spec.primeType;

/**
 * Created by chenweichao on 15-6-16.
 */
public class Stringintern {
    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";

        System.out.println(hello == "Hello");
        System.out.println(Other.hello == hello);
        System.out.println(spec.primeType.other.Other.hello == hello);
        System.out.println(hello == ("Hel" + "lo"));
        System.out.println(hello == ("Hel" + lo));
        System.out.println(hello == ("Hel"+lo).intern());


    }
}

 class Other{
    public static String hello = "Hello";
}