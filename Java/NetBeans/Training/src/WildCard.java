
import java.util.Scanner;

//https://www.codechef.com/problems/TTENIS
//Shameful Series: 4
class WildCard
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        in.nextLine();
        here: while(t-->0)
        {
            String a=in.nextLine();
            String b=in.nextLine();
            if(a.length()!=b.length())
            {
                System.out.println("No");
                continue;
            }
            for(int i=0;i<a.length();i++)
            {
                if(a.charAt(i)==b.charAt(i))
                    continue;
                else if(a.charAt(i)=='?' || b.charAt(i)=='?')
                    continue;
                else
                {
                    System.out.println("No");
                    continue here;
                }
            }
            System.out.println("Yes");
        }
    }
}