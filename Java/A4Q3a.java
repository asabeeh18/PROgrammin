/*A4Q3a.Write a program to accept students names from Command line and store them in vector*/
import java.util.*;
class A4Q3a
{
	public static void main(String args[])
	{
		Vector v=new Vector(100);
		for(int i=0;i<args.length;i++)
			v.addElement(new String(args[i]));
		for(int i=0;i<v.size();i++)	
			System.out.println(v.elementAt(i));
	}
}	