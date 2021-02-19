package com.rj.bd.HuToolTest;

import java.io.File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;

public class FIleNameUtilTest {
	public static void main(String[] args) {
		File file = FileUtil.file("d:/桌面/HuTool学习.md");

		// HuTool学习.md
		String name = FileNameUtil.getName(file);
		System.out.println(name);
		
		
		File file1 = FileUtil.file("d:/桌面/HuTool学习.md");

		// "HuTool学习"
		String name1 = FileNameUtil.mainName(file1);
		System.out.println(name1);
		// "md"
		String name2 = FileNameUtil.extName(file1);
		System.out.println(name2);
	}
}
