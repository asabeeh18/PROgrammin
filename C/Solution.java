import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	Scanner src=new Scanner(System.in);
	String s;
	int i,j,n,k=0;
	int cost[]=new int[100];
	n=src.nextInt();
	for(;n>0;n--)
	{
		s=src.next();
		System.out.println(s);
		cost[k]=0;
		i=0;
		while(i<s.length())
		{
			if(s.charAt(i)=='@');
			else
			{
				for(j=i+1;j<s.length();j++)
					if(s.charAt(i)==s.charAt(j))
					{
						cost[k]++;
						char[] myNameChars = s.toCharArray();
						myNameChars[j] = '@';
						s= String.valueOf(myNameChars);
						break;
					 }
				if(j<s.length())	 
					if(s.charAt(j)!='@')
						cost[k]++;
			}		 
			i++;
		}
		k++;
	}
	for(i=0;i<k;i++)
		System.out.println(cost[i]+"\n");
 
    }
}