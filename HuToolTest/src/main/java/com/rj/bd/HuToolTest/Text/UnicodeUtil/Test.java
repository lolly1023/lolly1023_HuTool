package com.rj.bd.HuToolTest.Text.UnicodeUtil;

import cn.hutool.core.text.UnicodeUtil;

public class Test {
	public static void main(String[] args) {
		//第二个参数true表示跳过ASCII字符（只跳过可见字符）
		String s = UnicodeUtil.toUnicode("lolly1023中文", true);
		// lolly1023\u4e2d\u6587
		System.out.println(s);
		String str = "lolly1023\u4e2d\u6587";
		String res = UnicodeUtil.toString(str);
		// lolly1023中文
		System.out.println(res);
	}
}
