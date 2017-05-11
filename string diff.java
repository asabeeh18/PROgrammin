import java.util.*;
class Ohio
{
	public static void main(String args[])
	{
		int i,j=0;
		String s1,s2;
		Scanner src=new Scanner(System.in);
		s1=src.nextLine();
		s2=src.nextLine();
		System.out.println(s1+"   "+s2);
		for(i=0;i<s1.length();i++)
		{
			if(s1.charAt(i)!=s2.charAt(i+j))
			{
				j=i;
				while(s1.charAt(i)!=s2.charAt(j) && j<s2.length())
				{
					System.out.println(s2.charAt(j));
					j++;
				}
			}
		}	
	}	
}