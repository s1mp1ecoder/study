package com.zxs.study.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * 计算对象大小
 *
 * @author s1mp1e
 * @date 1/7/2022
 */
public class JOLSimple {

    //指针压缩
    public static void main(String[] args) {
        ClassLayout objectLayout = ClassLayout.parseInstance(new Object());
        System.out.println(objectLayout.toPrintable());

        System.out.println();
        ClassLayout arrayLayout = ClassLayout.parseInstance(new int[]{});
        System.out.println(arrayLayout.toPrintable());

        System.out.println();
        ClassLayout instanceLayout = ClassLayout.parseInstance(new A());
        System.out.println(instanceLayout.toPrintable());

    }


    public static class A {
        int id;
        String name;
        byte b;
        Object o;
    }


}
