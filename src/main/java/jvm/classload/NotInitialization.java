package jvm.classload;

/**
 * Created by maximus on 16-5-11.
 */
public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
//        SuperClass[] sca = new SuperClass[10];
        System.out.println(ConstClass.HELLOWORLD);

//        System.out.println(new SubClass());
    }

}
