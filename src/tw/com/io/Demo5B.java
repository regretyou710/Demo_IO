package tw.com.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo5B {

	public static void main(String[] args) {
		//String str = Demo5B.readString();
		//System.out.println(str);
		double short_ = Demo5B.readShort();
		System.out.println(short_);
	}

	public static String readString() {
		BufferedReader br = null;
		String str = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			str = br.readLine();
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
		return str;
	}

	public static float readFloat() {
		return Float.parseFloat(readString());
	}

	public static double readDouble() {
		return Double.parseDouble(readString());
	}

	public static byte readByte() {
		return Byte.parseByte(readString());
	}

	public static short readShort() {
		return Short.parseShort(readString());
	}

	public static int readInt() {
		return Integer.parseInt(readString());
	}

	public static long readLong() {
		return Long.parseLong(readString());
	}
	
	public static boolean readBoolean(){
		return Boolean.parseBoolean(readString());
	}
}
