package jvm;

/**
 * Created by maximus on 16-5-4.
 * -Xss2M  容易 机器假死 慎重测试
 */
public class JavaVMStackOOM {
    private  void dontStop(){
        while (true) {

        }
    }
    public void  stackleakByThread(){
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                     dontStop();
                }
            });
            thread.start();
        }

    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackleakByThread();
    }
}
