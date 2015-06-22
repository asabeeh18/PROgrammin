//indexed sequentual search
#include<stdio.h>
#include<conio.h>
#define M 20
int index[M],key[M],d=2;
void genkey(int a[],int n)
{
	int i;
	for(i=0;i<n;i=i+d)
	{
		key[i]=a[i];
		index[i]=i;
	}
}
int search(int a[],int n,int s)
{
	int i;
	for(i=0;i<n;i=i+d)
		if(s<a[i])
			break;
	i=index[i-1];
	for(;i<n;i++)
		if(a[i]==s)
			break;
	if(i==n)
		return -1;
	return i;
}
void main()
{
	int a[M],n,s,i;
	clrscr();
	printf("Enter the number of elements");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	genkey(a,n);
	printf("Enter the elemnt to search for");
	scanf("%d",&s);
	i=search(a,n,s);
	printf("Found at: %d",i);
	getch();
}	