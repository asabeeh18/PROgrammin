//nqueen
#include<stdio.h>
#include<conio.h>
#include<math.h>
int n,x[20];
int place(int k,int i)
{
	int j;
	for(j=1;j<=k-1;j++)
		if(x[j]==i || abs(x[j]-i)==(k-j))		//first check if in same row den check if row=colums -diagonal check
			return 0;		//insertion not possible
	return 1;
}

void nqueen(int k)
{
	int i,m;
	for(i=1;i<=n;i++)
	{
		if(place(k,i))
		{
			x[k]=i;
			if(k==n)
			{
				for(m=1;m<=n;m++)
					printf("%d ",x[m]);
				printf("\n");
			      //	exit(0);		un-comment this line if u dont want all solutions
			}
			else
			{
				nqueen(k+1);
		       }
		}
	}
}
void main()
{
	int i;
	scanf("%d",&n);
	for(i=0;i<=n;i++)
		x[i]=0;
	nqueen(1);
}
