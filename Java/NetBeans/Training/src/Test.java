
import java.util.Scanner;


//https://www.codechef.com/problems/COMM3
//Shameful Series: 7
class Test
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        boolean flag=false;
        while(in.hasNext())
        {
            int x=in.nextInt();
            if(x==42)
                flag=true;
            if(!flag)
                System.out.println(x);
        }
    }
}