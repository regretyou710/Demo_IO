package tw.com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/*
 * 列印流
 * 提供一系列重載的print()和println()   
 */
public class Demo06 {

	@Test
	public void test01() {
		
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream(new File("demo06.txt"));
			// 創建列印輸出流，設置為自動刷新模式(寫入換行或位元 '\n'時，都會刷新緩衝區)
			ps = new PrintStream(fos, true);
			if (ps != null) {
				// 把標準輸出流(控制台輸出)改成文件
				System.setOut(ps);
			}
			for (int i = 0; i <= 255; i++) {
				// 輸出ASCII字元
				System.out.print((char) i);
				if (i % 50 == 0) {
					// 每50個數據一行
					System.out.println();// 換行
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps!=null) {
				ps.close();
			}
		}
		
	}
}
