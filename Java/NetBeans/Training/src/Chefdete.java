
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.codechef.com/FEB16/problems/CHEFDETE

class Chefdete
{
    public static void main(String ar[]) throws IOException
    {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		String line=r.readLine();
        int n=Integer.parseInt(line);
        String s[]=r.readLine().split(" ");
        boolean a[]=new boolean[n+1];
        for(int i=0;i<n;i++)
        {
            a[Integer.parseInt(s[i])]=true;
            
        }
        for(int i=0;i<=n;i++)
        {
            //
            if(!a[i])
            {
                System.out.print(i+" ");
            }
        }
    }
}