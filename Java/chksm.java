//chksum
import java.util.*;
class Main
{
	public static String check(String s,int f)
	{
		int n[]=new int[f];
		int a=0;
		for(int i=0;i<f;i++)
		{
			n[i]=Integer.parseInt(s.substring(i*4,(i+1)*4));
			a+=Integer.parseInt(""+n[i],2);
		}
		s=Integer.toBinaryString(a);
		while(s.length()>4)
		{
			String s1=s.substring(0,s.length()-4);
			s=s.substring(s.length()-4,s.length());
			s=Integer.toBinaryString((Integer.parseInt(s,2)+Integer.parseInt(s1,2)));
		}	
		while(s.length()<4)
		{
			s=0+s;
		}
		s=Integer.toBinaryString(~Integer.parseInt(s,2));
		s=s.substring(s.length()-4,s.length());
		return s;
	}
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter 16-bit sending code");
		String s=src.nextLine();
		s=s+check(s,4);
		System.out.println("Sent Code: "+s);
		System.out.println("Enter 20-bit received code");
		String s1=src.nextLine();
		s=check(s1,5);
		if(s.equals("0000"))
			System.out.println("ALL OK!");
		else
			System.out.println("Doesnt match Error:"+s);
	}
}