import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) 
	{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int a[][][];
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t!=0)
		{
			int n=src.nextInt();
			a=new int[n+1][n+1][n+1];
			int com=src.nextInt();
			String s1=src.next();
			while(com!=0)
			{
				int sum=0;
				String s=src.nextLine();
				s=s1+s;
				if(s.charAt(0)=='U')
					a[s.charAt(s.length()-7)-'0'][s.charAt(s.length()-5)-'0'][s.charAt(s.length()-3)-'0']=s.charAt(s.length()-1)-'0';
				else
				{
					for(int i=s.charAt(s.length()-11)-'0';i<=s.charAt(s.length()-5)-'0';i++)
						for(int j=s.charAt(s.length()-9)-'0';j<=s.charAt(s.length()-3)-'0';j++)
							for(int k=s.charAt(s.length()-7)-'0';k<=s.charAt(s.length()-1)-'0';k++)
								sum+=a[i][j][k];
					System.out.println(sum);
				}	
				com--;
				s1="";
			}
			t--;
		}		
    }
}