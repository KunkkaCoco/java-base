package com.user;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDemo {


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("################before###################");
    }

    @AfterClass
    public static void setAfterClass() throws Exception {
        System.out.println("#################after#########################");
    }

    @Test
    public void test(){
//        int a = 0;
        for (int a=0; ;a++) {
            System.out.println("dead loop! a="+a);
        }
    }

}
