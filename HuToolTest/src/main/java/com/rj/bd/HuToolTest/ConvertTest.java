package com.rj.bd.HuToolTest;

import java.util.Date;
import java.util.List;

import cn.hutool.core.convert.Convert;

public class ConvertTest {
	public static void main(String[] args) {
		// int类型转换
		int a = 1023;
		String aStr = Convert.toStr(a);
		// aStr结果为1023
		//System.out.println(aStr);
		// 数组进行转换
		int[] b = {1,2,3,4,5};
		String bStr = Convert.toStr(b);
		// bStr结果为[1, 2, 3, 4, 5]
		//System.out.println(bStr);
		
		String[] strArray = { "1", "0", "2", "3" };
		//结果为Integer数组
		Integer[] intArray = Convert.toIntArray(strArray);
		//System.out.println(Convert.toStr(intArray));
		
		Integer[] intArray2 = {1,0,2,3};
		//结果为String数组
		String[] strArray2 = Convert.toStrArray(intArray2);
		//System.out.println(Convert.toStr(strArray2));
		
		String date = "2000-10-23";
		//结果为Date日期对象
		Date value = Convert.toDate(date);
		//System.out.println(value);
		
		Object[] objectArray = {"lolly1023","lolly",1023};
		List<?> list = Convert.convert(List.class, objectArray);
		//System.out.println(list);
		// 4.1.11版本之后可使用toList
		List<?> list2 = Convert.toList(objectArray);
		//System.out.println(list2);
	}
}
