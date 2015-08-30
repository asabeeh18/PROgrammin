import java.util.*;
public class Money
{
	static int[] food,x;
	static int mon;
	public static int min(int a,int b)
	{
		return a<b?a:b;
	}
	public static int sumset(int a[],int i,int cs,int k)
	{
            int ibackup=i;
		for(;i>=0;i--)
		{
			if(!((food[i]+cs)>mon))
			{
				a[k++]=food[i];
				cs+=food[i];
				if(cs==mon)
				{
					System.out.print("[");
					for(int m=0;m<k;m++)
						System.out.print(a[m]+",");
					System.out.println("]");
					return i;
				}
				else 
				{
					if(sumset(a,--i,cs,k)==0)
                        return ibackup;
                                        
                                            
				}
			}
		}
                return i;
        }
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		StringTokenizer s=new StringTokenizer(r.nextLine()," ");
		int n=s.countTokens();
		food=new int[n];
		x=new int[n];
		
		//System.out.println(n);
		for(int i=0;i<n;i++)
		{
			food[i]=Integer.parseInt(s.nextToken());
		}
		mon=r.nextInt();
                Arrays.sort(food);
		int i=sumset(x,n-1,0,0);
	}
}