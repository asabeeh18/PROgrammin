//hashing
#include<stdio.h>
#include<conio.h>
#define M 10
int buk[10][10],cntr[10];
void hash(int a[],int n)
{
	int i,j;
	for(i=0;i<10;i++)
	{
		cntr[i]=-1;
		for(j=0;j<10;j++)
			buk[i][j]=-1;
	}
	for(i=0;i<n;i++)
		buk[++cntr[a[i]%M]][a[i]%M]=a[i];
}
int dehash(int a[],int s)
{
	int i;
	for(i=0;i<=cntr[s%M];i++)
		if(buk[cntr[s%M]][s%M]==s)
			return 1;
	return 0;
}
void main()
{
	int a[M],s,n,i;
	printf("Enter the number of elements\n ");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	hash(a,n);
	printf("Enter element to search ");
	scanf("%d",&s);
	if(dehash(a,s)==1)
		printf("FOUND");
	else
		printf("NOT");
}
