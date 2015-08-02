//http://www.codechef.com/JULY15/problems/ADDMUL

class zzzase{
	public static void main(String ar[]) throws Exception
	{
		final int M=1000000007;
		java.io.BufferedReader r=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		//int t=Integer.parseInt(r.readLine());
		String s=r.readLine();
		String ss[]=s.split(" ");
		int n=Integer.parseInt(ss[0]);
		int q=Integer.parseInt(ss[1]);
		
		int[] a=new int[n],lastUpdated=new int[n];//,operstack=new int[q];
		int[][] quer=new int[q][4];	//oper l r v
		//int ST=-1;
		
		s=r.readLine();
		ss=s.split(" ");
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ss[0]);
		
		for(int i=0;i<q;i++)
		{
			s=r.readLine();
			ss=s.split(" ");
			int oper=Integer.parseInt(ss[0]);
			if(oper!=4)
			{
				quer[i][0]=oper;
				quer[i][1]=Integer.parseInt(ss[1])-1;
				quer[i][2]=Integer.parseInt(ss[2])-1;
				quer[i][3]=Integer.parseInt(ss[3]);
			}				
			else	//display
			{
				int sum=0;
				q--; //danger
				i--;
				for(int j=Integer.parseInt(ss[1])-1;j<=Integer.parseInt(ss[2])-1;j++)
				{
					int x=a[j];
					//int k=lastUpdated[j];
					for(int k=i;k>lastUpdated[j];k--)	//bottom up
					{
						if(quer[k][0]==3 && j>=quer[k][1] && j<=quer[k][2]) //test phase:critical range check //(=)
						{
							x=quer[k][3];
					//		a[j]=x;
							//lastUpdated[j]=k+1;	//1-indexing inside lastUpdated, lastUpdated[0] is unint, lastUpdated[1] is quer[1]
						//	sum+=x;
							break;
						}
						else if(j>=quer[k][1] && j<=quer[k][2])
						{
							if(quer[k][0]==1)
							{
								x=(x+quer[k][3])%M;
							}
							else if(quer[k][0]==2)
							{
								x=(x+quer[k][3])%M;
							}
							else
							{
								System.out.println("ERROR!!");
							}
							//operstack[++ST]=quer[k][0];
						}
					}
					//a[j]=popStack(operstack,ST,x);
					//ST=-1;
					a[j]=x;
					sum+=x;
					lastUpdated[j]=i;
				}
                                System.out.println(sum);
			}
		}
	}
	/*
	public static int popStack(int stack[],int n,int a)
	{
		int count=0;
		int cue=stack[n];
		for(int i=n-1;i>=0;i--)
		{
			while(i>=0 && stack[i]==cue)
			{
				i--;
				count++;
			}
			if(cue==1)
			{
				count*
			}
				
		}
	}*/
}