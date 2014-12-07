package Library;
import java .io.*;
class Separate
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
     System.out.println("Enter the date in the format given \n dd/mm/yyyy");
     String s=br.readLine();
     if(s.charAt(2)!='/'&& s.charAt(5)!='/')
     {
     for(;s.charAt(2)!='/'&& s.charAt(5)!='/';)
     {
      System.out.println("Wrong format Entered");
     System.out.println("Enter the date in the format given \n dd/mm/yyyy");
      s=br.readLine();
    }
}
       int d=Integer.parseInt(s.substring(0,2));
     if(d>31)
     {
         System.out.println("The date does not exists");
        }
        int m=Integer.parseInt(s.substring(3,5));
     if(m>12)
     {
        System.out.println("The month does not exists");
        } 
     int l=s.length();
     l--;
     System.out.println("The date: "+s.substring(0,2));
     System.out.println("The Month: "+s.substring(3,5));
     System.out.println("The date: "+s.charAt(6)+s.charAt(7)+s.charAt(8)+s.charAt(9));
    }
}

