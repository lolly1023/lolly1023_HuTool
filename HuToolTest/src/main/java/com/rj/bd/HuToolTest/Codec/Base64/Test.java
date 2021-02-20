package com.rj.bd.HuToolTest.Codec.Base64;

import cn.hutool.core.codec.Base62;
import cn.hutool.core.codec.Base64;

public class Test {
	public static void main(String[] args) {
		String a = "Base64";

		// QmFzZTY0
		String encode = Base64.encode(a);
		System.out.println(encode);
		// 还原为Base64
		String decodeStr = Base64.decodeStr(encode);
		System.out.println(decodeStr);
	}
}
