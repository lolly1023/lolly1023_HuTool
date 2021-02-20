package com.rj.bd.HuToolTest.Coll.CollUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import cn.hutool.core.collection.CollUtil;

public class Test {
	public static void main(String[] args) {
		
		String[] col= new String[]{"l","o","l","l","y"};
		List<String> colList = CollUtil.newArrayList(col);

		String str = CollUtil.join(colList, "#"); 
		// l#o#l#l#y
		System.out.println(str);
		
		
		
		//Integer比较器
		Comparator<Integer> comparator = new Comparator<Integer>(){
		    @Override
		    public int compare(Integer o1, Integer o2) {
		        return o1.compareTo(o2);
		    }
		};

		//新建三个列表，CollUtil.newArrayList方法表示新建ArrayList并填充元素
		List<Integer> list1 = CollUtil.newArrayList(1, 2, 3);
		List<Integer> list2 = CollUtil.newArrayList(4, 5, 6);
		List<Integer> list3 = CollUtil.newArrayList(7, 8, 9);

		//参数表示把list1,list2,list3合并并按照从小到大排序后，取0~2个（包括第0个，不包括第2个），结果是[1,2]
		@SuppressWarnings("unchecked")
		List<Integer> result = CollUtil.sortPageAll(0, 2, comparator, list1, list2, list3);
		System.out.println(result);     //输出 [1,2]
		
		
		
		HashMap<String, String> map = CollUtil.newHashMap();
		HashSet<String> set = CollUtil.newHashSet();
		ArrayList<String> list = CollUtil.newArrayList();
		
		CollUtil.setOrAppend(list, 0, "1");
		System.out.println(list);
		
		List<String> list5 = CollUtil.reverse(list);
		System.out.println(list5);
		
		List<String> list4 = new ArrayList<>();
		List<String> list6 = new ArrayList<>();
		list4.add("lolly");
		list6.add("lolly1023");
 		CollUtil.addAll(list4, list6);
 		// [lolly, lolly1023]
		System.out.println(list4);
		// [lolly]
		System.out.println(CollUtil.sub(list4, 0, 1));
		// false
		System.out.println(CollUtil.isEmpty(list4));
		// true
		System.out.println(CollUtil.isNotEmpty(list4));
		}
}
