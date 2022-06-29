package com.zxs.study.classloader;

/**
 * 类加载过程测试类
 * 
 * @author ZXS
 *
 */
public class ClassLoaderProgressTest {

	/**
	 * 1.c++调用jvm.dll 开启虚拟机 
	 * 2.c++调用sun.misc.Launcher的getLauncher();
	 * 3.c++调用launcher的getClassLoader()开始加载类;
	 */
	/**
	 * 类加载过程 (懒加载 用才加载 不用不加载)
	 * 1.加载 把对应的class文件丢jvm内存
	 * 2.验证 验证class文件的语法 
	 * 3.链接 将符号引用转换成直接引用(静态链接编译期就可以确定 动态链接 运行时期才可以确定多态)
	 * 4.准备 赋给类默认值(int是0 object是null boolean是false等)
	 * 5.初始化 赋给类指定的值（static int a=1 准备期a==0）
	 */

	static {
		System.out.println("Inital ClassLoaderProgressTest");
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
		System.out.println("Inital A");
	}

	public A() {
		System.out.println("Use A Constructor");
	}

}

class B {

	static {
		System.out.println("Inital B");
	}

	public B() {
		System.out.println("Use B Constructor");
	}

}
