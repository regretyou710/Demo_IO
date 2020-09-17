package tw.com.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

/*
 * File類的使用
 * 1.File類的一個物件，代表一個文件(檔案)或一個文件目錄(資料夾)
 * 2.File類是聲明在 java.io包下
 */
public class Demo01 {

	@Test
	public void test01() {
		// 建構式一:
		// 相對路徑
		File f1 = new File("hello.txt");
		// 絕對路徑
		File f2 = new File("D:/myeclipsecode/Demo_IO/hello.txt");
		System.out.println(f1);
		System.out.println(f2);

		// 建構式二:
		File f3 = new File("D:/myeclipsecode", "Demo_IO");
		System.out.println(f3);

		// 建構式三:
		File f4 = new File(f3, "hello.txt");
		System.out.println(f4);
	}

	/*
	 * File常用方法
	 */
	@Test
	public void test02() {
		File f1 = new File("hello.txt");
		File f2 = new File("D:/nio/io/hi.txt");

		System.out.println("取得絕對路徑:" + f1.getAbsolutePath());
		System.out.println("取得路徑:" + f1.getPath());
		System.out.println("取得名稱:" + f1.getName());
		System.out.println("取得上層目錄路徑:" + f1.getParent());
		System.out.println("取得文件長度(位元):" + f1.length());
		System.out.println("取得最後修改時間(毫秒):" + f1.lastModified() + "->" + new Date(f1.lastModified()));

		System.out.println();

		System.out.println("取得絕對路徑:" + f2.getAbsolutePath());
		System.out.println("取得路徑:" + f2.getPath());
		System.out.println("取得名稱:" + f2.getName());
		System.out.println("取得上層目錄路徑:" + f2.getParent());
		System.out.println("取得文件長度(位元):" + f2.length());
		System.out.println("取得最後修改時間(毫秒):" + f2.lastModified() + "->" + new Date(f2.lastModified()));

	}

	@Test
	public void test03() {
		File f1 = new File("C:\\Windows\\System32");
		String[] list = f1.list();
		System.out.println("取得指定目錄下的所有文件或文件目錄的名稱陣列:");
		for (String str : list) {
			System.out.println(str);
		}

		System.out.println();

		File[] files = f1.listFiles();
		System.out.println("取得指定目錄下的所有文件或文件目錄的File陣列:");
		for (File f : files) {
			System.out.println(f);
		}
	}

	/*
	 * renameTo(File dest):把文件重新命名為指定的文件路徑
	 * 想要保證返回為true，f1在硬碟中是存在的，且f2在硬碟中是不存在的
	 */
	@Test
	public void test04() {
		File f1 = new File("hello.txt");
		File f2 = new File("D:\\myeclipsecode\\Demo_IO\\src\\tw\\com\\file\\hi.txt");
		boolean renameTo = f1.renameTo(f2);
		System.out.println(renameTo);
	}

	@Test
	public void test05() {
		File f1 = new File("hello.txt");
		System.out.println("判斷是否為文件目錄:" + f1.isDirectory());
		System.out.println("判斷是否為文件:" + f1.isFile());
		System.out.println("判斷是否存在:" + f1.exists());
		System.out.println("判斷是否可讀:" + f1.canRead());
		System.out.println("判斷是否可寫:" + f1.canWrite());
		System.out.println("判斷是否隱藏:" + f1.isHidden());

		System.out.println();

		File f2 = new File("D:\\myeclipsecode\\Demo_IO");
		System.out.println("判斷是否為文件目錄:" + f2.isDirectory());
		System.out.println("判斷是否為文件:" + f2.isFile());
		System.out.println("判斷是否存在:" + f2.exists());
		System.out.println("判斷是否可讀:" + f2.canRead());
		System.out.println("判斷是否可寫:" + f2.canWrite());
		System.out.println("判斷是否隱藏:" + f2.isHidden());
	}

	/*
	 * 在硬碟中建立實際檔案或資料夾
	 */
	@Test
	public void test06() throws IOException {
		//建立檔案
		File f1 = new File("world.txt");
		if (!f1.exists()) {
			f1.createNewFile();
			System.out.println("創建成功");
		} else {
			f1.delete();
			System.out.println("刪除成功");
		}	
				
	}
	
	@Test
	public void test07() throws IOException {		
		//建立資料夾
		
		//如果目錄存在就不創建，上層目錄不存在也不創建
		File f1 = new File("D:/io");
		boolean mkdir = f1.mkdir();
		if (mkdir) {
			System.out.println("mkdir 建立成功");
		}else {
			f1.delete();
			System.out.println("mkdir 刪除成功");
		}
		
		//如果上層目錄不存在連同上層目錄一起創建
		File f2 = new File("D:/nio/nios");
		boolean mkdirs = f2.mkdirs();
		if (mkdirs) {
			System.out.println("mkdirs 建立成功");
		}
	}
}
