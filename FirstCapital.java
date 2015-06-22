//MAke first letter of every word capital
import java.util.*;
class Word
{
	StringBuffer str;
	public Word()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the STRING");
		str=new StringBuffer(src.nextLine());
	}	
	public void makeCapital()
	{
		if(str.charAt(0)>='a' && str.charAt(0)<='z')
			str.setCharAt(0,(char)(str.charAt(0)-32));	//Converts first letter to uppercase
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i-1)==' ')	
				if(str.charAt(i)>='a' && str.charAt(i)<='z')
					str.setCharAt(i,(char)(str.charAt(i)-32));
		}	
	}
	public String toString()
	{
		return str.toString();
	}
		
}	
class Expt
{
	public static void main(String args[])
	{
		Word wr=new Word();
		wr.makeCapital();
		System.out.println(wr);
	}
}	
		