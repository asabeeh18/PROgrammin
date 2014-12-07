//String Series
import java.util.*;
class Dee
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		String s[]=new String[5];
		int n[]=new int[5];
		for(int i=0;i<5;i++)
		{
			n[i]=src.nextInt();
			src.nextLine();
			s[i]=src.nextLine();
			System.out.println("\n");
		}	
		for(int i=0;i<5;i++)
			System.out.println(s[i]+"   "+n[i]);
	}
}	
			