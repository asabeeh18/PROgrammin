import java.io.*;
class Functions extends Edit 
{
 
 void main()throws IOException
 {
   System.out.println("\t  Enter your choice \n 1. Edit a record\n2.Print or see a report \n3.Check fee Status \n4.Print a report card \n5.Enter a Student \n6.Remove a student");
   int ch=Integer.parseInt(bf.readLine());
   switch(ch)
   {
     case 1: Edit ed=new Edit();
             ed.change();
             break;
     case 2: report();
             break;
     case 3:
            
            break;
     case 4: report();
             break;
     case 5: AddStud as=new AddStud();
             as.add();
             break;
     case 6:
            break;     
     default: System.out.println("Wrong choice! Try again");  
              main();
    }
 }
}
     
     