//https://www.codechef.com/LTIME38/problems/STUDVOTE
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Drumpf
{
	public static void main(String ar[]) throws IOException
	{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		while(t-->0)
		{
            String s[]=r.readLine().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            s=r.readLine().split(" ");
            int a;
            int votes[]=new int[n];
            boolean disq[]=new boolean[n];
            Arrays.fill(votes, 0);
            Arrays.fill(disq, false);
            for(int i=0;i<n;i++)
            {
                a=Integer.parseInt(s[i]);
                if(a==i+1)
                {
                    disq[i]=true;
                    continue;
                }
                
                votes[a-1]++;              
            }
            
            int count=0;
            for(int i=0;i<n;i++)
            {
                if(votes[i]>=k && !disq[i])
                    count++;
            }
            System.out.println(count);
		}
	}
}