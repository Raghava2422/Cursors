package cursor;

import java.io.FileWriter;
import java.io.IOException;

public class Fwrite {

	public static void main(String[] args) throws IOException {
		FileWriter fw=new FileWriter("abc.txt");
		//BufferReader br = new BufferReader("ABC.txt");
		fw.write(100);
		fw.write('\n');
		char[] ch = {'a','b','c'};
		fw.write(ch);
		fw.write('\n');
		fw.flush();
		fw.close();
		System.out.println("Done");
	}

}
