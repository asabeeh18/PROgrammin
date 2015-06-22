import java.io.*;
class Edit extends SubEdit
{
 SubEdit se=new SubEdit(); 
 void change()throws IOException
 {
  Functions f=new Functions();   
  
  System.out.println("Enter Your Choice\n1.Edit the name\n2.Edit the marks\n3.Edit phone no.\n4.Edit gr no.\n5.Change Fee Status\n6.Go Back");
  int x=Integer.parseInt(bf.readLine());
  switch(x)
  {
    case 1:System.out.println("Enter the roll no. whose name you want to edit");
           se.names(Integer.parseInt(bf.readLine())+1);
           break;
   case 2:System.out.println("Enter the roll no. whose marks you want to edit");
           marks(Integer.parseInt(bf.readLine())+1);
           break;
   case 3:System.out.println("Enter the roll no. whose phone no. you want to edit");
          phon(Integer.parseInt(bf.readLine())+1);
          break;
   case 4:System.out.println("Enter the roll no. whose gr no. you want to edit");      
          gr(Integer.parseInt(bf.readLine())+1);
          break;
   case 5:System.out.println("Enter the roll no. whose fee status you want to change");  
          fee(Integer.parseInt(bf.readLine())+1);
          break;
   case 6: f.main();  
           break;
   default:System.out.println("Wrong choice To try again press Y/y");
            char c=(char)(bf.read());
        }
        }
    }    
