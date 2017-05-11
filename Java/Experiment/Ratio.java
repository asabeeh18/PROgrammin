import java.util.*;
class Ratio
{
	private int num,den;
	public Ratio()
	{}
	public Ratio(int num,int den)
	{
		this.num=num;
		this.den=den;
	}
	public Ratio addRatio(Ratio m)
	{
		Ratio r=new Ratio();
		r.num=num*m.den+den*m.num;
		r.den=den*m.den;
		r.simplify();
		return r;
	}
	public Ratio subRatio(Ratio m)
	{
		Ratio r=new Ratio();
		r.num=num*m.den-den*m.num;
		r.den=den*m.den;
		r.simplify();
		return r;
	}
	public Ratio multRatio(Ratio m)
	{
		Ratio r=new Ratio();
		r.num=num*m.num;
		r.den=den*m.den;
		r.simplify();
		return r;
	}
	public Ratio divideRatio(Ratio m)
	{
		Ratio r=new Ratio();
		r.num=num*m.den;
		r.den=den*m.num;
		r.simplify();
		return r;
	}
	void simplify()
	{
		for(int i=2;i<=den;i++)
		{
			if(num%i==0 && den%i==0)
			{
				num=num/i;
				den=den/i;
			}
		}
	}	
	public void compareRatio(Ratio b)
	{  
		
		if((num*b.den)<(den*b.num))
			System.out.println("Ratio 1 is less than Ratio 2");
		else if((num*b.den)>(den*b.num))
			System.out.println("Ratio 1 is greater than Ratio 2");
		else System.out.println("Ratio 1 is equal to  Ratio 2");
	}

	public Ratio reciprocal()
	{	
		Ratio r=new Ratio();
		r.num=den;
		r.den=num;
		return r;
	}

	public String toString()
    {
		return num+"/"+den;
	}
	
	public void display()
	{
		System.out.println(this);
	}	
}
class RatioExp
{
	public static void main(String args[])	
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter num and den of Ratio 1");
		Ratio a=new Ratio(src.nextInt(),src.nextInt());
		System.out.println("Enter num and den of Ratio 2");
     	Ratio b=new Ratio(src.nextInt(),src.nextInt());
		Ratio c=new Ratio();
		a.compareRatio(b);
		c=a.addRatio(b);
		c.display();
		c=a.subRatio(b);
		c.display();
		c=a.multRatio(b);
		c.display();
		c=a.divideRatio(b);
		c.display();
		c=a.reciprocal();
		c.display();
	}
}	