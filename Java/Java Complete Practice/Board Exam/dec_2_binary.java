import java.io.*;
class dec_2_binary
{int d=0,neo=0,s=0,rev=0;
 BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
  System.out.println("Enter d no. ");
  int n=Integer.parseInt(bf.readLine());
  
  while(n>0)
  {
      d=n%2;
      neo=(neo*10)+d;
      n=n/2;
    }
    String m=String.valueOf(neo);
    System.out.println(neo);
    
    while(neo>0)
  {
      s=neo%10;
      rev=(rev*10)+s;
      neo=neo/10;
    }
    
        String ne=String.valueOf(rev);
    
    System.out.println(rev);
}
}