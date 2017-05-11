import java.io.*;
class each_word_rev
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 void main(String ars[])throws IOException
 {
   System.out.println("Enter the str");
   String s=bf.readLine();
   int l=s.length();
   int p=0;
   for(int i=0;i<l;i++)
   {
     if(s.charAt(i)==' ')
     {
       for(int j=i;j>=p;j--)
       {
         System.out.println(s.charAt(j));
        }
        p=i;
      }
     }
    }
}

    
      
         
         
         
         
         