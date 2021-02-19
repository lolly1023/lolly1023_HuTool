package com.rj.bd.HuToolTest;

import java.io.File;
import java.io.IOException;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;

public class IOTest {
	public static void main(String[] args) throws IOException {
		// 文件的拷贝
		/**
		 
		BufferedInputStream in = FileUtil.getInputStream("d:/桌面/HuTool学习.md");
		BufferedOutputStream out = FileUtil.getOutputStream("d:/桌面/HuTool学习复制.md");
		long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
		// 拷贝文件的大小
		System.out.println(copySize);
		System.out.println("拷贝成功");
		in.close();
		out.close();
		* 
		*/
		
		File file = FileUtil.file("d:/桌面/HuTool学习.md");
		String type = FileTypeUtil.getType(file);
		//输出的是文件的格式
		//Console.log(type);
		
	}
}
