package algorithm;

/**
 * Created by chenweichao on 15-7-20.
 */
public class C extends B implements A{
    public static void main(String[] args) {
        A a = new C();
        a.sout("aa");
    }


    @Override
    public void sysout(String s) {

    }
}
