import java.io.*;
class SubEdit extends Declarations
{
  static Functions f=new Functions();
//____________________________---------------------______________________  
  static void names(int r)throws IOException
  {
   System.out.println("Enter the new name for: "+name[r]);
   name[r]=bf.readLine();
   f.func();
  }
//___________________----------------_____________________________________  
  static void marks(int r)throws IOException
  {
   char x='y';
   while(x=='y'||x=='Y')
   {
   System.out.println("Which mark do you want to edit");
   System.out.println("1.Science or");
   System.out.println("2.Computers");
    switch(Integer.parseInt(bf.readLine()))
    {
     case 1: System.out.println("Enter the new marks of science against:"+scimark[r]);
             scimark[r]=Integer.parseInt(bf.readLine());
             break;
     case 2: System.out.println("Enter the new marks of computer against:"+compmark[r]);
             compmark[r]=Integer.parseInt(bf.readLine());
             break;
     default:System.out.println("Wrong choice! To try again press y/Y"); 
             x=(char)(bf.read());
             f.func();
    }
  
    
  }
}
//__________________----------------_____________________________________---  
 static void phon(int r)throws IOException
  {
     System.out.println("Write the new phone number\nOld phone no.:"+phone[r]);
    phone[r]=Long.parseLong(bf.readLine());
    f.func();
  }
//_____________________--------------_____________________________________  
  static void gr(int r)throws IOException
  {
     System.out.println("Write the new gr number\nOld gr no.:"+gr[r]);
     gr[r]=Integer.parseInt(bf.readLine());
     f.func();
  }
//__________________----------------___________________________________  
  static void fee(int r)throws IOException
  {
     System.out.println("The Student has"+fees[r]+"the fees"); 
     if(fees[r]=="Paid")
     {
     System.out.println("Fee Status changed to Not Paid");
     fees[r]="Not Paid";
     }
     else
     {
     System.out.println("Fee Status changed to Paid");
     fees[r]="Paid";
     }
     f.func();
  }
}
     