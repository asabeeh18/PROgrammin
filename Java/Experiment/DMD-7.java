import java.util.*;
class Shape
{
	 double dim1,dim2;
	public void read()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter The two dimensions");
		dim1=src.nextInt();
		dim2=src.nextInt();
	}
	
	public double area()
	{
		return(dim1*dim2);
	}
	
	
}

class Circle extends Shape
{
	public void read()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter radius");
		dim1=src.nextInt();
		
	}
	public double area()
	{
		return(dim1*dim1*3.1415);
	}

}

class Rectangle extends Shape
{
}

class Triangle extends Shape 
{
	public double area()
	{
		return(0.5*dim1*dim2);
	}
}

class Ex7
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		Shape sh=new Shape();
		int ch;
		do
		{
			System.out.println("Enter Choice\n1.Shape\n2.Circle\n3.Rectangle\n4.Triangle\n5.Exit");
			ch=src.nextInt();
			switch(ch)
			{
				case 1:sh.read();
						System.out.println("Area="+sh.area());
						break;	
				case 2: sh=new Circle();
						sh.read();
						System.out.println("Area="+sh.area());
						break;
				case 3: sh=new Rectangle();
						sh.read();
						System.out.println("Area="+sh.area());
						break;
				case 4: sh=new Triangle();
						sh.read();
						System.out.println("Area="+sh.area());
						break;
				case 5:break;
				default:System.out.println("Wrong CHoice try Again!!");
			}
		}while(ch!=5);
	}
}	
	

	
	