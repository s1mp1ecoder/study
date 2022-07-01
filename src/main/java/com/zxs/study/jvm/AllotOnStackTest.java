package com.zxs.study.jvm;

/**
 * 栈上分配对象
 * <p>
 * 栈上分配，标量替换
 * 代码调用了1亿次alloc()，如果是分配到堆上，大概需要1GB以上堆空间，如果堆空间小于该值，必然会触发GC。
 * <p>
 * 使用如下参数不会发生GC
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * 使用如下参数都会发生大量GC
 * -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 * 栈上分配依赖于逃逸分析和标量替换
 * @author s1mp1e
 * @date 1/7/2022
 */

public class AllotOnStackTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        System.out.println(System.currentTimeMillis() - start);
    }


    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("zxs");
    }

}
