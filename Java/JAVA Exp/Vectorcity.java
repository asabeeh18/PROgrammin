//Vector-cities
import java.util.*;
class Cities
{
	Vector city;
	int k=0;
	public Cities()
	{
		city=new Vector();
	}	
	void add(String citi)
	{
		for(int i=0;i<city.size();i++)
			if(((String)city.elementAt(i)).equals(citi))
			{
				System.out.println("City Already Exists!!");
				return;
			}
		city.insertElementAt(citi,0);
	}
	void remove(String citi)
	{
		int i;
		for(i=0;i<city.size();i++)
			if(((String)city.elementAt(i)).equals(citi))
			{
				city.removeElementAt(i);
				break;
			}
		if(i==city.size())
				System.out.println("City Not present");
	}
	void display()
	{
		for(int i=0;i<city.size();i++)
			System.out.println(city.elementAt(i));
	}		
}
class Ecity
{
	public static void main(String args[])
	{
		int ch=0;
		Cities cit=new Cities();
		Scanner src=new Scanner(System.in);
		do{
			System.out.println("1.Add\n2.Remove3.Display All\n4.Exit");
			ch=src.nextInt();
			src.nextLine();	//dummy String
			switch(ch)
			{
				case 1: System.out.println("Enter City NAme");
						cit.add(src.nextLine());
						break;
				case 2: System.out.println("Enter City NAme");
						cit.remove(src.nextLine());
						break;
				case 3: cit.display();
						break;
				case 4: break;
				default: System.out.println("try again!");
			}
		}while(ch!=4);
	}
}	