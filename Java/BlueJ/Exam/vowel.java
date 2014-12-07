import java.io.*;
class vowel
{
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
      int count=0;
      System.out.println("Enter a string");
      String s=bf.readLine();
      int t=s.length();
      for(int i=0;i<t;i++)
      {
          char c=s.charAt(i);
          if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
          {
              count++;
            }
            System.out.print(c+"\t");
            System.out.print((i+1)+"\t");
            
        }
        System.out.println(count);
        
    }
}