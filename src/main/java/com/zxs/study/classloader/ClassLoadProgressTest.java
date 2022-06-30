package com.zxs.study.classloader;

/**
 * 类加载过程测试类
 *
 * @author ZXS
 */
public class ClassLoadProgressTest {


    static {
        System.out.println("Initial ClassLoaderProgressTest");
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        A a = new A();
        System.out.println("-------------------");
        B b = null;
    }

}

class A {

    static {
        System.out.println("Initial A");
    }

    public A() {
        System.out.println("Use A Constructor");
    }

}

class B {

    static {
        System.out.println("Initial B");
    }

    public B() {
        System.out.println("Use B Constructor");
    }

}
