package implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;

public class DriverClass {

	public static void main(String[] args) throws IOException {
		HashMap hm1=new HashMap(3);
		HashMap hm=new HashMap(hm1);
		hm.put(0, 11);
		hm.put(1, 12);
		hm.put(2, 13);
		hm.put(3, 14);
		hm.put(4, 15);
		hm.put(5, 16);
		hm.put(6, 17);
		hm.put(0, 18);
		hm.put(3, 19);
		hm.remove(3);
		System.out.println(hm.get(4));
	}

}
