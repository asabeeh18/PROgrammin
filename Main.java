import java.io.*;
public class Main
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t--!=0)
		{
			String s=br.readLine();
			String s1=br.readLine();
			if(s1.length()<s.length())
			{
				String temp=s1+"";
				s1=s+"";
				s=temp;
			}	
			int c=0;
			for(int i=0;i<s.length();i++)
				for(int j=0;j<s1.length();j++)
					if(s1.charAt(j)!='@' && s.charAt(i)==s1.charAt(j))
					{
						s1 = s1.substring(0,j)+'@'+s1.substring(j+1,s1.length());	
						c++;
						break;
					}	
			System.out.println(c);
		}
	}
}	