package com.extend;

public class ClassC extends ClassB {
    private String name;
    private String sex;

    public ClassC() {
        System.out.println("create1 ClassC");
    }

    public ClassC(String sex, int age) {
        super(age);
        this.sex = sex;
        System.out.println("create2 ClassC");
    }

    public ClassC(String sex, int age, String name) {
        super(age, name);
        this.sex = sex;
        System.out.println("create3 ClassC");
    }

    public static void main(String[] args) {
        ClassC cc = new ClassC("femail", 10, "john");
        System.out.println(cc.getAge());
        System.out.println(cc.getSex());
        System.out.println("-----------------");
        System.out.println(cc.getName());
        System.out.println(cc.getSuperName());
        System.out.println("-----------------");
        cc.setName("thisname");
        cc.setSuperName("supername");
        System.out.println(cc.getName());
        System.out.println(cc.getSuperName());
        System.out.println();
        System.out.println("-----------------");
        ClassA cb = cc;
        System.out.println(cb.getName());
        cb.setName("changename");
        System.out.println(cb.getName());
        System.out.println();

        ClassB bb= new ClassB(10, "john");
        System.out.println(bb.getAge());
        System.out.println(bb.getName());
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    // 加不加注解都覆盖父类
    public String getName() {
        return name;
    }

    public String getSuperName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {

        this.name = name;
    }

    public void setSuperName(String name) {
        super.setName(name);

    }
}
