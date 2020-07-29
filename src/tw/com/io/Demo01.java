package tw.com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class Demo01 {

	@Test
	public void test01() {
		// 將hello2.txt內容讀入內存並輸出到控制台

		// System.out.println(f1.getAbsolutePath());
		FileReader fileReader = null;
		try {
			File f1 = new File("helloreader.txt");
			fileReader = new FileReader(f1);

			// 方式一:
			// int data = fileReader.read();//每一個char對應一個int。exe:'a'->97
			// while (data != -1) {
			// System.out.println((char)data);
			// data = fileReader.read();
			// }

			// 方式二:
			int data;// 每一個char對應一個int。exe:'a'->97
			while ((data = fileReader.read()) != -1) {
				// read():每次讀入一個字元(char)
				System.out.println((char) data);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	// read()的操作升級:使用read()重載方法
	@Test
	public void test02() {
		// 1.File的實例化
		File f1 = null;
		// 2.FileReader流的實例化
		FileReader fr = null;

		try {
			f1 = new File("helloreader.txt");
			fr = new FileReader(f1);
			// 3.讀入的操作
			// read(char[] cbuf):返回每次讀入cbuf陣列中的字元個數。如果達到文件末尾，返回-1。
			char[] buffer = new char[5];
			int size;
			while ((size = fr.read(buffer)) != -1) {
				// 方式一:
				// 錯誤寫法
				// for (int i = 0; i < buffer.length; i++) {
				// System.out.print(buffer[i]);
				// }

				// 正確寫法
				// for (int i = 0; i < size; i++) {
				// System.out.print(buffer[i]);
				// }

				// -----------------------------------------

				// 方式二:
				// 錯誤寫法:與方式一的錯誤寫法一樣
				// String str = new String(buffer);
				// System.out.println(str);

				// 正確寫法
				String str = new String(buffer, 0, size);
				System.out.print(str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.資源關閉
			try {
				if (f1 != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 從內存寫出到硬碟文件中 
	 * 說明: 
	 * 1.輸出操作，對應的File文件可以不存在。並不會拋異常
	 * 2.如果不存在，在輸出的過程中會自動創建此文件。 
	 * 	   如果存在，
	 * 		流使用的建構式是:FileWriter(file,false)/FileWriter(file),對原有的文件覆蓋
	 * 		流使用的建構式是:FileWriter(file,true),不會對原有的文件覆蓋而是在原有的文件基礎上追加內容	 
	 */
	@Test
	public void test03() throws IOException {
		// 1.提供File類的物件，指名寫出目的地的文件
		File f1 = new File("hellowriter.txt");

		// 2.提供FileWriter物件，用於數據的寫出
		FileWriter fw = new FileWriter(f1);

		// 3.寫出的操作
		fw.write("Hello!");
		fw.write("This's writer.");

		// 4.資源流的關閉
		fw.close();
	}
	
	@Test
	public void test04(){
		
		FileReader fr = null;
		FileWriter fw = null;

		try {
			// 1.創建File類的物件，指名讀入和寫出的文件
			File f1 = new File("helloreader.txt");
			File f2 = new File("hellowriter.txt");
			
			// 2.創建輸入流和輸出流的對象
			fr = new FileReader(f1);
			fw = new FileWriter(f2);

			// 3.讀入和寫出的操作
			char[] buff = new char[5];
			int size;// 紀錄每次讀入到buff陣列中的字元個數
			while ((size = fr.read(buff)) != -1) {
				fw.write(buff, 0, size);// 每次寫出size個字元
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.資源流關閉
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
