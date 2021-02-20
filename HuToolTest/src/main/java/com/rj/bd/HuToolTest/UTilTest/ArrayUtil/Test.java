package com.rj.bd.HuToolTest.UTilTest.ArrayUtil;

import java.util.Map;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;

public class Test {
	public static void main(String[] args) {
		
		int[] a = {};
		int[] b = null;
		// 判断空
		// true
		System.out.println(ArrayUtil.isEmpty(a));
		// true
		System.out.println(ArrayUtil.isEmpty(b));
		
		//判断非空
		// false
		System.out.println(ArrayUtil.isNotEmpty(a));
		
		String[] newArray = ArrayUtil.newArray(String.class, 3);
		
		ArrayUtil.resize(newArray, 4);
		int[] c = {1,2,3};
		int[] d = {4,5,6};
		int[] e = ArrayUtil.addAll(c,d);
		// [1, 2, 3, 4, 5, 6]
		System.out.println(Convert.toStr(e));
		
		int[] array = ArrayUtil.range(0,10);
		// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println(Convert.toStr(array));
		
		byte[] array2 = {1,1,1,1,2,2,2,2};
		byte[][] array3 = ArrayUtil.split(array2, 4);
		// [[1, 1, 1, 1], [2, 2, 2, 2]]
		System.out.println(Convert.toStr(array3));
		
		String[] keys = {"w", "e", "r", "f"};
		Integer[] values = {1,0,2,3};
		Map<String, Integer> map = ArrayUtil.zip(keys, values, true);
		// {w=1, e=0, r=2, f=3}
		System.out.println(Convert.toStr(map));
		
		int[] f = {1,2,3};
		// true
		System.out.println(ArrayUtil.contains(f, 3));
	
		int[] g = {1,2,3};
		int h = 1;
		// true
		System.out.println(ArrayUtil.isArray(g));
		// false
		System.out.println(ArrayUtil.isArray(h));
		
		int[] i = {1,2,3};
		// [1, 2, 3]
		System.out.println(ArrayUtil.toString(i));
		// 第二个参数为间隔符, 1/2/3
		System.out.println(ArrayUtil.join(i, "/"));
	}
}
