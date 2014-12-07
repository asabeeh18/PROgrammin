import java.io.*;
class Functions extends Edit 
{
 
 static void func()throws IOException
 {
    int ch=1; 
   try
   {
   System.out.println("\t  Enter your choice");
   System.out.println("1. Edit a record");
   System.out.println("2.Print or see a report");
   System.out.println("3.Check fee Status");
   System.out.println("4.Print a report card");
   System.out.println("5.Enter a Student");
   //System.out.println("6.Remove a student");
   ch=Integer.parseInt(bf.readLine());
  }
   catch(NumberFormatException e1)
   {
      func();
    }
   switch(ch)
   {
     case 1: Edit ed=new Edit();
             ed.change();
             break;
     case 2: report();
             break;
     case 3:System.out.println("Enter the roll no. whose fee status you want to check");
            int i=(Integer.parseInt(bf.readLine())-1);
            System.out.println("The student has"+fees[i]+"the fees");   
            break;
     case 4: report();
             break;
     case 5: AddStud as=new AddStud();
             as.add();
             break;
     //case 6:
            //break;     
     default: System.out.println("Wrong choice! Try again");  
              func();
    }
 }
}
     
     