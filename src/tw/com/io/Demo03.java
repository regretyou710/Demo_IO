package tw.com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 處理流之一:緩衝流的使用
 * 作用:提高流的讀取、寫入的速度
 */
public class Demo03 {

	// BufferedInputStream和BufferedOutputStream操作
	@Test
	public void test01() {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			File f1 = new File("duke1.png");
			File f2 = new File("duke3.png");

			FileInputStream fis = new FileInputStream(f1);
			FileOutputStream fos = new FileOutputStream(f2);

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			byte[] buff = new byte[5];
			int size;
			while ((size = bis.read(buff)) != -1) {
				bos.write(buff, 0, size);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 關閉資源:先關外層流再關內層流。但關閉外層流的同時內層流會自動關閉。
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 指定路徑下的文件複製功能(加入緩衝流)
	 */
	public void copyFile(String srcPath, String destPath) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			File srcFile = new File(srcPath);
			File destFile = new File(destPath);

			FileInputStream fis = new FileInputStream(srcFile);
			FileOutputStream fos = new FileOutputStream(destFile);

			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			// 複製過程
			byte[] buff = new byte[1024];
			int size;
			while ((size = bis.read(buff)) != -1) {
				bos.write(buff, 0, size);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (bis != null) {
				try {
					bis.close();
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

	// BufferedReader和BufferedWriter操作
	@Test
	public void test03(){
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(new File("D:\\桌面\\JAVA監聽器Listener和過濾器Filter.txt")));
			bw = new BufferedWriter(new FileWriter(new File("D:\\桌面\\JAVA監聽器Listener和過濾器Filter_1.txt")));
			
			//方式一:使用char陣列
//			char[] buff = new char[1024];
//			int size;
//			while ((size = br.read(buff)) != -1) {
//				bw.write(buff, 0, size);
//				//bw.flush();
//			} 
			
			//方式二:使用String
			String data;
			while ((data=br.readLine())!=null) {
				//1.
				//bw.write(data+"\r\n");//data中不包含換行符號
				
				//2.
				bw.write(data);//data中不包含換行符號
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
