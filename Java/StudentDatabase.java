/*wap to accept n students. each student has name,roll no and marks in 3 subjects. determine total marks of each student,highest marks in bee,roll no of the student securing it and sort the students according to their grand totals.also find the average percentage of d class. */
//add a toString which prints all details of students ..thoda better hoga
//keep program as short as posibl..shortcuts
/* Example:
public boolean isPalin(int x)
	{
		return ((x==reverse(x))?true:false);
	}
*/	
import java.util.*;

class Student
{
	Scanner src=new Scanner(System.in);
	public String name;
	public int rno,maths,bee,mech;
	public static int total;
	public int gtotal;
	
	public Student()
	{
		System.out.println("enter name");
		name=src.nextLine();
		System.out.println("enter roll no");
		rno=src.nextInt();
		System.out.println("enter marks in 3 subjects");
		maths=src.nextInt();
		bee=src.nextInt();
		mech=src.nextInt();
		total+=maths + bee + mech;              /*total stores d total of d grandtotals of all students */
		//grand total idhar hi nikaal
		gtotal=maths +bee +mech;
	}

	public static void grandtotal(Student x[])
	{
		//int i; no need of dis
		for(int i=0;i<x.length;i++)
			x[i].gtotal=x[i].maths + x[i].bee + x[i].mech;
	}
	
	public static void sort(Student x[])
	{
		int i,j;
		for(i=0;i<x.length-1;i++)	//int andar ghusa
			for(j=0;j<x.length;j++)	//for(j=0;j<x.length-i-1;j++)
				if(x[j].gtotal<x[j+1].gtotal)
				{
					Student t=x[j];
					x[j]=x[j+1];
					x[j+1]=t;
				}
	}

	public static void beeTopper(Student x[])
	{
		String topper=x[0].name;		
		int i,highest=0;
		for(i=0;i<x.length;i++)	//int andar ghusa
			if(x[i].bee>highest)
			{
				highest=x[i].bee;
				topper=x[i].name;
			}
		System.out.println("BEE topper is "+ topper +" at "+ highest +" marks");
	}

	public static double avgPercent(Student x[])
	{
		double avgper=total/(300*x.length)*100;
		return avgper;
		//return total/(300*x.length)*100;
	}
}
	
class StudentDatabase
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("enter no. of students");
		Student s[]=new Student[src.nextInt()];
		for(int i=0;i<s.length;i++)
			s[i]=new Student();
		double avgper=Student.avgPercent(s);
		System.out.println("Average percent of the class= "+avgper);
		//System.out.println("Average percent of the class= "+Student.avgPercent(s));
		Student.beeTopper(s);
		System.out.println("\nsorted Students");
		System.out.println("\nname\t roll no \t total");//dont depnd on colums display show in horizontal format columns will always have next line problms
		/*
		Name:asjfasd
		marks:asdf
		roll:a0223
		--------
		Name:asjfasd
		marks:asdf
		roll:a0223
		--------
		Name:asjfasd
		marks:asdf
		roll:a0223
		--------
		*///lyk dat
		//toString or display function is preferred
		for(int j=0;j<s.length;j++)
			System.out.println(s[j].name + "\t" + s[j].rno + "\t\t  " + s[j].gtotal);
	}
}