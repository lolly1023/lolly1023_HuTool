package com.rj.bd.HuToolTest.UTilTest.HexUtil;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;

public class Test {
	public static void main(String[] args) {
		String str = "测试16进制转换";

		String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
		// e6b58be8af953136e8bf9be588b6e8bdace68da2
		System.out.println(hex);

		String decodedStr = HexUtil.decodeHexStr(hex);
		// 测试16进制转换,解码后与str相同
		System.out.println(decodedStr);
	}
}
