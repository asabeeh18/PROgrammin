abstract class bhow
{
	int p=22;
	abstract void fu();
	abstract  void kung();
}
class yo extends bhow
{
	public void fu()
	{
		int a=2+3;
		System.out.println(a);
	}
	 void kung()
	{
		System.out.println(p);
	}
}	
class de
{
	public static void main(String ar[])
	{
		System.out.println("JJ");
		yo y=new yo();
		y.fu();
		y.kung();
		
	}
}	