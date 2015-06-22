import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Database
{
	protected static String today,fine,rank,roll,name,phone,adress,bookname,bookid,bookreturn,booktaken,bcheck;
	protected static String nameofBook,uniqueID,sQuant,price,des,loc,q,aurthor,year,lang,page,type;
	protected static int quant;
	
	public static void readStudent(String login) throws IOException
	{
		File Student = new File(("C:\\The D Library\\public\\"+login+".txt"));
		if(Student.exists()==true)
		{
		Scanner rStudent = new Scanner(new FileReader("C:\\The D Library\\public\\"+login+".txt"));
				rank=rStudent.nextLine();
				roll=rStudent.nextLine();
				name=rStudent.nextLine();
				phone=rStudent.nextLine();
				adress=rStudent.nextLine();
				bookname=rStudent.nextLine();
				bookid=rStudent.nextLine();
				booktaken=rStudent.nextLine();
				bookreturn=rStudent.nextLine();
				fine=rStudent.nextLine();
				bcheck=rStudent.nextLine();
		}
		else
		{
			System.out.println("Error 2: ERROR_FILE_NOT_FOUND");
		}
	}
	public static void readBook(String s) throws IOException
	{
		File book = new File("C:\\The D Library\\book\\"+s+".txt");
		if(book.exists()==true)
		{
		Scanner rBook = new Scanner(new FileReader("C:\\The D Library\\book\\"+s+".txt"));
		
				nameofBook=rBook.nextLine();
				aurthor=rBook.nextLine();
				year=rBook.nextLine();
				lang=rBook.nextLine();
				page=rBook.nextLine();
				type=rBook.nextLine();
				uniqueID=rBook.nextLine();
				quant=Integer.parseInt(rBook.nextLine());
				price=rBook.nextLine();
				des=rBook.nextLine();
				loc=rBook.nextLine();
		
		}
		else
		{
			System.out.println("Error 2: ERROR_FILE_NOT_FOUND");
		}
		
	}
	public static void writeStudent(String login) throws IOException
	{
		BufferedWriter newStudent = new BufferedWriter(new FileWriter("C:\\The D Library\\public\\"+login+".txt"));
		newStudent.write(""+rank);
		newStudent.newLine();
		newStudent.write(login);
		newStudent.newLine();
		newStudent.write(""+name);
		newStudent.newLine();
		newStudent.write(""+phone);
		newStudent.newLine();
		newStudent.write(""+adress);
		newStudent.newLine();
		newStudent.write(""+bookname);
		newStudent.newLine();
		newStudent.write(""+bookid);
		newStudent.newLine();
		newStudent.write(""+booktaken);
		newStudent.newLine();
		newStudent.write(""+bookreturn);
		newStudent.newLine();
		newStudent.write(""+fine);
		newStudent.newLine();
		newStudent.write(""+bcheck);
		newStudent.close();
	}
	public static void writeBook(String s) throws IOException
	{
		BufferedWriter nBook = new BufferedWriter(new FileWriter("C:\\The D Library\\book\\"+s+".txt"));
		nBook.write(nameofBook);
		nBook.newLine();
		nBook.write(aurthor);
		nBook.newLine();
		nBook.write(year);
		nBook.newLine();
		nBook.write(lang);
		nBook.newLine();
		nBook.write(page);
		nBook.newLine();
		nBook.write(type);
		nBook.newLine();
		nBook.write(uniqueID);
		nBook.newLine();
		nBook.write(""+quant);
		nBook.newLine();
		nBook.write(price);
		nBook.newLine();
		nBook.write(des);
		nBook.newLine();
		nBook.write(loc);
		nBook.newLine();
		nBook.close();
		
	}
	public static void makenew(String login) throws IOException 
	{
		Scanner src = new Scanner(System.in);
		BufferedWriter newStudent = new BufferedWriter(new FileWriter("C:\\The D Library\\public\\"+login+".txt"));
		newStudent.write("isStudent");
		newStudent.newLine();
		newStudent.write(login);
		newStudent.newLine();
		System.out.println("Enter your Full Name");
		System.out.println("Note: This Name should be Exactly Same as of your ID-Card");
		System.out.println("Note: Middle Name isn't Nessary");
		newStudent.write(src.nextLine()); //name
		newStudent.newLine();
		System.out.println("Enter your Mobile Number/LandLine Number");
		newStudent.write(src.nextLine()); //phone
		newStudent.newLine();
		System.out.println("Enter your Residential Adress");
		newStudent.write(src.nextLine()); //adress
		newStudent.newLine();
		newStudent.write("null"); //
		newStudent.newLine(); 
		newStudent.write("null"); //
		newStudent.newLine();
		newStudent.write("null"); // 
		newStudent.newLine();
		newStudent.write("null"); // 
		newStudent.newLine();
		newStudent.write("0"); // Fine
		newStudent.newLine();
		newStudent.write("False"); //
		newStudent.newLine();
		newStudent.close();
		}
	public static void ilist(int x, int y, int z, String login) throws IOException
	{
		String date=(x+""+y+""+z);
		File check = new File(("C:\\The D Library\\idate\\"+date+".txt"));
		BufferedWriter newStudent = new BufferedWriter(new FileWriter("C:\\The D Library\\idate\\"+date+".txt",true));
		File check1 = new File(("C:\\The D Library\\rdate\\"+date+".txt"));
		BufferedWriter newStudent1 = new BufferedWriter(new FileWriter("C:\\The D Library\\rdate\\"+date+".txt",true));
		{
		newStudent1.write("null");
		newStudent1.newLine();
		newStudent1.close();
		}	
		if(check.exists()==true)
		{
			newStudent.append(login+"");
			newStudent.newLine();
			newStudent.close();
		}
		else
		{
			check.mkdir();
			{
				newStudent.append(login+"");
				newStudent.newLine();
				newStudent.close();
			}
		}
		
	}
	public static void rlist(int x, int y, int z, String login) throws IOException 
	{
		String date=(x+""+y+""+z);
		
		
		File check = new File(("C:\\The D Library\\rdate\\"+date+".txt"));
		BufferedWriter newStudent = new BufferedWriter(new FileWriter("C:\\The D Library\\rdate\\"+date+".txt",true));
		if(check.exists()==true)
		{
			newStudent.append(login+"");
			newStudent.newLine();
			newStudent.close();
		}
		else
		{
			check.mkdir();
			{
				newStudent.append(login+"");
				newStudent.newLine();
				newStudent.close();
			}
		}
		
	}
	
}
class Core extends Database
{
	public void searchBook(String login) throws IOException 
	{
			Scanner src = new Scanner(System.in);
			System.out.println("Enter The New Book Name");
			String s = src.nextLine();
			
			File book = new File("C:\\The D Library\\book\\"+s+".txt");
			if(book.exists())
			{
				Database.readBook(s);
				System.out.println("Book Found Sucessful");
				System.out.println("===============================");
				System.out.println("Name of The Book: "+nameofBook);
				System.out.println("Aurthor: "+aurthor);
				System.out.println("Year Published: "+year);
				System.out.println("No of Pages: "+page);
				System.out.println("Book Type: "+type);
				System.out.println("ISBN-13 : "+uniqueID);
				System.out.println("Total Avaible : "+quant);
				System.out.println("Price of Each Book: "+price);
				System.out.println("ISBN-13 : "+uniqueID);
				System.out.println("Summary Of The Book : "+des);
				System.out.println("Book Location: "+loc);
				System.out.println("===============================");
			
			
			}
			else
			{
				
				System.out.println("Sorry Book isnt Avaible");
				System.out.println("If you want to sugest this book Press 1");
				int ch=src.nextInt();
				if(ch==1)
				{
					System.out.println("Your Request has been Raised");
					
				}
				else
				{
				System.out.println("Thank you");
				}
				
				}
			
	}
	public void issueBook(String login) throws IOException
	{
		Scanner src = new Scanner(System.in);
		System.out.println("Enter The New Book Name");
		String s = src.nextLine();
		
		Database.readStudent(login);
		Database.readBook(s);
		if(Boolean.parseBoolean(bcheck)==true)
		{
			System.out.println("You Have Issued A Book Return Back");
		}
		else
		{
		if(quant==0)
		{
			System.out.println("Stock is Over");
		}
		else
		{
		System.out.println(quant);
		quant--;
		long base=System.currentTimeMillis();
		Date issue = new Date(base+(24*60*60*1000));
		Date toreturn = new Date(base+7*24*60*60*1000);
		
		booktaken=(issue+"");
		bookreturn=(toreturn+"");
		bcheck="true";
		
		int x=toreturn.getDate();
		int y=toreturn.getMonth();
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 6);
		c.setTime(d);
		int z = c.get(Calendar.YEAR);
		
		ilist(x,y,z,login);
		System.out.println(quant);
		System.out.println(bookname);
		String pass = "true";
		bookid = uniqueID;
		bookname = nameofBook;
		fine=0+"";
		Database.writeStudent(login);
		Database.writeBook(s);
		}
		
		}
		
		
	}
}

