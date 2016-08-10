class Testing
{
	int a=1;
	String s="2";
	Testing(Testing t)
	{
		t.a=3;
		t.s="a";
		t=null;
	}
	Testing()
	{
	}
	
	public static void main(String ar[])
	{
		Testing t=new Testing();
		new Testing(t);
		if(t==null)
			System.out.println("NULL"+t.a);
		else
			System.out.println(t.a+":"+t.s);
	}
}