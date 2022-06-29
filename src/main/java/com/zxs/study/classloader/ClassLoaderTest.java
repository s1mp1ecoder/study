package com.zxs.study.classloader;

/**
 * 类加载器测试类
 * @author ZXS
 *
 */
public class ClassLoaderTest {
	/**
	 * 总共有4种加载器
	 * 1.bootstrapClassLoader 加载lib下的rt.jar等jar包
	 * 2.extClassLoader 扩展类加载器 加载ext下的jar包
	 * 3.appClassLoader 应用程序类加载器 加载自己写的类
	 * 4.自定义加载器 
	 * 
	 */

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
		System.out.println("bootstapClassLoader=" + bootstapClassLoader);

		/**
		 * 类加载的双亲委派:
		 * 1.加载某个应用程序类首先由appClassLoader查看该类是否已经被加载(findClass(String name))
		 * 2.如果appClassLoader没有加载该类交给他的父加载器(extClassLoader)加载,如果已加载直接返回	
		 * 3.如果extClassLoader已加载则直接返回,未加载则交给他的父加载器(bootStrapClassLoader)加载
		 * 4.如果bootStrapClassLoader已加载则直接返回 没有加载就交给extClassLoader加载 
		 * 5.同4 最后交给appClassLoader加载
		 * 注意:
		 * 1.是父加载器不是父类 所有classLoader的上层父类都是ClassLoader对象
		 * 2.如此设计有两点
		 *  2.1:沙箱安全机制 不可能修改jdk源码
		 *  2.2:避免类的重复加载
		 */

	}

}
