package tw.com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/*
 * 處理流之二:轉換流的使用;InputStreamReader和OutputStreamWriter的操作
 * InputStreamReader:將一個位元的輸入流轉換成字元的輸入流
 * OutputStreamWriter:將一個字元的輸出流轉換成位元的輸出流
 */
public class Demo04 {

	// 以位元流讀取字元文件，過程中使用InputStreamReader專換
	@Test
	public void test01() {
		InputStreamReader isr = null;
		try {
			// 使用另一種建構式創建位元流
			FileInputStream fis = new FileInputStream("D:\\桌面\\JAVA監聽器Listener和過濾器Filter.txt");

			// isr = new InputStreamReader(fis);//使用系統默認的字符集
			isr = new InputStreamReader(fis, "utf-8");// 參數2指名了字符集，具體使用哪個字符集，取決於文件保存時使用的字符集

			char[] buff = new char[20];
			int size;
			while ((size = isr.read(buff)) != -1) {
				String str = new String(buff, 0, size);
				System.out.print(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// InputStreamReader和OutputStreamWriter的操作
	@Test
	public void test02() {
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;

		try {
			File f1 = new File("D:\\桌面\\JAVA監聽器Listener和過濾器Filter.txt");
			File f2 = new File("D:\\桌面\\JAVA監聽器Listener和過濾器Filter_gbk.txt");
			
			FileInputStream fis = new FileInputStream(f1);
			FileOutputStream fos = new FileOutputStream(f2);
			
			isr = new InputStreamReader(fis, "utf-8");// 以utf-8讀入(解碼)
			osw = new OutputStreamWriter(fos, "gbk");// 以gbk寫出(編碼)
			
			char[] buff = new char[20];
			int size;
			while ((size = isr.read(buff)) != -1) {
				osw.write(buff, 0, size);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
}
