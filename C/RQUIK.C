#include<stdio.h>
#include<conio.h>
#define M 20
int partition(int a[],int left,int right)
{
	int l=a[left];
	int i=left;
	int j=right,temp;
	while(i<j)
	{
		while(a[i]<=l && i<=right)
			i++;
		while(a[j]>l)
			j--;
		if(i<j)
		{
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}
	a[left]=a[j];
	a[j]=l;
	return j;
}
void quick(int a[],int left,int right)
{
		int p,x,temp;
		if(left<right)
		{
			x=rand()%(right-left+1)+left;
			temp=a[left];
			a[left]=a[x];
			a[x]=temp;
			p=partition(a,left,right);
			quick(a,left,p-1);
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