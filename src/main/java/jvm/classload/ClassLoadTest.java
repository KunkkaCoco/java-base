package jvm.classload;


import java.io.InputStream;

/**
 * Created by maximus on 16-5-17.
 */
public class ClassLoadTest {

    public static void main(String[] args) throws Exception{

        ClassLoader myLoader = new ClassLoader(){

            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }

            }

        };


        Object obj = myLoader.loadClass("jvm.classload.ClassLoadTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof jvm.classload.ClassLoadTest);
    }
}