class Librarian extends Core
{
	private String login;
	public Librarian(String login) 
	{
		this.login=login;
	}
	public void newBook() throws IOException 
	{
		Scanner src = new Scanner(System.in);
		System.out.println("Enter The New Book Name");
		String s = src.nextLine();
		File book = new File("C:\\The D Library\\book\\"+s+".txt");
		if(book.exists())
		{
			System.out.println("The book already entered in our database");
		}
		else
		{
			book.createNewFile();
			BufferedWriter nBook = new BufferedWriter(new FileWriter("C:\\The D Library\\book\\"+s+".txt"));
			nBook.write(s);
			nBook.newLine();
			System.out.println("Enter Book's Publisher");
			nBook.write(src.nextLine());
			nBook.newLine();
			System.out.println("Publication Year");
			nBook.write(src.nextLine());
			nBook.newLine();
			System.out.println("Language");
			nBook.write(src.nextLine());
			nBook.newLine();
			System.out.println("Number of Pages");
			nBook.write(src.nextLine());
			nBook.newLine();
			System.out.println("Book Type");
			nBook.write(src.nextLine());
			nBook.newLine();
			System.out.println("Enter Book's ISBN-13");
			nBook.write(src.nextLine());
			nBook.newLine();
			System.out.println("Enter Total Number Of Books");
			nBook.write(src.nextLine());
			nBook.newLine();
			System.out.println("Enter Price of each book");
			nBook.write(src.nextLine());
			nBook.newLine();
			System.out.println("Enter book's description");
			String des = src.nextLine();
			nBook.write(des);
			nBook.newLine();
			System.out.println("Enter book's location in Library");
			String loc = src.nextLine();
			nBook.write(loc);
			nBook.close();
		}
		
	}
	public void removeBook() 
	{
		Scanner src = new Scanner(System.in);
		System.out.println("Enter The New Book Name To Delete");
		String s = src.nextLine();
		File book = new File("C:\\The D Library\\book\\"+s+".txt");
		if (book.exists())
		{
			book.delete();
			System.out.println("Book has been Deleted");
		}
		else
			System.out.println("Book Doents Exits Over Here");	
	}
	public void deissue() throws IOException, ParseException  //idate rdate error
	{
	Scanner src = new Scanner(System.in);
	System.out.println("Enter Student's Login ID");
	String login=src.next();
	Core.readStudent(login);	
	Core.readBook(bookname);	
	String b=sQuant;
	String student = "student";
	String teacher = "teacher";
	if(Boolean.parseBoolean(bcheck)==true)
		{
		if(rank.contains(student))
		{
		DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
		Date idate = df.parse(booktaken);
		Date rdate = df.parse(bookreturn);
		long base=System.currentTimeMillis();
		Date today = new Date(base+(24*60*60*1000));
		Date fake = new Date(base+(7*24*60*60*1000));
		int x=fake.getDate();
		int y=fake.getMonth();
		Calendar c = Calendar.getInstance();
		c.setTime(fake);
		int z = c.get(Calendar.YEAR);
		System.out.println(today);
		System.out.println(rdate);
		System.out.println(idate);

		if(rdate.compareTo(today)>0)
		{
			System.out.println("No Fine applicable");
			quant++;
			writeBook(bookname);
			bcheck=false+"";
			rlist(x,y,z,login);
			writeStudent(login);    
		}
		
		else if(rdate.compareTo(today)<=0)
		{
			System.out.println("Fine lagla");
			Integer f=new Integer(Integer.parseInt(fine));
			
			if(f==0)
			{
			
				f=f+20;
				fine=f.toString();
				quant++;
				bcheck=false+"";
				writeBook(bookname);
				rlist(x,y,z,login);
				writeStudent(login);
			}
			
			
		}
		
		
				
		}
		
		else if(rank.contains(teacher))
		{
			quant++;
			writeBook(bookname);
			bcheck=false+"";
			bookname="null";
			bookreturn="null";
			booktaken="null";
			bookid="null";
			writeStudent(login);  
		}
		}
		else
		{
			System.out.println("Student hasnt Issued a Book");
		}
	}
	public void defaulter() throws IOException
	{
		Scanner src = new Scanner(System.in);
		System.out.println("Enter the Date To Be Checked in This format DDMMYY");
		String date;
		int x=src.nextInt();
		int y=src.nextInt();
		int z=src.nextInt();
		date=x+""+y+""+z;
		File check1 = new File(("C:\\The D Library\\idate\\"+date+".txt"));
		BufferedReader newStudent1 = new BufferedReader(new FileReader("C:\\The D Library\\idate\\"+date+".txt"));
		File check2 = new File(("C:\\The D Library\\rdate\\"+date+".txt"));
		BufferedReader newStudent2 = new BufferedReader(new FileReader("C:\\The D Library\\rdate\\"+date+".txt"));
		int num1 = 0;
		String rough;
		while((rough = newStudent1.readLine()) != null)
		{
			num1++;
		}
		
		int num2 = 0;
		while((rough = newStudent2.readLine()) != null)
		{
			num2++;
		}
		String idate[]= new String[num1];
		String rdate[]=new String[num2];
		idate[0]="nothing";
		rdate[0]="nothing";
		Scanner iread = new Scanner(new FileReader("C:\\The D Library\\idate\\"+date+".txt"));
		for(int i=0;i<idate.length;i++)
		{
			idate[i]=iread.nextLine();
			
		}
		Scanner rread = new Scanner(new FileReader("C:\\The D Library\\rdate\\"+date+".txt"));
		for(int i=0;i<rdate.length;i++)
		{
			rdate[i]=rread.nextLine();
			
		}
		int i;
		int j;
		for(i=0;i<idate.length;i++)
		lable1:for(j=0;j<rdate.length;j++)
			{
				if((idate[i].equals(rdate[j]))==false)
				{
					System.out.println("Defaulters: "+idate[i]);
					break lable1;
				}
			}
		
			
	}

