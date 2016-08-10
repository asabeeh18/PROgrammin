
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//x^1/x > y^1/y
class Arr
{
	public static void main(String ar[]) throws IOException
	{
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
        while(t-->0)
        {
            int n=100000;//Integer.parseInt(r.readLine());
            int x[]=new int[n];
            double xf[]=new double[n];
            int y[]=new int[n];
            double yf[]=new double[n];
            //String[] s=r.readLine().split(" ");
            for(int i=0;i<n;i++)
            {
                x[i]=10;//Integer.parseInt(s[i]);
                xf[i]=Math.pow(x[i], 1.0/x[i]);
            }
            //s=r.readLine().split(" ");
            for(int i=0;i<n;i++)
            {
                y[i]=100;//Integer.parseInt(s[i]);
                yf[i]=Math.pow(y[i], 1.0/y[i]);
            }
            Arrays.sort(xf);
            Arrays.sort(yf);
            long point=0;
            int j=0;
            int i=0;
            for(;i<n;i++)
            {
                point+=j;   //cause of next line and elements in asc order,the points for next.
                for(;j<n;j++)   //start j from where it previously ended
                {
                    if(xf[i]>yf[j])
                    {
                        point++;
                    }
                    else
                        break;
                }
            }
            if(i<n)
            {
                point+=n*(n-i);
            }
            System.out.println((double)point/n+"");
        }
	}
}