//NFA wid abselon to dfa table
// 'o' is abselon
import java.util.*;
class Tabl
{
	public int abs[],a[],b[];
	Tabl(int Q)
	{
		abs[]=new int[Q];
		a[]=new int[Q];
		b[]=new int[Q];
	}	
}	
class NFADFA
{
	int M[][];	
	public static void dfs(int i)
	{
		//	for(int j=i;j<3;j++)
				if(M[j][3]!=-1);
				{
					dfs(M[j][3]);
					
				}	
				else
				{
					if(M[j][0]!=-1)
						a[k][++an[k]]=M[j][0];
					if(M[j][0]!=-1)
						b[k][++bn[k]]=M[j][1];
				}	
	}	
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Q: ");
		int Q=src.nextInt();
		//System.out.println("L: ");
		int L=2;	//src.nextInt();
		
		M[][]=new int[Q][L+1];	//columns a b abselon
		System.out.println("Transitions -1 for no transition ");
		System.out.println("a\tb\t$");
		for(int i=0;i<Q;i++)
		{		
			M[i][0]=src.nextInt();
			M[i][1]=src.nextInt();
			M[i][2]=src.nextInt();
		}
		//ACCEPTANCE FINISHED!!!
	/	for(int i=0,k=0;i<Q;i++,k++)
		{
			dfs(0);
			//sort a[] b[] aftr evry call dup;icate chking
		//	sTart a loop
			if!(row of a||b completely matches with already analysed row)
				add it to queue
			pop from queue -for every value in dat row run tue dfs 	
}
