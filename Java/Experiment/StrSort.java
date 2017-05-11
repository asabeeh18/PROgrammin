import java.util.*;
class StrSort
{
	private String s[];
	public StrSort(int n)
	{
		s=new String[n];
		Scanner src=new Scanner(System.in);
		System.out.println("ENTER STRINGS");
		for(int i=0;i<n;i++)
			s[i]=src.nextLine();
	}	
	public void sort()
	{
		for(int i=0;i<s.length-1;i++)
			for(int j=0;j<s.length-i-1;j++)
				if(s[j].compareToIgnoreCase(s[j+1])>1)
				{
					String t=s[j];
					s[j]=s[j+1];
					s[j+1]=t;
				}
	}
	public String toString()
	{
		String r="";
		for(int i=0;i<s.length;i++)
			r+=s[i]+"\n";
		return r;	
	}
}
class Exp9
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the number of Strings to enter");
		StrSort s=new StrSort(src.nextInt());
		System.out.println("Original String:\n"+s);
		s.sort();
		System.out.println("Sorted String:\n"+s);
	}	
}	