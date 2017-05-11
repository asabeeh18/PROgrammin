import java.util.*;
class Solution
{
	public static void main(String args[])
	{
    String s1,s2;
    int i,j,ind=-1,m=-1,k;
   // printf("7");
	Scanner src=new Scanner(System.in);
	s1=src.next();
	s2=src.next();
	int a[][]=new int[s2.length()][s1.length()];
    //printf("9");
	for(i=0;i<s2.length();i++)
	{
		for(j=0;j<s1.length();j++)
		{
      //      printf("12");
			k=0;
			if(s2.charAt(i+k)==s1.charAt(j+k))
			{
                while( (i+k)<(s2.length()) &&(j+k)<s1.length() && s2.charAt(i+k)==s1.charAt(j+k))
					k++;
          //      printf("19");
				a[i][j]=k;
			}
		}
	}
	for(i=0;i<(s2.length());i++)
		for(j=0;j<(s1.length());j++)
			if(m<a[i][j])
			{
				m=a[i][j];
				ind=i;
			}
	for(i=ind;i<(ind+m);i++)
	{
		System.out.print(s2.charAt(i));
	}
	System.out.print("\n"+m);
	
}
}