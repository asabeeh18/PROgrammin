//Insertion Sort
#include<stdio.h>
#include<conio.h>
#define M 20
void insert(int a[],int n)
{
	int i,x,j;
	for(i=1;i<n;i++)
	{
		x=a[i];
		for(j=i;j>0 && a[j-1]>x;j--)
			a[j]=a[j-1];
		a[j]=x;
	}
}	
void main()
{
	int a[M],n,i;
	printf("Entr the number of elements: \n");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	insert(a,n);
	for(i=0;i<n;i++)
		printf("%d  ",a[i]);
}