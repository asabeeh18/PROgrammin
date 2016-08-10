

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Source:https://www.codechef.com/LTIME29/problems/STDPRGS
 * Status/Result:  * 
 */

public class Progress {

    public static void main(String[] args) throws IOException
    {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(r.readLine());
        String s[]=r.readLine().split(" ");
        int[] a=new int[n];
        Integer[] objAr=new Integer[n];
        int[] index=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
            objAr[i]=i;
        }
        
        //INDEXER
        //System.arraycopy(a, 0, b, 0, n);
        Arrays.sort(objAr,new Comparator<Integer>(){
			public int compare(Integer i,Integer j)
			{
				return a[i]-a[j];
			}
		});
        
        for(int i=0;i<n;i++)
        {
            index[objAr[i]]=i;
        }
        
        //Take query
        int q=Integer.parseInt(r.readLine());
        
        while(q-->0)
        {
            int k=0;
            s=r.readLine().split(" ");
            int t=Integer.parseInt(s[0]);
            int u=Integer.parseInt(s[1]);
            for(int i=t-1;i<u-1;i++)
            {
                k+=(a[index[i+1]]-a[index[i]])*(a[index[i+1]]-a[index[i]]);
            }
            System.out.println(k);
        }
    }
    
}
