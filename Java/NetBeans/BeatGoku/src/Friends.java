import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Friends
{

    public static int[] a,num,lastV;
    public static int ends[][];
    static boolean end=false;
    public static int top=-1,ii=0;
    public static int[][] list;
    static long lastC=0,co=0,cT;
    public static int find(int x)
    {
        if(a[x]!=x)
            a[x]=find(a[x]);
        return a[x];
    }
    public static void merge(int x,int y)
    {
        int m=find(x);
        int n=find(y);
        if(m==n && !end)
        {
            //save for ends
            top++;
            ends[top][0]=x;
            ends[top][1]=y;
            return;
        } 
        //long rest=lastC-(num[m]*(num[m]-1)+num[n]*(num[n]-1));
        //if(rest<0)
          //  rest=0;
        if(m<n)
        {
            a[n]=m;    
            num[m]+=num[n];
            lastC=(num[m]*(num[m]-1));
            list[ii][0]=m;
            list[ii][1]=n;
        }
        else if(n<m)
        {    
            a[m]=n;
            num[n]+=num[m];
            lastC=(num[n]*(num[n]-1));
            list[ii][0]=n;
            list[ii][1]=m;
        }
        list[ii][2]=(int)lastC;
        ii++;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++)
        {
            int n = in.nextInt();
            int m = in.nextInt();
            
            //Initialise SH!T
            a=new int[n+1];
            num=new int[n+1];
            ends=new int[m][2];
            list=new int[m+n+1][4];
            lastV=new int[n+1];
            for(int i=m;i<m+n;i++)
            {
                list[i][0]=i-m+1;
                list[i][1]=0;
                list[i][2]=0;
            }
            for(int i=0;i<m;i++)
                list[i][3]=0;
            for(int i=0;i<=n;i++)
                a[i]=i;
            Arrays.fill(num,1);
            
            //start process
            for(int a1 = 0; a1 < m; a1++)
            {
                int x = in.nextInt();
                int y = in.nextInt();
                merge(x,y);
            }
            //System.out.println("Input Done========================");
            Arrays.sort(list, (int[] o1, int[] o2) -> Integer.compare(o2[2],o1[2]));
            //while(!allVis)
            {
                for(int i=0;i<m;i++)
                    if(list[i][3]==0)
                        calc(list[i][0]);
            }
            end=true;
            //ends
            for(int i=0;i<=top;i++)
            {
                co+=cT;
                //merge(ends[i][0],ends[i][1]);
            }
            System.out.println(co);
        }
    }

    private static void calc(int i)
    {
        int max=list.length-1;
        boolean getOut=false;
        
        for(int i1=0;i1<ii && !getOut;i1++)
        {
            if(list[i1][3]==0 && list[i1][2]>=list[max][2] && (list[i1][0]==i || list[i1][1]==i))
            {
                max=i1;
                getOut=true;
                list[i1][3]=1;//mark visited
            }
        }
        if(list[max][2]>2)
        {
            //build both leaders first
            calc(list[max][0]);
            calc(list[max][1]);
        }
        if(list[max][2]<2)
        {
            lastV[i]=0;
            
            return;
        }
        co+=list[max][2]+cT-lastV[list[max][0]]-lastV[list[max][1]];
        cT=list[max][2]+cT-lastV[list[max][0]]-lastV[list[max][1]];
        lastV[list[max][0]]=list[max][2];
        lastV[list[max][1]]=list[max][2];
    }
}