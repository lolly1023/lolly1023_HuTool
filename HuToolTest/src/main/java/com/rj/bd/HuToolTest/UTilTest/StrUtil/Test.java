package com.rj.bd.HuToolTest.UTilTest.StrUtil;

import cn.hutool.core.util.StrUtil;

public class Test {
	public static void main(String[] args) {
		String nullStr = null;
		// true
		//System.out.println(StrUtil.hasBlank(nullStr));
		// true
		//System.out.println(StrUtil.hasEmpty(nullStr));
		
		String fileName = StrUtil.removeSuffix("HuTool学习.md", ".md"); 
		// HuTool学习
		//System.out.println(fileName);
		String fileName1 = StrUtil.removePrefix("HuTool学习.md", "HuTool学习."); 
		// md
		//System.out.println(fileName1);
		
		
		String str = "lolly1023";
		
		String strSub1 = StrUtil.sub(str, 0, 5); 
		// lolly
		//System.out.println(strSub1);
		String strSub2 = StrUtil.sub(str, 0, -4);
		// lolly
		//System.out.println(strSub2);
		String strSub3 = StrUtil.sub(str, 5, 0);
		// lolly
		//System.out.println(strSub3);
		
		// 使用{}占位
		String template = "{}+{}=2";
		// 1+1=2
		String str1 = StrUtil.format(template, "1", "1"); 
		System.out.println(str1);
	}
}
