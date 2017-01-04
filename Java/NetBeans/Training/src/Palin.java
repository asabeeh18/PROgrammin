
import java.util.Scanner;

//https://www.codechef.com/problems/SPALNUM
//Shameful Series: 5
class Palin
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        in.nextLine();
        int[] a=new int[100001];
        a[0]=0;
        for(int i=1;i<=100000;i++)
        {

            if(isPrime(i))
                a[i]=a[i-1]+i;
            else
                a[i]=a[i-1];
        }
        while(t-->0)
        {
            int c=in.nextInt();
            int b=in.nextInt();
            System.out.println(a[b]-a[c-1]);
        }
    }

    private static boolean isPrime(int i) 
    {
        int n=i;
        StringBuilder sb=new StringBuilder();
        while(n>0)
        {
            sb.append(n%10);
            n/=10;
        }
        n=Integer.parseInt(sb+"");
        if(i==n)
            return true;
        return false;
    }
}