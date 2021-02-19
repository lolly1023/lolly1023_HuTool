package com.rj.bd.HuToolTest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.Tailer;

public class TailerTest {
	public static void main(String[] args) {
		Tailer tailer = new Tailer(FileUtil.file("d:/桌面/test.log"), Tailer.CONSOLE_HANDLER, 2);
		tailer.start();
	}
}
