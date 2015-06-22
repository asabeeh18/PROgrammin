//Inheriting Constructor
interface bhow
{
	int p=22;
	void fu();
	void kung();
}
class Inherit
{
	static int y=9;
	Inherit()
	{
		System.out.println("Inherit COnstructor");
	}
	static void no()
	{
		y+=9;
		System.out.println(y);
	}	
}
class Boy extends Inherit implements bhow
{
		Boy()
		{
			System.out.println("Boy COnstructor");
		}
		public void fu()
	{
		int a=2+3;
		System.out.println(a);
	}
	 public static void kung()
	{
		System.out.println(p);
		no();
	}
	
}		
class Man extends Boy
{
		Man()
		{
			System.out.println("Man COnstructor");
			kung();
		}
		final static Boy b=new Boy();
}		
class inho
{
	public static void main(String args[])
	{
		final Boy n=new Man();
		
	}
}	