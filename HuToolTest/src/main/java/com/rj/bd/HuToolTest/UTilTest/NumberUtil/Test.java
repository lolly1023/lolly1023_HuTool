package com.rj.bd.HuToolTest.UTilTest.NumberUtil;

import java.util.Collection;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.NumberUtil;

public class Test {
	public static void main(String[] args) {
		double te1=123456.123456;
		double te2=123456.123456;
		// 第二个参数为保留几位小数
		// 123456.1
		Console.log(NumberUtil.round(te1,1));
		// 123456.123
		Console.log(NumberUtil.round(te2,3));
		
		
		double te3=123456.123456;
		double te4=123456.128456;
		// 第二个参数为保留几位小数
		//123456.12
		Console.log(NumberUtil.roundStr(te3,2));
		//123456.13
		Console.log(NumberUtil.roundStr(te4,2));
		
		long c=299792458;//光速
		String format = NumberUtil.decimalFormat(",###", c);//299,792,458
		System.out.println(format);
		
		// 生成随机数,用int类型数组承载
		int[] array = NumberUtil.generateRandomNumber(0, 10, 8);
		System.out.println(Convert.toStr(array));
		// 生成随机数,用Integer类型数组承载
		Integer[] array2 = NumberUtil.generateBySet(0, 10, 8);
		System.out.println(Convert.toStr(array2));
		
		// 第一个参数为起点，第二个参数为终点
		int[] array3 = NumberUtil.range(2, 5);
		// [2, 3, 4, 5]
		System.out.println(Convert.toStr(array3));
		
	}
	
}
