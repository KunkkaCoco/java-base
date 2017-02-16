package com.user;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

public class TestDemo {


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("################before###################\n");
    }

    @AfterClass
    public static void setAfterClass() throws Exception {
        System.out.println("#################after#########################");
    }

    @Test
    public void test() {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Integer ss = 12;
        Integer sf = 12;
        Integer sss = 1222;
        Integer ssf = 1222;

        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(ss == sf);
        System.out.println(sss == ssf);
//        System.out.println(c == (a+b));
//        System.out.println(c.equals(a+b));
//        System.out.println(g == (a+b));
//        System.out.println(g.equals(a+b));

    }

}
