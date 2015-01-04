import java.io.*;
class Main
{
	public static void main(String args[])
	{
		String s="";
		for(int i=1;s.length()<=3001;i++)
		{	s+=""+i;
			if(s.length()>=3000)
				System.out.println(i);
		}
		System.out.println(s.charAt(2999));
	}
}