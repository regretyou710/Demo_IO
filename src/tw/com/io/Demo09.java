package tw.com.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Demo09 {

	public static void main(String[] args) {
		// 使用Apache第三方工具進行IO操作
		// 匯入commons-io-xx.jar檔
		File srcFile = new File("duke1.png");
		File destFile = new File("duke3.png");

		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("複製檔案成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
