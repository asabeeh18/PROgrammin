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
void shift(int a[],int n)
{	
	int i;
	for(i=n;i>=0;i--)
		a[i]=a[i-1];
}
int main()
{
	int n,*f,hit=0,miss=0,p=0,e;
	printf("Enter number of page frames");
	scanf("%d",&n);
	f=(int *)malloc(n*sizeof(int));
	while(1)
	{
		printf("\nEnter page to access: ");
		scanf("%d",&p);
		if(p==-1)
			break;
		e=exist(f,p,n);
		if(e==-1)	//page not found
		{
			shift(f,n-1);
			miss++;
		}
		else		//page found
		{
			shift(f,e);
			hit++;
		}
		f[0]=p;
		printf("\nCurrent status of frames\n");
		display(f,n);
	}
	printf("\nHITS:%d\tMISS:%d",hit,miss);
}