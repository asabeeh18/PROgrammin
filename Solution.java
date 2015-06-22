import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.*/
	Scanner src=new Scanner(System.in);
	int ex[];
	int en[];
	int n=src.nextInt();
	int ppl=0;
	while(n>0)
	{
		ppl=0;
		int r=src.nextInt();
		ex=new int[r];
		en=new int[r];
		for(int i=0;i<r;i++)
		{
			en[i]=src.nextInt();
			ex[i]=src.nextInt();
		}
		for(int i=0;i<r;i++)
		{
			int j;
			for(j=i+1;j<r;j++)
			{
				if(ex[i]<=en[j] && ex[i]!=0 && en[i]!=0)
				{
					en[j]=0;
					ppl++;
					break;
				}	
			}
			if(j==r && en[i]!=0)
				ppl++;
		}
		n--;
	}	
		System.out.println(ppl);
    }
}