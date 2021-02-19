package com.rj.bd.HuToolTest;

import cn.hutool.core.convert.Convert;

public class Test {
	public static void main(String[] args) {
		int a = 1;
		String aStr = Convert.toStr(a);
		System.out.println(aStr);
		long[] b = {1,2,3,4,5};
		//bStr为："[1, 2, 3, 4, 5]"
		String bStr = Convert.toStr(b);
		System.out.println(bStr);
	}
}
