//fCfS
/*
Sort with arrival times
*/
#include<stdio.h>
#include<malloc.h>
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

void fcfs(int **a,int n)
{
	int time=0,i,wt=0,tt=0,wait;
	printf("ID Waiting Time Turnaround Time\n");
	for(i=0;i<n;i++)
	{
		if(time>=a[i][1])
			wait=time-a[i][1];
		else
			wait=0;
		time+=a[i][2];
		printf("%d\t%d\t%d\n",a[i][0],wait,time-a[i][1]);
		wt+=wait;
		tt+=time-a[i][1];
	}
	printf("\nAverage turnAround Time:%f Average waiting time:%f",tt/(float)n,wt/(float));
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
	sortArrv(a,n);
	fcfs(a,n);
}