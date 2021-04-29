>本文的所有代码均已上传GitHub，[HuTool学习](https://github.com/lolly1023/lolly1023_HuTool)
>
*学习交流q群：470464545，大家一起学习进步，CSDN博客：[lolly1023](https://blog.csdn.net/lolly1023)*

@[TOC]
# 简介与安装
## 简介

Hutool是一个小而全的Java工具类库，通过静态方法封装，降低相关API的学习成本，提高工作效率，使Java拥有函数式语言般的优雅，让Java语言也可以“甜甜的”。

Hutool中的工具方法来自每个用户的精雕细琢，它涵盖了Java开发底层代码中的方方面面，它既是大型项目开发中解决小问题的利器，也是小型项目中的效率担当；

Hutool是项目中“util”包友好的替代，它节省了开发人员对项目中公用类和公用工具方法的封装时间，使开发专注于业务，同时可以最大限度的避免封装不完善带来的bug。

### Hutool名称的由来

Hutool = Hu + tool，是原公司项目底层代码剥离后的开源库，“Hu”是公司名称的表示，tool表示工具。Hutool谐音“糊涂”，一方面简洁易懂，一方面寓意“难得糊涂”。

### Hutool如何改变我们的coding方式
Hutool的目标是使用一个工具方法代替一段复杂代码，从而最大限度的避免“复制粘贴”代码的问题，彻底改变我们写代码的方式。

以计算MD5为例：

- 【以前】打开搜索引擎 -> 搜“Java MD5加密” -> 打开某篇博客-> 复制粘贴 -> 改改好用
- 【现在】引入Hutool -> SecureUtil.md5()

Hutool的存在就是为了减少代码搜索成本，避免网络上参差不齐的代码出现导致的bug。

****

上述摘自[HuTool官网](https://hutool.cn/docs/#/)
## 安装
**在Maven项目中**
在项目的pom.xml的`dependencies`中加入以下内容：
```xml
<dependency>
	<groupId>cn.hutool</groupId>
	<artifactId>hutool-all</artifactId>
	<version>5.5.8</version>
</dependency>
```
**非Maven项目中**
点击以下任一链接，下载`hutool-all-X.X.X.jar`即可：

- [Maven中央库1](https://repo1.maven.org/maven2/cn/hutool/hutool-all/5.5.8/)
- [Maven中央库2](http://repo2.maven.org/maven2/cn/hutool/hutool-all/5.5.8/)

> 注意 Hutool 5.x支持JDK8+，对Android平台没有测试，不能保证所有工具类或工具方法可用。 如果你的项目使用JDK7，请使用Hutool 4.x版本

# 常用方法
>本文的所有代码均已上传GitHub，[HuTool学习](https://github.com/lolly1023/lolly1023_HuTool)

## 类型转换
**类型转换的工具类为Convert**
### 转为字符串
```java
		// int类型转换
		int aInt = 1023;
		String aStr = Convert.toStr(aInt);
		// aStr结果为1023
		System.out.println(aStr);
		// 数组进行转换
		int[] bArray = {1,2,3,4,5};
		String bStr = Convert.toStr(bArray);
		// bStr结果为[1, 2, 3, 4, 5]
		System.out.println(bStr);
```
### 转为指定类型数组
```java
		String[] strArray = { "1", "0", "2", "3" };
		//结果为Integer数组
		Integer[] intArray = Convert.toIntArray(strArray);
		System.out.println(Convert.toStr(intArray));
		
		Integer[] intArray2 = {1,0,2,3};
		//结果为String数组
		String[] strArray2 = Convert.toStrArray(intArray2);
		System.out.println(Convert.toStr(strArray2));
```

### 转换为Date日期对象
```java
		String date = "2000-10-23";
		//结果为Date日期对象
		Date value = Convert.toDate(date);
		System.out.println(value);
```
### 转化为List集合
```java
		Object[] objectArray = {"lolly1023","lolly",1023};
		List<?> list = Convert.convert(List.class, objectArray);
		System.out.println(list);
		// 4.1.11版本之后可使用toList
		List<?> list2 = Convert.toList(objectArray);
		System.out.println(list2);
```
## 日期时间
日期时间的工具类为DateUtil
### 多种获取日期的方式
```java
		// 获取当前时间的Date对象
		Date nowDate = DateUtil.date();
		System.out.println(nowDate);
		
		// 使用Calendar获取当前时间的Date对象
		Date nowDate2 = DateUtil.date(Calendar.getInstance());
		System.out.println(nowDate2);
		
		// 使用当前时间戳获取当前时间的Date对象
		Date nowDate3 = DateUtil.date(System.currentTimeMillis());
		System.out.println(nowDate3);
		
		// 使用工具类获取当前时间的字符串,格式为:yyyy-MM-dd HH:mm:ss
		String nowDateStr = DateUtil.now();
		System.out.println(nowDateStr);
		
		// 使用工具类获取当前时间的字符串,格式为:yyyy-MM-dd
		String todayDateStr= DateUtil.today();
		System.out.println(todayDateStr);
```
输出样式为:
```
2021-02-19 21:04:12
2021-02-19 21:04:12
2021-02-19 21:04:12
2021-02-19 21:04:12
2021-02-19
```
### 字符串转换为Date对象
字符串转为Date对象使用到了`DateUtil`工具类中的`parse`方法，该方法会自动识别一些日期的常用格式，例如:

 1. yyyy-MM-dd HH:mm:ss.SSS
 2. yyyy-MM-dd HH:mm:ss
 3. yyyy-MM-dd HH:mm
 4. yyyy-MM-dd 
 5. HH:mm:ss

```java
		// 字符串转为Date对象 
		String dateStr = "2000-10-23 12:30";
		Date date = DateUtil.parse(dateStr);
		// 输出2000-10-23 12:30:00
		System.out.println(date);
		
		// 也可以在转的时候指定格式
		Date date2 = DateUtil.parse(dateStr,"yyyy-MM-dd");
		// 输出2000-10-23 00:00:00
		System.out.println(date2);
```
### 格式化Date对象
```java
		//格式化Date日期对象
		Date date4 = DateUtil.date();
		
		String format = DateUtil.format(date4, "yyyy年MM月dd日");
		// 输出为2021年02月19日
		System.out.println(format);
		
		String formatDate = DateUtil.formatDate(date4);
		// 常用格式化,输出为2021-02-19
		System.out.println(formatDate);
		
		String formatDateTime = DateUtil.formatDateTime(date4);
		// 精确到秒,结果为2021-02-19 21:16:09
		System.out.println(formatDateTime);
		
		String formatTime = DateUtil.formatTime(date4);
		// 只保留时分秒,结果为21:16:09
		System.out.println(formatTime);
```
### 获取Date对象的年月日
```java
		// 获取Date对象的年月日
		Date date5 = DateUtil.date();
		// 获取年,结果为2021
		System.out.println(DateUtil.year(date5));
		// 获取月,结果为1(从0开始计数,0则为一月)
		System.out.println(DateUtil.month(date5));
		// 获取日(在本年)
		System.out.println(DateUtil.dayOfYear(date5));
		// 获取日(在本月)
		System.out.println(DateUtil.dayOfMonth(date5));
		// 获取日(在本周)
		System.out.println(DateUtil.dayOfWeek(date5));
```
### 开始和结束日期
用于**计算开始时间和结束时间**，有每天的，每月的，等等
```java
		Date date3 = DateUtil.date();

		//一天的开始，结果:2021-02-19 00:00:00
		Date beginOfDay = DateUtil.beginOfDay(date3);
		System.out.println(beginOfDay);
		//一天的结束，结果:2021-02-19 23:59:59
		Date endOfDay = DateUtil.endOfDay(date3);
		System.out.println(endOfDay);
		//一月的开始，结果:2021-02-01 00:00:00
		Date beginOfMonth = DateUtil.beginOfMonth(date3);
		System.out.println(beginOfMonth);
		//一月的结束，结果:2021-02-28 23:59:59
		Date endOfMonth = DateUtil.endOfMonth(date3);
		System.out.println(endOfMonth);
```
### 日期时间的偏移
对**日期的减少或者添加**，可以对时分秒天周月等进行更改
```java
		String dateStr2 = "2000-10-23 12:30";
		Date date6 = DateUtil.parse(dateStr2);
		
		// 偏移10天
		DateTime newDate = DateUtil.offsetDay(date, 10);
		// 结果为2000-11-02 12:30:00
		System.out.println(newDate);
		// 偏移-10天
		DateTime newDate2 = DateUtil.offsetDay(date, -10);
		// 结果为2000-10-13 12:30:00
		System.out.println(newDate2);
		
		/**常用的偏移还有
		 * 月份 ：DateUtil.offsetMonth(newDate2, offset)
		 * 周：DateUtil.offsetWeek(newDate2, offset)
		 */
		
		// 对比这种偏移,还有一种较简单的偏移方法
		//昨天
		System.out.println(DateUtil.yesterday());
		//明天
		System.out.println(DateUtil.tomorrow());
		//上周
		System.out.println(DateUtil.lastWeek());
		//下周
		System.out.println(DateUtil.nextWeek());
		//上个月
		System.out.println(DateUtil.lastMonth());
		//下个月
		System.out.println(DateUtil.nextMonth());
```
### 日期时间差
用于计算两个日期直接的时间差
```java
		String dateStr3 = "2000-10-23 12:30:00";
		Date date7 = DateUtil.parse(dateStr3);

		Date date8 = DateUtil.date();

		// 计算2000-10-23距今多久:7424天
		long betweenDay = DateUtil.between(date7, date8, DateUnit.DAY);
		System.out.println(betweenDay);
```
### 计时器
```java
		TimeInterval timer = DateUtil.timer();
		
		try {
			// 模拟耗时操作
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//花费毫秒数
		System.out.println(timer.interval());
		//返回花费时间，并重置开始时间
		System.out.println(timer.intervalRestart());
		//花费分钟数
		System.out.println(timer.intervalMinute());
```
### 星座与属相
这个功能还是挺出乎意料的，没想到还有这种
```java
		// "天秤座"
		String zodiac = DateUtil.getZodiac(Month.OCTOBER.getValue(), 23);
		System.out.println(zodiac);
		// "龙"
		String chineseZodiac = DateUtil.getChineseZodiac(2000);
		System.out.println(chineseZodiac);
```
### 年龄与闰年判断
不得不说，这个工具类小玩意还挺多
```java
		//年龄
		System.out.println(DateUtil.ageOfNow("2000-10-23"));

		//是否闰年
		System.out.println(DateUtil.isLeapYear(2000));
```
## IO流相关
### 文件的拷贝
```java
		// 文件的拷贝
		BufferedInputStream in = FileUtil.getInputStream("d:/桌面/HuTool学习.md");
		BufferedOutputStream out = FileUtil.getOutputStream("d:/桌面/HuTool学习复制.md");
		long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
		// 拷贝文件的大小
		System.out.println(copySize);
		System.out.println("拷贝成功");
		in.close();
		out.close();
```
### 文件类型判断
用于**文件类型的判断**，返回值为文件的类型
```java
		File file = FileUtil.file("d:/桌面/HuTool学习.md");
		String type = FileTypeUtil.getType(file);
		//输出的是文件的格式
		Console.log(type);
```
### 文件监听
在以前，我们需要**监听文件的变化**：创建修改删除等，需要进行遍历来定时检查文件，效率很低，性能很差，所以有了这个工具类。
**监听指定事件**
```java
		File file2 = FileUtil.file("example.properties");
		//这里只监听文件或目录的修改事件
		WatchMonitor watchMonitor = WatchMonitor.create(file2, WatchMonitor.ENTRY_MODIFY);
		watchMonitor.setWatcher(new Watcher(){
		    @Override
		    public void onCreate(WatchEvent<?> event, Path currentPath) {
		        Object obj = event.context();
		        Console.log("创建：{}-> {}", currentPath, obj);
		    }

		    @Override
		    public void onModify(WatchEvent<?> event, Path currentPath) {
		        Object obj = event.context();
		        Console.log("修改：{}-> {}", currentPath, obj);
		    }

		    @Override
		    public void onDelete(WatchEvent<?> event, Path currentPath) {
		        Object obj = event.context();
		        Console.log("删除：{}-> {}", currentPath, obj);
		    }

		    @Override
		    public void onOverflow(WatchEvent<?> event, Path currentPath) {
		        Object obj = event.context();
		        Console.log("Overflow：{}-> {}", currentPath, obj);
		    }
		});

		//设置监听目录的最大深入，目录层级大于制定层级的变更将不被监听，默认只监听当前层级目录
		watchMonitor.setMaxDepth(3);
		//启动监听
		watchMonitor.start();
```
**监听全部事件**
```java
		WatchMonitor.createAll(file, new SimpleWatcher(){
		    @Override
		    public void onModify(WatchEvent<?> event, Path currentPath) {
		        Console.log("EVENT modify");
		    }
		}).start();
```
### 文件的读取
```java
		//默认UTF-8编码，可以在构造中传入第二个参数做为编码
		FileReader fileReader = new FileReader("d:/桌面/HuTool测试.txt");
		String result = fileReader.readString();
		System.out.println(result);
```
### 文件的写入
```java
		FileWriter writer = new FileWriter("d:/桌面/HuTool测	试.txt");
		writer.write("添加文本",true);
```
### 文件追加
主要用于**类似日志**这种（此类只有在写入文件的时候打开文件，写入结束之后，此类**不需要关闭**）
```java
		File file = new File("d:/桌面/HuTool测试.txt");
		FileAppender appender = new FileAppender(file, 16, true);
		appender.append("lolly1023");
		appender.append("追加");
		appender.append("成功");

		appender.flush();
		appender.toString();
```
### 文件跟随
有时候需要启动线程来“**监控**”**文件的变化**，类似于Linux下的`tail -f`命令
```java
	Tailer tailer = new Tailer(FileUtil.file("d:/桌面/test.log"), Tailer.CONSOLE_HANDLER, 2);
	tailer.start();
```
实时打印文件变化的类
```java
/**
 * 命令行打印的行处理器
 * 
 * @author looly
 * @since 4.5.2
 */
public static class ConsoleLineHandler implements LineHandler {
    @Override
    public void handle(String line) {
        Console.log(line);
    }
}
```
>该方法会阻塞线程

### 文件名与扩展名
获取**文件名**
```java
		File file = FileUtil.file("d:/桌面/HuTool学习.md");

		// HuTool学习.md
		String name = FileNameUtil.getName(file);
		System.out.println(name);
```
单独获取**主文件名**与**扩展名**
```java
		File file1 = FileUtil.file("d:/桌面/HuTool学习.md");

		// "HuTool学习"
		String name1 = FileNameUtil.mainName(file1);
		System.out.println(name1);
		// "md"
		String name2 = FileNameUtil.extName(file1);
		System.out.println(name2);
```
## 工具类
### 字符串工具
#### 判断是否为空
给定指定字符串，如果是空，则返回`true`，使用到`hasBlank`和`hasEmpty`方法。`hasEmpty`只判断是否为null或者是空字符串，`hasBlank`会把不可见的字符也算为空。
```java
		String nullStr = null;
		// true
		System.out.println(StrUtil.hasBlank(nullStr));
		// true
		System.out.println(StrUtil.hasEmpty(nullStr));
```
#### 删除前后缀
`removePrefix`为删除字符串前缀，`removeSuffix`为删除字符串后缀，经常用于去文件扩展名。
```java
		String fileName = StrUtil.removeSuffix("HuTool学习.md", ".md"); 
		// HuTool学习
		System.out.println(fileName);
		String fileName1 = StrUtil.removePrefix("HuTool学习.md", "HuTool学习."); 
		// md
		System.out.println(fileName1);
```
#### 截取字符串
在`String`中就有截取字符串的方法，但是时常会**越界**，在这个工具类中，该方法会**自动判断**，支持负数，（与`python`相同），第二个位置与第一个位置搞反了的话，也会自动识别更改。
```java
		String str = "lolly1023";
		
		String strSub1 = StrUtil.sub(str, 0, 5); 
		// lolly
		System.out.println(strSub1);
		String strSub2 = StrUtil.sub(str, 0, -4);
		// lolly
		System.out.println(strSub2);
		String strSub3 = StrUtil.sub(str, 5, 0);
		// lolly
		System.out.println(strSub3);
```
#### 格式化字符串
使用{}进行占位即可，然后使用`format`方法进行格式化
```java
		// 使用{}占位
		String template = "{}+{}=2";
		// 1+1=2
		String str1 = StrUtil.format(template, "1", "1"); 
		System.out.println(str1);
```
### 16进制工具
#### 16进制的转换
```java
		String str = "测试16进制转换";

		String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
		// e6b58be8af953136e8bf9be588b6e8bdace68da2
		System.out.println(hex);

		String decodedStr = HexUtil.decodeHexStr(hex);
		// 测试16进制转换,解码后与str相同
		System.out.println(decodedStr);
```
### URL工具
#### 标准化URL链接
对于不带`http://`头的地址做简单补全。
```java
		String url = "http://www.hutool.cn//aaa/bbb";
		// 结果为：http://www.hutool.cn/aaa/bbb
		String normalize = URLUtil.normalize(url);
		System.out.println(normalize);
		url = "http://www.hutool.cn//aaa/\\bbb?a=1&b=2";
		// 结果为：http://www.hutool.cn/aaa/bbb?a=1&b=2
		normalize = URLUtil.normalize(url);
		System.out.println(normalize);
```
### XML工具
#### 读取XML
读取XML分为两个方法：

- `XmlUtil.readXML` 读取XML文件
- `XmlUtil.parseXml` 解析XML字符串为Document对象
#### 写XML
- `XmlUtil.toStr` 将XML文档转换为String
- `XmlUtil.toFile` 将XML文档写入到文件
#### 创建XML
- `XmlUtil.createXml` 创建XML文档, 创建的XML默认是utf8编码，修改编码的过程是在toStr和toFile方法里，既XML在转为文本的时候才定义编码。
#### XML操作
通过以下工具方法，可以完成基本的节点读取操作。

- `XmlUtil.cleanInvalid` 除XML文本中的无效字符
- `XmlUtil.getElements` 根据节点名获得子节点列表
- `XmlUtil.getElement` 根据节点名获得第一个子节点
- `XmlUtil.elementText` 根据节点名获得第一个子节点
- `XmlUtil.transElements` 将NodeList转换为Element列表
### XML与对象转换
- `writeObjectAsXml` 将可序列化的对象转换为XML写入文件，已经存在的文件将被覆盖。
- `readObjectFromXml` 从XML中读取对象。
>**注意 这两个方法严重依赖JDK的`XMLEncoder`和`XMLDecoder`，生成和解析必须成对存在（遵循固定格式），普通的XML转Bean会报错。**
#### Xpath操作
更多Xpath操作：[点击此处](https://www.ibm.com/developerworks/cn/xml/x-javaxpathapi.html)
**举例xml文件**
```xml
<?xml version="1.0" encoding="utf-8"?>

<returnsms> 
  <returnstatus>Success（成功）</returnstatus>  
  <message>ok</message>  
  <remainpoint>1490</remainpoint>  
  <taskID>885</taskID>  
  <successCounts>1</successCounts> 
</returnsms>
```
**java代码**
```java
		File xmlFile = new File("/Study/HuToolTest/src/main/java/com/rj/bd/HuToolTest/UTilTest/URLUtil/Test.xml");
		Document docResult=XmlUtil.readXML(xmlFile);
		Object value = XmlUtil.getByXPath("//returnsms/message", docResult, XPathConstants.STRING);
		// ok
		System.out.println(value.toString());
```
### 对象工具
#### 两个对象是否相等
需要满足：
1. `obj1 == null && obj2 == null`
2. `obj1.equals(obj2)`

才会返回true
```java
		String string1 = "1";
		Integer integer1 = 1;
		// false
		System.out.println(ObjectUtil.equal(string1, integer1));
```
#### 计算对象长度
其实本质就是调用不同对象的计算长度方法，支持的类型有：
- CharSequence
- Collection
- Map
- Iterator
- Enumeration
- Array
```java
		List<Integer> list = new ArrayList<Integer>();
		// 0
		System.out.println(ObjectUtil.length(list));
```
#### 判断是否包含元素
即为判断对象中是否包含元素
```java
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(0);
		// true
		System.out.println(ObjectUtil.contains(list1, 0));
```
### 判断是否为空
```java
		List<Integer> list2 = new ArrayList<Integer>();
		// false
		System.out.println(ObjectUtil.isNull(list2));
		// true
		System.out.println(ObjectUtil.isNotNull(list2));
```
#### 克隆
- `ObjectUtil.clone`克隆对象，如果对象实现`Cloneable`接口，调用其`clone`方法，如果实现`Serializable`接口，执行深度克隆，否则返回`null`。

- `ObjectUtil.cloneIfPossible` 返回克隆后的对象，如果克隆失败，返回原对象

- `ObjectUtil.cloneByStream` 序列化后拷贝流的方式克隆，对象必须实现`Serializable`接口
#### 序列化与反序列化
- `serialize` 序列化，调用JDK序列化
- `unserialize` 反序列化，调用JDK
#### 判断基本类型
如果该对象是基本类型，则返回true，反之返回false。
```java
		int i = 0;
		// true
		System.out.println(ObjectUtil.isBasicType(i));
```
### 反射
#### 获取某类的全部方法
```java
		// 获取类中的全部方法
		Method[] methods = ReflectUtil.getMethods(Test.class);
```
#### 获取某类的某个方法
```java
		// 获取类中的某个方法
		Method method = ReflectUtil.getMethod(Test.class, "getID");
```
#### 获取某类的构造方法
```java
		// 获取某类的构造方法
		ReflectUtil.newInstance(Test.class);
```
#### 执行方法

```java
public class TestClass {
	public String print(String string) {
		return string;
	}
}	
```
**测试类**
```java
		TestClass testClass = new TestClass();
		// lolly1023
		ReflectUtil.invoke(testClass, "print", "lolly1023");
```
### 剪切板工具
#### 获取剪切板内容及修改剪切板内容
```java
		// 获取系统剪切板内容
		Clipboard copy = ClipboardUtil.getClipboard();
		// 设置剪切板内容,图片的话使用setImage
		ClipboardUtil.setStr("123");
		// 获取剪切板内容：123，图片的话使用getImage
		System.out.println(ClipboardUtil.getStr());
```
### 命令行工具
通过Java代码执行命令行命令，在`Wubdows`下是`cmd`，在`Linux`下是`shell命令`
#### 执行命令
```java
		// cmd下输入ipconfig为网卡信息
		String str = RuntimeUtil.execForStr("ipconfig");
		// 输出正常,为网卡信息
		System.out.println(str);
```
### 数字工具
#### 加减乘除
- `NumberUtil.add` 针对double类型做加法
- `NumberUtil.sub` 针对double类型做减法
- `NumberUtil.mul` 针对double类型做乘法
- `NumberUtil.div` 针对double类型做除法，并提供重载方法用于规定除不尽的情况下保留小数位数和舍弃方式。

以上的方法都会将`double`转为`BigDecimal`，解决了精确问题。
#### 保留小数
```java
		double te1=123456.123456;
		double te2=123456.123456;
		// 第二个参数为保留几位小数
		// 123456.1
		Console.log(NumberUtil.round(te1,1));
		// 123456.123
		Console.log(NumberUtil.round(te2,3));
```
#### 四舍五入
```java
		double te3=123456.123456;
		double te4=123456.128456;
		// 第二个参数为保留几位小数
		//123456.12
		Console.log(NumberUtil.roundStr(te3,2));
		//123456.13
		Console.log(NumberUtil.roundStr(te4,2));
```
#### 格式化
```java
		long c=299792458;//光速
		String format = NumberUtil.decimalFormat(",###", c);//299,792,458
		System.out.println(format);
```
**常用的格式化方式**
- `0` -> 取一位整数
- `0.00` -> 取一位整数和两位小数
- `00.000` -> 取两位整数和三位小数
- `#` -> 取所有整数部分
- `#.##%` -> 以百分比方式计数，并取两位小数
- `#.#####E0` -> 显示为科学计数法，并取五位小数
- `,###` -> 每三位以逗号进行分隔，例如：299,792,458
- `光速大小为每秒,###米` -> 将格式嵌入文本

[更多格式化操作，点击处此](https://blog.csdn.net/evangel_z/article/details/7624503)

#### 是否为数字
- `NumberUtil.isNumber` 是否为数字
- `NumberUtil.isInteger` 是否为整数
- `NumberUtil.isDouble` 是否为浮点数
- `NumberUtil.isPrimes` 是否为质数
#### 随机数
第一个参数为最小值，第二个参数为最大值，第三个参数为长度。
```java
		// 生成随机数,用int类型数组承载
		int[] array = NumberUtil.generateRandomNumber(0, 10, 8);
		System.out.println(Convert.toStr(array));
		// 生成随机数,用Integer类型数组承载
		Integer[] array2 = NumberUtil.generateBySet(0, 10, 8);
		System.out.println(Convert.toStr(array2));
```
#### 有序整数列表
生成一个有序的int类型数组
```java
		// 第一个参数为起点，第二个参数为终点
		int[] array3 = NumberUtil.range(2, 5);
		// [2, 3, 4, 5]
		System.out.println(Convert.toStr(array3));
```
#### 其它
- `NumberUtil.factorial` 阶乘
- `NumberUtil.sqrt` 平方根
- `NumberUtil.divisor` 最大公约数
- `NumberUtil.multiple` 最小公倍数
- `NumberUtil.getBinaryStr` 获得数字对应的二进制字符串
- `NumberUtil.binaryToInt` 二进制转int
- `NumberUtil.binaryToLong` 二进制转long
- `NumberUtil.compare` 比较两个值的大小
- `NumberUtil.toStr` 数字转字符串，自动并去除尾小数点儿后多余的0
### 数组工具
#### 判断是否为空
```java
		int[] a = {};
		int[] b = null;
		// 判断空
		// true
		System.out.println(ArrayUtil.isEmpty(a));
		// true
		System.out.println(ArrayUtil.isEmpty(b));
		
		//判断非空
		// false
		System.out.println(ArrayUtil.isNotEmpty(a));
```
#### 新建泛型数组
该方法支持泛型返回值
```java
		String[] newArray = ArrayUtil.newArray(String.class, 3);
```
#### 调整大小
```java
		ArrayUtil.resize(newArray, 4);
```
#### 合并数组
```java
		int[] c = {1,2,3};
		int[] d = {4,5,6};
		int[] e = ArrayUtil.addAll(c,d);
		// [1, 2, 3, 4, 5, 6]
		System.out.println(Convert.toStr(e));
```
#### 克隆
1. **泛型数组调用原生克隆**
```java
		Integer[] b = {1,2,3};
		Integer[] cloneB = ArrayUtil.clone(b);
		Assert.assertArrayEquals(b, cloneB);
```
2. **非泛型数组（原始类型数组）调用第二种重载方法**
```java
	int[] a = {1,2,3};
	int[] clone = ArrayUtil.clone(a);
	Assert.assertArrayEquals(a, clone);
```
####  有序列表生成
```java
		int[] array = ArrayUtil.range(0,10);
		// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		System.out.println(Convert.toStr(array));
```
#### 拆分数组
```java
		byte[] array2 = {1,1,1,1,2,2,2,2};
		byte[][] array3 = ArrayUtil.split(array2, 4);
		// [[1, 1, 1, 1], [2, 2, 2, 2]]
		System.out.println(Convert.toStr(array3));
```
#### 过滤
举例，过滤数组，保留偶数
```java
		Integer[] a = {1,2,3,4,5,6};
		Integer[] filter = ArrayUtil.filter(a, new 		Editor<Integer>(){
   		@Override
    	public Integer edit(Integer t) {
       	return (t % 2 == 0) ? t : null;
    	}});
		Assert.assertArrayEquals(filter, new Integer[]{2,4,6});
```
#### 两个数组生成map
此方法在`python`中为`zip()`函数。
第一个数组为**key**，第二个数组对应为**value**。
```java
		String[] keys = {"w", "e", "r", "f"};
		Integer[] values = {1,0,2,3};
		Map<String, Integer> map = ArrayUtil.zip(keys, values, true);
		// {w=1, e=0, r=2, f=3}
		System.out.println(Convert.toStr(map));
```
#### 是否包含元素
```java
		int[] f = {1,2,3};
		// true
		System.out.println(ArrayUtil.contains(f, 3));
```
#### 判断对象是否为数组
```java
		int[] g = {1,2,3};
		int h = 1;
		// true
		System.out.println(ArrayUtil.isArray(g));
		// false
		System.out.println(ArrayUtil.isArray(h));
```
#### 转为字符串
```java
		int[] i = {1,2,3};
		// [1, 2, 3]
		System.out.println(ArrayUtil.toString(i));
		// 第二个参数为间隔符, 1/2/3
		System.out.println(ArrayUtil.join(i, "/"));
```
### 随机工具
#### 基本使用
- `RandomUtil.randomInt` 获得**指定范围内的随机数**
- `RandomUtil.randomBytes` 随机**bytes**
- `RandomUtil.randomEle` 随机获得**列表中的元素**
- `RandomUtil.randomEleSet` 随机获得**列表中的一定量的不重复元素，返回Set**
- `RandomUtil.randomString` 获得一个**随机的字符串（只包含数字和字符）**
- `RandomUtil.randomNumbers` 获得一个**只包含数字的字符串**
- `RandomUtil.randomUUID` **随机UUID**
- `RandomUtil.weightRandom` 权重随机生成器，传入带权重的对象，然后根据权重随机获取对象
### 唯一ID工具
#### UUID
UUID全称通用唯一识别码（universally unique identifier）
```java
		//生成的UUID是带-的字符串
		String uuid = IdUtil.randomUUID();
		System.out.println(uuid);
		//生成的是不带-的字符串
		String simpleUUID = IdUtil.simpleUUID();
		System.out.println(simpleUUID);
```
#### ObjectId
ObjectId是MongoDB数据库的一种唯一ID生成策略，是UUID version1的变种。
```java
		//生成id
		String id = ObjectId.next();
		System.out.println(id);
		//方法2：从Hutool-4.1.14开始提供
		String id2 = IdUtil.objectId();
		System.out.println(id2);
```
#### Snowflake
分布式系统中，有一些需要使用全局唯一ID的场景，有些时候我们希望能使用一种简单一些的ID，并且希望ID能够按照时间有序生成。Twitter的Snowflake 算法就是这种生成器。
```java
		//参数1为终端ID
		//参数2为数据中心ID
		Snowflake snowflake = IdUtil.getSnowflake(1, 1);
		long id3 = snowflake.nextId();
		System.out.println(id3);
```
### 压缩工具
#### 压缩
**打包到当前目录**
```java
		//将aaa目录下的所有文件目录打包到d:/aaa.zip
		ZipUtil.zip("d:/aaa");
```
**打包到指定目录**
```java
		//将aaa目录下的所有文件目录打包到d:/bbb/目录下的aaa.zip文件中
		// 此处第二个参数必须为文件，不能为目录
		ZipUtil.zip("d:/aaa", "d:/bbb/aaa.zip");

		//将aaa目录下的所有文件目录打包到d:/bbb/目录下的ccc.zip文件中
		ZipUtil.zip("d:/aaa", "d:/bbb/ccc.zip");
```
**多个文件进行打包**
```java
		ZipUtil.zip(FileUtil.file("d:/bbb/ccc.zip"), false, 
		FileUtil.file("d:/test1/file1.txt"),
 		FileUtil.file("d:/test1/file2.txt"),
  		FileUtil.file("d:/test2/file1.txt"),
  	    FileUtil.file("d:/test2/file2.txt")
		);
```
#### 解压
```java
		//将test.zip解压到e:\\aaa目录下，返回解压到的目录
		File unzip = ZipUtil.unzip("E:\\aaa\\test.zip", "e:\\aaa");
```
### 身份证工具
主要方法为：
- `isValidCard` 验证身份证是否合法
- `convert15To18` 身份证15位转18位
- `getBirthByIdCard` 获取生日
- `getAgeByIdCard` 获取年龄
- `getYearByIdCard` 获取生日年
- `getMonthByIdCard` 获取生日月
- `getDayByIdCard` 获取生日天
- `getGenderByIdCard` 获取性别
- `getProvinceByIdCard` 获取省份
#### 简单使用
```java
		String ID_18 = "321083197812162119";
		String ID_15 = "150102880730303";

		//是否有效
		boolean valid = IdcardUtil.isValidCard(ID_18);
		boolean valid15 = IdcardUtil.isValidCard(ID_15);

		//转换
		String convert15To18 = IdcardUtil.convert15To18(ID_15);
		Assert.assertEquals(convert15To18, "150102198807303035");

		//年龄
		DateTime date = DateUtil.parse("2017-04-10");
        
		int age = IdcardUtil.getAgeByIdCard(ID_18, date);
		Assert.assertEquals(age, 38);

		int age2 = IdcardUtil.getAgeByIdCard(ID_15, date);
		Assert.assertEquals(age2, 28);

		//生日
		String birth = IdcardUtil.getBirthByIdCard(ID_18);
		Assert.assertEquals(birth, "19781216");

		String birth2 = IdcardUtil.getBirthByIdCard(ID_15);
		Assert.assertEquals(birth2, "19880730");

		//省份
		String province = IdcardUtil.getProvinceByIdCard(ID_18);
		Assert.assertEquals(province, "江苏");

		String province2 = IdcardUtil.getProvinceByIdCard(ID_15);
		Assert.assertEquals(province2, "内蒙古");
```
>声明本次数据摘自HuTool官网，为随即编造，如有雷同，纯属巧合。
## 集合类
### 集合工具
#### 转为字符串
第二个参数为连接符
```java
		String[] col= new String[]{"l","o","l","l","y"};
		List<String> colList = CollUtil.newArrayList(col);

		String str = CollUtil.join(colList, "#"); 
		// l#o#l#l#y
		System.out.println(str);
```
#### 分页
```java
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
```
可能接触时间有点少，没读太懂，直接略过了。
#### 创建容器
```java
	HashMap<String, String> map = CollUtil.newHashMap();
	HashSet<String> set = CollUtil.newHashSet();
	ArrayList<String> list = CollUtil.newArrayList();
```
#### 添加元素
```java
		CollUtil.setOrAppend(list, 0, "1");
		System.out.println(list);
```
#### 调整数据大小
```java
		List<String> list5 = CollUtil.reverse(list);
```
没有搞懂改变List大小有啥用。。。，希望有会的指点一下
#### 合并数组
```java
		List<String> list4 = new ArrayList<>();
		List<String> list6 = new ArrayList<>();
		list4.add("lolly");
		list6.add("lolly1023");
 		CollUtil.addAll(list4, list6);
 		// [lolly, lolly1023]
		System.out.println(list4);
```
#### 截取数组
```java
		// [lolly]
		System.out.println(CollUtil.sub(list4, 0, 1));
```
#### 判断是否为空
```java
		// false
		System.out.println(CollUtil.isEmpty(list4));
		// true
		System.out.println(CollUtil.isNotEmpty(list4));
```
#### 集合生成Map
>源自python语法糖
```java
		Collection<String> keys = CollUtil.newArrayList("a", "b", "c", "d");
		Collection<Integer> values = CollUtil.newArrayList(1, 2, 3, 4);

		// {a=1,b=2,c=3,d=4}
		Map<String, Integer> map = CollUtil.zip(keys, values);
```
#### 过滤方法
此方法可以过滤掉map中不需要的key
**举例：**
```java
		@Test
		public void CollUtil_Filter() {
    		Map<String, Object> m = new HashMap<String, Object>() {{
        		put("k1", "v1");
        		put("k2", "v2");
        		put("k3", "v3");
    		}};
    		String[] inc = {"k1", "k3"};//需要的key
    		List<String> incList = Arrays.asList(inc);
    		m = CollectionUtil.filter(m, new Editor<Map.Entry<String, Object>>() {
        		@Override
        		public Map.Entry<String, Object> edit(Map.Entry<String, Object> stringObjectEntry) {
            		if (incList.contains(stringObjectEntry.getKey())) {
                		return stringObjectEntry;
            		}
            		return null;
        		}
    		});
    		log.info("{}", m);
		}
```
**控制台输出**
```
{k3=v3, k1=v1}
```
### 列表工具
#### 过滤列表
*对每一个元素进行过滤*
```java
		List<String> a = ListUtil.toLinkedList("1", "2", "3");
		// 结果: [edit1, edit2, edit3]
		List<String> filter = ListUtil.filter(a, str -> "edit" + str);
```
#### 获取满足规则元素下标
```java
		List<String> a = ListUtil.toLinkedList("1", "2", "3", "4", "3", "2", "1");
		// [1, 5]
		int[] indexArray = ListUtil.indexOfAll(a, "2"::equals);
```
### Iterator工具
#### 基本方法
- `isEmpty` 是否为**null**或者**无元素**
- `isNotEmpty` 是否为非**null**或者**至少一个元素**
- `hasNull` 是否有**null元素**
- `isAllNull` 是否**全部为null元素**
- `countMap` 根据集合返回一个元素计数的Map，所谓元素计数就是假如这个集合中某个元素出现了n次，那将这个元素做为key，n做为value
- `join` 使用分隔符将集合**转换为字符串**
- `toMap` toMap Entry列表转Map，或者key和value单独列表转Map
- `asIterator` `Enumeration`转`Iterator`
- `asIterable` `Iterator`转`Iterable`
- `getFirst` 获取列表的**第一个元素**
- `getElementType` 获取**元素类型**
## Map
### Map工具
#### 行转列
如若map中的数据为：
```java
[
  {a: 1, b: 1, c: 1},
  {a: 2, b: 2},
  {a: 3, b: 3},
  {a: 4}
]
```
则使用`toListMap`之后变为：

```java
{
   a: [1,2,3,4],
   b: [1,2,3,],
   c: [1]
}
```
#### 列转行
如若map中的数据为：
```java
{
   a: [1,2,3,4],
   b: [1,2,3,],
   c: [1]
}
```
则使用`toMapList`之后变为：

```java
[
  {a: 1, b: 1, c: 1},
  {a: 2, b: 2},
  {a: 3, b: 3},
  {a: 4}
]
```
#### 转为字符串
>`join`、`joinIgnoreNull`、`sortJoin`将Map按照给定的分隔符转换为字符串，此方法一般用于签名。
```java
Map<String, String> build = MapUtil.builder(new HashMap<String, String>())
    .put("key1", "value1")
    .put("key3", "value3")
    .put("key2", "value2").build();

// key1value1key2value2key3value3
String join1 = MapUtil.sortJoin(build, StrUtil.EMPTY, StrUtil.EMPTY, false);
// key1value1key2value2key3value3123
String join2 = MapUtil.sortJoin(build, StrUtil.EMPTY, StrUtil.EMPTY, false, "123");
```
#### 过滤方法
举例：
```java
Map<String, String> map = MapUtil.newHashMap();
map.put("a", "1");
map.put("b", "2");
map.put("c", "3");
map.put("d", "4");

Map<String, String> map2 = MapUtil.filter(map, (Filter<Entry<String, String>>) t -> Convert.toIn(t.getValue()) % 2 == 0);
```
结果为：
```
{
   b: "2",
   d: "4"
}
```
#### key和value互换
举例：
```java
Map<String, String> map = MapUtil.newHashMap();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");

Map<String, String> map2 = MapUtil.reverse(map);
```
结果为：
```
{
   "1": "a",
   "2": "b",
   "3": "c",
   "4": "d",
}
```
### BiMap
>BiMap，它实现了一种双向查找的功能，即根据key查找value和根据value查找key，Hutool也同样提供此对象。
#### 基本使用
```java
BiMap<String, Integer> biMap = new BiMap<>(new HashMap<>());
biMap.put("aaa", 111);
biMap.put("bbb", 222);

// 111
biMap.get("aaa");
// 222
biMap.get("bbb");

// aaa
biMap.getKey(111);
// bbb
biMap.getKey(222);
```
#### TableMap
>TableMap这类数据结构，通过键值单独建立List方式，使键值对一一对应，实现正向和反向两种查找。

#### 基本使用
```java
TableMap<String, Integer> tableMap = new TableMap<>(new HashMap<>());
tableMap.put("aaa", 111);
tableMap.put("bbb", 222);

// 111
tableMap.get("aaa");
// 222
tableMap.get("bbb");

// aaa
tableMap.getKey(111);
// bbb
tableMap.getKey(222);

// [111]
tableMap.getValues("aaa");

//[aaa]
tableMap.getKeys(111);
```
## Codec编码
### Base62编码解码
```java
		String a = "Base62";

		// KixpUr22
		String encode = Base62.encode(a);
		System.out.println(encode);
		// 还原为Base62
		String decodeStr = Base62.decodeStr(encode);
		System.out.println(decodeStr);
```
### Base64编码解码
```java
		String a = "Base64";

		// QmFzZTY0
		String encode = Base64.encode(a);
		System.out.println(encode);
		// 还原为Base64
		String decodeStr = Base64.decodeStr(encode);
		System.out.println(decodeStr);
```
### Base32编码解码
```java
		String a = "Base32";

		// IJQXGZJTGI
		String encode = Base32.encode(a);
		System.out.println(encode);
		// 还原为Base32
		String decodeStr = Base32.decodeStr(encode);
		System.out.println(decodeStr);
```
## 文本操作
### StrBuilder
>在JDK提供的StringBuilder中，拼接字符串变得更加高效和灵活，但是生成新的字符串需要重新构建StringBuilder对象，造成性能损耗和内存浪费，因此Hutool提供了可复用的StrBuilder。

摘自HuTool官网
#### 基本使用
```java
		StrBuilder builder = StrBuilder.create();
		builder.append("lolly").append("1023").append('！');
		// lolly1023！
		System.out.println(builder);
```
对比`StringBuilder`来说，性能几乎提升一倍之高。

### Unicode编码转换工具
#### 字符串转Unicode符
```java
		//第二个参数true表示跳过ASCII字符（只跳过可见字符）
		String s = UnicodeUtil.toUnicode("lolly1023中文", true);
		// lolly1023\u4e2d\u6587
		System.out.println(s);
```
#### Unicode转字符串
```java
		String str = "lolly1023\u4e2d\u6587";
		String res = UnicodeUtil.toString(str);
		// lolly1023中文
		System.out.println(res);
```
## 比较器
### 版本比较器
```java
		// 1.2.1 < 1.12.1,返回-1
		System.out.println(VersionComparator.INSTANCE.compare("1.2.1", "1.12.1"));

		// 1.12.1 < 1.12.1c,返回-1
		System.out.println(VersionComparator.INSTANCE.compare("1.12.1", "1.12.1c"));

		// V0.0.20170102 > V0.0.20170101,返回1
		System.out.println(VersionComparator.INSTANCE.compare("V0.0.20170102", "V0.0.20170101"));
```
### 其它比较器
- `ReverseComparator` **反转比较器**，排序时提供反序
- `VersionComparator` **版本比较器**，支持如：1.3.20.8，6.82.20160101，8.5a/8.5c等版本形式
- `PropertyComparator` **Bean属性比较器**，通过Bean的某个属性来对Bean对象进行排序
- `IndexedComparator` **按照数组的顺序正序排列**，数组的元素位置决定了对象的排序先后
- `ComparatorChain` **比较器链**。此链包装了多个比较器，最终比较结果按照比较器顺序综合多个比较器结果。
- `PinyinComparator` **按照GBK拼音顺序**对给定的汉字字符串排序。
## 异常
### 基本方法
- `getMessage` 获得完整消息，包括异常名
- `wrap` 包装一个异常为指定类型异常
- `wrapRuntime` 使用运行时异常包装编译异常
- `getCausedBy` 获取由指定异常类引起的异常
- `isCausedBy` 判断是否由指定异常类引起
- `stacktraceToString` 堆栈转为完整字符串

其他方法请参考API文档：[API文档](https://apidoc.gitee.com/loolly/hutool/cn/hutool/core/exceptions/ExceptionUtil.html)
### 其它异常封装
- `DependencyException` **依赖异常**
- `StatefulException` **带有状态码的异常**
- `UtilException` **工具类异常**
- `NotInitedException` **未初始化异常**
- `ValidateException` **验证异常**

## 图片
### 图片工具
#### 缩放图片
```java
		ImgUtil.scale(
				FileUtil.file("d:/桌面/石原里美.jpg"), 
				FileUtil.file("d:/桌面/石原里美缩小版.jpg"),
				0.5f// 缩放比例
		);
```
#### 剪裁图片
```java
		ImgUtil.cut(
			    FileUtil.file("d:/桌面/石原里美.jpg"), 
			    FileUtil.file("d:/桌面/石原里美剪裁版.jpg"), 
			    new Rectangle(200, 200, 200, 200)//裁剪的矩形区域
		);
```
#### 分成行列剪裁
```java
		ImgUtil.slice(
				FileUtil.file("d:/桌面/石原里美.jpg"), 
				FileUtil.file("d:/桌面/石原里美"),
				2, 
				2
		);
```
#### 图片类型转换
```java
		ImgUtil.convert(
				FileUtil.file("d:/桌面/石原里美.jpg"), 
				FileUtil.file("d:/桌面/石原里美.png")
		);
```
#### 图片转为黑白
```java
		ImgUtil.gray(
				FileUtil.file("d:/桌面/石原里美.jpg"), 
				FileUtil.file("d:/桌面/石原里美黑白版.jpg")
		);
```
#### 添加文字水印
```java
		ImgUtil.pressText(//
			    FileUtil.file("d:/桌面/石原里美.jpg"), //
			    FileUtil.file("d:/桌面/石原里美水印版.jpg"), //
			    "lolly1023", Color.WHITE, //文字
			    new Font("黑体", Font.BOLD, 100), //字体
			    0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
		);
```
#### 添加图片水印
```java
		ImgUtil.pressImage(
			    FileUtil.file("d:/桌面/石原里美.jpg"), 
			    FileUtil.file("d:/桌面/石原里美图片水印版.jpg"), 
			    ImgUtil.read(FileUtil.file("d:/桌面/石原里美.jpg")), //水印图片
			    0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0.1f
		);
```
#### 旋转图片
```java
		// 旋转180度
		BufferedImage image = (BufferedImage) ImgUtil.rotate(ImageIO.read(FileUtil.file("d:/桌面/石原里美.jpg")), 180);
		ImgUtil.write(image, FileUtil.file("d:/桌面/石原里美旋转版.jpg"));
```
#### 水平翻转图片
```java
	ImgUtil.flip(
				FileUtil.file("d:/桌面/石原里美.jpg"), 
				FileUtil.file("d:/桌面/石原里美翻转版.jpg")
		);
```
### 图片编辑器
#### 图像切割
```java
		Img.from(
				FileUtil.file("d:/桌面/石原里美.jpg"))
	    		.cut(0, 0, 200)//
	    		.write(FileUtil.file("d:/桌面/石原里美切割版.jpg")
	    );
```
#### 图片压缩
图片压缩只支持jpg文件
```java
		Img.from(
				FileUtil.file("d:/桌面/石原里美.jpg"))
	    		.setQuality(0.5)//压缩比率
	    		.write(FileUtil.file("d:/桌面/石原里美压缩版.jpg")
	    );
```

# HuTool暂未学完，持续更新
>本文的所有代码均已上传GitHub，[HuTool学习](https://github.com/lolly1023/lolly1023_HuTool)
>
*学习交流q群：470464545，大家一起学习进步，CSDN博客：[lolly1023](https://blog.csdn.net/lolly1023)*
