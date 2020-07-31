package tw.com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import tw.com.bean.Account;
import tw.com.bean.Person;

/*
 * 物件流的使用*  
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用:用於儲存和讀取基本數據類型數據或物件的處理流。
 * note:ObjectIntputStream和ObjectOutputStream不能序列化static及transient修飾的成員屬性
 */
public class Demo08 {

	// 序列化過程:將內存中的java物件保存到硬碟或透過網路傳輸出去
	@Test
	public void tese01() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
			oos.writeObject(new String("這是序列化文件"));
			oos.flush();
			
			oos.writeObject(new Person("張無忌",22));
			oos.flush();
			
			oos.writeObject(new Person("張三豐",52,1001,new Account(5000.0)));
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 反序列化過程:將硬碟文件中的物件還原為內存中的一個java物件
	@Test
	public void tese02() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("object.dat"));
			
			Object obj = ois.readObject();
			String str = (String) obj;
			System.out.println(obj);
			
			Person p = (Person)ois.readObject();			
			System.out.println(p);
			
			Person p2 = (Person)ois.readObject();			
			System.out.println(p2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
