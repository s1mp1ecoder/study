package com.zxs.study.classloader;

/**
 * 类加载器测试类
 *
 * @author ZXS
 */
public class ClassLoaderTest {


    @SuppressWarnings("restriction")
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());//这个加载器由c++实现 所以次数是null
        System.out.println(com.sun.crypto.provider.DESedeCipher.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader());

        System.out.println();

        ClassLoader appClassLoader = ClassLoaderTest.class.getClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstapClassLoader = extClassLoader.getParent();

        System.out.println("appClassLoader=" + appClassLoader);
        System.out.println("extClassLoader=" + extClassLoader);
        System.out.println("bootstrapClassLoader=" + bootstapClassLoader);
    }

}
