package tw.com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 測試InputStream和OutputStream的使用
 */
public class Demo02 {

	@Test
	public void test01() {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			File f1 = new File("duke1.png");
			File f2 = new File("duke2.png");

			fis = new FileInputStream(f1);
			fos = new FileOutputStream(f2);

			// 複製過程
			byte[] buff = new byte[5];
			int size;
			while ((size = fis.read(buff)) != -1) {
				fos.write(buff, 0, size);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 指定路徑下的文件複製功能
	 */
	public void copyFile(String srcPath, String destPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			File srcFile = new File(srcPath);
			File destFile = new File(destPath);

			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);

			// 複製過程
			byte[] buff = new byte[1024];
			int size;
			while ((size = fis.read(buff)) != -1) {
				fos.write(buff, 0, size);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void test02() {
		long start = System.currentTimeMillis();
		String srcPath = "D:\\桌面\\duke1.png";
		String destPath = "D:\\桌面\\duke2.png";
		copyFile(srcPath, destPath);
		long end = System.currentTimeMillis();
		System.out.println("複製操作所花費時間:" + (end - start) + "毫秒");
	}
}
