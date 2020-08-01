package tw.com.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class Demo02 {

	@Test
	public void test01() throws IOException {
		File f1 = new File("D:/io/exercise/hi.txt");
		// 創建一個與f1相同目錄下的另一個檔案，檔案名為hello.txt
		File f2 = new File(f1.getParent(), "hello.txt");
		
		if (!f2.exists()) {
			f1 = new File(f1.getParent());
			f1.mkdirs();
			f2.createNewFile();
			System.out.println("f2 創建成功");
		}
	}	
	
}
