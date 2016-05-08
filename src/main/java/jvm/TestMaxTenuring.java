package jvm;

/**
 * Created by maximus on 16-5-6.
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 */
public class TestMaxTenuring {

    private static final int _1MB = 1024*1024;

    public static void testTenuringThreshold() {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[4*_1MB];
        allocation2 = new byte[4*_1MB];
        allocation3 = new byte[4*_1MB];

        allocation3 = null;
        allocation3 = new byte[4 * _1MB];


    }

    public static void main(String[] args) {
        TestMaxTenuring testMaxTenuring = new TestMaxTenuring();
        testMaxTenuring.testTenuringThreshold();

    }
}
