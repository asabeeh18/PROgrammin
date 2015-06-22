//IP
import java.util.*;
class Main
{
	public static void subnetGen(int c)
	{
		System.out.print("Default Subnet Mask: ");
		for(int i=0;i<c;i++)
			System.out.print("255.");
		for(int i=0;i<(4-c-1);i++)
			System.out.print("0.");
		System.out.print("0");
	}

	public static void main(String args[])
	{
		System.out.print("Enter IP address: ");
		Scanner src=new Scanner(System.in);
		String s=src.nextLine();
		String c[]=s.split("\\.");
		int l=0;
		System.out.print("Class ");
		
		if(c[0].compareTo("127")<=0 && c[1].compareTo("255")<=0  && c[2].compareTo("255")<=0  && c[3].compareTo("255")<=0 )
		{
			System.out.println("A");
			l=1;
		}
		else if(c[0].compareTo("191")<=0 && c[1].compareTo("255")<=0  && c[2].compareTo("255")<=0  && c[3].compareTo("255")<=0 )
		{
			System.out.println("B");
			l=2;	
		}		
		else if(c[0].compareTo("223")<=0 && c[1].compareTo("255")<=0  && c[2].compareTo("255")<=0  && c[3].compareTo("255")<=0 )
		{
			System.out.println("C");
			l=3;
		}
		else
		{
			System.out.println("No class");
		}
		subnetGen(l);
	}
}
		