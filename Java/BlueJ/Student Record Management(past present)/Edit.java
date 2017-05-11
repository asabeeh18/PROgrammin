import java.io.*;
class Edit extends SubEdit
{
 static SubEdit se=new SubEdit(); 
 static void change()throws IOException
 {
  Functions f=new Functions();   
  
  System.out.println("Enter Your Choice");
  System.out.println("1.Edit the name");
  System.out.println("2.Edit the marks");
  System.out.println("3.Edit phone no.");
  System.out.println("4.Edit gr no.");
  System.out.println("5.Change Fee Status");
  System.out.println("6.Go Back");
  int x=Integer.parseInt(bf.readLine());
  switch(x)
  {
    case 1:System.out.println("Enter the roll no. whose name you want to edit");
           se.names(Integer.parseInt(bf.readLine())-1);
           break;
   case 2:System.out.println("Enter the roll no. whose marks you want to edit");
           marks(Integer.parseInt(bf.readLine())-1);
           break;
   case 3:System.out.println("Enter the roll no. whose phone no. you want to edit");
          phon(Integer.parseInt(bf.readLine())-1);
          break;
   case 4:System.out.println("Enter the roll no. whose gr no. you want to edit");      
          gr(Integer.parseInt(bf.readLine())-1);
          break;
   case 5:System.out.println("Enter the roll no. whose fee status you want to change");  
          fee(Integer.parseInt(bf.readLine())-1);
          break;
   case 6: f.func();  
           break;
   default:System.out.println("Wrong choice To try again press Y/y");
            char c=(char)(bf.read());
        }
        }
    }    
