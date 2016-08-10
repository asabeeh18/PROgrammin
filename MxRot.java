import java.util.*;
import jdk.nashorn.api.scripting.AbstractJSObject;
class MxRot
{
	public static void main(String args[])
	{
		Scanner read=new Scanner(System.in);
		int m=read.nextInt();
		int n=read.nextInt();
		int rot=read.nextInt();
		int a[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
			{
				a[i][j]=read.nextInt();
				getNewpoz(i,j,rot);
			}
		
		int u=0,d=n-1,l=0,r=m-1;
		for(int i=0;i<m;i++)
		{
            int jj,ii;
            //top
            for(int j=0;j<n;j++)
            {
               //(i,m-i,j,n-j);
            }
			
			
		}
	}
    public static void topRotate(int x,int y,int rot,int u,int d,int l,int r)
    {
        int jj,ii;
        if(rot<=r-l)
        {
            jj=y-rot;
        }
        else
        {
            
            leftRotate(x,l,rot-r-l,u,d,l,r);
        }
    }
    public  static int[] leftRotate(int x,int y,int rot,int u,int d,int l,int r)
    {
        int jj,ii;
        if(rot<d-u)
        {
            ii=x+rot;
        }
        else
        {
            bottomRotate(d,y,rot-d-u,u,d,l,r);
        }
    }
    public static void bottomRotate(int x,int y,int rot,int u,int d,int l,int r)
    {
        int jj,ii;
        if(rot<=r-l)
        {
            jj=y+rot;
        }
        else
        {
            
            rightRotate(x,r,rot-r-l,u,d,l,r);
        }
    }
    public static void rightRotate(int x,int y,int rot,int u,int d,int l,int r)
    {
        int jj,ii;
        if(rot<=d-u)
        {
            ii=x-rot;
        }
        else
        {
            topRotate(x,u,rot-d-u,u,d,l,r);
        }
    }
}