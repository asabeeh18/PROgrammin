
import java.util.Scanner;


//https://www.codechef.com/problems/TTENIS
//Shameful Series: 3
class TT
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        in.nextLine();
        while(t-->0)
        {
            String s=in.nextLine();
            int a=0,b=0,i=0,z;
            while(a!=11 && b!=11)
            {
                z=(s.charAt(i)=='0')?a++:b++;
                i++;
            }
            
            if(Math.abs(a-b)>=2)
            {
                if(a>b)
                    System.out.println("LOSE");
                else
                    System.out.println("WIN");
            }
            else
            {
                while(Math.abs(a-b)<2)
                {
                    z=(s.charAt(i)=='0')?a++:b++;
                    i++;
                }
                if(a>b)
                    System.out.println("LOSE");
                else
                    System.out.println("WIN");
            }
            
        }
    }
}