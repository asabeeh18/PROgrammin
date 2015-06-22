//Quick Sort
#include<stdio.h>
#include<conio.h>
#define M 20
int partition(int a[],int left,int right)
{
	int i=left,j=right,x=a[left],t=0;
	while(i<j)
	{
		while(a[i]<=x && i<=right)
			i++;
		while(a[j]>x)
			j--;
		if(i<j)
		{
			t=a[i];
			a[i]=a[j];
			a[j]=t;
		}
	}
	a[left]=a[j];
	a[j]=x;
	printf("\n");
	return j;
}
void quick(int a[],int left,int right)
{
	int p;
	printf("Quick(%d,%d)------",left,right);
	if(left<right)
	{
		p=partition(a,left,right);
		quick(a,left,p);
		quick(a,p+1,right);
	}
}
void main()
{
	int a[M],n,i;
	printf("Entr the number of elements: \n");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	quick(a,0,n-1);
	for(i=0;i<n;i++)
		printf("%d  ",a[i]);
}