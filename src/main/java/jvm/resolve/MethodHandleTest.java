package jvm.resolve;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by maximus on 16-6-1.
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s) {
            System.out.println(s);
        }

    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() %2 ==0? System.out: new ClassA();

        getPrintlnMH(obj).invokeExact("icyfenix");
    }
}
