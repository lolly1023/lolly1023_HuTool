package com.rj.bd.HuToolTest.UTilTest.RuntimeUtil;

import cn.hutool.core.util.RuntimeUtil;

public class Test {
	public static void main(String[] args) {
		// cmd下输入ipconfig为网卡信息
		String str = RuntimeUtil.execForStr("ipconfig");
		// 输出正常,为网卡信息
		System.out.println(str);
	}
}
