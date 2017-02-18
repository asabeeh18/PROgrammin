
import java.util.Scanner;

//http://poj.org/problem?id=1003
class Hangover
{
    public static void main(String ar[])
    {
        Scanner r=new Scanner(System.in);
        double d=r.nextDouble();
        while(d!=0.0d)
        {
            double sum=0;
            int i=2;
            while(sum<d)
            {
                sum+=1.0/i;
                i++;
            }
            System.out.println((i-2)+" card(s)");
            d=r.nextDouble();
        }
    }
}