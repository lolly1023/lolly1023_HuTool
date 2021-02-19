package com.rj.bd.HuToolTest;

import java.util.Calendar;
import java.util.Date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;

public class DateUtilTest {
	public static void main(String[] args) {
		// 获取当前时间的Date对象
		Date nowDate = DateUtil.date();
		//System.out.println(nowDate);
		
		// 使用Calendar获取当前时间的Date对象
		Date nowDate2 = DateUtil.date(Calendar.getInstance());
		//System.out.println(nowDate2);
		
		// 使用当前时间戳获取当前时间的Date对象
		Date nowDate3 = DateUtil.date(System.currentTimeMillis());
		//System.out.println(nowDate3);
		
		// 使用工具类获取当前时间的字符串,格式为:yyyy-MM-dd HH:mm:ss
		String nowDateStr = DateUtil.now();
		//System.out.println(nowDateStr);
		
		// 使用工具类获取当前时间的字符串,格式为:yyyy-MM-dd
		String todayDateStr= DateUtil.today();
		//System.out.println(todayDateStr);
		
		// 字符串转为Date对象 
		String dateStr = "2000-10-23 12:30";
		Date date = DateUtil.parse(dateStr);
		// 输出2000-10-23 12:30:00
		//System.out.println(date);
		
		// 也可以在转的时候指定格式
		Date date2 = DateUtil.parse(dateStr,"yyyy-MM-dd");
		// 输出2000-10-23 00:00:00
		//System.out.println(date2);
		
		
		//格式化Date日期对象
		Date date4 = DateUtil.date();
		
		String format = DateUtil.format(date4, "yyyy年MM月dd日");
		// 输出为2021年02月19日
		//System.out.println(format);
		
		String formatDate = DateUtil.formatDate(date4);
		// 常用格式化,输出为2021-02-19
		//System.out.println(formatDate);
		
		String formatDateTime = DateUtil.formatDateTime(date4);
		// 精确到秒,结果为2021-02-19 21:16:09
		//System.out.println(formatDateTime);
		
		String formatTime = DateUtil.formatTime(date4);
		// 只保留时分秒,结果为21:16:09
		//System.out.println(formatTime);
		
		
		// 获取Date对象的年月日
		Date date5 = DateUtil.date();
		// 获取年,结果为2021
		//System.out.println(DateUtil.year(date5));
		// 获取月,结果为1(从0开始计数,0则为一月)
		//System.out.println(DateUtil.month(date5));
		// 获取日(在本年)
		//System.out.println(DateUtil.dayOfYear(date5));
		// 获取日(在本月)
		//System.out.println(DateUtil.dayOfMonth(date5));
		// 获取日(在本周)
		//System.out.println(DateUtil.dayOfWeek(date5));
		
		Date date3 = DateUtil.date();

		//一天的开始，结果:2021-02-19 00:00:00
		Date beginOfDay = DateUtil.beginOfDay(date3);
		//System.out.println(beginOfDay);
		//一天的结束，结果:2021-02-19 23:59:59
		Date endOfDay = DateUtil.endOfDay(date3);
		//System.out.println(endOfDay);
		//一月的开始，结果:2021-02-01 00:00:00
		Date beginOfMonth = DateUtil.beginOfMonth(date3);
		//System.out.println(beginOfMonth);
		//一月的结束，结果:2021-02-28 23:59:59
		Date endOfMonth = DateUtil.endOfMonth(date3);
		//System.out.println(endOfMonth);
		
		
		
		String dateStr2 = "2000-10-23 12:30";
		Date date6 = DateUtil.parse(dateStr2);
		
		// 偏移10天
		DateTime newDate = DateUtil.offsetDay(date, 10);
		// 结果为2000-11-02 12:30:00
		//System.out.println(newDate);
		// 偏移-10天
		DateTime newDate2 = DateUtil.offsetDay(date, -10);
		// 结果为2000-10-13 12:30:00
		//System.out.println(newDate2);
		
		/**常用的偏移还有
		 * 月份 ：DateUtil.offsetMonth(newDate2, offset)
		 * 周：DateUtil.offsetWeek(newDate2, offset)
		 */
		
		// 对比这种偏移,还有一种较简单的偏移方法
		//昨天
		//System.out.println(DateUtil.yesterday());
		//明天
		//System.out.println(DateUtil.tomorrow());
		//上周
		//System.out.println(DateUtil.lastWeek());
		//下周
		//System.out.println(DateUtil.nextWeek());
		//上个月
		//System.out.println(DateUtil.lastMonth());
		//下个月
		//System.out.println(DateUtil.nextMonth());
		
		
		String dateStr3 = "2000-10-23 12:30:00";
		Date date7 = DateUtil.parse(dateStr3);

		Date date8 = DateUtil.date();

		// 计算2000-10-23距今多久:7424天
		long betweenDay = DateUtil.between(date7, date8, DateUnit.DAY);
		//System.out.println(betweenDay);
		
		
		TimeInterval timer = DateUtil.timer();
		
		try {
			// 模拟耗时操作
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//花费毫秒数
		//System.out.println(timer.interval());
		//返回花费时间，并重置开始时间
		//System.out.println(timer.intervalRestart());
		//花费分钟数
		//System.out.println(timer.intervalMinute());
		
		
		// "天秤座"
		String zodiac = DateUtil.getZodiac(Month.OCTOBER.getValue(), 23);
		//System.out.println(zodiac);
		// "龙"
		String chineseZodiac = DateUtil.getChineseZodiac(2000);
		//System.out.println(chineseZodiac);
		
		
		//年龄
		System.out.println(DateUtil.ageOfNow("2000-10-23"));

		//是否闰年
		System.out.println(DateUtil.isLeapYear(2000));
	}
}
