package cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Llter {

	private static String String;

	public static void main(String[] args) {
		
		ArrayList l =new ArrayList();
		for(int i=0;i<10;i++)
			l.add(i);
		System.out.println(l);
		
		ArrayList l1 =new ArrayList();
		
		 List list = new ArrayList ();
		// String name="Hi";
		 list.add(8);
		 System.out.println(list);
		 
		
		ListIterator li =l.listIterator();
		while(li.hasNext()) {
			int i =(Integer)li.next();
			System.out.print(i+" ");
			
			if(i%2==0) {
			i++; //Change the value to add
			li.set(i);
			li.add(i);
			}
		}
		System.out.println();
		System.out.println(l);
			
	
	}
}
		
				