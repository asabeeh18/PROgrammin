//Radix Sort
#include<stdio.h>
#include<conio.h>
#define M 20
void radix(int a[],int n)
{
	int m,i,j,d=0,b[10][10],e=1,k=0,cntr[10],t=0,l=0;
	for(i=0;i<n;i++)
		if(a[i]>m)
			m=a[i];
	for(i=1;i<=m;i*=10,d++);
	for(i=0;i<d;i++,l=0,e*=10)
	{
		for(j=0;j<10;j++)
		{
			cntr[j]=-1;
			for(k=0;k<10;k++)
				b[i][j]=-1;
		}
		for(j=0;j<n;j++)
		{
			t=(a[j]/e)%10;
			cntr[t]++;
			b[cntr[t]][t]=a[j];
		}
		for(k=0;k<10;k++)
			for(j=0;j<=cntr[k];j++)
				a[l++]=b[k][j];
	     for(k=0;k<n;k++)
		printf("%d  ",a[k]);
	}
}
void main()
{
	int a[M],n,i;
	printf("Entr the number of elements: \n");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	radix(a,n);
	for(i=0;i<n;i++)
		printf("%d  ",a[i]);
}