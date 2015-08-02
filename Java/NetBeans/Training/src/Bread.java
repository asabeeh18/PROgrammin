//http://www.codechef.com/JULY15/problems/EGBOBRD
class Solution
{
	public static void main(String ar[]) throws Exception
	{
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(r.readLine());
		String s;
		while(t-->0)
		{
			int bread=0,rem=0,pack;
			s=r.readLine();
			String ss[]=s.split(" ");
			int n=Integer.parseInt(ss[0]);
			int k=Integer.parseInt(ss[1]);
			//int[] a=new int[n];
			int a;
			s=r.readLine();
			ss=s.split(" ");
			// K = 4, A = {3, 1, 2}. 7
			
			for(int i=0;i<n;i++)
			{
				a=Integer.parseInt(ss[i]);
				if(rem>0)
					rem--;
				if(rem<a)
                                {
                                    a-=rem;
                                    if(k>a)
                                            rem=k-a;
                                    else
                                            rem=a%k;
                                }
                                else
                                {
                                    rem-=a;
                                    a=0;
                                    
                                }
				pack=a/k;
				if(rem==0)
					bread+=pack;
				else
				{	bread+=pack+1;
				System.out.println(bread);
				}
			}
			System.out.println(bread);
		}
	}
}