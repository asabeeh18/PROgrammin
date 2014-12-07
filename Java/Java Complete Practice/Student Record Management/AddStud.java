import java.io.*;
class AddStud extends Functions
{

 static void add()throws IOException
 {
     Functions f=new Functions(); 
     char y='y'; 
     int roll1[],scimark1[],compmark1[],gr1[];
     long phone1[];
     String name1[],addr1[],fname1[],mname1[],fees1[];
    while(y=='y'||y=='Y')
    {
     roll1=new int[n];
     scimark1=new int[n];
     compmark1=new int[n];
     gr1=new int[n];
     phone1=new long[n];
     name1=new String[n];
     //addr1=new String[n];
     fname1=new String[n];
     mname1=new String[n];
     fees1=new String[n];
     System.arraycopy(roll,0,roll1,0,n);
     System.arraycopy(scimark,0,scimark1,0,n);
     System.arraycopy(compmark,0,compmark1,0,n);
     System.arraycopy(gr,0,gr1,0,n);
     System.arraycopy(phone,0,phone1,0,n);
     System.arraycopy(name,0,name1,0,n);
     System.arraycopy(fname,0,fname1,0,n);
     System.arraycopy(mname,0,mname1,0,n);
     System.arraycopy(fees,0,fees1,0,n);
     int m=n;
     m++;
     roll=new int[m];
     scimark=new int[m];
     compmark=new int[m];
     gr=new int[m];
     phone=new long[m];
     name=new String[m];
     //addr=new String[n];
     fname=new String[m];
     mname=new String[m];
     fees=new String[m];
     
//____________-----------------------________________________--     
     System.arraycopy(roll1,0,roll,0,n);
     System.arraycopy(scimark1,0,scimark,0,n);
     System.arraycopy(compmark1,0,compmark,0,n);
     System.arraycopy(gr1,0,gr,0,n);
     System.arraycopy(phone1,0,phone,0,n);
     System.arraycopy(name1,0,name,0,n);
     System.arraycopy(fname1,0,fname,0,n);
     System.arraycopy(mname1,0,mname,0,n);
     System.arraycopy(fees1,0,fees,0,n);
     System.out.println("Enter the name of the Student");
     name[n]=bf.readLine();
     System.out.println("Enter the last schools Computer Marks");
     compmark[n]=Integer.parseInt(bf.readLine());
     System.out.println("Enter the last schools Science Marks");
     scimark[n]=Integer.parseInt(bf.readLine());
     System.out.println("Enter the phone number");
     phone[n]=Long.parseLong(bf.readLine());
     System.out.println("Has he paid the fee or will pay after some time Press y/Y");
     if((char)(bf.read())=='y'||(char)(bf.read())=='Y')
     {
      fees[n]="Paid";
    }
    else
    {
       fees[n]="Not Paid";
    }
     gr[n]=(gr[n-1]+1);
     roll[n]=n+1;
     n++;
     System.out.println("Do you want to add one more student press Y/y");
     y=(char)(bf.read());    
  }
  f.func();
 }
}
   