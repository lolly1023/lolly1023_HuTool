package com.rj.bd.HuToolTest.UTilTest.ClipboardUtil;

import java.awt.datatransfer.Clipboard;

import cn.hutool.core.swing.clipboard.ClipboardUtil;

public class Test {
	public static void main(String[] args) {
		// 获取系统剪切板内容
		Clipboard copy = ClipboardUtil.getClipboard();
		// 设置剪切板内容
		ClipboardUtil.setStr("123");
		// 获取剪切板内容：123
		System.out.println(ClipboardUtil.getStr());
	}
}
