#include<stdio.h>
void insertion(int a[],int n)
{
	int i,k,temp;
	for(i=2;i<n;i++)
	{
		temp=a[i];
		for (k = i-1; k > 0 && temp <= a[k]; k--)
		{
			a[k+1]=a[k];
				
		}
		a[k+1]=temp;
	}
	//return a;
}
void display(int n,int* a)
{
	int i;
	for(i=1;i<n;i++)
	{
		printf("%d ",a[i]);
	}
	printf("\n");
}
void main(int argc,char* argv[])
{
	printf("Insertion Sort\n");
	if(argc<1)
	{
		printf("Usage:(list of integers)");
		return;
	}
	
	int a[argc];
	int i;
	//printf("argc: %d\n",argc);
	for(i=1;i<argc;i++)
	{
		a[i]=atoi(argv[i]);
		//printf("%d\n",a[i]);
	}
	for(i=1;i<argc;i++)
	{
		//printf("%d ",a[i]);
	}
	insertion(a,argc);
	
	display(argc,a);	
}
