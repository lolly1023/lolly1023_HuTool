package com.rj.bd.HuToolTest.Text.StrBuilder;

import cn.hutool.core.text.StrBuilder;

public class Test {
	public static void main(String[] args) {
		StrBuilder builder = StrBuilder.create();
		builder.append("lolly").append("1023").append('！');
		// lolly1023！
		System.out.println(builder);
	}
}
