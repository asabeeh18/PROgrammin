package APC_Comp;
import java.io.*;
class type_convert
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    void main()throws IOException
    {
    System.out.println("Enter a letter");
    int x=Integer.parseInt(br.readLine());
    char g=(char)x;
    System.out.println(g);
}
}