package com.rj.bd.HuToolTest.Img.ImgUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;

public class Test {
	public static void main(String[] args) throws IOException {
//		ImgUtil.scale(
//				FileUtil.file("d:/桌面/石原里美.jpg"), 
//				FileUtil.file("d:/桌面/石原里美缩小版.jpg"),
//				0.5f// 缩放比例
//		);
		
//		ImgUtil.cut(
//			    FileUtil.file("d:/桌面/石原里美.jpg"), 
//			    FileUtil.file("d:/桌面/石原里美剪裁版.jpg"), 
//			    new Rectangle(200, 200, 200, 200)//裁剪的矩形区域
//		);
		
//		ImgUtil.slice(
//				FileUtil.file("d:/桌面/石原里美.jpg"), 
//				FileUtil.file("d:/桌面/石原里美"),
//				2, 
//				2
//		);
		
//		ImgUtil.convert(
//				FileUtil.file("d:/桌面/石原里美.jpg"), 
//				FileUtil.file("d:/桌面/石原里美.png")
//		);
		
//		ImgUtil.gray(
//				FileUtil.file("d:/桌面/石原里美.jpg"), 
//				FileUtil.file("d:/桌面/石原里美黑白版.jpg")
//		);
		
//		ImgUtil.pressText(//
//			    FileUtil.file("d:/桌面/石原里美.jpg"), //
//			    FileUtil.file("d:/桌面/石原里美水印版.jpg"), //
//			    "lolly1023", Color.WHITE, //文字
//			    new Font("黑体", Font.BOLD, 100), //字体
//			    0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
//			    0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
//			    0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
//		);
		
//		ImgUtil.pressImage(
//			    FileUtil.file("d:/桌面/石原里美.jpg"), 
//			    FileUtil.file("d:/桌面/石原里美图片水印版.jpg"), 
//			    ImgUtil.read(FileUtil.file("d:/桌面/石原里美.jpg")), //水印图片
//			    0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
//			    0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
//			    0.1f
//		);
		
//		// 旋转180度
//		BufferedImage image = (BufferedImage) ImgUtil.rotate(ImageIO.read(FileUtil.file("d:/桌面/石原里美.jpg")), 180);
//		ImgUtil.write(image, FileUtil.file("d:/桌面/石原里美旋转版.jpg"));
//		ImgUtil.flip(
//				FileUtil.file("d:/桌面/石原里美.jpg"), 
//				FileUtil.file("d:/桌面/石原里美翻转版.jpg")
//		);
		
//		Img.from(
//				FileUtil.file("d:/桌面/石原里美.jpg"))
//	    		.cut(0, 0, 200)//
//	    		.write(FileUtil.file("d:/桌面/石原里美切割版.jpg")
//	    );
		
		Img.from(
				FileUtil.file("d:/桌面/石原里美.jpg"))
	    		.setQuality(0.5)//压缩比率
	    		.write(FileUtil.file("d:/桌面/石原里美压缩版.jpg")
	    );
	}
}
