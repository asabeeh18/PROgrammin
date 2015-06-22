//SJF
/*
Sort with arrival times
for same arrival times sort in burst times
*/
#include<stdio.h>
#include<malloc.h>
void disp(int **a,int n)
{
	int i;
	for(i=0;i<n;i++)
	{
		printf("%d %d %d\n",a[i][0],a[i][1],a[i][2]);
	}
}
void sortArrv(int **a,int n)
{
	int t,i,j;
	for(i=0;i<n-1;i++)
		for(j=0;j<n-i-1;j++)
			if(a[j][1]>a[j+1][1])
			{
				t=a[j][1];
				a[j][1]=a[j+1][1];
				a[j+1][1]=t;
			}
}
void main()
{
	int **a,n,i,j,av,b;
	printf("Enter number of Processes	: ");
	scanf("%d",&n);
	*a=(int *)malloc(n*sizeof(int));
	for(i=0;i<n;i++)
		a[i]=(int *)malloc(3*sizeof(int));
	printf("Arrival time and Burst times\n");
	for(i=0;i<n;i++)
	{
		scanf("%d %d",&av,&b);
		a[i][0]=i;
		a[i][1]=av;
		a[i][2]=b;
	}
	disp(a,n);
	sortArrv(a,n);
	disp(a,n);
}