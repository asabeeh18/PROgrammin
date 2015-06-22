//return array
class ddd
{
	Object[] pur()
	{
		Object ch[]={'c','a','t'};
		return ch;
	}
}
class de
{
	public static void main(String as[])
	{
		Object ch[]=(new ddd()).pur();
		System.out.println(ch[0]+""+ch[1]+""+ch[2]);
	}
}	