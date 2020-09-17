package tw.com.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 數據流:DataInputStream和DataOutputStream
 * 作用:用於讀取或寫出基本數據類型的變量或字串
 */
public class Demo07 {

	// 將內存中的字串、基本數據類型的變量寫出到文件中
	@Test
	public void test01() {
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(new File("demo07.txt")));
			
			dos.writeUTF("張三豐");
			dos.flush();
			dos.writeInt(22);
			dos.flush();
			dos.writeBoolean(true);
			dos.flush();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void test02() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(new File("demo07.txt")));
			
			String name = dis.readUTF();
			int age = dis.readInt();
			boolean gender = dis.readBoolean();
			
			System.out.println("name: " + name);
			System.out.println("age: " + age);
			System.out.println("gender: " + gender);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dis != null)
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
}
