import java.io.*;
public class Main
{
    public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t--!=0)
		{
			String s=src.next()
			String s1=src.next();
			if(s1.length()<s.length())
			{
				String temp=s1+"";
				s1=s+"";
				s=temp;
			}	
			int c=0;
			for(int i=0;i<s.length();i++)
				for(int j=0;j<s1.length();j++)
					if(s.charAt(i)==s1.charAt(j))
					{
						s1 = s1.substring(0,j)+'@'+s1.substring(j+1,s1.length());	
						c++;
						break;
					}	
			System.out.println(c);
		}
	}
}