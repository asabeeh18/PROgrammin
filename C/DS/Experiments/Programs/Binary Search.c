#include<stdio.h>
#include<conio.h>
#define SIZE 10
int binarySearch(int a[],int n,int m)
{
	int l=0,u=n-1;
	while(l<=u)
	{
		mid=(l+u)/2;
		if(m==a[mid])
			break;
		else if(m<a[mid])
			u=mid-1;
		else
			l=mid+1;
	}
	if(m==a[mid])
		return mid;
	return -1;	
}	
void main()
{
	int a[SIZE],i,n,m,p;
	printf("\nEnter the size of an array: ");
	scanf("%d",&n);
	printf("\nEnter the elements in ascending order: ");
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	printf("\nEnter the number to be search: ");
	scanf("%d",&m);
	p=binarySearch(a,n,m)
	if(p==-1)
		printf("The number not found.");
	else
		printf("\nThe number is found at: %d",p);
	getch();
}
