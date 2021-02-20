package com.rj.bd.HuToolTest.Codec.Base32;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base62;

public class Test {
	public static void main(String[] args) {
		String a = "Base32";

		// IJQXGZJTGI
		String encode = Base32.encode(a);
		System.out.println(encode);
		// 还原为Base32
		String decodeStr = Base32.decodeStr(encode);
		System.out.println(decodeStr);
	}
}
