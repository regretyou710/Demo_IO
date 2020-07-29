package tw.com.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/*
 * 其他流的的使用
 * 1.標準的輸入、輸出流
 * 2.列印流
 * 3.數據流
 */
public class Demo05A {

	/*
	 * 1.
	 * System.in:標準的輸入流 ，默認從鍵盤輸入。 System.out：標準的輸入流，默認從控制台輸出。
	 * 
	 * 2. 
	 * System類的setIn(InputStream is)/setOut(PrintStream ps)方式重新指定輸入和輸出的流。
	 */

	// 練習：從鍵盤輸入字串，要求將讀到的整行字串轉成大寫輸出。然後繼續進行輸入操作，直到當輸入"e"或是"exit"，退出程式。
	// 方法一：使用Scanner實現，調用next()返回一個字串
	// 方法二：使用System.in實現。System.in → 轉換流 → BufferedReader的readLine()
	@Test
	public void test01() {
		BufferedReader br = null;

		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			
			br = new BufferedReader(isr);
			
			while (true) {
				System.out.println("請輸入字串:");
				String data = br.readLine();
				if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
					System.out.println("成功退出程式！");
					break;
				}
				String upperCase = data.toUpperCase();
				System.out.println(upperCase);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
