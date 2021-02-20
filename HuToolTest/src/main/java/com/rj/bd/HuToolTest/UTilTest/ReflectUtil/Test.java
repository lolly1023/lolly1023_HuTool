package com.rj.bd.HuToolTest.UTilTest.ReflectUtil;

import java.lang.reflect.Method;

import cn.hutool.core.util.ReflectUtil;

public class Test {
	public static void main(String[] args) {
		// 获取类中的全部方法
		Method[] methods = ReflectUtil.getMethods(Test.class);
		// 获取类中的某个方法
		Method method = ReflectUtil.getMethod(Test.class, "getID");
		// 获取某类的构造方法
		ReflectUtil.newInstance(Test.class);
		
		
		TestClass testClass = new TestClass();
		// lolly1023
		ReflectUtil.invoke(testClass, "print", "lolly1023");
	}
}
