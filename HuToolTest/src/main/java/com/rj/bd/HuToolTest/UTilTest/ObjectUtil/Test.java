package com.rj.bd.HuToolTest.UTilTest.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.util.ObjectUtil;

public class Test {
	public static void main(String[] args) {
		String string1 = "1";
		Integer integer1 = 1;
		// false
		// System.out.println(ObjectUtil.equal(string1, integer1));
		
		List<Integer> list = new ArrayList<Integer>();
		// 0
		// System.out.println(ObjectUtil.length(list));
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(0);
		// true
		//System.out.println(ObjectUtil.contains(list1, 0));
		
		List<Integer> list2 = new ArrayList<Integer>();
		// false
		System.out.println(ObjectUtil.isNull(list2));
		// true
		System.out.println(ObjectUtil.isNotNull(list2));
		
		int i = 0;
		// true
		System.out.println(ObjectUtil.isBasicType(i));
	}
}
