package com.rj.bd.HuToolTest.UTilTest.IdUtil;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class Test {
	public static void main(String[] args) {
		//生成的UUID是带-的字符串
		String uuid = IdUtil.randomUUID();
		System.out.println(uuid);
		//生成的是不带-的字符串
		String simpleUUID = IdUtil.simpleUUID();
		System.out.println(simpleUUID);
		
		
		//生成id
		String id = ObjectId.next();
		System.out.println(id);
		//方法2：从Hutool-4.1.14开始提供
		String id2 = IdUtil.objectId();
		System.out.println(id2);
		
		
		
		//参数1为终端ID
		//参数2为数据中心ID
		Snowflake snowflake = IdUtil.getSnowflake(1, 1);
		long id3 = snowflake.nextId();
		System.out.println(id3);
	}
}
