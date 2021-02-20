package com.rj.bd.HuToolTest.Comparator.VersionComparator;

import cn.hutool.core.comparator.VersionComparator;

public class Test {
	public static void main(String[] args) {
		// 1.2.1 < 1.12.1,返回-1
		System.out.println(VersionComparator.INSTANCE.compare("1.2.1", "1.12.1"));

		// 1.12.1 < 1.12.1c,返回-1
		System.out.println(VersionComparator.INSTANCE.compare("1.12.1", "1.12.1c"));

		// V0.0.20170102 > V0.0.20170101,返回1
		System.out.println(VersionComparator.INSTANCE.compare("V0.0.20170102", "V0.0.20170101"));
	}
}
