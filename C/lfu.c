/*
lru
nmbr of page frame
exist
not den insert
shift up
zup zup zup*/
#include<stdio.h>
#include<malloc.h>
void display(int a[],int n)
{
	int i;
	for(i=0;i<n;i++)
	{
		printf("%d ",a[i]);
	}
}
int exist(int a[],int p,int n)	//search if page exists
{
	int i;
	for(i=0;i<n;i++)
		if(a[i]==p)
			return i;

	return -1;	//page not found
}
int main()
{
	int n,*f,*q,t,i,r,hit=0,miss=0,p=0,e;
	printf("Enter number of page frames");
	scanf("%d",&n);
	printf("Enter maximum number of unique pages to be entered");
	scanf("%d",&r);
	q=(int *)malloc(r*sizeof(int));
	f=(int *)malloc(n*sizeof(int));
	while(1)
	{
		printf("\n-1 to Quit\nEnter page to access: ");
		scanf("%d",&p);
		if(p==-1)
			break;
		e=exist(f,p,n);
		if(e==-1)	//page not found
		{
			miss++;
			q[p]=1;
			for(i=0;i<n;i++)
				if(f[i]==0)	//check for empty frame
				{
					f[i]=p;
					break;
				}
			if(i==n)	//insert and replace
				f[n-1]=p;
		}
		else		//page found
		{
			hit++;
			q[p]++;
			if(e!=0)
				if(q[f[e-1]]<q[f[e]])
				{
					t=f[e-1];
					f[e-1]=f[e];
					f[e]=t;
				}
		}
		printf("\nCurrent status of frames\n");
		display(f,n);
	}
	printf("\nHITS:%d\tMISS:%d",hit,miss);
}