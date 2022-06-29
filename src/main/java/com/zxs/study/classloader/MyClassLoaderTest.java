package com.zxs.study.classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器测试
 * @author ZXS
 *
 */
public class MyClassLoaderTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
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

	static class MyClassLoader extends ClassLoader {
		private String classPath;

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
	}

}
