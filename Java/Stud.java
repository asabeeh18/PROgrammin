/*Create a class student which stores name rollno. and height of a student.
Write a program to arrange records of n students in ascending order of their height*/
import java.util.*;
class Student
{
	private int roll,ht;
	private String name;
	private static int n;
	Student(int a){n=a;}
	Student()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the name of Student");
		name=src.nextLine();
		System.out.println("Enter the roll number of Student");
		roll=src.nextInt();
		System.out.println("Enter the height of Student");
		ht=src.nextInt();
	}	
	public static void sort(Student s[])
	{
		for(int i=0;i<n-1;i++)
			for( int j=0;j<n-i-1;j++)
				if(s[j].ht>s[j+1].ht)
				{
					Student t=s[j];
					s[j]=s[j+1];
					s[j+1]=t;
				}	
	}
	public static void display(Student s[])
	{
		for(int i=0;i<n;i++)
			System.out.println("Name: "+s[i].name+"\tRoll No.: "+s[i].roll+"\tHeight: "+s[i].ht);
	}		
}
class A3Q5
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the number of students you want to enroll");
		int n=src.nextInt();
		Student[] s=new Student[n];
		new Student(n);
		for(int i=0;i<n;i++)
			s[i]=new Student();
		Student.sort(s);	
		Student.display(s);
	}
}	