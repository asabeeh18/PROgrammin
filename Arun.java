import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args)
	{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.*/
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		int f[];
		while(t>0)
		{
			int p=src.nextInt();
			int k=src.nextInt();
			int l=src.nextInt();
			f=new int[l];
			for(int i=0;i<l;i++)
				f[i]=src.nextInt();
			sort(f);
			int kk,km=1;
			for(int i=0;i<l;i++)
			{
				if(kk>=k)
				{
					km++;
					kk=0;
				}
				s+=f[i]*km;
				kk++
			}
			System.out.println(s);
		}
	}
}	
				