	public void rankChange() throws IOException
	{
		System.out.println("Enter the login ID");
		Scanner src = new Scanner(System.in);
		login = src.nextLine();
		File check = new File("C:\\The D Library\\public\\"+login+".txt");
		if(check.exists()==true)
		{
			System.out.println("Enter your Choise");
			System.out.println("1:To make as a Admin 2: To make as a Student 3:To Make as a Treacher");
			{
				int ch=src.nextInt();
				switch(ch)
				{
				case 1: Database.readStudent(login);
						rank="isAdmin";
						Database.writeStudent(login);
						break;
				case 2: Database.readStudent(login);
						rank="isStudent";
						Database.writeStudent(login);
						break;
				case 3: Database.readStudent(login);
						rank="teacher";
						Database.writeStudent(login);
						break;
				default:System.out.println("Invalid Choise");
				}
			}
		}
		else
		{
			System.out.println("Invalid ID");
		}
	}

}
class Teacher extends Core
{
	private String login;
	public Teacher(String login) 
	{
		this.login=login;
	}
	
	public void about() {
		{
			System.out.println("Name: "+name);
			System.out.println("Roll Number: "+roll);
			System.out.println("Designation: "+rank);
			System.out.println("Phone Number: "+phone);
			System.out.println("Adress: "+adress);
			System.out.println("Current Book Issed:  "+booktaken+ "(If 0 then False)");
			System.out.println("Book Name: "+bookname);
			System.out.println("Returning Date: "+bookreturn);
			System.out.println("Current Fine: "+fine+" rs");
			
		}
		
	}
}
class Student extends Core
{
	private String login;
	public Student(String login)
	{
		this.login=login;
	}
	public void fine() 
	{
		System.out.print("Your Current Fine is: ");
		System.out.print(fine);
		System.out.print(" Ruppe");
		
	}
	public void pending() 
	{
		if(Integer.parseInt(booktaken)==1)
		{
			System.out.println("You have Alread Issued" +bookname+"Book");
		}
		else
		{
			System.out.println("You are elegible to issue a Book");
		}
	}
	public void about()
	{
		System.out.println("Name: "+name);
		System.out.println("Roll Number: "+roll);
		System.out.println("Designation: "+rank);
		System.out.println("Phone Number: "+phone);
		System.out.println("Adress: "+adress);
		System.out.println("Current Book Issed:  "+booktaken+ "(If 0 then False)");
		System.out.println("Book Name: "+bookname);
		System.out.println("Returning Date: "+bookreturn);
		System.out.println("Current Fine: "+fine+" rs");
		
	}
}
class LibraryMain 
{
	public static void main(String args[]) throws IOException, ParseException
	{
		Scanner src = new Scanner(System.in);
		
		File firstrun = new File("C:\\The D Library");
		if(firstrun.exists()==true)
		{
		System.out.println("Enter Your ID Number");
		String login = src.next();
		File check = new File(("C:\\The D Library\\public\\"+login+".txt"));
		{
		if(check.isFile()==true)
		{
		BufferedReader level = new BufferedReader(new FileReader("C:\\The D Library\\public\\"+login+".txt"));
		String isAdmin = level.readLine();
		String teach = new String("teacher");
		String Admin = new String("isAdmin");
		if(Admin.equals(isAdmin))
		{
			
			Librarian librarian = new Librarian(login);
			System.out.println("Welcome Admin");
			int ch;
			do{
			System.out.println("1: To Add A New Book \n2: Remove The Bunch of Book \n3:Deissue a Book\n4:Check For Defaulters\n5:Change the Rank\n6:Exit ");
			ch=src.nextInt();
			switch(ch)
			{
			case 1:	librarian.newBook();
					break;
			case 2: librarian.removeBook();
					break;
			case 3: librarian.deissue();
					break;
			case 4: librarian.defaulter();
					break;
			case 5: librarian.rankChange();
					break;
			case 6: break;
			default: System.out.println("Invalid Choise");
			}
			}
			while (ch!=6);
		}
		
		else if(teach.equals(isAdmin))
		{
			Teacher teacher = new Teacher(login);
			System.out.println("Welcome Teacher");
			int ch;
			do{
			System.out.println("1: To Search a Book \n2: Issue a Book \n3:About  ");
			ch=src.nextInt();
			Database.readStudent(login);
			switch(ch)
			{
			case 1: teacher.searchBook(login);
					break;
			case 2:	teacher.issueBook(login);
					break;
			case 3:teacher.about();
					break;
			}
			}
			while (ch!=5);	
		}
		else
		{
			Student student = new Student(login);
			Database.readStudent(login);
			long base=System.currentTimeMillis();
			Date today = new Date(base+(24*60*60*1000));
			int ch1;
			System.out.println("Welcome Student");
			do{
			System.out.println("1: To Search a Book\n2: Issue a Book\n3:Already Issued Book\n4:Fine\n5:About Me");
			ch1= src.nextInt();
			switch(ch1)
			{
			case 1: student.searchBook(login);
					break;
			case 2:	student.issueBook(login);
					break;
			case 3: student.pending();
					break;
			case 4: student.fine();
					break;
			case 5:student.about();
					break;
			}
			}
			while(ch1!=6);
			
			}
		
		
	}
		
		else
		{
		System.out.println("You arent Registered");
		System.out.println("Press 1 to Register 2 to Exit");
		int rcheck = src.nextInt();
			if(rcheck==1)
			{
			Database.makenew(login);
			System.out.println("Thank you For Registering");
			}
		}
		}
	}
		else
		{
			System.out.println("Installing the Required File/Folders");
			firstrun.mkdir();
			File folder1 = new File("C:\\The D Library\\book");
			File folder2 = new File("C:\\The D Library\\idate");
			File folder3 = new File("C:\\The D Library\\public");
			File folder4 = new File("C:\\The D Library\\rdate");
			folder1.mkdir();
			folder2.mkdir();
			folder3.mkdir();
			folder4.mkdir();
			System.out.println("Sucessful. Please Restart the Program");
		}
	}
}
