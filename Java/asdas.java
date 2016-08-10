
import java.util.Arrays;
import java.util.Scanner;

//WOrks APp1

class Snake
{
	static int a[][];
        static int[][][] box;
        static boolean[] entry,entryOld;
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int n=r.nextInt();
		int m=r.nextInt();
		a=new int[n+1][m];	//fake last row is infinite row
		box=new int[m
                        ][n][n];
		entry=new boolean[n];
                entryOld=new boolean[n];
		//init
		Arrays.fill(entry,true);
		Arrays.fill(a[n],Integer.MIN_VALUE);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				a[i][j]=r.nextInt();
			}
		}
		
		//start
		for(int i=0;i<=0;i++)
		{
			for(int j=0;j<n;j++)
			{
				
				for(int k=0;k<n;k++)
				{
					int jk=updown(i,j,k);
                                        if(j==0)
                                            box[i][j][k]=jk;
                                        else
                                            box[i][j][k]=Math.max(box[i][j-1][k],jk);
					//box[ijk] contains max value to exit from cell k,of column i
				}
			}
		}
                for(int i=1;i<m;i++)
		{
                        System.arraycopy(entry, 0, entryOld, 0, entry.length);
			for(int j=0;j<n;j++)
			{
                                if(a[j][i]==-1)
                                {
                                    if(j!=0)
                                        System.arraycopy(box[i][j-1], 0, box[i][j], 0, n);
                                    else
                                        System.arraycopy(box[i-1][n-1], 0, box[i][j], 0, n);
                                    continue;
                                }
				if(entryOld[j])
				for(int k=0;k<n;k++)
				{
                                        if(a[k][i]==-1)
                                        {
                                            entry[k]=false;
                                            continue;
                                        }
    					int jk=updown(i,j,k);
                                        if(j==0)
                                            box[i][j][k]=Math.max(0,jk);
                                        else
                                            box[i][j][k]=Math.max(box[i][j-1][k],jk);
					//box[ijk] contains max value to exit from cell k,of column i
				}
                                else
                                {
                                    if(j!=0)
                                        System.arraycopy(box[i][j-1], 0, box[i][j], 0, n);
                                    else
                                        System.arraycopy(box[i-1][n-1], 0, box[i][j], 0, n);
                                    
                                }
			}
                }
//                for(int i=0;i<box.length;i++)
//                {
//                    for(int j=0;j<box[0].length;j++)
//                    {
//                        for(int k=0;k<box[0][0].length;k++)
//                            System.out.print(box[i][j][k]+" ");
//                        System.out.println();
//		}
//                    System.out.println("===");
//                }
                int max=box[a[0].length-1][n-1][0];
                for(int i=0;i<box[0][0].length;i++)
                {
                    if(box[a[0].length-1][n-1][i]>max)
                        max=box[a[0].length-1][n-1][i];
                }
                System.out.println(max);
	}
        public static int updown(int i,int j,int k)
        {
            int up=0,down;
            boolean enter1=true,enter2=true,teleportUp=false,teleportDown=false;
            if(i!=0)
            {
                up=box[i-1][a.length-1-1][j];
            }
            down=up;
            if(a[k][i]==-1 || a[j][i]==-1)
            {
                if(a[k][i]==-1)
                    entry[k]=false;
                return 0;
            }
            for(int m=j;m!=k;m=(m+1)%a.length)
            {
                if(a[m][i]==-1)
                {
                    up=Integer.MIN_VALUE;
                    enter1=false;
                    
                    break;
                }
                if(a[m][i]<0)
                {
                    up=0;
                    teleportUp=true;
                    continue;
                }
                up+=a[m][i];
            }
            up+=a[k][i];
            
            for(int m=j;m!=k;m=m-1==-1?a.length-1:m-1)
            {
                if(a[m][i]==-1)
                {
                    down=Integer.MIN_VALUE;
                    enter2=false;
                    
                    break;
                }
                if(a[m][i]<0)
                {
                    down=0;
                    teleportDown=true;
                    continue;
                }
                down+=a[m][i];
                
            }
            down+=a[k][i];
            //cheap stupid coder
            
            if(i==1 && j==2 && k==0)
            {
                down=down+1-1;
            }
            //if u cant exit from UP or down OR entry==exit and it is -1
            if((!enter1 && !enter2))
            {
                entry[k]=false|entry[k];
                return 0;
            }
            entry[k]=true;
            if(i==0)// | teleport)
                return Math.max(0,Math.max(up,down));
            if(up>down)
            {
                if(teleportUp)
                    return up;
            }
            else //both might be equal and tele issue -.-"
            {
                if(down>up)
                {
                    if(teleportDown)
                        return down;
                }
                else //equal
                {
                    if(teleportDown & teleportUp)
                        return up;
                }
            }
            return Math.max(0,Math.max(up,down));
        }
        
}