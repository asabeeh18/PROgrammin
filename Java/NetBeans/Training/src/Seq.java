import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


//https://www.codechef.com/problems/ONP
//Shameful Series: 2
class Seq
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t-->0)
        {
            int n=in.nextInt();
            HashSet<Integer> a=new HashSet<>();
            for(int i=0;i<n;i++)
            {
                a.add(in.nextInt());
            }
            
            int m=in.nextInt();
            int b[]=new int[m];
            for(int i=0;i<m;i++)
            {
                b[i]=in.nextInt();
            }
            boolean[] c=new boolean[m];
            Arrays.fill(c,false);
            for(int i=0;i<m;i++)
            {
                if(a.contains(b[i]))
                {
                    c[i]=true;
                }
                    
            }
            int l=0;
            for(;l<m;l++)
            {
                if(!c[l])
                {
                    System.out.println("No");
                    break;
                }
            }
            if(l==m)
                System.out.println("Yes");
        }
    }
}