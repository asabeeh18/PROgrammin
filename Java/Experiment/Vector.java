import java.util.*;
class MyVector
{
	Vector v=new Vector();
	public MyVector()
	{}
	public void read()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter a Character to stop Reading");
		try
		{
			v.addElement(new Integer(src.nextInt()));
		}
		catch(Exception e){}	
	}	
	void deleteMax()
	{
		int m=0;
		for(int i=0;i<v.size();i++)
			if((Integer)v.elementAt(i).intValue()>m)
				m=i;		
		removeElementAt(m);
	}		
	public void findMean()
	{
		int s=0;
		for(int i=0;i<v.size();i++)
			s+=(Integer)v.elementAt(i).intValue();
		System.out.println("Average of Elements:="+(double)s/v.size);
	}
	public void sort()
	{
		for(int i=0;i<v.size()-1;i++)
			for(int j=0;j<v.size()-i-1;j++)
				if((Integer)v.elementAt(j).intValue()>(Integer)v.elementAt(j+1).intValue())
				{
					Object t=(Integer)v.elementAt(j);
					(Integer)v.elementAt(j)=(Integer)v.elementAt(j+1);
					(Integer)v.elementAt(j+1)=t;
				}
	}			
	public void insertPos()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the position then Element");
		int n=src.nextInt();
		insertElement((object)new Integer((src.nextInt())),n);
	}
	public void display()
	{
		for(int i=0;i<v.size;i++)
			System.out.println(v.elementAt(i));
	}
}
class Exp10
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		MyVector mv=new Vector();
		mv.read();
		int ch=0;
		do
		{
			System.out.println("1.Delete MAx\n2.findMEan\n3.sort\n4.insert Pos\n5.display");
			ch=src.nextInt();
			switch(ch)
			{
				case 1:mv.deleteMax();
						break;
				case 2:mv.findMean();
						break;
				case 3:	mv.sort();	
						break;
				case 4:	mv.insertPos();
						break;
				case 5:display();
						break;
				case 6: break;
			}
		}while(ch!=6);
	}
}	