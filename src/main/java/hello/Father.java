package hello;

import java.lang.reflect.Method;

/**
 * Created by chenweichao on 15-6-18.
 */
public class Father {
    private String name = "father";

    public void print() {
        System.out.println(" Father print ：" + this.name);
    }

    public void showName() {
        System.out.println("Father showName : "+this.name);
    }

    public void getName() {
        System.out.println(" Father getName : "+this.name);
    }
    public static void main(String[] args) {
        Father father = new Father();
        father.print();

        Son son = new Son();
        son.sonMethod();
        Father father1 = son;
        father1.print();
        Father father2 = new GrandSon();
        father2.print();
        Method[] methods = father2.getClass().getMethods();
        System.out.println("show methods ==========");
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
        System.out.println( "father2 instanceof " + (father2 instanceof GrandSon ? "grandson" : " father"));
        System.out.println("--------------");

        Son son1 = (Son)father2;
        son1.print();
        System.out.println("gs instanceof " + (son1 instanceof GrandSon ? "grandson" : " Son"));
        GrandSon gs = (GrandSon) father2;
        gs.print();
        System.out.println("--------------");
        gs.showName();
        gs.getName();
//        GrandSon gs1 = (GrandSon)father1;  //类型转换错误
//        gs1.print();

    }
}

class Son extends Father {
    private String name = "son";

    public void print() {
        System.out.println(" Son print ：" + this.name);
    }

    public void showName() {
        System.out.println(" Son print showname" );
    }
    public void sonMethod(){

    }
}

class GrandSon extends Son {
    private String name = "GrandSon";
    private String GrandSonOnly="only grandson have";
    public void print() {
        System.out.println(" grandSon print ：" + this.name);
    }

    public void showName() {
        super.showName();
    }
    public void grandMethod(){

    }

}
