/*Q4a.Write a program to count the frequency of occurence of given character in a given line of text.*/
import java.util.*;
class Occur
{
	String s;
	public Occur(String s)
	{
		this.s=s;
	}	
	public int freq(char c)
	{
		int ctr=0;
		for(int i=0;i<s.length();i++)
			if(c==s.charAt(i))
				ctr++;
		return ctr;
	}
}
class A4Q4a
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the String");
		Occur oc=new Occur(src.nextLine());
		System.out.println("Enter the character to check frequency");
		char c=src.next().charAt(0);
		System.out.println("Frequency of "+c+" is: "+oc.freq(c));
	}
}	