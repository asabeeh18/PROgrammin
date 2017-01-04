
import java.util.Scanner;

//https://www.codechef.com/problems/FRUITS
//Shameful Series: 1
class Fruits
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0)
        {
            int n=in.nextInt();
            int m=in.nextInt();
            int k=in.nextInt();
            int j=Math.abs(n-m);
            if(j!=0)
            {
                if(j<=k)
                    j=0;
                else
                {
                    j-=k;
                }
            }
            System.out.println(""+j);
        }
    }
}