/*
Given 2 jugs of capacity a and b gallons, and an infinite supply of water,
 can you fill one of the jugs with exactly c gallons of water ?*/
 import java.io.*;
import java.util.*;

class Solution
{
  public static void main (String [] args) throws IOException 
  {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
	StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int t = Integer.parseInt(st.nextToken());
	while(t--!=0)
	{
    st= new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int a = Integer.parseInt(st.nextToken());    // first integer
    int b = Integer.parseInt(st.nextToken());    // second integer
    int c=Integer.parseInt(st.nextToken());
	int ar[]=new int[a*b];
	ar[0]=a;
	ar[1]=b;
	int len=2;
	if(ar[0]<ar[1])
	{
		ar[0]=b;
		ar[1]=a;
	}
	boolean found=false;
	boolean gotNew=false;
	if(c>ar[0]+ar[1])
	{
		System.out.println("NO");
		continue;
	}
		
	for(int i=0;i<len-1 && !found;i++)
	{
		for(int j=0;j<len;j++)
		{
			
			if(i!=j)
			{
				//for(int l=0;l<len;l++)
					//System.out.print(ar[l]+" ");
				//System.out.println(i+"-"+j);
				//System.out.println();
				int k=ar[i]-ar[j];
				if(k==c)
				{
					System.out.println("YES");
					found=true;
					break;
				}
				//if k not in ar then push in ar
				boolean isThere=false;
				for(int h=0;h<len && !isThere;h++)
					if(k==ar[h])
						isThere=true;
				if(k<=0)
					isThere=true;
				if(!isThere)
				{
					ar[len++]=k;
					gotNew=true;
				}
				
				if(ar[j]+ar[i]==c)
				{
					ar[len++]=ar[j]+ar[i];
					System.out.println("YES");
					found=true;
					break;
				}
			}
		}
		if(gotNew)
			i=-1;
		gotNew=false;
	}
	if(!found)
		System.out.println("NO");
  }
    System.exit(0);                               // don't omit this!
  }
}
