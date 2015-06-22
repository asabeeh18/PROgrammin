import java.io.*;
class AddStud extends Functions
{

 void add()throws IOException
 {
    Functions f=new Functions(); 
    char y='y'; 
    int roll1[],scimark1[],compmark1[],gr1[];
    double phone1[];
    String name1[],addr1[],fname1[],mname1[];
    while(y=='y'||y=='Y')
    {
     roll1=new int[n];
     scimark1=new int[n];
     compmark1=new int[n];
     gr1=new int[n];
     phone1=new double[n];
     name1=new String[n];
     //addr1=new String[n];
     //fname1=new String[n];
     //mname1=new String[n];
     int m=n;
     m++;
     roll=new int[m];
     scimark=new int[m];
     compmark=new int[m];
     gr=new int[m];
     phone=new double[m];
     name=new String[m];
     //addr=new String[n];
     //fname=new String[n];
     //mname=new String[n];
     System.arraycopy(roll,0,roll1,0,n);
     System.arraycopy(scimark,0,scimark1,0,n);
     System.arraycopy(compmark,0,compmark1,0,n);
     System.arraycopy(gr,0,gr1,0,n);
     System.arraycopy(phone,0,phone1,0,n);
     System.arraycopy(name,0,name1,0,n);
//____________-----------------------________________________--     
     System.arraycopy(roll1,0,roll,0,n);
     System.arraycopy(scimark1,0,scimark,0,n);
     System.arraycopy(compmark1,0,compmark,0,n);
     System.arraycopy(gr1,0,gr,0,n);
     System.arraycopy(phone1,0,phone,0,n);
     System.arraycopy(name1,0,name,0,n);
     n++;
     System.out.println("Enter the name of the Student");
     name[n]=bf.readLine();
     System.out.println("Enter the last schools Computer Marks");
     compmark[n]=Integer.parseInt(bf.readLine());
     System.out.println("Enter the last schools Science Marks");
     scimark[n]=Integer.parseInt(bf.readLine());
     System.out.println("Enter the phone/Mobile number");
     phone[n]=Float.parseFloat(bf.readLine());
     gr[n]=(gr[n-1]+1);
     roll[n]=n+1;
     System.out.println("Do you want to add one more student press Y/y");
     y=(char)(bf.read());
     if(y!='y'||y!='Y')

     f.main();
  }
 }
}
   