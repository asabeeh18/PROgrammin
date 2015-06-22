import java.util.*;
class Person
{
Scanner src = new Scanner(System.in);	
protected String name,code;
public void takeele()
{

	System.out.println("Enter The Name and Code");
	this.name=src.nextLine();
	this.code=src.nextLine();
}

}
class Account extends Person
{
protected int pay;

public void takeele()
{
	super.takeele();
	System.out.println("Enter The Pay");
	{
	this.pay=src.nextInt();
	}
}
}
class Admin extends Account
{
protected int exp;
public void takeele()
{
	super.takeele();
	System.out.println("Enter Experience");
	{
		this.exp=src.nextInt();
	}
}
public void display() 
{
	System.out.println("Name: "+name+" Code: "+code+" Pay: "+pay+" Experience: "+exp);
}
}
class Main
{
	public static void main(String args[])
	{
		Admin a = new Admin();
		a.takeele();
		a.display();
		System.out.println(a);
	}
}
