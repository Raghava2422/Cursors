package cursor;

import java.io.File;
import java.io.IOException;

public class Fhand {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File Obj = new File("myfile.txt");
		System.out.println(Obj.exists());
		
		Obj.createNewFile();
		System.out.println(Obj.exists());
	}

}
