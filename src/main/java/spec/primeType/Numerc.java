package spec.primeType;

import com.alibaba.fastjson.JSON;

/**
 * Created by chenweichao on 15-6-16.
 */
public class Numerc {

    public static void main(String[] args) {
        System.out.println("******************");
        double d = 1e308;
        System.out.print("overflow produces infinity: ");
        System.out.println(d + "*10=" + d * 10);
        // An example of gradual underflow:
        d = 1e-305 * Math.PI;
        System.out.print("gradual underflow: " + d + "\n");
        for (int i = 0; i < 4; i++)
            System.out.print(" " + (d /= 100000));
        System.out.println();
// An example of NaN:
        System.out.print("0.0/0.0 is Not-a-Number: ");
        d = 0.0 / 0.0;
        System.out.println(d);
// An example of inexact results and rounding:
        System.out.print("inexact results with float:");
        for (int i = 0; i < 100; i++) {
            float z = 1.0f / i;
            if (z * i != 1.0f)
                System.out.print(" " + i);
        }
        System.out.println();
// Another example of inexact results and rounding:
        System.out.print("inexact results with double:");
        for (int i = 0; i < 100; i++) {
            double z = 1.0 / i;
            if (z * i != 1.0)
                System.out.print(" " + i);
        }
        System.out.println();
// An example of cast to integer rounding:
        System.out.print("cast to int rounds toward 0: ");
        d = 12345.6;
        System.out.println((int) d + " " + (int) (-d));
        Numerc numerc = new Numerc();
        numerc.getClass().getMethods();
        System.out.print("----------------" + JSON.toJSONString(numerc.getClass().getMethods()));

    }

    public void finalize(){
        System.out.println("&&&&&&&&&&&finalize before destory !");
    }
}
