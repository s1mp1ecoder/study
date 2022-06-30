package com.zxs.study.classloader;

import sun.misc.PerfCounter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器测试
 *
 * @author ZXS
 */
public class MyClassLoaderTest {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        Class clazz = classLoader.loadClass("com.zxs.study.pojo.User");
        Object object = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout");
        method.invoke(object);
        System.out.println(clazz.getClassLoader());
        //如果工程内部还有一个user 由于双亲委派 就会用appclassLoader加载器加载该类 如果没有就用myclassLoader加载
        //重新loadClass方法就可以打破双亲委派

    }

    /**
     * 打破了双亲委派的类加载器 tomcat有一系列的自定义类加载器(一个war包一个)
     */
    static class MyClassLoader extends ClassLoader {
        private final String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadBytes(String name) throws Exception {
            if (name == null || "".equals(name)) {
                throw new IllegalArgumentException("name is null or name is empty");
            }
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            if (len <= 0) {
                fis.close();
                throw new FileNotFoundException();
            }
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadBytes(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    if (!name.startsWith("com.zxs.study")) {
                        c = this.getParent().loadClass(name);
                    } else {
                        c = findClass(name);
                    }
                    long t1 = System.nanoTime();
                    PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }
}