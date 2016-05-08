package jvm;

/**
 * Created by maximus on 16-5-4.
 *
 * -Xss256k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Exception {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }
}
