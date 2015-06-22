import java.io.*;
public class Main
{
	public static void main(String args[])
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t--!=0)
		{
			String s=br.readLine();
			String s1=br.readLine();
			int c=0;
			for(int i=0;i<s.length();i++)
				for(int j=0;j<s1.length();j++)
					if(s.charAt(i)==s1.chatAt(j))
					{
						String s1 = s1.substring(0,j)+'@'+myName.substring(j+1,s1.length());	
						c++;
					}	
			System.out.println(c);
		}
	}
}	