import java.util.*;
class Stuff
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter data to send: ");
		String s=src.nextLine();
		for(int i=0;i<s.length();i++)
		{
			int c=0;
			while(i<s.length() && s.charAt(i)=='1')
			{
				c++;
				i++;
				if(c==5)
				{
					s=s.substring(0,i)+'0'+s.substring(i,s.length());
					c=0;
				}

			}
		}
		System.out.println("Stuffed Data:"+s);
		//destuff
		for(int i=0;i<s.length();i++)
		{
			int c=0;
			while(i<s.length() && s.charAt(i)=='1')
			{
				c++;
				i++;
				if(c==5)
				{
					s=s.substring(0,i)+s.substring(i+1,s.length());
					c=0;
				}

			}
		}
		System.out.println("Receivers End Destuffed Data:"+s);	
	}
}