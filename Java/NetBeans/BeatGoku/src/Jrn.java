import java.io.*;
import java.util.*;

public class Jrn {
    public static int[] a;
    public static long[] rank;
    public static long rankS()
    {
        long sumr=0;
        for(int i=0;i<rank.length;i++)
        {
            sumr+=rank[i];
        }
        return sumr;
    }
	public static int find(int x)
	{
		if(a[x]!=x)
			a[x]=find(a[x]);
		//System.out.println(x);
		return a[x];
	}
	public static void merge(int x,int y)
	{
		int xx=find(x),yy=find(y);
		//System.out.println(yy+":"+xx);
		if(xx<yy)
		{
			int t=xx;
			xx=yy;
			yy=t;
		}
        rank[yy]+=rank[xx];
        rank[xx]=0;
		a[xx]=yy;
		//System.out.println(yy+":"+a[xx]);
	}
    public static void main(String[] args) {
        long sumr=0;
        Scanner r=new Scanner(System.in);
        int n=r.nextInt();
        a=new int[n];
        rank=new long[n];
        Arrays.fill(rank,1);
        for(int i=0;i<n;i++)
        {
            a[i]=i;
            sumr=i;
        } 
        System.out.println("N: "+sumr);
        sumr=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]==i)
            {
                //System.out.println("Group: "+i+" Of: "+rank[i]);
                sumr+=rank[i];
            }
        }
        System.out.println("R: "+sumr);
        int e=r.nextInt();
        sumr=0;
        System.out.println("Sum of : "+rankS());
        for(int i=0;i<e;i++)
        {
            int x=r.nextInt(),y=r.nextInt();
            merge(x,y);
            sumr=i;
            System.out.println("Sum of "+i+": "+x+", "+y+" : " +rankS());
        }
        System.out.println("E: "+sumr);
        //System.out.println("Sum of : "+rankS());
        long sum=0,l=n;
        sumr=0;
        //System.out.println(Arrays.deepToString(rank));
        for(int i=0;i<rank.length;i++)
        {
            sumr+=rank[i];
            if(a[i]==i)
            {
                //System.out.println("Group: "+i+" Of: "+rank[i]);
                
                l=l-rank[i];
                if(l>0)
                    sum+=rank[i]*l;
            }
        }
        System.out.println(sum+":"+sumr);
    }
}