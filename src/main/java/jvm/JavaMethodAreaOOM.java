package jvm;


import jvm.bean.Enhancer;

/**
 * Created by maximus on 16-5-4.
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
        }
    }
}
