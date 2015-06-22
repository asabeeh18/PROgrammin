/*Consider a class Network.The class 'Admin' derives information from the class 'Account' 
which in turn derives information from 'Person' class.Write a program to display Admin Object.*/
import java.util.*;
class Person
{
	protected String name;
	protected int code;
	public Person()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter name and code");
		name=src.nextLine();
		code=src.nextInt();
	}
}
class Account extends Person
{
	protected long pay;
	public Account()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the PAY");
		pay=src.nextInt();
	}
}
class Admin extends Account
{
	protected int exp;
	public Admin()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the Experience");
		exp=src.nextInt();
	}
	public String toString()
	{
		return "Name: "+name+"\nCode: "+code+"\nPAY: "+pay+"\nExperience: "+exp;
	}	
}
class A4Q2
{
	public static void main(String args[])		
	{
		Admin ad=new Admin();
		System.out.println(ad);
	}
}	