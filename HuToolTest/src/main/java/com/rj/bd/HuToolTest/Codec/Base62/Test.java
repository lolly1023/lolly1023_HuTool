package com.rj.bd.HuToolTest.Codec.Base62;

import cn.hutool.core.codec.Base62;

public class Test {
	public static void main(String[] args) {
		String a = "Base62";

		// KixpUr22
		String encode = Base62.encode(a);
		System.out.println(encode);
		// 还原为Base62
		String decodeStr = Base62.decodeStr(encode);
		System.out.println(decodeStr);
	}
}
