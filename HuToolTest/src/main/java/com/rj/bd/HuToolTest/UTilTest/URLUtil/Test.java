package com.rj.bd.HuToolTest.UTilTest.URLUtil;

import java.io.File;

import javax.xml.xpath.XPathConstants;

import org.w3c.dom.Document;

import cn.hutool.core.util.URLUtil;
import cn.hutool.core.util.XmlUtil;

public class Test {
	public static void main(String[] args) {
		String url = "http://www.hutool.cn//aaa/bbb";
		// 结果为：http://www.hutool.cn/aaa/bbb
		String normalize = URLUtil.normalize(url);
		//System.out.println(normalize);
		url = "http://www.hutool.cn//aaa/\\bbb?a=1&b=2";
		// 结果为：http://www.hutool.cn/aaa/bbb?a=1&b=2
		normalize = URLUtil.normalize(url);
		//System.out.println(normalize);
		
		File xmlFile = new File("/Study/HuToolTest/src/main/java/com/rj/bd/HuToolTest/UTilTest/URLUtil/Test.xml");
		Document docResult=XmlUtil.readXML(xmlFile);
		Object value = XmlUtil.getByXPath("//returnsms/message", docResult, XPathConstants.STRING);
		// ok
		System.out.println(value.toString());
	}
}
