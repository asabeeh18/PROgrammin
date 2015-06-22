import java.util.*;
class po
{
public static void main(String args[])
{
		Scanner src=new Scanner(System.in);
		System.out.println("Q: ");
		int Q=src.nextInt();
		//System.out.println("L: ");
		int L=2;	//src.nextInt();
		
		int M[][]=new int[Q][L+1];	//columns a b abselon
		for(int i=0;i<Q;i++)
			for(int j=0;j<Q;j++)
				M[i][j]='o';
		System.out.println("Transitions -1 for no transition ");
		System.out.println("a\tb\t$");
		for(int i=0;i<Q;i++)
		{		
			M[i][0]=src.nextInt();
			M[i][1]=src.nextInt();
			M[i][2]=src.nextInt();
		}
		//ACCEPTANCE FINISHED!!!
}
		
}		