package com.zxs.study.jvm;

/**
 * gc测试 增加-XX:+PrintGCDetails
 *  大对象就是需要大量连续内存空间的对象（比如：字符串、数组）。JVM参数 -XX:PretenureSizeThreshold 可以设置大对象的大小，如果对象超过设置大小会直接进入老年代，不会进入年轻代，这个参数只在 Serial 和ParNew两个收集器下有效。
 * 比如设置JVM参数：-XX:PretenureSizeThreshold=1000000 (单位是字节)  -XX:+UseSerialGC  ，再执行下上面的第一个程序会发现大对象直接进了老年代
 * 为什么要这样呢？
 * 为了避免为大对象分配内存时的复制操作而降低效率。
 *
 * 对象晋升到老年代的年龄阈值，可以通过参数 -XX:MaxTenuringThreshold 来设置。
 * @author s1mp1e
 * @date 1/7/2022
 */
public class GCTest {

    public static void main(String[] args) {
        byte[] object60M = new byte[50 * 1024 * 1024];

        byte[] object10M = new byte[10 * 1024 * 1024];

        byte[] object5M = new byte[5 * 1024 * 1024];

    }

}
